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
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A fragment demonstrating the toggle button
 */
public class Input_Toggle_ButtonFragment extends Fragment {
    @InjectView(R.id.input_switch_display)
    View switchDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_toggle_button_fragment, container, false);
        ButterKnife.inject(this, view);
        switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_grey));
        switchDisplay.setContentDescription("OFF");
        return view;
    }

    /**
     * Switches the frame's background color
     *
     * @param view
     */
    @OnClick(R.id.input_switch)
    public void onToggleClicked(View view){
        if (((SwitchCompat)view).isChecked()) {
            switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_yellow));
            switchDisplay.setContentDescription("ON");
        } else {
            switchDisplay.setBackgroundColor(getResources().getColor(R.color.custom_grey));
            switchDisplay.setContentDescription("OFF");
        }
    }
}
