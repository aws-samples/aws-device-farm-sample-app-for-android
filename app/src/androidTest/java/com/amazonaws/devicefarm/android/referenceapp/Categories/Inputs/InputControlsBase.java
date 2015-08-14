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

import com.amazonaws.devicefarm.android.referenceapp.R;
import com.amazonaws.devicefarm.android.referenceapp.ViewPagerTestBase;

import org.junit.Ignore;

/**
 * A base class for all input controls
 */
@Ignore
public abstract class InputControlsBase extends ViewPagerTestBase {
    @Override
    protected String getClassName() {
        return "Input Controls";
    }

    @Override
    protected int getPagerId() {
        return R.id.pager_tabstrip;
    }
}
