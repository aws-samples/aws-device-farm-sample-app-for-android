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

package com.amazonaws.devicefarm.android.referenceapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * <h1>Back Navigation Activity</h1>
 * <p>
 *     A activity which is used to display back navigation.
 *     </br>
 *     A simple activity with a button which increments a counter for each new
 *     activity pushed to the stack
 * </p>
 */
public class BackNavigationActivity extends AppCompatActivity {
    private int PeerCount;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @InjectView(R.id.back_navigation_counter)
    TextView counter;

    @InjectView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_navigation);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarTitle.setText(R.string.back_navigation_activity_title);


        PeerCount = getIntent().getIntExtra(getString(R.string.PEER_COUNT), 0) + 1;
        counter.setText(String.format("%d",PeerCount));
    }

    /**
     * Returns to the previous activity when the hardware back button
     * is pressed
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * Creates a new activity with a incremented number
     */
    @OnClick(R.id.back_navigation_next_button)
    public void nextButtonOnClick(){
        Intent target = new Intent(this, BackNavigationActivity.class);
        target.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        target.putExtra(getString(R.string.PEER_COUNT), PeerCount);
        startActivity(target);
    }
}
