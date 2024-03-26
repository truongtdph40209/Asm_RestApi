package com.example.restapi_asm_ph40209.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.adapter.BillAdapter;
import com.example.restapi_asm_ph40209.model.bill;
import com.example.restapi_asm_ph40209.model.category;

import java.util.ArrayList;


public class detail_frg extends Fragment {



    public detail_frg() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    private RecyclerView rcv_bill;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail_frg, container, false);

        rcv_bill = view.findViewById(R.id.rcv_bill);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rcv_bill.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rcv_bill.getContext(), layoutManager.getOrientation());

        rcv_bill.addItemDecoration(dividerItemDecoration);

        BillAdapter billAdapter = new BillAdapter(getListBill());

        rcv_bill.setAdapter(billAdapter);
        return view;
    }
    private ArrayList<bill> getListBill() {
        ArrayList<bill> listBill = new ArrayList<>();

        listBill.add(new bill("1", "23-12-2024","abc@abc.abc"));
        listBill.add(new bill("2", "23-12-2024","abc@abc.abc"));
        listBill.add(new bill("3", "23-12-2024","abc@abc.abc"));



        return listBill;

    }


}