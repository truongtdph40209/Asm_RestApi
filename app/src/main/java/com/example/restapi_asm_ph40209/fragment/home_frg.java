package com.example.restapi_asm_ph40209.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.adapter.CategoryAdapter;
import com.example.restapi_asm_ph40209.adapter.ProductAdapter;
import com.example.restapi_asm_ph40209.man_hinh_account;
import com.example.restapi_asm_ph40209.model.category;
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
    private RecyclerView rcv_category;

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



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rcv_product.setLayoutManager(gridLayoutManager);

        ProductAdapter adapter = new ProductAdapter(getListProduct(), getContext());

        rcv_product.setAdapter(adapter);


        rcv_category = view.findViewById(R.id.rcv_category);
        rcv_category.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        CategoryAdapter categoryAdapter = new CategoryAdapter(getListItemcate());
        rcv_category.setAdapter(categoryAdapter);

        return view;
    }

    private List<product> getListProduct() {
        List<product> listPr = new ArrayList<>();

        listPr.add(new product(R.drawable.fruits1,"1" , "San pham 1", "The orange is the fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus x sinensis, which is also called sweet orange, to distinguish it from the related Citrus aurantium ", 14.29));
        listPr.add(new product(R.drawable.fruits2,"2" , "San pham 2", "The orange is the fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus x sinensis, which is also called sweet orange, to distinguish it from the related Citrus aurantium ", 14.29));
        listPr.add(new product(R.drawable.fruits3,"3" , "San pham 3", "The orange is the fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus x sinensis, which is also called sweet orange, to distinguish it from the related Citrus aurantium ", 14.29));
        listPr.add(new product(R.drawable.fruits4,"4" , "San pham 4", "The orange is the fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus x sinensis, which is also called sweet orange, to distinguish it from the related Citrus aurantium ", 14.29));

        listPr.add(new product(R.drawable.vegetables1,"5" , "San pham 5", "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia. It belongs to the amaranth family and is related to beets and quinoa. What's more, it's considered very healthy", 15.29));
        listPr.add(new product(R.drawable.vegetables2,"6" , "San pham 6", "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia. It belongs to the amaranth family and is related to beets and quinoa. What's more, it's considered very healthy", 15.29));
        listPr.add(new product(R.drawable.vegetables3,"7" , "San pham 7", "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia. It belongs to the amaranth family and is related to beets and quinoa. What's more, it's considered very healthy", 15.29));
        listPr.add(new product(R.drawable.vegetables4,"8" , "San pham 8", "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia. It belongs to the amaranth family and is related to beets and quinoa. What's more, it's considered very healthy", 15.29));

        listPr.add(new product(R.drawable.bestdeal1,"9" , "San pham 9", "The orange is the fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus x sinensis, which is also called sweet orange, to distinguish it from the related Citrus aurantium ", 14.29));
        listPr.add(new product(R.drawable.bestdeal2,"10" , "San pham 10", "Spinach (Spinacia oleracea) is a leafy green vegetable that originated in Persia. It belongs to the amaranth family and is related to beets and quinoa. What's more, it's considered very healthy", 15.29));


        return listPr;
    }

    private ArrayList<category> getListItemcate() {
        ArrayList<category> listCate = new ArrayList<>();

        listCate.add(new category("1", "All"));
        listCate.add(new category("2", "Vegetables1"));
        listCate.add(new category("3", "Fruits"));
        listCate.add(new category("4", "Meats"));
        listCate.add(new category("5", "Deals"));
        listCate.add(new category("6", "Best Seller"));



        return listCate;

    }



}