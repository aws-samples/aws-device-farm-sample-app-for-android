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

package com.amazonaws.devicefarm.android.referenceapp.Adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.amazonaws.devicefarm.android.referenceapp.R;
import com.squareup.picasso.Picasso;

/**
 * A base adapter for the image gallery. Uses the Glide library to load the images in asynchronously.
 */
public class ImageGalleryAdapter extends BaseAdapter {

    private final Context context;
    private final TypedArray galleryIds;

    public ImageGalleryAdapter(Context context){
        this.context = context;
        galleryIds = context.getResources().obtainTypedArray(R.array.image_gallery_image_ids);
    }

    @Override
    public int getCount() {
        return galleryIds.length();
    }

    @Override
    public Object getItem(int position) {
        return galleryIds.getDrawable(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else{
            imageView = (ImageView) convertView;
        }
        Picasso.with(context).load(galleryIds.getResourceId(position, -1)).resize(300,300).into(imageView);
        return imageView;
    }
}
