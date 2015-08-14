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

package com.amazonaws.devicefarm.android.referenceapp.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A fragment used to demonstrate notications
 */
public class NotificationsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * Toast button clicked; shows toast
     */
    @OnClick(R.id.notifications_toast_button)
    public void onToastButtonClick(){
        Toast.makeText(getActivity(), getString(R.string.Toast_button_message), Toast.LENGTH_SHORT).show();

    }

    /**
     * Alert button clicked; shows alert
     */
    @OnClick(R.id.notifications_alert_button)
    public void onAlertButton(){
        new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.alert_title)).
                setMessage(getString(R.string.alert_message)).setPositiveButton(getString(R.string.alert_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();

    }
}
