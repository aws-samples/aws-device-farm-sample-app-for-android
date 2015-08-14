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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating a checkbox input
 */
public class Input_CheckBoxFragment extends Fragment implements CheckBox.OnCheckedChangeListener{
    @InjectView(R.id.input_checkbox_status)
    TextView checkbox_display;

    @InjectView(R.id.input_checkbox)
    CheckBox checkBox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_checkbox_fragment, container, false);
        ButterKnife.inject(this, view);
        changeDisplay();
        checkBox.setOnCheckedChangeListener(this);
        return view;
    }

    /**
     * Changes the display, reflecting a checkbox's status
     */
    private void changeDisplay(){
        if (checkBox.isChecked()) {
            checkbox_display.setText("Checked");
        } else {
            checkbox_display.setText("Unchecked");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        changeDisplay();
    }
}
