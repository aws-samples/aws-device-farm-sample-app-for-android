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

package com.amazonaws.devicefarm.android.referenceapp.Categories.Native;

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;

/**
 * Tests for out of content scrolling tests
 */
public class OutOfContentScrollingTest extends NativeBase {
    @Override
    protected int getPageIndex() {
        return 4;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.out_of_content_scrollView);
    }

    /**
     * Tests out of content elements by first verifying whether it's not there,
     * then swiping up and then checking if the element is displayed.
     */
    @Test
    public void testScrollToOutOfContent() {
        onView(withId(R.id.hidden_text)).check(matches(not(isDisplayed())));
        onView(withId(R.id.out_of_content_scrollView)).perform(swipeUp());
        onView(withId(R.id.hidden_text)).check(matches(isDisplayed()));
    }
}
