package com.example.restapi_asm_ph40209.inteface;

import com.example.restapi_asm_ph40209.model.category;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryInterface {
    @GET("category")
    Call<List<category>> lay_category();
}
