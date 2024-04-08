package com.example.restapi_asm_ph40209.inteface;

import com.example.restapi_asm_ph40209.model.favourite;
import com.example.restapi_asm_ph40209.model.product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FavouriteInterface {
    @GET("favourite")
    Call<List<favourite>> lay_danh_sach();

    //them
    @POST("favourite")
    Call<favourite> them_yeu_thich (@Body favourite objFavoutire );


    @DELETE("favourite/{id}")
    Call<Void> xoa_yeu_thich (@Path("id") String id);

//    // Cập nhật bài viết
//    @PUT("chitieu/{id}")
//    Call<QLChiTieu> sua_chi_tieu(@Path("id") String id, @Body QLChiTieu objChitieu);



}
