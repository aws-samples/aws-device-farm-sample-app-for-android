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

package com.amazonaws.devicefarm.android.referenceapp.IdlingResources;

import android.support.test.espresso.IdlingResource;
import android.widget.VideoView;

/**
 * Checks to see if the video either loaded or playing before becoming idle
 */
public class VideoPlayerIdlingResource implements IdlingResource{
    private VideoView videoView;
    private ResourceCallback resourceCallback;
    private boolean isIdle;

    public VideoPlayerIdlingResource(VideoView videoView) {
        this.videoView = videoView;
        isIdle = videoView.isPlaying();
    }

    @Override
    public String getName() {
        return "VideoPlayerIdlingResource";
    }

    @Override
    public boolean isIdleNow() {
        return videoView == null || videoView.isPlaying();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }
}
