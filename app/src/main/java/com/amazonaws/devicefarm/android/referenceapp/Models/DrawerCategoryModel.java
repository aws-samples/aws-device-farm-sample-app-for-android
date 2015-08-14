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

import java.util.List;

/**
 * A model of a drawer category
 */
public final class DrawerCategoryModel implements Parcelable{

    private String fragment_id;
    private String category_name;
    private String headline;
    private String icon_name;
    private boolean has_tabs;
    private List<TabViewModel> tabs;

    public List<TabViewModel> getTabs() {
        return tabs;
    }

    public boolean isHas_tabs() {
        return has_tabs;
    }

    public String getHeadline() {
        return headline;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getFragment_id() {
        return fragment_id;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public DrawerCategoryModel() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fragment_id);
        dest.writeString(this.category_name);
        dest.writeString(this.headline);
        dest.writeString(this.icon_name);
        dest.writeByte(has_tabs ? (byte) 1 : (byte) 0);
        dest.writeTypedList(tabs);
    }

    protected DrawerCategoryModel(Parcel in) {
        this.fragment_id = in.readString();
        this.category_name = in.readString();
        this.headline = in.readString();
        this.icon_name = in.readString();
        this.has_tabs = in.readByte() != 0;
        this.tabs = in.createTypedArrayList(TabViewModel.CREATOR);
    }

    public static final Creator<DrawerCategoryModel> CREATOR = new Creator<DrawerCategoryModel>() {
        public DrawerCategoryModel createFromParcel(Parcel source) {
            return new DrawerCategoryModel(source);
        }

        public DrawerCategoryModel[] newArray(int size) {
            return new DrawerCategoryModel[size];
        }
    };
}
