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

package com.amazonaws.devicefarm.android.referenceapp.Util;

import android.content.Context;

import com.amazonaws.devicefarm.android.referenceapp.Models.DrawerCategoryModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Parses Json into the data models
 */
public class JsonParser {

    private Context context;
    private int resId;

    public JsonParser(Context context, int resId) {
        this.context = context;
        this.resId = resId;
    }

    /**
     * Parses the JSON file into data models
     * @return List of DrawerCategory Models
     */
    public List<DrawerCategoryModel> serializeJson(){
        try {
            Reader reader = new InputStreamReader(context.getResources().openRawResource(resId));
            Gson gson = new GsonBuilder().create();
            Type listType = new TypeToken<List<DrawerCategoryModel>>(){}.getType();
            List<DrawerCategoryModel> list = gson.fromJson(reader,listType);
            reader.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
