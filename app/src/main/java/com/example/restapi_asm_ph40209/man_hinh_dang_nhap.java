package com.example.restapi_asm_ph40209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class man_hinh_dang_nhap extends AppCompatActivity {
    TextView txt_signin;
    Button btn_login;
    EditText edt_email;
    EditText edt_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_nhap);
        txt_signin = findViewById(R.id.txt_signin);
        btn_login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email_dn);
        edt_pass = findViewById(R.id.edt_password_dn);


        txt_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(man_hinh_dang_nhap.this, man_hinh_dang_ki.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkdn();
            }
        });



    }

    private void checkdn() {

        FirebaseAuth auth = FirebaseAuth.getInstance();


        String email = edt_email.getText().toString().trim();
        String pass = edt_pass.getText().toString().trim();


        if (email.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Không được để trống dữ liệu", Toast.LENGTH_SHORT).show();
        }else {
            auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(man_hinh_dang_nhap.this, MainActivity.class));

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(man_hinh_dang_nhap.this, "DN phất bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


        }
    }
}