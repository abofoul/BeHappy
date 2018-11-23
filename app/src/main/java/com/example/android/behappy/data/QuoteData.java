package com.example.android.behappy.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.android.behappy.controller.AppController;
import com.example.android.behappy.model.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuoteData {

    ArrayList<Quote> quoteArrayList = new ArrayList<>();

    public void getQuotes(final QuoteListAsyncResponse callback){
        String url = "https://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i=0; i <response.length();i++){
                            try {

                                JSONObject nameJsonObject = response.getJSONObject(i);

                                String name = nameJsonObject.getString("quote");
                                String author = nameJsonObject.getString("name");

                                Quote quote = new Quote(name , author);

                                quoteArrayList.add(quote);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        if(null != callback){
                            callback.processFinished(quoteArrayList);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        AppController.getInstance().addToRequestQueue(jsonArrayRequest);

    }
}
