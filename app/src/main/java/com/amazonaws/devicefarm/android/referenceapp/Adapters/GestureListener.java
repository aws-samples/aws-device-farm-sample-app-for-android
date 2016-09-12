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
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.amazonaws.devicefarm.android.referenceapp.R;

/**
 * <h1>A class that controls the logic for different gestures</h1>
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    private final TextView textView;
    private final Context context;

    public GestureListener(final TextView textView, final Context context) {
        super();
        this.context = context;
        this.textView = textView;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        // Up motion completing a single tap occurred.
        displayEvent(R.string.single_up_tap);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // Touch has been long enough to indicate a long press.
        // Does not indicate motion is complete yet (no up event necessarily)
        displayEvent(R.string.long_press_tap);
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        displayEvent(R.string.scroll_tap);
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        // Fling event occurred.  Notification of this one happens after an "up" event.
        displayEvent(R.string.fling_tap);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        // User performed a down event, and hasn't moved yet.
        displayEvent(R.string.press_tap);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        // "Down" event - User touched the screen.
        displayEvent(R.string.down_tap);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        // User tapped the screen twice.
        displayEvent(R.string.double_tap);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        displayEvent(R.string.double_tap_event);
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        // A confirmed single-tap event has occurred.  Only called when the detector has
        // determined that the first tap stands alone, and is not part of a double tap.
        displayEvent(R.string.Single_tap);
        return false;
    }

    /**
     * Displays a message 
     * @param resourceId
     */
    private void displayEvent(int resourceId){
        textView.append(context.getString(resourceId));
        textView.append("\n");
    }
}
