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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.Models.DrawerCategoryModel;
import com.amazonaws.devicefarm.android.referenceapp.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * <h1>Navigation Drawer Adapter</h1>
 * <p>A adapter for the navigation drawer which initalizes the rows of the drawer</p>
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolder>{
    private final List<DrawerCategoryModel> data;
    private OnItemClickListener listener;
    private View container;
    private DrawerLayout drawerLayout;
    private final Context context;

    /**
     * Used to communicate to the main activity
     */
    public interface OnItemClickListener {
        void onNavMenuItemClick(View view, int position);
    }

    /**
     * Class represents the view which contains a row
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected int viewType;

        @InjectView(R.id.drawer_row_icon) ImageView rowImage;
        @InjectView(R.id.drawer_row_title) TextView rowTitle;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            this.viewType = viewType;
            ButterKnife.inject(this, itemView);
        }
    }

    public DrawerAdapter(final List<DrawerCategoryModel> data, final Context context,
                         final OnItemClickListener listener, final DrawerLayout drawerLayout,
                         final View container){
        this.data = data;
        this.context = context;
        this.listener = listener;
        this.drawerLayout = drawerLayout;
        this.container = container;
    }

    @Override
    /**
     * Creates the view holder for the row
     */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_row, parent, false);
            return new ViewHolder(view, viewType);
    }

    @Override
    /**
     * Sets up a drawer row
     */
    public void onBindViewHolder(ViewHolder holder, final int position) {
            String rowText = data.get(position).getCategory_name();
            holder.rowTitle.setText(rowText);
            holder.rowImage.setImageResource(getImageResourceFromName(data.get(position).getIcon_name()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNavMenuItemClick(v, position);
                    drawerLayout.closeDrawer(container);
                }
            });
    }

    @Override
    /**
     * returns the size of the collection
     */
    public int getItemCount() {
        return data.size();
    }

    /**
     * Gets a category image from the row image name
     * @param name
     * @return
     */
    private int getImageResourceFromName(String name){
        final String BASE_URL = "ic_action_";
        return context.getResources().getIdentifier(BASE_URL + name, "drawable", context.getPackageName());
    }
}
