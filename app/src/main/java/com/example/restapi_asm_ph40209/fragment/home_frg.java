package com.example.restapi_asm_ph40209.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.adapter.CategoryAdapter;
import com.example.restapi_asm_ph40209.adapter.ProductAdapter;
import com.example.restapi_asm_ph40209.inteface.CategoryInterface;
import com.example.restapi_asm_ph40209.inteface.ProductInterface;
import com.example.restapi_asm_ph40209.man_hinh_account;
import com.example.restapi_asm_ph40209.model.category;
import com.example.restapi_asm_ph40209.model.favourite;
import com.example.restapi_asm_ph40209.model.product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class home_frg extends Fragment {


    public home_frg() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private ImageView btn_account;

    private RecyclerView rcv_product;
    private RecyclerView rcv_category;

    static String BASE_URL = "http://192.168.1.7:3000/";

    List<product> ds_product;
    List<favourite> ds_favourite;
    List<category> ds_cate;
    CategoryAdapter categoryAdapter;

    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_frg, container, false);
        ds_favourite = new ArrayList<favourite>();

        btn_account = view.findViewById(R.id.btn_account);

        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), man_hinh_account.class));
            }
        });
        //get product
        ds_product = new ArrayList<product>();
        rcv_product = view.findViewById(R.id.rcv_product);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcv_product.setLayoutManager(gridLayoutManager);
        adapter = new ProductAdapter(getContext(),ds_product, ds_favourite);
        rcv_product.setAdapter(adapter);

        //get category
        ds_cate = new ArrayList<category>();
        rcv_category = view.findViewById(R.id.rcv_category);
        rcv_category.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        categoryAdapter = new CategoryAdapter(ds_cate, getContext());
        rcv_category.setAdapter(categoryAdapter);

        GetDanhSachProduct();
        GetDanhSachCategory();


        return view;
    }


    void GetDanhSachProduct() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ProductInterface productInterface = retrofit.create(ProductInterface.class);

        Call<List<product>> objCall = productInterface.lay_danh_sach();

        objCall.enqueue(new Callback<List<product>>() {
            @Override
            public void onResponse(Call<List<product>> call, Response<List<product>> response) {
                if (response.isSuccessful()){
                    ds_product.clear();
                    ds_product.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }else {
                    Log.d("zzzzzz", "onResponse: Kkong lay duoc ds");
                }
            }
            @Override
            public void onFailure(Call<List<product>> call, Throwable throwable) {
                Log.e("zzzzzzz", "onFailure: loi " + throwable.getMessage() );
                throwable.printStackTrace();
            }
        });

    }
    void GetDanhSachCategory() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CategoryInterface categoryInterface = retrofit.create(CategoryInterface.class);

        Call<List<category>> objCall = categoryInterface.lay_category();

        objCall.enqueue(new Callback<List<category>>() {
            @Override
            public void onResponse(Call<List<category>> call, Response<List<category>> response) {
                if (response.isSuccessful()){
                    ds_cate.clear();
                    ds_cate.addAll(response.body());
                    categoryAdapter.notifyDataSetChanged();
                }else {
                    Log.d("zzzzzz", "onResponse: Kkong lay duoc ds");
                }
            }
            @Override
            public void onFailure(Call<List<category>> call, Throwable throwable) {
                Log.e("zzzzzzz", "onFailure: loi " + throwable.getMessage() );
                throwable.printStackTrace();
            }
        });

    }




}