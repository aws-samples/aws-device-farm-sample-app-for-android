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

package com.amazonaws.devicefarm.android.referenceapp.Categories;

import com.amazonaws.devicefarm.android.referenceapp.BaseADFTest;
import com.amazonaws.devicefarm.android.referenceapp.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests for a static homepage
 */
public class HomePageTest extends BaseADFTest {
    @Override
    protected String getClassName() {
        return "Home";
    }

    @Override
    public void testSanity() {
        checkIfIdIsDisplayedWithText(R.id.homepage_headline,
                R.string.adf_homepage_headline);

        checkIfIdIsDisplayedWithText(R.id.homepage_subheadline,
                R.string.adf_homepage_subtitle);
    }
}
