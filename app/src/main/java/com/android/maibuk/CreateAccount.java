package com.android.maibuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Button btn = findViewById(R.id.create_btn);
        TextView masuktxt = findViewById(R.id.to_masuk), kosong = findViewById(R.id.kosong);

        masuktxt.setOnClickListener(view -> finish());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText get_username = findViewById(R.id.username_create), get_email = findViewById(R.id.email_create);
                EditText get_password = findViewById(R.id.password_create);
                String user,password,email;
                user = get_username.getText().toString();
                email = get_email.getText().toString();
                password = get_password.getText().toString();

                if (user.isEmpty() || email.isEmpty() || password.isEmpty()){
                    kosong.setVisibility(View.VISIBLE);
                }
                else{
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(CreateAccount.this, "Masukkan alamat email yang valid", Toast.LENGTH_LONG).show();
                    } else {
                        Intent to_login = new Intent(CreateAccount.this, home.class);
                        to_login.putExtra("user", user);
                        to_login.putExtra("password", password);
                        startActivity(to_login);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        kosong.setVisibility(View.INVISIBLE);
                    }
                }

            }
        });





    }
}