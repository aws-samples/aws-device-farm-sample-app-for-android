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

import com.amazonaws.devicefarm.android.referenceapp.R;

import org.junit.Test;

/**
 * Tests for a camera preview
 */
public class CameraPreviewTest extends NativeBase {
    @Override
    protected int getPageIndex() {
        return 3;
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.camera_surface_view);
    }

    /**
     * Tests a camera preview by checking if it's element's content description
     * indicates that it's on. Fails on devices with no camera support.
     */
    @Test
    public void testCheckIfCameraOn() {
        checkIdWithContentDescription(R.id.camera_surface_view, R.string.camera_preview_on);
    }
}
