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

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Words> familyList = new ArrayList<Words>();
        familyList.add(new Words("father", "fathert", R.drawable.family_father));
        familyList.add(new Words("mother", "mothert", R.drawable.family_mother));
        familyList.add(new Words("son", "sont", R.drawable.family_son));
        familyList.add(new Words("daughter", "daughtert", R.drawable.family_daughter));
        familyList.add(new Words("older brother", "older brothert", R.drawable.family_older_brother));
        familyList.add(new Words("younger brother", "younger brothert", R.drawable.family_younger_brother));
        familyList.add(new Words("older sister", "older sistert", R.drawable.family_older_sister));
        familyList.add(new Words("younger sister", "younger sister", R.drawable.family_younger_sister));
        familyList.add(new Words("grand mother", "grand mothert", R.drawable.family_grandmother));
        familyList.add(new Words("grand father", "grand fathert", R.drawable.family_grandfather));

        WordsAdapter wordsAdapter = new WordsAdapter(this, familyList, R.color.category_family);
        ListView familyListView = (ListView) findViewById(R.id.family_layout);
        familyListView.setAdapter(wordsAdapter);
    }
}
