package com.example.restapi_asm_ph40209;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapi_asm_ph40209.model.account;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class man_hinh_dang_ki extends AppCompatActivity {
    TextView txt_login;
    Button btn_dangki;
    EditText edt_email;
    EditText edt_password;
    EditText edt_repassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_dang_ki);
        txt_login = findViewById(R.id.txt_login);
        btn_dangki = findViewById(R.id.btn_dangki);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        edt_repassword = findViewById(R.id.edt_repassword);

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btn_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signup();

            }
        });



    }

    private void signup() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        String email = edt_email.getText().toString().trim();
        String password = edt_password.getText().toString().trim();
        String repassword = edt_repassword.getText().toString().trim();

        if (!password.equals(repassword)){
            Toast.makeText(man_hinh_dang_ki.this, "pass khong trung nhau", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.length() <= 6 || password.length() <= 6 || repassword.length() <=6){
            Toast.makeText(man_hinh_dang_ki.this, "ki tu khong duoc thap hon 6", Toast.LENGTH_SHORT).show();
            return;
        }


        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

                            account ac = new account( email,"", password, "", "");

                            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("Account");
                            userRef.child(userId).setValue(ac);

                            startActivity(new Intent(man_hinh_dang_ki.this, man_hinh_dang_nhap.class));
                            finishAffinity();
                        } else {
                            // Đăng ký thất bại, hiển thị thông báo
                            Toast.makeText(man_hinh_dang_ki.this, "Đăng ký thất bại"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}