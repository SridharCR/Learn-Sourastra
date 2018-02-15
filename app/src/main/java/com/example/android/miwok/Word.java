package com.example.android.miwok;

/**
 * Created by crsri on 1/1/2017.
 */

public class Word {
    private String mEnglishTrans;
    private String mSourTrans;
    private int mImageResourceId=NO_IMG_STATE;
    private static final int NO_IMG_STATE=-1;
    private int mAudioResourceId;

    public Word(String eng,String sour,int au){
        mEnglishTrans=eng;
        mSourTrans=sour;
        mAudioResourceId=au;
    }
    public Word(String eng,String sour,int re,int au){
        mEnglishTrans=eng;
        mSourTrans=sour;
        mImageResourceId=re;
        mAudioResourceId=au;
    }
    public String getEnglishTrans(){
        return mEnglishTrans;
    }

    public String getSourTrans(){
        return mSourTrans;
    }
    public int getImageResourceId(){
        return mImageResourceId;
    }
    public boolean hasImage(){
        return mImageResourceId!=NO_IMG_STATE;
    }
    public int getmAudioResourceId(){ return mAudioResourceId; }


}
