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

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("one", "onet", R.drawable.number_one));
        words.add(new Words("two", "twot", R.drawable.number_two));
        words.add(new Words("three", "threet", R.drawable.number_three));
        words.add(new Words("four", "fourt", R.drawable.number_four));
        words.add(new Words("five", "fivet", R.drawable.number_five));
        words.add(new Words("six", "sixt", R.drawable.number_six));
        words.add(new Words("seven", "sevent", R.drawable.number_seven));
        words.add(new Words("eight", "eightt", R.drawable.number_eight));
        words.add(new Words("nine", "ninet", R.drawable.number_nine));
        words.add(new Words("ten", "tent", R.drawable.number_ten));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.numbers_layout);
        listView.setAdapter(itemsAdapter);
    }
}
