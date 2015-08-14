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

package com.amazonaws.devicefarm.android.referenceapp.Categories.Native;

import android.widget.GridView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.StringStartsWith.startsWith;

/**
 * Tests for an image collection
 */
public class ImageCollectionTest extends NativeBase {
    @Override
    protected int getPageIndex() {
        return 0;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.native_image_grid_view);
    }

    /**
     * Tests a image gallery by seeing if a gridview is displayed
     */
    @Test
    public void testImageGallery(){
        onView(withId(R.id.native_image_grid_view)).
                check(matches(withClassName(startsWith(GridView.class.getName())))).
                check(matches(isDisplayed()));
    }
}
