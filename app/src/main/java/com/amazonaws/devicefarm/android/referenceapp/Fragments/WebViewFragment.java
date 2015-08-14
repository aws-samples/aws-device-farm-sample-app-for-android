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

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.devicefarm.android.referenceapp.R;
import com.amazonaws.devicefarm.android.referenceapp.Util.Util;

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnEditorAction;

/**
 * A fragment representing a web view
 */
public class WebViewFragment extends Fragment {

    @InjectView(R.id.website_input)
    EditText websiteInput;

    @InjectView(R.id.webView_browser)
    WebView webView;

    private boolean isError;

    public WebViewFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.web_fragment,container,false);
        ButterKnife.inject(this, view);
        isError = false;
        //Needed in order to run within appium
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            WebView.setWebContentsDebuggingEnabled(true);

        webView.setWebViewClient(generateWebViewClient());
        webView.loadUrl(getActivity().getString(R.string.default_url));
        return view;
    }

    /**
     * loads a custom url from the url bar
     * @param v
     * @param actionId
     * @return
     */
    @OnEditorAction(R.id.website_input)
    boolean onEditorAction(TextView v, int actionId){

        if (URLUtil.isValidUrl(v.getText().toString()))
            webView.loadUrl(v.getText().toString());
        else
            Toast.makeText(getActivity(),getString(R.string.web_error_toast), Toast.LENGTH_SHORT).show();
        Util.hideKeyboard(websiteInput, getActivity());
        return true;
    }

    /**
     * Generates a WebView client with custom logic for calabash tests
     *
     * @return WebViewClient
     */
    private WebViewClient generateWebViewClient() {
        return new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i("WebView", url);
                if (!isError) {
                    try {
                        webView.setContentDescription((new URL(url)).getHost());
                    } catch (MalformedURLException e) {
                        Log.e("WebView", "Malformed url error");
                    }
                } else {
                    webView.setContentDescription(getString(R.string.webview_fail));
                }
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                isError = true;
            }
        };
    }
}
