package com.example.restapi_asm_ph40209.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.model.bill;
import com.example.restapi_asm_ph40209.model.product;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    private ArrayList<bill> lisBill;
    Context context;


    public BillAdapter(ArrayList<bill> lisBill) {
        this.lisBill = lisBill;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bill bi = lisBill.get(position);

        holder.txt_billid.setText("BillId: " + bi.getBillId());
        holder.txt_date.setText("Date: " + bi.getDate());
        holder.txt_email.setText("Email: " + bi.getEmail());
    }

    @Override
    public int getItemCount() {
        return lisBill.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_billid, txt_date, txt_email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_billid = itemView.findViewById(R.id.txt_billid);
            txt_date = itemView.findViewById(R.id.txt_date);
            txt_email = itemView.findViewById(R.id.txt_email);
        }
    }
}
