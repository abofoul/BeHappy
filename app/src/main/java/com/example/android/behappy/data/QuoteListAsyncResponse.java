package com.example.android.behappy.data;

import com.example.android.behappy.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {

    void processFinished(ArrayList<Quote> quotes);
}
