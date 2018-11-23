package com.example.android.behappy.model;

public class Quote {

    private String mQuote;

    private String mAuthor;

    public Quote(String quote , String author){
        mQuote = quote;
        mAuthor = author;

    }
    public String getmQuote() {
        return mQuote;
    }

    public String getmAuthor() {
        return mAuthor;
    }
}
