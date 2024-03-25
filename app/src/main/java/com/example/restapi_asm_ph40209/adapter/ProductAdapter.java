package com.example.restapi_asm_ph40209.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.model.product;

import org.w3c.dom.Text;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHoder>{
    private Context context;

    private List<product> listProduct;

    public ProductAdapter(List<product> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context = context;

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
        holder.txt_tensp.setText(pr.getProductName());
        holder.txt_gia.setText(String.valueOf(pr.getPrice()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogChitiet(listProduct.get(position));
            }
        });


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




    private void showDialogChitiet(product pr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_showchitiet, null);
        builder.setView(view);


        ImageButton btn_dong = view.findViewById(R.id.btn_close);
        ImageView img_chitiet = view.findViewById(R.id.img_chitiet);

        TextView tensp_chitiet = view.findViewById(R.id.tensp_chitiet);
        TextView gia_chitiet = view.findViewById(R.id.gia_chitiet);
        TextView desc_chitiet = view.findViewById(R.id.desc_chitiet);

        img_chitiet.setImageResource(pr.getImage());
        gia_chitiet.setText(String.valueOf(pr.getPrice()));
        tensp_chitiet.setText(pr.getProductName());
        desc_chitiet.setText(pr.getDesc());



        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }
}
