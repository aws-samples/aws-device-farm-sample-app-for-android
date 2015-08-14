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

package com.amazonaws.devicefarm.android.referenceapp.IdlingResources;

import android.support.test.espresso.IdlingResource;
import android.support.v4.view.ViewPager;

/**
 * Used to prevent Espresso from becoming idle when the viewpager is in a animated state
 */
public class ViewPagerIdlingResource implements IdlingResource, ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    private boolean isIdle;
    private ResourceCallback resourceCallback;

    public ViewPagerIdlingResource(ViewPager pager) {
        this.viewPager = pager;
        pager.addOnPageChangeListener(this);
        isIdle = true;
    }

    @Override
    public String getName() {
        return "ViewPagerIdlingResource";
    }

    @Override
    public boolean isIdleNow() {
        return viewPager == null || isIdle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {}

    /**
     * Checks to see if not in a scrolling state
     *
     * @param state the viewpager's state
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        this.isIdle = state != ViewPager.SCROLL_STATE_SETTLING;

        if (this.isIdle)
            this.resourceCallback.onTransitionToIdle();
    }
}
