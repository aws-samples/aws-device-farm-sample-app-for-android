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

import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests for a login page
 */
public class LoginPageTest extends BaseADFTest {

    @Override
    protected String getClassName() {
        return "Login Page";
    }

    @Override
    public void testSanity() {
        checkIfAtLogin();
    }

    /**
     * tests if the correct message appears when logging in successfully
     */
    @Test
    public void testLoginPassCheck(){
        loginIn("admin", "password", R.string.login_success_message);
    }

    /**
     * Tests if the correct message appears when failing to log in
     */
    @Test
    public void testLoginFailCheck(){
        loginIn("Wrong Username", "12345", R.string.login_fail_message);
    }

    /**
     * Attemps to log into the form
     *
     * @param user the username
     * @param pass the password
     * @param message the expected message
     */
    private void loginIn(String user, String pass, int message){
        writeTextIntoTextBox(R.id.username_text_input, user);
        writeTextIntoTextBox(R.id.password_text_input, pass);
        clickId(R.id.login_button);
        checkLoginMessage(message);
        clickId(R.id.alt_button);
        checkIfAtLogin();
    }

    /**
     * checks if the expected message is displayed
     *
     * @param message the expected message
     */
    private void checkLoginMessage(int message){
        checkIfIdIsDisplayedWithText(R.id.login_alt_message_textView,
                message);
    }

    /**
     * Checks if at the main login screen
     */
    private void checkIfAtLogin(){
        checkIfIdDisplayed(R.id.login_main_view);
        checkIfIdDisplayed(R.id.username_text_input);
        checkIfIdDisplayed(R.id.password_text_input);
        checkIfIdDisplayed(R.id.login_button);
    }
}
