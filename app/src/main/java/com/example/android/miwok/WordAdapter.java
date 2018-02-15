package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by crsri on 1/1/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> words,int colorResourceId ) {
        super(context, 0, words);
        mColorResourceId= colorResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        Word currentWord = getItem(position);
        TextView sourTextView = (TextView) listItemView.findViewById(R.id.sour_text_view);
        sourTextView.setText(currentWord.getSourTrans());
        TextView engTextView = (TextView) listItemView.findViewById(R.id.english_text_view);
        engTextView.setText(currentWord.getEnglishTrans());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
        }


    }

