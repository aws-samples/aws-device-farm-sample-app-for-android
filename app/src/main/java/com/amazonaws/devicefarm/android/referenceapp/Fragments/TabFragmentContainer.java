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

package com.amazonaws.devicefarm.android.referenceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazonaws.devicefarm.android.referenceapp.Adapters.TabAdapter;
import com.amazonaws.devicefarm.android.referenceapp.Models.TabViewModel;
import com.amazonaws.devicefarm.android.referenceapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment container for fragments with tabs
 * Uses a page view for tab switching
 */
public class TabFragmentContainer extends Fragment {

    @InjectView(R.id.view_pager1)
    ViewPager pager;

    public TabFragmentContainer() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {//TODO SINGLETON or single instance?
        View view =  inflater.inflate(R.layout.tab_fragment_container, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        List<TabViewModel> data = args.getParcelableArrayList(getString(R.string.tab_fragment_bundle_key));
        setUp(data);
    }

    private void setUp(List<TabViewModel> dataModel){
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager(), dataModel);
        pager.setAdapter(tabAdapter);
    }
}
