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
 * Tests for check boxes
 */
public class CheckBoxTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 1;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_checkbox);
        checkIfIdDisplayed(R.id.input_checkbox_status);
    }

    /**
     * Tests the check box by checking and unchecking the input then verifying if the text is
     * displayed.
     */
    @Test
    public void testCheckBox(){
        checkIfIdIsDisplayedWithText(R.id.input_checkbox_status, "Unchecked");
        clickId(R.id.input_checkbox);
        checkIfIdIsDisplayedWithText(R.id.input_checkbox_status, "Checked");
    }
}
