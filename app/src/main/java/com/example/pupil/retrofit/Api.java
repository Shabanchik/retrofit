package com.example.pupil.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("?=onions")//ильтр, может быть гарлик-ченок, выведет совсем другое
    public Call<DataModel> getRecipe();
}
