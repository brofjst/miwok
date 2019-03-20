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

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<Words> colorsList = new ArrayList<Words>();
        colorsList.add(new Words("red", "redt", R.drawable.color_red, R.raw.color_red));
        colorsList.add(new Words("green", "greent", R.drawable.color_green, R.raw.color_green));
        colorsList.add(new Words("brown", "brownt", R.drawable.color_brown, R.raw.color_brown));
        colorsList.add(new Words("gray", "grayt", R.drawable.color_gray, R.raw.color_gray));
        colorsList.add(new Words("black", "blackt", R.drawable.color_black, R.raw.color_black));
        colorsList.add(new Words("white", "whitet", R.drawable.color_white, R.raw.color_white));
        colorsList.add(new Words("dusty yellow", "dusty yellowt", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsList.add(new Words("red", "redt", R.drawable.color_red, R.raw.color_red));
        colorsList.add(new Words("mustard yellow", "mustard yellowt", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordsAdapter wordsAdapter = new WordsAdapter(this, colorsList, R.color.category_colors);
        ListView colorsView = (ListView) findViewById(R.id.colors_layout);

        colorsView.setAdapter(wordsAdapter);

        colorsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = colorsList.get(position);
                MediaPlayer mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getSongID());
                mMediaPlayer.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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

}
