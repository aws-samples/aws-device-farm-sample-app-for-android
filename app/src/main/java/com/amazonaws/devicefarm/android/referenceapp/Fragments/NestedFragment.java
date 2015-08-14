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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazonaws.devicefarm.android.referenceapp.Activities.BackNavigationActivity;
import com.amazonaws.devicefarm.android.referenceapp.Activities.UpNavigationActivity;
import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NestedFragment extends Fragment {

    public NestedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nested_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    /**
     * displays the back button activity
     */
    @OnClick(R.id.nested_back_button)
    public void backButtonOnClick() {
        getActivity().startActivity(new Intent(getActivity(), BackNavigationActivity.class));
    }

    /**
     * Displays the up navigation activity
     */
    @OnClick(R.id.nested_up_button)
    public void upButtonOnClick() {
        getActivity().startActivity(new Intent(getActivity(), UpNavigationActivity.class));
    }
}
