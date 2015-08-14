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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating radio button input
 */
public class Input_RadioButtonFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    @InjectView(R.id.radio_button_group)
    RadioGroup radioGroup;

    @InjectView(R.id.input_radio_button_display)
    TextView radioButtonDisplay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_radio_button_fragment, container, false);
        ButterKnife.inject(this,view);
        radioGroup.setOnCheckedChangeListener(this);
        radioButtonDisplay.setText(getString(R.string.radio_button_1));
        return view;
    }

    /**
     * When a radio button is selected
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        setDisplay(checkedId);
    }

    /**
     * Changes display based upon the given radio button id
     * @param radio_id
     */
    private void setDisplay(int radio_id){
        RadioButton radioButton = (RadioButton) getActivity().findViewById(radio_id);
        radioButtonDisplay.setText(radioButton.getText());
    }
}
