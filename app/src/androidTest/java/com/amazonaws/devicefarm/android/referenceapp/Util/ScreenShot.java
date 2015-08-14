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

package com.amazonaws.devicefarm.android.referenceapp.Util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Screenshot taker for Espresso tests within Device Farm
 *
 * Assigns a random file name to the image and saves it into a specific device farm directory
 */
public class ScreenShot {
    private static final String TAG = "SCREENSHOT";
    private static final String DEVICE_FARM_ESPRESSO_SCREEN_DIRECTORY = "/test-screenshots/";
    private static final int SCREEN_SHOT_IMAGE_QUALITY = 100;

    public static void take(Activity activity){

        final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + DEVICE_FARM_ESPRESSO_SCREEN_DIRECTORY + UUID.randomUUID().toString();;
        Log.i(TAG, "Saving to path: " +  path);

        View phoneView = activity.getWindow().getDecorView().getRootView();
        phoneView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(phoneView.getDrawingCache());
        phoneView.setDrawingCacheEnabled(false);

        OutputStream out = null;

        File imageFile = new File(path);

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, SCREEN_SHOT_IMAGE_QUALITY, out);
            out.flush();
        }

        catch (FileNotFoundException e) {
            Log.e(TAG, e.toString());
        }
        catch (IOException e) {
            Log.e(TAG, e.toString());
        }

        finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                Log.e(TAG, e.toString());
            }
        }
    }
}
