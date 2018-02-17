package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    /*private MediaPlayer.OnCompletionListener mCompletionListener=new MediaPlayer.OnCompletionListener() {
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
        Word w = new Word("white","hujal",R.drawable.color_white,R.raw.color_white);
        words.add(w);
        words.add(new Word("black","khaalo",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("red","lhovho",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("yellow","haladhu",R.drawable.color_mustard_yellow,R.raw.color_yellow));

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //releaseMediaPlayer();
                Word word = words.get(position);
                mMediaPlayer= MediaPlayer.create(ColorsActivity.this,word.getmAudioResourceId());
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


