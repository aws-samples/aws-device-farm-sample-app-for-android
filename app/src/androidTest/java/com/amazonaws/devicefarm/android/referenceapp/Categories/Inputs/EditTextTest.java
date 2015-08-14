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

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests a edit text input control
 */
public class EditTextTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 0;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_edit_text);
    }

    /**
     * Tests a edit text by inputting text in a text input then
     * validating if the text is inside the input
     */
    @Test
    public void testEditText() {
        final String input = "Something";
        writeTextIntoTextBox(R.id.input_edit_text, input);
        checkIfIdIsDisplayedWithText(R.id.input_edit_text, input);
    }
}
