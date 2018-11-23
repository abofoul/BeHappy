package com.example.android.behappy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;

import com.example.android.behappy.data.QuoteAdapter;
import com.example.android.behappy.data.QuoteData;
import com.example.android.behappy.data.QuoteListAsyncResponse;
import com.example.android.behappy.model.Quote;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    public FragmentPagerAdapter fragmentPagerAdapter;
    ViewPager viewPager;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentPagerAdapter = new QuoteAdapter(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(fragmentPagerAdapter);

    }

    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();

        new QuoteData().getQuotes(new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {

                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getmQuote(),
                            quotes.get(i).getmAuthor()
                    );

                    fragmentList.add(quoteFragment);
                }
                fragmentPagerAdapter.notifyDataSetChanged();
            }
        });
        return fragmentList;
    }

}
