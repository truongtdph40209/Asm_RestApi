package com.example.restapi_asm_ph40209.inteface;

import com.example.restapi_asm_ph40209.model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductInterface {
    //http://192.168.137.1:3000/product

    @GET("product")
    Call<List<product>> lay_danh_sach();

    //them
//    @POST("chitieu")
//    Call<QLChiTieu> them_chi_tieu (@Body QLChiTieu objChitieu );
//
//
//    @DELETE("chitieu/{id}")
//    Call<Void> xoa_chi_tieu (@Path("id") String id);
//
//    // Cập nhật bài viết
//    @PUT("chitieu/{id}")
//    Call<QLChiTieu> sua_chi_tieu(@Path("id") String id, @Body QLChiTieu objChitieu);




}
