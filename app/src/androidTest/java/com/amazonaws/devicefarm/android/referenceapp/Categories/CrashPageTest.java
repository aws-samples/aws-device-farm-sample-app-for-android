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

import android.support.test.espresso.PerformException;

import com.amazonaws.devicefarm.android.referenceapp.BaseADFTest;
import com.amazonaws.devicefarm.android.referenceapp.R;
import org.junit.Test;

/**
 * Tests for a crash page
 */
public class CrashPageTest extends BaseADFTest{
    @Override
    protected String getClassName() {
        return "Crash/Bug";
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.bug_fragment_message);
        checkIfIdDisplayed(R.id.crash_button);
    }

    /**
     * Tests if the app crashes when the crash button is pressed
     */
    @Test(expected = PerformException.class)
    public void testVerifyCrash(){
        checkIfIdIsDisplayedWithText(R.id.bug_fragment_message, R.string.crash_headline);
        try {
            clickId(R.id.crash_button);
            fail("App did not crash");
        } catch (PerformException e ){}
    }
}