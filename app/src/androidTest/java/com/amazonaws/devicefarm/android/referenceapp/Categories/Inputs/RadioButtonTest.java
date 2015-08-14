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

/**
 * Tests for a radio button
 */
public class RadioButtonTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 2;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.radio_button_group);
        checkIfIdDisplayed(R.id.radio_button_1);
        checkIfIdDisplayed(R.id.radio_button_2);
        checkIfIdDisplayed(R.id.radio_button_3);
        checkIfIdDisplayed(R.id.input_radio_button_display);
    }

    /**
     * Clicks a specific radio button then verifies if the text changes
     */
    @Test
    public void testRadio() {
        clickId(R.id.radio_button_1);
        assertRadioDisplay(R.string.radio_button_1);
        clickId(R.id.radio_button_2);
        assertRadioDisplay(R.string.radio_button_2);
        clickId(R.id.radio_button_3);
        assertRadioDisplay(R.string.radio_button_3);
    }

    private void assertRadioDisplay(int id){
        checkIfIdIsDisplayedWithText(R.id.input_radio_button_display, id);
    }
}
