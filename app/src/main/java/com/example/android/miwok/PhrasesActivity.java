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

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Words> phrasesList = new ArrayList<Words>();
        phrasesList.add(new Words("where are you going?", "where are you goingt?", R.raw.phrase_where_are_you_going));
        phrasesList.add(new Words("what is your name", "what is your namet?", R.raw.phrase_what_is_your_name));
        phrasesList.add(new Words("my name is", "my name ist", R.raw.phrase_my_name_is));
        phrasesList.add(new Words("how are you feeling?", "how are you feelingt?", R.raw.phrase_how_are_you_feeling));
        phrasesList.add(new Words("im feeling good", "im feeling goodt", R.raw.phrase_im_feeling_good));
        phrasesList.add(new Words("are you coming?", "are you comingt?", R.raw.phrase_are_you_coming));
        phrasesList.add(new Words("yes im coming", "yes im comingt", R.raw.phrase_yes_im_coming));
        phrasesList.add(new Words("im coming", "im comingt", R.raw.phrase_im_coming));
        phrasesList.add(new Words("let's go", "let's got", R.raw.phrase_lets_go));
        phrasesList.add(new Words("come heret", "come heret", R.raw.phrase_come_here));

        WordsAdapter phrasesAdapter = new WordsAdapter(this, phrasesList, R.color.category_phrases);
        ListView phrasesView = (ListView) findViewById(R.id.phrases_layout);

        phrasesView.setAdapter(phrasesAdapter);

        phrasesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = phrasesList.get(position);
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSongID());
                mMediaPlayer.start();
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
