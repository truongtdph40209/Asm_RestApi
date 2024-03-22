package com.example.restapi_asm_ph40209.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.model.product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHoder>{
    private List<product> listProduct;

    public ProductAdapter(List<product> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        product pr = listProduct.get(position);

        if (pr == null){
            return;
        }

        holder.img_product.setImageResource(pr.getImage());
        holder.txt_tensp.setText(pr.getTensp());
        holder.txt_luuluong.setText(pr.getLuuluong() + " mg");
        holder.txt_gia.setText(String.valueOf(pr.getGia()));


    }

    @Override
    public int getItemCount() {
        if (listProduct != null){
            return listProduct.size();
        }
        return 0;

    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        private ImageView img_product;
        private TextView txt_tensp, txt_luuluong, txt_gia;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            img_product = itemView.findViewById(R.id.img_product);
            txt_tensp = itemView.findViewById(R.id.txt_tensp);
            txt_luuluong = itemView.findViewById(R.id.txt_luuluong);
            txt_gia = itemView.findViewById(R.id.txt_gia);
        }
    }

}
