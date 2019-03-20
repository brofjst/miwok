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

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Words> words = new ArrayList<Words>();
        words.add(new Words("one", "onet", R.drawable.number_one, R.raw.number_one));
        words.add(new Words("two", "twot", R.drawable.number_two, R.raw.number_two));
        words.add(new Words("three", "threet", R.drawable.number_three, R.raw.number_three));
        words.add(new Words("four", "fourt", R.drawable.number_four, R.raw.number_four));
        words.add(new Words("five", "fivet", R.drawable.number_five, R.raw.number_five));
        words.add(new Words("six", "sixt", R.drawable.number_six, R.raw.number_six));
        words.add(new Words("seven", "sevent", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Words("eight", "eightt", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Words("nine", "ninet", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Words("ten", "tent", R.drawable.number_ten, R.raw.number_ten));

        WordsAdapter itemsAdapter =
                new WordsAdapter(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.numbers_layout);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = words.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getSongID());
                mediaPlayer.start();
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
