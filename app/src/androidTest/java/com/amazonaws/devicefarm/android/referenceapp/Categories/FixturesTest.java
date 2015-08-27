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

/**
 * Tests for fixtures
 */
public class FixturesTest extends BaseADFTest {
    @Override
    protected String getClassName() {
        return "Fixtures";
    }

    @Override
    public void testSanity() {
        checkIfIdDisplayed(R.id.lat);
        checkIfIdDisplayed(R.id.longitude);
        checkIfIdDisplayed(R.id.wifi);
        checkIfIdDisplayed(R.id.bluetooth);
        checkIfIdDisplayed(R.id.gps);
        checkIfIdDisplayed(R.id.nfc);
    }

    /**
     * Tests if the wifi is on
     */
    @Test
    public void testWifiOn (){
        assertIdStatus(R.id.wifi, true);
    }

    /**
     * Tests if the bluetooth is on
     */
    @Test
    public void testBluetoothOn() {
        assertIdStatus(R.id.bluetooth, true);
    }

    /**
     * Tests if the gps is on
     */
    @Test
    public void testGpsOn() {
        assertIdStatus(R.id.gps, true);
    }

    /**
     * Tests if the nfc is on. Fails on devices with no nfc support
     */
    @Test
    public void testNfcOn() {
        assertIdStatus(R.id.nfc, true);
    }

    /**
     * Asserts the status of a specific id
     *
     * @param id element id
     * @param status boolean status
     */
    private void assertIdStatus(int id, boolean status){
        checkIfIdIsDisplayedWithText(id, Boolean.toString(status));
    }
}
