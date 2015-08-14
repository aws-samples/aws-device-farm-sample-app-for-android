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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model representing a tab within the viewpager
 */
public final class TabViewModel implements Parcelable{
    private String tab_id;
    private String tab_name;
    private String tab_headline;

    public String getTab_id() {
        return tab_id;
    }

    public String getTab_name() {
        return tab_name;
    }

    public String getTab_headline() {
        return tab_headline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tab_id);
        dest.writeString(this.tab_name);
        dest.writeString(this.tab_headline);
    }

    public TabViewModel() {
    }

    protected TabViewModel(Parcel in) {
        this.tab_id = in.readString();
        this.tab_name = in.readString();
        this.tab_headline = in.readString();
    }

    public static final Creator<TabViewModel> CREATOR = new Creator<TabViewModel>() {
        public TabViewModel createFromParcel(Parcel source) {
            return new TabViewModel(source);
        }

        public TabViewModel[] newArray(int size) {
            return new TabViewModel[size];
        }
    };
}
