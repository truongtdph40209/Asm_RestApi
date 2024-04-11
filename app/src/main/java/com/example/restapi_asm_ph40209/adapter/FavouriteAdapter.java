package com.example.restapi_asm_ph40209.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.restapi_asm_ph40209.R;
import com.example.restapi_asm_ph40209.env.Port;
import com.example.restapi_asm_ph40209.inteface.FavouriteInterface;
import com.example.restapi_asm_ph40209.model.favourite;
import com.example.restapi_asm_ph40209.model.product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    List<favourite> listyt;
    Context context;


    public FavouriteAdapter(List<favourite> list, Context context) {
        this.listyt = list;
        this.context = context;

//        Log.e("abc", list.get(0)+""  );
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        favourite yt = listyt.get(position);


        Glide.with(holder.itemView.getContext())
                .load(yt.getImg())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.img_favourite);
        holder.txt_tensp_favourite.setText(yt.getProductName());
        holder.txt_giasp_favourite.setText(yt.getPrice() + "$");

        holder.img_unfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteFavourite(yt);
            }
        });
    }



    @Override
    public int getItemCount() {
        return listyt.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_favourite;
        ImageButton img_unfavorite;
        TextView txt_tensp_favourite, txt_giasp_favourite;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_favourite = itemView.findViewById(R.id.img_favourite);
            img_unfavorite = itemView.findViewById(R.id.img_unfavorite);
            txt_giasp_favourite = itemView.findViewById(R.id.txt_giasp_favourite);
            txt_tensp_favourite = itemView.findViewById(R.id.txt_tensp_favourite);

        }
    }

    private void DeleteFavourite(favourite favourite) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FavouriteInterface favouriteInterface = retrofit.create(FavouriteInterface.class);
        Call<Void> call = favouriteInterface.xoa_yeu_thich(favourite.get_id());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(context, "Un favourite Succes", Toast.LENGTH_SHORT).show();
                    GetDanhSachFavourite();


                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                Log.e("Error", "errr: " + throwable.getMessage());
            }
        });
    }


    void GetDanhSachFavourite() {

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Port.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        FavouriteInterface favouriteInterface = retrofit.create(FavouriteInterface.class);

        Call<List<favourite>> objCall = favouriteInterface.lay_danh_sach();

        objCall.enqueue(new Callback<List<favourite>>() {
            @Override
            public void onResponse(Call<List<favourite>> call, Response<List<favourite>> response) {
                if (response.isSuccessful()){
                    listyt.clear();
                    listyt.addAll(response.body());
                    notifyDataSetChanged();
                }else {
                    Log.d("zzzzzz", "onResponse: Kkong lay duoc ds");
                }
            }
            @Override
            public void onFailure(Call<List<favourite>> call, Throwable throwable) {
                Log.e("zzzzzzz", "onFailure: loi " + throwable.getMessage() );
                throwable.printStackTrace();
            }
        });

    }





}
