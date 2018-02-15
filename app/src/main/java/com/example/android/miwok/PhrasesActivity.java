package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    /*private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("What is your name?","Thora naav khayo?",R.raw.phrases_1));
        words.add(new Word("My name is..","Mora naavu..",R.raw.phrases_2));
        words.add(new Word("Where are you going?","Khood jaryo?",R.raw.phrases_3));
        words.add(new Word("How are you feeling?","Khono lavaras",R.raw.phrases_4));
        words.add(new Word("I’m feeling good","Chokad lavaras",R.raw.phrases_5));
        words.add(new Word("Are you coming?","Thu avaryo ya?",R.raw.phrases_6));
        words.add(new Word("Yes, I’m coming","Hai, me avaryo",R.raw.phrases_7));
        words.add(new Word("Let’s go","Aav jeyangan",R.raw.phrases_8));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //releaseMediaPlayer();
                Word word = words.get(position);
                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this,word.getmAudioResourceId());
                mMediaPlayer.start();
                Log.v("NumbersActivity", "Current word: " + word);
                //mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /*private void releaseMediaPlayer() {
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
    }*/
}
