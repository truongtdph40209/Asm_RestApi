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
import com.example.restapi_asm_ph40209.adapter.CartAdapter;
import com.example.restapi_asm_ph40209.adapter.FavouriteAdapter;
import com.example.restapi_asm_ph40209.env.Port;
import com.example.restapi_asm_ph40209.inteface.CartInterface;
import com.example.restapi_asm_ph40209.inteface.FavouriteInterface;
import com.example.restapi_asm_ph40209.model.cart;
import com.example.restapi_asm_ph40209.model.favourite;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class cart_frg extends Fragment {



    public cart_frg() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    List<cart> ds_cart;
    CartAdapter cartAdapter;
    private RecyclerView rcv_cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart_frg, container, false);

        ds_cart = new ArrayList<cart>();
        rcv_cart = view.findViewById(R.id.rcv_cart);
        rcv_cart.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        cartAdapter = new CartAdapter( getContext(),ds_cart);
        rcv_cart.setAdapter(cartAdapter);

        GetDanhSachCart();
        return view;
    }

    void GetDanhSachCart() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CartInterface cartInterface = retrofit.create(CartInterface.class);

        Call<List<cart>> objCall = cartInterface.lay_danh_sach();

        objCall.enqueue(new Callback<List<cart>>() {
            @Override
            public void onResponse(Call<List<cart>> call, Response<List<cart>> response) {
                if (response.isSuccessful()){
                    ds_cart.clear();
                    ds_cart.addAll(response.body());
                    cartAdapter.notifyDataSetChanged();
                }else {
                    Log.d("zzzzzz", "onResponse: Kkong lay duoc ds");
                }
            }
            @Override
            public void onFailure(Call<List<cart>> call, Throwable throwable) {
                Log.e("zzzzzzz", "onFailure: loi " + throwable.getMessage() );
                throwable.printStackTrace();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        GetDanhSachCart();
    }
}