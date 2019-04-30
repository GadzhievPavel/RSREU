package com.example.rsreu.data.json_parser.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {
    public final API api;
    private APIHelper(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://rsreu.ru/schedule/").addConverterFactory(
                GsonConverterFactory.create()).build();
        api=retrofit.create(API.class);
    }

}
