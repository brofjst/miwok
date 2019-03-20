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

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        final ArrayList<Words> familyList = new ArrayList<Words>();
        familyList.add(new Words("father", "fathert", R.drawable.family_father, R.raw.family_father));
        familyList.add(new Words("mother", "mothert", R.drawable.family_mother, R.raw.family_mother));
        familyList.add(new Words("son", "sont", R.drawable.family_son, R.raw.family_son));
        familyList.add(new Words("daughter", "daughtert", R.drawable.family_daughter, R.raw.family_daughter));
        familyList.add(new Words("older brother", "older brothert", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyList.add(new Words("younger brother", "younger brothert", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyList.add(new Words("older sister", "older sistert", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyList.add(new Words("younger sister", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyList.add(new Words("grand mother", "grand mothert", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyList.add(new Words("grand father", "grand fathert", R.drawable.family_grandfather, R.raw.family_grandfather));

        WordsAdapter wordsAdapter = new WordsAdapter(this, familyList, R.color.category_family);
        ListView familyListView = (ListView) findViewById(R.id.family_layout);

        familyListView.setAdapter(wordsAdapter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words word = familyList.get(position);
                MediaPlayer mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getSongID());
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
