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
 * Screenshot taker for Espresso tests within AWS Device Farm
 *
 * Saves the image with the specified name (or a randomly generated one) and
 * saves it into a directory Device Farm will pull from when generating reports
 */
public class ScreenShot {
    private static final String TAG = "SCREENSHOT";
    private static final String DEVICE_FARM_ESPRESSO_SCREEN_DIRECTORY = "/test-screenshots/";
    private static final int SCREEN_SHOT_IMAGE_QUALITY = 100;

    public static void take(Activity activity, String fileName) {
        // Create the directory path
        final StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        pathBuilder.append(DEVICE_FARM_ESPRESSO_SCREEN_DIRECTORY);

        // Verify that the directory exists and create it if not
        File directoryPath = new File(pathBuilder.toString());
        if (!directoryPath.isDirectory()) {
            Log.i(TAG, "Creating directory: " + directoryPath);
            directoryPath.mkdirs();
        }

        // Build the full file path
        pathBuilder.append(fileName);
        pathBuilder.append(".png");

        final String path = pathBuilder.toString();

        Log.i(TAG, "Saving to path: " + path);

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

    public static void take(Activity activity) {
        take(activity, UUID.randomUUID().toString());
    }
}
