/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Native;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment that demonstrates playing a media file
 */
public class Native_MediaPlayer extends Fragment{
    private String movieUri;

    @InjectView(R.id.native_video_player)
    VideoView videoView;

    MediaPlayer player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.native_mediaplayer_fragment, container, false);
        ButterKnife.inject(this, view);
        movieUri = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.movie;
        new BackgroundVideoTask().execute(movieUri);
        return view;
    }

    /**
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (player == null)
            return;

        if (this.isVisible()) {
            videoView.setZOrderOnTop(false);
            player.start();
            videoView.setContentDescription(getString(R.string.videoView_playing));
            if (!isVisibleToUser) {
                player.stop();
                videoView.setZOrderOnTop(true);
                videoView.setContentDescription(getString(R.string.videoView_paused));
            }
        }
    }

    /**
     * Background task so that the video loading doesn't run on the UI thread.
     *
     * Running processor intense tasks on the UI thread causes slowdown.
     */
    private class BackgroundVideoTask extends AsyncTask<String, Uri, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                Uri videoUri = Uri.parse(params[0]);
                publishProgress(videoUri);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Uri... values) {
            try {
                videoView.setVideoURI(values[0]);
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        player = mp;
                        videoView.start();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
