package com.example.restapi_asm_ph40209.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.env.Port;
import com.example.restapi_asm_ph40209.fragment.favourite_frg;
import com.example.restapi_asm_ph40209.inteface.CartInterface;
import com.example.restapi_asm_ph40209.inteface.FavouriteInterface;
import com.example.restapi_asm_ph40209.model.cart;
import com.example.restapi_asm_ph40209.model.favourite;
import com.example.restapi_asm_ph40209.model.product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHoder>{

    private Context context;

    private List<product> listProduct;
    private List<favourite> favouriteList;
    FavouriteAdapter favouriteAdapter;

    int soluong = 0;


    public ProductAdapter(Context context, List<product> listProduct, List<favourite> favouriteList ) {
        this.context = context;
        this.listProduct = listProduct;
        this.favouriteList = favouriteList;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent,false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, @SuppressLint("RecyclerView") int position) {
        product pr = listProduct.get(position);



        if (pr == null){
            return;
        }

        Glide.with(holder.itemView.getContext())
                        .load(pr.getImg())
                                .placeholder(R.drawable.placeholder)
                                        .error(R.drawable.placeholder)
                                                .into(holder.img_product);
        holder.txt_tensp.setText(pr.getProductName());
        holder.txt_gia.setText(pr.getPrice() + "$");


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogChitiet(listProduct.get(position));
            }
        });

        holder.add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart cart = new cart(pr.get_id(), pr.getProductName(), pr.getImg(), pr.getPrice(), 1);
                add_cart(cart);
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
        Button add_cart;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            img_product = itemView.findViewById(R.id.img_product);
            txt_tensp = itemView.findViewById(R.id.txt_tensp);
//            txt_luuluong = itemView.findViewById(R.id.txt_luuluong);
            txt_gia = itemView.findViewById(R.id.txt_gia);
            add_cart = itemView.findViewById(R.id.btn_addcart);
        }
    }




    private void showDialogChitiet(product pr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.item_showchitiet, null);
        builder.setView(view);


        ImageButton btn_dong = view.findViewById(R.id.btn_close);
        ImageButton imgbtn_add_yeuthich = view.findViewById(R.id.imgbtn_add_yeuthich);


        ImageView img_chitiet = view.findViewById(R.id.img_chitiet);
        TextView tensp_chitiet = view.findViewById(R.id.tensp_chitiet);
        TextView gia_chitiet = view.findViewById(R.id.gia_chitiet);
        TextView desc_chitiet = view.findViewById(R.id.desc_chitiet);

        Glide.with(context)
                .load(pr.getImg())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(img_chitiet);
        gia_chitiet.setText(pr.getPrice() + "$");
        tensp_chitiet.setText(pr.getProductName());
        desc_chitiet.setText(pr.getDescription());



        ImageButton img_tangsl = view.findViewById(R.id.img_tangsl);
        ImageButton img_giamsl = view.findViewById(R.id.img_giamsl);
        TextView txt_soluong = view.findViewById(R.id.txt_soluong);
        Button btn_add_chitiet = view.findViewById(R.id.btn_add_chitiet);

        btn_add_chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart cart = new cart(pr.get_id(), pr.getProductName(), pr.getImg(), pr.getPrice(), soluong);
                add_cart(cart);
            }
        });

        imgbtn_add_yeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                favourite yt = new favourite(pr.get_id(), pr.getProductName(), pr.getImg(), pr.getPrice());
                add_favourite(yt);


            }
        });


        img_tangsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong ++ ;
                txt_soluong.setText(String.valueOf(soluong));
            }
        });

        img_giamsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soluong > 1) {
                    soluong--;
                    txt_soluong.setText(String.valueOf(soluong));
                } else {
                    Toast.makeText(context, "Số lượng không thể nhỏ hơn 0", Toast.LENGTH_SHORT).show();
                }
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }



    private void add_favourite(favourite objyt) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FavouriteInterface favouriteInterface = retrofit.create(FavouriteInterface.class);

        Call<favourite> objCall = favouriteInterface.them_yeu_thich(objyt);

        objCall.enqueue(new Callback<favourite>() {
            @Override
            public void onResponse(Call<favourite> call, Response<favourite> response) {


                Toast.makeText(context, "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<favourite> call, Throwable throwable) {
                Log.e("Error", "onFailure: " + throwable.getMessage());
                Toast.makeText(context, "Có lỗi xảy ra, vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void add_cart(cart objcart) {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CartInterface cartInterface = retrofit.create(CartInterface.class);

        Call<cart> objCall = cartInterface.them_cart(objcart);

        objCall.enqueue(new Callback<cart>() {
            @Override
            public void onResponse(Call<cart> call, Response<cart> response) {

                Toast.makeText(context, "Đã thêm vào gio hang", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<cart> call, Throwable throwable) {
                Log.e("Error", "onFailure: " + throwable.getMessage());
                Toast.makeText(context, "Có lỗi xảy ra, vui lòng thử lại sau", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
