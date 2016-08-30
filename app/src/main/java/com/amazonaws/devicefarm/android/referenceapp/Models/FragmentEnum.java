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

package com.amazonaws.devicefarm.android.referenceapp.Models;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.amazonaws.devicefarm.android.referenceapp.Fragments.FixturesFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.LocalWebView;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.LoginFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.NestedFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.NotificationsFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.SimpleFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_CheckBoxFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_DatePickerFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_GestureFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_RadioButtonFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_RefreshButtonFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_SpinnerFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_SubmitButtonFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_TimePickerFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Inputs.Input_Toggle_ButtonFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Native.Native_CameraFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Native.Native_ImageGalleryFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.Native.Native_MediaPlayer;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.SupplementalUploads.SupplementalUploads_AdditionalAppFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.Tabs.SupplementalUploads.SupplementalUploads_ExtraDataFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.WebViewFragment;
import com.amazonaws.devicefarm.android.referenceapp.Fragments.crashFragment;
import com.amazonaws.devicefarm.android.referenceapp.R;

/**
 * An Enum representing all the fragments within the app
 */
public enum FragmentEnum {
    HOME(createSimpleFragment(R.layout.fragment_homepage)),
    HTTP(new WebViewFragment()),
    NATIVE(null),
    INPUTS(null),
    NESTED(new NestedFragment()),
    CRASH(new crashFragment()),
    ALERT(new NotificationsFragment()),
    LOGIN(new LoginFragment()),

    //tabs for input
    EDIT_TEXT(createSimpleFragment(R.layout.input_textfield)),
    CHECKBOX(new Input_CheckBoxFragment()),
    RADIO_BUTTON(new Input_RadioButtonFragment()),
    TOGGLE_BUTTON(new Input_Toggle_ButtonFragment()),
    TIME_PICKER(new Input_TimePickerFragment()),
    DATE_PICKER(new Input_DatePickerFragment()),
    SUBMIT_BUTTON(new Input_SubmitButtonFragment()),
    REFRESH(new Input_RefreshButtonFragment()),
    SPINNER(new Input_SpinnerFragment()),
    GESTURES(new Input_GestureFragment()),

    //tabs for native views
    IMAGE_GALLERY(new Native_ImageGalleryFragment()),
    CONTENT_SCROLLING(createSimpleFragment(R.layout.native_content_scrolling)),
    MEDIA_PLAYER(new Native_MediaPlayer()),
    CAMERA(new Native_CameraFragment()),
    OUT_OF_VIEW(createSimpleFragment(R.layout.native_out_of_view_scrolling)),
    FIXTURES(new FixturesFragment()),
    LOCAL_WEB_VIEW(new LocalWebView()),

    //tabs for supplemental uploads
    SUPPLEMENTAL_UPLOADS(null),
    EXTRA_DATA(new SupplementalUploads_ExtraDataFragment()),
    ADDITIONAL_APP(new SupplementalUploads_AdditionalAppFragment());

    private final Fragment fragment;

    FragmentEnum(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment(){
        return this.fragment;
    }

    /**
     * Creates a static fragment with no logic from a layout
     * @param resourceLayoutId
     * @return
     */
    private static Fragment createSimpleFragment(int resourceLayoutId){
        Fragment fragment = new SimpleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("frag_bundle_key", resourceLayoutId);
        fragment.setArguments(bundle);
        return fragment;
    }
}
