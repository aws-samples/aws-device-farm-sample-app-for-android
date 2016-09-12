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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.amazonaws.devicefarm.android.referenceapp.Adapters.DrawerAdapter;
import com.amazonaws.devicefarm.android.referenceapp.Models.DrawerCategoryModel;
import com.amazonaws.devicefarm.android.referenceapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static android.content.Context.*;

/**
 * Fragment for the the navigation drawer
 */
public class NavigationDrawerFragment extends Fragment {
    @InjectView(R.id.drawerList)
    RecyclerView recycleView;

    private DrawerAdapter drawerAdapter;

    /**
     * Creates and initializes the drawer with the drawer adapter
     * @param fragmentId
     * @param drawerLayout
     * @param data
     * @param toolbar
     * @param listener
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout, List<DrawerCategoryModel> data, Toolbar toolbar, DrawerAdapter.OnItemClickListener listener) {
        drawerAdapter = new DrawerAdapter(data, getActivity(),listener,drawerLayout,getActivity().findViewById(fragmentId));
        recycleView.setAdapter(drawerAdapter);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

        final InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);

        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),0);//TODO utility?
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                drawerToggle.syncState();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.inject(this, layout);
        return layout;
    }
}
