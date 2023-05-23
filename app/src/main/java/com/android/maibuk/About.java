package com.android.maibuk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;


public class About extends AppCompatActivity {
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        LinearLayout to_home = findViewById(R.id.home_icon_bar), to_my_book = findViewById(R.id.mybook_icon);
        LinearLayout to_cart = findViewById(R.id.cart_icon);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book = new Intent(About.this, home.class);
//                intent_book.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent_book.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent_book);
            }
        });

             to_my_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book = new Intent(About.this, MyBook.class);
//                intent_book.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent_book.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent_book);
                overridePendingTransition(0, 0);
            }
        });

        to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_ct = new Intent(About.this, Cart.class);
                startActivity(to_ct);
                overridePendingTransition(0,0);
            }
        });

    }
}