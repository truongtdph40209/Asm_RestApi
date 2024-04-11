package com.example.restapi_asm_ph40209.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.env.Port;
import com.example.restapi_asm_ph40209.inteface.CartInterface;
import com.example.restapi_asm_ph40209.inteface.FavouriteInterface;
import com.example.restapi_asm_ph40209.model.cart;
import com.example.restapi_asm_ph40209.model.favourite;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{


    Context context;
    List<cart> list;

    public CartAdapter(Context context, List<cart> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent,false);
        return new ViewHolder(View);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cart cart = list.get(position);

        Glide.with(holder.itemView.getContext())
                .load(cart.getImg())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.img_cart);

        holder.txt_tensp_cart.setText(cart.getProductName());
        holder.txt_giasp_cart.setText(cart.getPrice() * cart.getSoluong() + "$");
        holder.txt_soluong_cart.setText(cart.getSoluong() + "");

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                DeleteCart(cart);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_cart;
        TextView txt_tensp_cart, txt_soluong_cart, txt_giasp_cart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_cart = itemView.findViewById(R.id.img_cart);
            txt_tensp_cart = itemView.findViewById(R.id.txt_tensp_cart);
            txt_soluong_cart = itemView.findViewById(R.id.txt_soluong_cart);
            txt_giasp_cart = itemView.findViewById(R.id.txt_giasp_cart);
        }
    }

    private void DeleteCart(cart ca) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CartInterface cartInterface = retrofit.create(CartInterface.class);
        Call<Void> call = cartInterface.xoa_cart(ca.get_id());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(context, "Un favourite Succes", Toast.LENGTH_SHORT).show();
                    GetDanhSachCart();


                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Log.e("Error", "errr: " + throwable.getMessage());
            }
        });
    }

    private void GetDanhSachCart() {

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
                    list.clear();
                    list.addAll(response.body());
                    notifyDataSetChanged();
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


}
