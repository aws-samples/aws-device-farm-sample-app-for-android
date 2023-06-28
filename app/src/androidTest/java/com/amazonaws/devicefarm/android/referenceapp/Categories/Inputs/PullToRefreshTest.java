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

import androidx.test.espresso.action.ViewActions;

import com.amazonaws.devicefarm.android.referenceapp.R;
import com.amazonaws.devicefarm.android.referenceapp.RegularExpressionMatcher;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests for a pull to refresh control
 */
public class PullToRefreshTest extends InputControlsBase {
    @Override
    protected int getPageIndex() {
        return 5;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.input_refresh);
        checkIfIdDisplayed(R.id.input_refresh_display);
        checkIfIdDisplayed(R.id.input_refresh_scrollview);
    }

    /**
     * Tests a pull to refresh control by pulling to refresh and checking if the
     * display matches specific pattern for the time.
     */
    @Test
    public void testRefresh() {
        onView(withId(R.id.input_refresh_scrollview)).perform(ViewActions.swipeDown());
        onView(withId(R.id.input_refresh_display)).
                check(matches(RegularExpressionMatcher.
                matchesPattern("\\d{2}:\\d{2}:\\d{2} (AM|PM)")));
    }
}
