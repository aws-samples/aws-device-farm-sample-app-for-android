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

package com.amazonaws.devicefarm.android.referenceapp;


import android.support.test.InstrumentationRegistry;
import android.support.test.annotation.UiThreadTest;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import com.amazonaws.devicefarm.android.referenceapp.Activities.MainActivity;
import com.amazonaws.devicefarm.android.referenceapp.Util.ScreenShot;

import org.junit.Ignore;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * The base Espresso class for all the Espresso tests
 */
@Ignore
public abstract class BaseADFTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public BaseADFTest() {
        super(MainActivity.class);
    }

    protected abstract String getClassName();

    @UiThreadTest
    @Test
    public abstract void testSanity();

    /**
     * Gets the activity and navigates to the Class's category in the navigation drawer
     *
     * Uses espresso-contrib dor navigation drawer and recyclerView support
     *
     * @throws Exception instrumentation ActivityInstrumentationTestCase2 exception
     */
    @Override
    protected void setUp() throws Exception {
        getActivity(); //IMPORTANT you must call this before your tests!
        super.setUp();
        DrawerActions.openDrawer(R.id.drawer_layout);
        RecyclerViewActions.scrollTo(withText(getClassName()));
        onView(withId(R.id.drawerList)).perform(RecyclerViewActions.actionOnItem(hasDescendant(withText(getClassName())), click()));
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
    }

    /**
     * Takes a screenshot after every test
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        try {
            takeScreenShot();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        super.tearDown();
    }

    /**
     * Inputs text into a specific id
     *
     * @param id the input id
     * @param text the text to input
     */
    protected void writeTextIntoTextBox(int id, String text){
        onView(withId(id)).perform(typeText(text));
    }

    /**
     * clicks an element id
     *
     * @param id the element id
     */
    protected void clickId(int id){
        onView(withId(id)).perform(click());
    }

    /**
     * Checks if id is displayed with expected text
     *
     * @param id the element id
     * @param textResource the string resource id of the expected text
     */
    protected void checkIfIdIsDisplayedWithText(int id, int textResource){
        onView(withId(id)).check(matches(withText(textResource))).check(matches(isDisplayed()));
    }

    /**
     * Checks if id is displayed with expected text
     *
     * @param id the element id
     * @param text the string of the expected text
     */
    protected void checkIfIdIsDisplayedWithText(int id, String text){
        onView(withId(id)).check(matches(withText(text))).check(matches(isDisplayed()));
    }

    /**
     * Checks if a specific id is displayed
     * @param id the element id
     */
    protected void checkIfIdDisplayed(int id){
        onView(withId(id)).check(matches(isDisplayed()));
    }

    /**
     * A method to take a screenshot
     *
     * It is important to run the screenshot take on the UI thread.
     * Not doing so can cause threading errors or unexpected results.
     *
     * @throws Throwable
     */
    protected void takeScreenShot() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                ScreenShot.take(getActivity());
            }
        });
    }

    /**
     * Checks if a toast message is displayed
     * @param messageId the string resource of the expected toast message
     */
    protected void verifyToastMessage(int messageId){
        onView(withText(messageId)).
                inRoot(withDecorView(not(getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

    /**
     * Convenience method to match a specific id with a specific content description resource id
     * @param id the element id
     * @param contentDescriptionId the elements content description id
     */
    protected void checkIdWithContentDescription(int id, int contentDescriptionId) {
        onView(withId(id)).check(matches(withContentDescription(contentDescriptionId)));
    }

    /**
     * Convenience method to match a specific id with a specific content description
     * @param id the element id
     * @param contentDescription the expected content description
     */
    protected void checkIdWithContentDescription(int id, String contentDescription) {
        onView(withId(id)).check(matches(withContentDescription(contentDescription)));
    }
}
