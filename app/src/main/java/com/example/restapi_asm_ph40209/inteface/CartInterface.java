package com.example.restapi_asm_ph40209.inteface;

import com.example.restapi_asm_ph40209.model.cart;
import com.example.restapi_asm_ph40209.model.favourite;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartInterface {
    @GET("cart")
    Call<List<cart>> lay_danh_sach();

    //them
    @POST("cart")
    Call<cart> them_cart (@Body cart objcart );


    @DELETE("cart/{id}")
    Call<Void> xoa_cart (@Path("id") String id);

//    // Cập nhật bài viết
//    @PUT("chitieu/{id}")
//    Call<QLChiTieu> sua_chi_tieu(@Path("id") String id, @Body QLChiTieu objChitieu);



}
