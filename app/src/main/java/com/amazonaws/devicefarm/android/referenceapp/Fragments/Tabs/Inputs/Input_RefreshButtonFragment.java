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

package com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment representing a refresh input
 */
public class Input_RefreshButtonFragment extends android.support.v4.app.Fragment implements
        SwipeRefreshLayout.OnRefreshListener{
    @InjectView(R.id.input_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @InjectView(R.id.input_refresh_display)
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_refresh_fragment, container, false);
        ButterKnife.inject(this, view);
        swipeRefreshLayout.setOnRefreshListener(this);
        return view;
    }

    /**
     * Called when refreshing
     */
    @Override
    public void onRefresh() {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("hh:mm:ss a");
        date.setTimeZone(TimeZone.getDefault());
        textView.setText(date.format(currentLocalTime));
        swipeRefreshLayout.setRefreshing(false);
    }
}
