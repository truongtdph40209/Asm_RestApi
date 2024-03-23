package com.example.restapi_asm_ph40209.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.adapter.ProductAdapter;
import com.example.restapi_asm_ph40209.man_hinh_account;
import com.example.restapi_asm_ph40209.model.product;

import java.util.ArrayList;
import java.util.List;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_frg, container, false);

        btn_account = view.findViewById(R.id.btn_account);

        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), man_hinh_account.class));
            }
        });

        rcv_product = view.findViewById(R.id.rcv_product);
//        rcv_product.setNestedScrollingEnabled(false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcv_product.setLayoutManager(gridLayoutManager);

        ProductAdapter adapter = new ProductAdapter(getListProduct(), getContext());

        rcv_product.setAdapter(adapter);



        return view;
    }

    private List<product> getListProduct() {
        List<product> list = new ArrayList<>();

        list.add(new product(1, R.drawable.fruits1, "San pham 1", 500, 14.29, "ahdshdsuhdushdu", product.TYPE_1));
        list.add(new product(2, R.drawable.fruits2, "San pham 2", 500, 14.29, "ahdshdsuhdushdu", product.TYPE_1));
        list.add(new product(3, R.drawable.fruits3, "San pham 3", 500, 14.29, "ahdshdsuhdushdu", product.TYPE_1));
        list.add(new product(4, R.drawable.fruits4, "San pham 4", 500, 14.29, "ahdshdsuhdushdu", product.TYPE_1));

        list.add(new product(5, R.drawable.vegetables1, "San pham 5", 400, 15.29, "ahdshdsuhdushdu", product.TYPE_2));
        list.add(new product(6, R.drawable.vegetables2, "San pham 6", 400, 15.29, "ahdshdsuhdushdu", product.TYPE_2));
        list.add(new product(7, R.drawable.vegetables3, "San pham 7", 400, 15.29, "ahdshdsuhdushdu", product.TYPE_2));
        list.add(new product(8, R.drawable.vegetables4, "San pham 8", 400, 15.29, "ahdshdsuhdushdu", product.TYPE_2));

        list.add(new product(9, R.drawable.bestdeal1, "San pham 9", 450, 16.29, "ahdshdsuhdushdu", product.TYPE_3));
        list.add(new product(10, R.drawable.bestdeal2, "San pham 10", 450, 16.29, "ahdshdsuhdushdu", product.TYPE_3));

        return list;
    }
}