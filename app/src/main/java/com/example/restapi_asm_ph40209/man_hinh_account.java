package com.example.restapi_asm_ph40209;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class man_hinh_account extends AppCompatActivity {
    ImageButton btn_back;
    Button btn_dangxuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_account);

        btn_back = findViewById(R.id.btn_back);
        btn_dangxuat = findViewById(R.id.btn_dangxuat);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("my_prefs", MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();

                // Khởi chạy màn hình đăng nhập mới
                Intent intent = new Intent(man_hinh_account.this, man_hinh_dang_nhap.class);
                startActivity(intent);
                finish();
            }
        });
    }
}