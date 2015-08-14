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

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Tests for a spinner display
 */
public class SpinnerInputTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 4;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_spinner);
        checkIfIdDisplayed(R.id.input_spinner_message);
    }

    /**
     * Tests a spinner by selecting a specific value then verifying if it's displayed
     */
    @Test
    public void testInputSpinner(){
        clickId(R.id.input_spinner);
        onData(allOf(is(instanceOf(String.class)), is("option 2")))
                .perform(click());
        checkIfIdIsDisplayedWithText(R.id.input_spinner_message, "Selected: option 2");

        clickId(R.id.input_spinner);
        onData(allOf(is(instanceOf(String.class)), is("option 5")))
                .perform(click());
        checkIfIdIsDisplayedWithText(R.id.input_spinner_message, "Selected: option 5");

        clickId(R.id.input_spinner);
        onData(allOf(is(instanceOf(String.class)), is("option 3")))
                .perform(click());
        checkIfIdIsDisplayedWithText(R.id.input_spinner_message, "Selected: option 3");
    }
}
