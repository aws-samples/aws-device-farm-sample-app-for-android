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

package com.amazonaws.devicefarm.android.referenceapp.IdlingResources;

import android.support.test.espresso.IdlingResource;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * A way to ensure that the website to fully loaded before continuing.
 *
 */
public class WebViewIdlingResource extends WebChromeClient implements IdlingResource{
    private static final int FINISHED = 100;
    private final WebView webView;
    private ResourceCallback resourceCallback;

    public WebViewIdlingResource(WebView webView) {
        this.webView = webView;
        webView.setWebChromeClient(this);
    }

    @Override
    public String getName() {
        return "WebViewIdlingResource";
    }

    /**
     * Idle if the progress is 100% or the window's title is not blank
     * @return
     */
    @Override
    public boolean isIdleNow() {
        if (webView == null) return true;
        return webView.getProgress() == FINISHED && webView.getTitle() != null;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        this.resourceCallback = resourceCallback;
    }

    /**
     * Updates the progress
     *
     * @param view the webview
     * @param newProgress the current progress
     */
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        Log.i(getName(), ""  + newProgress);
        if (newProgress == FINISHED && view.getTitle() != null && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
    }

    /**
     * Called when the web view title is received
     *
     * @param view the webview
     * @param title the web title
     */
    @Override
    public void onReceivedTitle(WebView view, String title) {
        Log.i(getName(), title);
        if (webView.getProgress() == FINISHED && resourceCallback != null) {
            resourceCallback.onTransitionToIdle();
        }
    }
}
