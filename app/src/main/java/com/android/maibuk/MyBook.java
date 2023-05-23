package com.android.maibuk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;


public class MyBook extends AppCompatActivity {

      @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_book);
        Window window = getWindow();

        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(getColor(R.color.white));
        LinearLayout ll_book1 = findViewById(R.id.home_icon_bar), ll_book_cart = findViewById(R.id.cart_icon);
        LinearLayout ll_about = findViewById(R.id.profil_icon);

        ll_book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book = new Intent(MyBook.this, home.class);
//                intent_book.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent_book.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent_book);
                overridePendingTransition(0,0);
            }
        });

        ll_book_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_cart = new Intent(MyBook.this, Cart.class);
                startActivity(to_cart);
                overridePendingTransition(0,0);
            }
        });

        ll_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_about = new Intent(MyBook.this, About.class);
                startActivity(to_about);
                overridePendingTransition(0,0);

            }
        });
    }
}