package com.example.restapi_asm_ph40209.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.adapter.CategoryAdapter;
import com.example.restapi_asm_ph40209.adapter.FavouriteAdapter;
import com.example.restapi_asm_ph40209.env.Port;
import com.example.restapi_asm_ph40209.inteface.FavouriteInterface;
import com.example.restapi_asm_ph40209.inteface.ProductInterface;
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


public class favourite_frg extends Fragment {



    public favourite_frg() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    List<favourite> ds_favourite;
    FavouriteAdapter favouriteAdapter;
    private RecyclerView rcv_favourite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_favourite_frg, container, false);

        ds_favourite = new ArrayList<favourite>();
        rcv_favourite = view.findViewById(R.id.rcv_favourite);
        rcv_favourite.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        favouriteAdapter = new FavouriteAdapter(ds_favourite, getContext());
        rcv_favourite.setAdapter(favouriteAdapter);

        GetDanhSachFavourite();
        return view;
    }


     void GetDanhSachFavourite() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FavouriteInterface favouriteInterface = retrofit.create(FavouriteInterface.class);

        Call<List<favourite>> objCall = favouriteInterface.lay_danh_sach();

        objCall.enqueue(new Callback<List<favourite>>() {
            @Override
            public void onResponse(Call<List<favourite>> call, Response<List<favourite>> response) {
                if (response.isSuccessful()){
                    ds_favourite.clear();
                    ds_favourite.addAll(response.body());
                    favouriteAdapter.notifyDataSetChanged();
                }else {
                    Log.d("zzzzzz", "onResponse: Kkong lay duoc ds");
                }
            }
            @Override
            public void onFailure(Call<List<favourite>> call, Throwable throwable) {
                Log.e("zzzzzzz", "onFailure: loi " + throwable.getMessage() );
                throwable.printStackTrace();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        GetDanhSachFavourite();
    }
}