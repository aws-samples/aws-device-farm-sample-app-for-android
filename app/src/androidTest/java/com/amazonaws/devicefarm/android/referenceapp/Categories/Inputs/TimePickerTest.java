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

package com.amazonaws.devicefarm.android.referenceapp.Categories.Inputs;

import android.support.test.espresso.contrib.PickerActions;

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests for the time picker
 */
public class TimePickerTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 6;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_timepicker);
        checkIfIdDisplayed(R.id.input_time_display);
    }

    /**
     * Tests a time picker by setting the time and checking the time display
     */
    @Test
    public void testTimePicker() {
        onView(withId(R.id.input_timepicker)).perform(PickerActions.setTime(8, 2));
        checkIfIdIsDisplayedWithText(R.id.input_time_display, "8 : 02");
    }
}
