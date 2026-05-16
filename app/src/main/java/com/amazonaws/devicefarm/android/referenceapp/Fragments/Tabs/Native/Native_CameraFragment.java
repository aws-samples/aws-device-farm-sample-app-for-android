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

package com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Native;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.amazonaws.devicefarm.android.referenceapp.R;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A fragment that demos a camera preview using Camera2 API
 */
public class Native_CameraFragment extends Fragment implements SurfaceHolder.Callback {
    private static final String TAG = "CAMERA_FRAGMENT";

    @BindView(R.id.camera_surface_view)
    SurfaceView surfaceView;

    private CameraDevice cameraDevice;
    private CameraCaptureSession captureSession;
    private HandlerThread backgroundThread;
    private Handler backgroundHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.native_camera_fragment, container, false);
        ButterKnife.bind(this, view);
        surfaceView.getHolder().addCallback(this);
        return view;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startBackgroundThread();
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
        } else {
            openCamera();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        closeCamera();
        stopBackgroundThread();
    }

    private void openCamera() {
        Context ctx = getActivity();
        if (ctx == null) return;

        if (ContextCompat.checkSelfPermission(ctx, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.w(TAG, "Camera permission not granted");
            return;
        }

        CameraManager manager = (CameraManager) ctx.getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = manager.getCameraIdList()[0];
            manager.openCamera(cameraId, new CameraDevice.StateCallback() {
                @Override
                public void onOpened(@NonNull CameraDevice camera) {
                    cameraDevice = camera;
                    startPreview();
                }

                @Override
                public void onDisconnected(@NonNull CameraDevice camera) {
                    camera.close();
                    cameraDevice = null;
                }

                @Override
                public void onError(@NonNull CameraDevice camera, int error) {
                    camera.close();
                    cameraDevice = null;
                    Log.e(TAG, "Camera error: " + error);
                }
            }, backgroundHandler);
        } catch (CameraAccessException | SecurityException e) {
            Log.e(TAG, "Failed to open camera", e);
        }
    }

    private void startPreview() {
        if (cameraDevice == null || !surfaceView.getHolder().getSurface().isValid()) return;

        try {
            CaptureRequest.Builder builder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            builder.addTarget(surfaceView.getHolder().getSurface());

            cameraDevice.createCaptureSession(
                Collections.singletonList(surfaceView.getHolder().getSurface()),
                new CameraCaptureSession.StateCallback() {
                    @Override
                    public void onConfigured(@NonNull CameraCaptureSession session) {
                        captureSession = session;
                        try {
                            session.setRepeatingRequest(builder.build(), null, backgroundHandler);
                            surfaceView.setContentDescription(getString(R.string.camera_preview_on));
                        } catch (CameraAccessException e) {
                            Log.e(TAG, "Failed to start preview", e);
                        }
                    }

                    @Override
                    public void onConfigureFailed(@NonNull CameraCaptureSession session) {
                        Log.e(TAG, "Camera configuration failed");
                    }
                },
                backgroundHandler
            );
        } catch (CameraAccessException e) {
            Log.e(TAG, "Failed to create capture session", e);
        }
    }

    private void closeCamera() {
        if (captureSession != null) {
            captureSession.close();
            captureSession = null;
        }
        if (cameraDevice != null) {
            cameraDevice.close();
            cameraDevice = null;
        }
    }

    private void startBackgroundThread() {
        backgroundThread = new HandlerThread("CameraBackground");
        backgroundThread.start();
        backgroundHandler = new Handler(backgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        if (backgroundThread != null) {
            backgroundThread.quitSafely();
            try {
                backgroundThread.join();
            } catch (InterruptedException e) {
                Log.e(TAG, "Background thread interrupted", e);
            }
            backgroundThread = null;
            backgroundHandler = null;
        }
    }
}
