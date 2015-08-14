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
import android.widget.TextView;
import android.widget.TimePicker;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment demonstrating a time picker input
 */
public class Input_TimePickerFragment extends Fragment  implements TimePicker.OnTimeChangedListener{
    @InjectView(R.id.input_timepicker)
    TimePicker timePicker;

    @InjectView(R.id.input_time_display)
    TextView timeDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_timepicker_fragment, container, false);
        ButterKnife.inject(this,view);
        timePicker.setOnTimeChangedListener(this);
        timeDisplay.setText(getString(R.string.time_picker_default_display));
        return view;
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        timeDisplay.setText(String.format("%d : %02d", hourOfDay, minute));
    }
}
