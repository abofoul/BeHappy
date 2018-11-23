package com.example.android.behappy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteTextView = fragmentView.findViewById(R.id.quote_text_view);
        TextView authorTextView = fragmentView.findViewById(R.id.author_text_view);
        CardView cardView = fragmentView.findViewById(R.id.card_view);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[] {R.color.blue_500, R.color.pink_900, R.color.green_400,
                R.color.lime_400, R.color.orange_400, R.color.amber_800, R.color.pink_800,
                R.color.grey_700};

        quoteTextView.setText(quote);
        authorTextView.setText("-" + author);

        cardView.setBackgroundResource(getRandomColor(colors));

        return fragmentView;

    }

    public static final QuoteFragment newInstance(String quote , String author){
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();

        bundle.putString("quote" , quote);
        bundle.putString("author" , author);

        fragment.setArguments(bundle);

        return fragment;
    }


    int getRandomColor(int[] colorArray){
        int color;

        Random random = new Random();
        int randomNum = random.nextInt(colorArray.length);
        color = colorArray[randomNum];

        Log.d("Error color" , "num is = " + randomNum);
        return color;

    }
}
