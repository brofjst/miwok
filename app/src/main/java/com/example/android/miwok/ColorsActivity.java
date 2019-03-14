/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<Words> colorsList = new ArrayList<Words>();
        colorsList.add(new Words("red", "redt", R.drawable.color_red));
        colorsList.add(new Words("green", "greent", R.drawable.color_green));
        colorsList.add(new Words("brown", "brownt", R.drawable.color_brown));
        colorsList.add(new Words("gray", "grayt", R.drawable.color_gray));
        colorsList.add(new Words("black", "blackt", R.drawable.color_black));
        colorsList.add(new Words("white", "whitet", R.drawable.color_white));
        colorsList.add(new Words("dusty yellow", "dusty yellowt", R.drawable.color_dusty_yellow));
        colorsList.add(new Words("red", "redt", R.drawable.color_red));
        colorsList.add(new Words("mustard yellow", "mustard yellowt", R.drawable.color_mustard_yellow));

        WordsAdapter wordsAdapter = new WordsAdapter(this, colorsList, R.color.category_colors);
        ListView colorsView = (ListView) findViewById(R.id.colors_layout);

        colorsView.setAdapter(wordsAdapter);
    }
}
