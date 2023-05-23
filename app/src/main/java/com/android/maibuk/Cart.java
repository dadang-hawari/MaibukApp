package com.android.maibuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Cart extends AppCompatActivity {

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        LinearLayout to_mybook = findViewById(R.id.mybook_icon), to_home = findViewById(R.id.home_icon_bar);
        LinearLayout to_about = findViewById(R.id.profil_icon);

        to_mybook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_mb = new Intent(Cart.this, MyBook.class);
                startActivity(to_mb);
                overridePendingTransition(0,0);
            }
        });
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_hm = new Intent(Cart.this, home.class);
//                to_hm.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                to_hm.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(to_hm);
                overridePendingTransition(0,0);
            }
        });
        to_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_abt = new Intent(Cart.this, About.class);
                startActivity(to_abt);
                overridePendingTransition(0,0);
            }
        });

    }
}