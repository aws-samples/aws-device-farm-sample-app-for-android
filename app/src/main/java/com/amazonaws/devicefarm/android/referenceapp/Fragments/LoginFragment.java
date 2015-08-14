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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A fragment mocking a login page
 */
public class LoginFragment extends Fragment {

    private String USERNAME;
    private String PASSWORD;
    private String FAIL_MESSAGE;
    private String SUCCESS_MESSAGE;
    private String ALT_BUTTON_FAIL_TITLE;
    private String ALT_BUTTON_SUCCESS_TITLE;
    private InputMethodManager imm;

    @InjectView(R.id.login_main_view)
    View mainView;

    @InjectView(R.id.login_alt_view)
    View altView;

    @InjectView(R.id.username_text_input)
    EditText usernameInput;

    @InjectView(R.id.password_text_input)
    EditText passwordInput;

    @InjectView(R.id.login_button)
    Button loginButton;

    @InjectView(R.id.login_alt_message_textView)
    TextView altText;

    @InjectView(R.id.alt_button)
    Button altButton;

    public LoginFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this,view);

        USERNAME = getString(R.string.login_username);
        PASSWORD = getString(R.string.login_password);
        FAIL_MESSAGE = getString(R.string.login_fail_message);
        SUCCESS_MESSAGE = getString(R.string.login_success_message);
        ALT_BUTTON_FAIL_TITLE = getString(R.string.try_login_again_button_title);
        ALT_BUTTON_SUCCESS_TITLE = getString(R.string.logout_button_title);

        imm = (InputMethodManager)getActivity().getSystemService(getActivity().getApplicationContext().INPUT_METHOD_SERVICE);

        return view;
    }

    /**
     * Checks if username and passwork are correct
     */
    @OnClick(R.id.login_button)
    public void loginButtonPressed(){
        imm.hideSoftInputFromWindow(passwordInput.getWindowToken(), 0);

        mainView.setVisibility(View.GONE);
        altView.setVisibility(View.VISIBLE);

        if (usernameInput.getText().toString().equals(USERNAME) && passwordInput.getText().toString().equals(PASSWORD)){
            altButton.setText(ALT_BUTTON_SUCCESS_TITLE);
            altText.setText(SUCCESS_MESSAGE);
            return;
        }
        altButton.setText(ALT_BUTTON_FAIL_TITLE);
        altText.setText(FAIL_MESSAGE);
    }

    /**
     * Resets the view
     */
    @OnClick(R.id.alt_button)
    public void altButtonPressed(){
        usernameInput.setText("");
        passwordInput.setText("");

        altView.setVisibility(View.GONE);
        mainView.setVisibility(View.VISIBLE);
        imm.showSoftInput(usernameInput, InputMethodManager.SHOW_IMPLICIT);
    }


}
