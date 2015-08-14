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

package com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs;

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
 * A fragment demonstrating a simple submit button
 * The submit button sends out a submit toast
 */
public class Input_SubmitButtonFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_submit_button_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.input_submit_button)
    public void onClick(){
        Toast.makeText(getActivity(), getString(R.string.submit_button_toast_message), Toast.LENGTH_SHORT).show();
    }
}
