package com.example.restapi_asm_ph40209.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.model.category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    ArrayList<category> ListItem;
    Context context;

    public CategoryAdapter(ArrayList<category> listItem) {
        ListItem = listItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent,false);
        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_category.setText(ListItem.get(position).getCateName());



    }

    @Override
    public int getItemCount() {
        return ListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_category;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_category = itemView.findViewById(R.id.txt_category);
        }
    }
}
