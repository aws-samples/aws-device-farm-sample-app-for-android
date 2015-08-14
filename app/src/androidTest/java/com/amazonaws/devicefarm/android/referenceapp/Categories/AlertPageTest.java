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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Tests for alerts/notifications
 */
public class AlertPageTest extends BaseADFTest{
    @Override
    protected String getClassName() {
        return "Alerts";
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.notifications_alert_button);
        checkIfIdDisplayed(R.id.notifications_toast_button);
    }

    /**
     * Clicks the toast button and checks if the toast text is displayed
     */
    @Test
    public void testToast(){
        clickId(R.id.notifications_toast_button);
        verifyToastMessage(R.string.Toast_button_message);
    }

    /**
     * Clicks the alert button and checks if the alert text is displayed
     */
    @Test
    public void testAlert(){
        clickId(R.id.notifications_alert_button);
        onView(withText(R.string.alert_message)).check(matches(isDisplayed()));
        onView(withText("OK")).perform(click());
    }
}
