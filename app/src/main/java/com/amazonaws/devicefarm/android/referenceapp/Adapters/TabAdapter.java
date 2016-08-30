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

package com.amazonaws.devicefarm.android.referenceapp.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.amazonaws.devicefarm.android.referenceapp.Models.FragmentEnum;
import com.amazonaws.devicefarm.android.referenceapp.Models.TabViewModel;

import java.util.List;

/**
 * An adapter for the pageview
 */
public class TabAdapter extends FragmentPagerAdapter {

    List<TabViewModel> tabs;
    public TabAdapter(FragmentManager fragmentManager, List<TabViewModel> tabs){
        super(fragmentManager);
        this.tabs = tabs;
    }

    /**
     * Gets the fragment for a specific tab
     * @param position
     * @return the fragment for a specific position
     */
    @Override
    public Fragment getItem(int position) {
        return FragmentEnum.valueOf(tabs.get(position).getTab_id()).getFragment();
    }

    /**
     * Gets the number of tabs
     * @return tab size
     */
    @Override
    public int getCount() {
        return tabs.size();
    }

    /**
     * Gets the title for a tab at a specific position
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTab_name();
    }
}