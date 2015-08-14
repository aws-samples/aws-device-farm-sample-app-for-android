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

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkArgument;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.CoreMatchers.is;

/**
 * A custom matcher for regular expressions
 */
public final class RegularExpressionMatcher{

    /**
     * Matches a string to a specific pattern
     *
     * @param pattern regular expression
     * @return the matcher result
     */
    public static Matcher<View> matchesPattern(final String pattern){
        checkNotNull(pattern);
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public void describeTo(final Description description) {
                description.appendText("The textview does not conform to the pattern: ")
                        .appendText(pattern);
            }

            @Override
            protected boolean matchesSafely(TextView textView) {
                return textView.getText().toString().matches(pattern);
            }
        };
    }


}