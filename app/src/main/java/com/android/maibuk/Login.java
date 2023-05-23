package com.android.maibuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login_btn = findViewById(R.id.login_btn);
        TextView create_account = findViewById(R.id.create_account), kosong = findViewById(R.id.kosong);
        EditText pw = findViewById(R.id.passowrd_login);
        EditText user = findViewById(R.id.username_login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = user.getText().toString();
                String psw = pw.getText().toString();

                if (nama.isEmpty() || psw.isEmpty()) {
                    kosong.setVisibility(View.VISIBLE);

                } else if(nama.equals("dadang") && psw.equals("123") || (nama.equals("adam") && psw.equals("123")) || (nama.equals("ikhzan") && psw.equals("123"))){
                    Intent home = new Intent(Login.this, home.class);
                    home.putExtra("user", nama);
                    home.putExtra("password", psw);
                    startActivity(home);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    kosong.setVisibility(View.INVISIBLE);

                }else{
                    kosong.setText("Username atau password anda salah");
                    kosong.setVisibility((View.VISIBLE));
                }
            }
        });


        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Login.this, CreateAccount.class);
                startActivity(home);
            }
        });
    }



}