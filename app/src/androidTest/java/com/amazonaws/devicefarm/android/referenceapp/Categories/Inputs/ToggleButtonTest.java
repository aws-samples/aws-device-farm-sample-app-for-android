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
 * Tests for toggle buttons
 */
public class ToggleButtonTest extends InputControlsBase{
    @Override
    protected int getPageIndex() {
        return 3;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_switch);
        checkIfIdDisplayed(R.id.input_switch_display);
    }

    /**
     * Tests a toggle button by switching it on and checking it's content description
     */
    @Test
    public void testInputSwitch(){
        checkIdWithContentDescription(R.id.input_switch_display, R.string.switch_off_text);
        clickId(R.id.input_switch);
        checkIdWithContentDescription(R.id.input_switch_display, R.string.switch_on_text);
    }
}
