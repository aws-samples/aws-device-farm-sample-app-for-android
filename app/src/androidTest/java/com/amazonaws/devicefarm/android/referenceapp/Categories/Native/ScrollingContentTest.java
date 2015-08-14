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

import android.support.test.espresso.action.ViewActions;

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Tests for a scroll view
 */
public class ScrollingContentTest extends NativeBase {
    @Override
    protected int getPageIndex() {
        return 1;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.content_scrolling_view);
    }

    /**
     * scrolls the scroll view
     */
    @Test
    public void testScroll(){
        onView(withId(R.id.content_scrolling_view)).perform(ViewActions.swipeUp());
    }
}
