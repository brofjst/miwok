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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Words> phrasesList = new ArrayList<Words>();
        phrasesList.add(new Words("where are you going?", "where are you goingt?"));
        phrasesList.add(new Words("what is your name", "what is your namet?"));
        phrasesList.add(new Words("my name is", "my name ist"));
        phrasesList.add(new Words("how are you feeling?", "how are you feelingt?"));
        phrasesList.add(new Words("im feeling good", "im feeling goodt"));
        phrasesList.add(new Words("are you coming?", "are you comingt?"));
        phrasesList.add(new Words("yes im coming", "yes im comingt"));
        phrasesList.add(new Words("im coming", "im comingt"));
        phrasesList.add(new Words("let's go", "let's got"));
        phrasesList.add(new Words("come heret", "come heret"));

        WordsAdapter phrasesAdapter = new WordsAdapter(this, phrasesList, R.color.category_phrases);
        ListView phrasesView = (ListView) findViewById(R.id.phrases_layout);

        phrasesView.setAdapter(phrasesAdapter);
    }
}
