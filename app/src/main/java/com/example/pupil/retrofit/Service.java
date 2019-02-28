package com.example.pupil.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    public static Api getApi(){//библиотека ретрофи одна из самых рампростаненных
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.recipepuppy.com/api/")
                .addConverterFactory(GsonConverterFactory.create())//переделывает джисон
                .build();
        Api api = retrofit.create(Api.class);
        return api;
    }
}