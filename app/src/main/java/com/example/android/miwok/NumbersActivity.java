package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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
        Word w = new Word("one","onta",R.drawable.number_one,R.raw.number_one);
        words.add(w);
        words.add(new Word("two","dhoo",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","theen",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","char",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","panch",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","shoo",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","shaat",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","ahat",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","noov",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","dhus",R.drawable.number_ten,R.raw.number_ten));
        //final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.number_one);

        WordAdapter adapter = new WordAdapter(this,words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //releaseMediaPlayer();
                Word word = words.get(position);
                mMediaPlayer= MediaPlayer.create(NumbersActivity.this,word.getmAudioResourceId());
                mMediaPlayer.start();
                Log.v("NumbersActivity", "Current word: " + word);
                //mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });




    } /*
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
    }*/
}

