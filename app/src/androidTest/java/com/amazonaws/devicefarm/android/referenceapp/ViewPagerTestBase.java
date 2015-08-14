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

package com.amazonaws.devicefarm.android.referenceapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.v4.view.ViewPager;

import com.amazonaws.devicefarm.android.referenceapp.IdlingResources.ViewPagerIdlingResource;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;

/**
 * A base class for a view pager
 */
public abstract class ViewPagerTestBase extends BaseADFTest{

    /**
     * Gets the index of the page
     * @return the index of the page
     */
    protected abstract int getPageIndex();

    /**
     * The id of the specific viewpager
     *
     * @return the id of the pager
     */
    protected abstract int getPagerId();

    /**
     * A custom idling resource to ensure the tab is fully loaded before continuing
     */
    private ViewPagerIdlingResource viewPagerIdlingResource;

    /**
     * Overloads the set up method to go to the specific page index
     * within the view pager.
     *
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        viewPagerIdlingResource = new ViewPagerIdlingResource((ViewPager)getActivity().findViewById(R.id.view_pager1));
        Espresso.registerIdlingResources(viewPagerIdlingResource);
        for (int i = 0; i < getPageIndex(); i++) {
            onView(withId(getPagerId())).perform(swipeLeft());
        }
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
    }

    /**
     * Removed the idling resource
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        Espresso.unregisterIdlingResources(viewPagerIdlingResource);
        super.tearDown();
    }
}
