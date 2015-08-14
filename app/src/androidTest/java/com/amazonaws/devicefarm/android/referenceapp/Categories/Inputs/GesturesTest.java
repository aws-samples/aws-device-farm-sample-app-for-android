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

import android.support.test.espresso.action.ViewActions;

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.core.StringEndsWith.endsWith;

/**
 * Tests for gestures
 */
public class GesturesTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 9;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_gesture_action_pad);
        checkIfIdDisplayed(R.id.input_gesture_content);
        checkIfIdDisplayed(R.id.input_gesture_headline);
    }

    /**
     * Tests a fling gesture by performing it and then checking if the action is displayed
     */
    @Test
    public void testFling(){
        onView(withId(R.id.input_gesture_action_pad)).perform(ViewActions.swipeUp());
        checkIfEitherActionIsDisplayed("Fling", "Scroll");
    }

    /**
     * Tests a long press gesture by performing it and then checking if the action is displayed
     */
    @Test
    public void testLongPress(){
        onView(withId(R.id.input_gesture_action_pad)).perform(ViewActions.longClick());
        checkIfActionIsDisplayed("Long Press");

    }

    /**
     * Tests a single press gesture by performing it and then checking if the action is displayed
     */
    @Test
    public void testSinglePress(){
        clickId(R.id.input_gesture_action_pad);
        checkIfActionIsDisplayed("Single tap confirmed");

    }

    /**
     * Checks the last gesture text out put with an expected gesture
     *
     * @param action the gesture string
     */
    private void checkIfActionIsDisplayed(String action){
        onView(withId(R.id.input_gesture_content)).check(matches(withText(endsWith(action + "\n"))));
    }

    private void checkIfEitherActionIsDisplayed(String action1, String action2){
        onView(withId(R.id.input_gesture_content)).check(matches(anyOf(withText(endsWith(action1 + "\n")),
                withText(endsWith(action2 + "\n")))));
    }
}
