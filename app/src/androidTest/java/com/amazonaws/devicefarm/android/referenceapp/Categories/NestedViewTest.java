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

package com.amazonaws.devicefarm.android.referenceapp.Categories;

import com.amazonaws.devicefarm.android.referenceapp.BaseADFTest;
import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.pressBack;

/**
 * Tests for nested views
 */
public class NestedViewTest extends BaseADFTest {
    @Override
    protected String getClassName() {
        return "Nested Views";
    }

    @Override
    public void testSanity() {
        checkMainView();
    }

    /**
     * Tests up navigation by going up, checking for expected messages then going back to see
     * if the same messages appear.
     */
    @Test
    public void testUpNavigation() {
        checkMainView();
        clickId(R.id.nested_up_button);
        checkIfIdIsDisplayedWithText(R.id.up_navigation_content_text, R.string.back_navigation_message);
        clickId(R.id.nested_up_button);
        checkIfIdIsDisplayedWithText(R.id.up_navigation_content_text, R.string.up_navigation_final);
        pressBack();
        checkIfIdIsDisplayedWithText(R.id.up_navigation_content_text, R.string.back_navigation_message);
    }

    /**
     * Tests by going up by a certain amount of times then going back a calculated amount of times.
     * A counter is kept within the app to keep track of the level.
     *
     * The counter is then verified in order to see if the correct value is displayed.
     */
    @Test
    public void testBackNavigation() {
        checkMainView();
        clickId(R.id.nested_back_button);
        checkIfIdIsDisplayedWithText(R.id.back_navigation_counter, "1");
        for (int i = 0; i < 9; i++) {
            clickId(R.id.back_navigation_next_button);
        }

        checkIfIdIsDisplayedWithText(R.id.back_navigation_counter, "10");

        for (int i = 0; i < 9; i++) {
            pressBack();
        }

        checkIfIdIsDisplayedWithText(R.id.back_navigation_counter, "1");
    }

    /**
     * Checks to see if at the main menu
     */
    private void checkMainView(){
        checkIfIdDisplayed(R.id.nested_back_button);
        checkIfIdDisplayed(R.id.nested_textview);
        checkIfIdDisplayed(R.id.nested_up_button);
    }
}
