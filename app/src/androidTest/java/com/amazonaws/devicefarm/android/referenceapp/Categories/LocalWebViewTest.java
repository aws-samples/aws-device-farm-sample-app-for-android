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

import android.support.test.espresso.web.webdriver.Locator;

import com.amazonaws.devicefarm.android.referenceapp.BaseADFTest;
import com.amazonaws.devicefarm.android.referenceapp.R;


import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.assertion.WebViewAssertions.webContent;
import static android.support.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static android.support.test.espresso.web.matcher.DomMatchers.hasElementWithId;
import static android.support.test.espresso.web.matcher.DomMatchers.withTextContent;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.getText;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webKeys;
import static org.hamcrest.CoreMatchers.containsString;


import org.junit.Test;

/**
 * Tests for a hybrid local web view
 */
public class LocalWebViewTest extends BaseADFTest {
    private final String FIRST_NAME_FORM_ID = "first-name-form";
    private final String LAST_NAME_FORM_ID = "last-name-form";
    private final String FULL_NAME_DISPLAY_ID = "full_name";
    private final String[] FIRST_NAMES = {"Montreal","Las Vegas", "Austin"};
    private final String[] LAST_NAMES = {"Quebec","Nevada", "Texas"};

    @Override
    protected String getClassName() {
        return "Local Web View";
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.webView_browser);
        onWebView().check(webContent(hasElementWithId(FIRST_NAME_FORM_ID)));
        onWebView().check(webContent(hasElementWithId(LAST_NAME_FORM_ID)));
        onWebView().check(webContent(hasElementWithId(FULL_NAME_DISPLAY_ID)));

    }

    /**
     * Assert all of the names and assert if they are displayed
     */
    @Test
    public void testFullName(){
        for (int i = 0; i < LAST_NAMES.length; i++) {
            assertName(FIRST_NAMES[i], LAST_NAMES[i]);
        }
    }

    /**
     * Enters a full name and then asserts if it's displayed
     *
     * @param firstName the entered first name
     * @param lastName the entered last name
     */
    private void assertName(String firstName, String lastName) {
        typeIntoWebField(FIRST_NAME_FORM_ID, firstName);
        typeIntoWebField(LAST_NAME_FORM_ID, lastName);
        onWebView().withElement(findElement(Locator.ID, FULL_NAME_DISPLAY_ID)).
                check(webMatches(getText(), containsString(firstName + " " + lastName)));
    }

    /**
     * Types a given string into a id
     *
     * @param id the element id
     * @param text the text input
     */
    private void typeIntoWebField(String id, String text){
        onWebView().withElement(findElement(Locator.ID, id)).perform(clearElement()).perform(webKeys(text));
    }
}
