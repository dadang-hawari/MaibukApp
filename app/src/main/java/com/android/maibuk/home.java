package com.android.maibuk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class home extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView user_login = findViewById(R.id.user_login);
        ScrollView mysv = findViewById(R.id.sv_home);
        Toolbar mytb = findViewById(R.id.mytoolbar);
        View dropshadow = findViewById(R.id.shadow_toolbar);
        Calendar kalender = Calendar.getInstance();
        TextView greeting = findViewById(R.id.greeting);
        LinearLayout ll_book2 = findViewById(R.id.mybook_icon), ll_book_voucher = findViewById(R.id.voucher_book);
        LinearLayout ll_book_profil = findViewById(R.id.profil_icon), ll_geo = findViewById(R.id.geografi);
        LinearLayout ll_book_cart = findViewById(R.id.cart_icon), ll_to_top_picks = findViewById(R.id.top_picks), ll_audio = findViewById(R.id.audio);
        LinearLayout ll_horor = findViewById(R.id.horor), ll_berkendara = findViewById(R.id.berkendara), ll_petualangan = findViewById(R.id.petualangan);
        EditText etsc = findViewById(R.id.etku);

        int jam = kalender.get(Calendar.HOUR_OF_DAY);
        String text = user_login.getText().toString();

        //Status Bg
        Window window = getWindow();
        View decor = getWindow().getDecorView();
        window.setStatusBarColor(getResources().getColor(R.color.main_col));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mysv.setOnScrollChangeListener((view, horizontal, vertikal, i2, vertikal_prev) -> {
                if (vertikal > 97) {
                    int flags = window.getDecorView().getSystemUiVisibility();
                    flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;  // Tambahkan flag View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    window.getDecorView().setSystemUiVisibility(flags);
                    mytb.setBackgroundColor(getResources().getColor(R.color.white));
                    window.setStatusBarColor(getResources().getColor(R.color.white));
                    dropshadow.setVisibility(View.VISIBLE);
                } else {
                    decor.setSystemUiVisibility(0);
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
                    mytb.setBackgroundColor(getResources().getColor(R.color.main_col));
                    window.setStatusBarColor(getResources().getColor(R.color.main_col));
                    dropshadow.setVisibility(View.INVISIBLE);
                }
            });
        }


        ImageSlider imageSlider = findViewById(R.id.quote_slide);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.quote1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.quote2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.quote3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        Bundle datanya = getIntent().getExtras();

        if (text.length() > 13) {
            user_login.setTextSize(13);
            greeting.setTextSize(13);
        }
        if (datanya != null && datanya.containsKey("user") && datanya.containsKey("password")) {
            String nama = datanya.getString("user");
            if (nama != null) user_login.setText(nama);
            if (jam < 11) greeting.setText("Selamat Pagi! " + nama);
            else if (jam < 15) greeting.setText("Selamat Siang! " + nama);
            else if (jam < 18) greeting.setText("Selamat Sore! " + nama);
            else greeting.setText("Selamat Malam! " + nama);
        }else{
            String nama = "Budi";
            user_login.setText(nama);
         if (jam < 11) greeting.setText("Selamat Pagi! " + nama);
            else if (jam < 15) greeting.setText("Selamat Siang! " + nama);
            else if (jam < 18) greeting.setText("Selamat Sore! " + nama);
            else greeting.setText("Selamat Malam! " + nama);
        }

        etsc.setOnClickListener(view -> {
            Intent to_sc = new Intent(home.this, Search.class);
            startActivity(to_sc);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        });

        ll_to_top_picks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_top_book = new Intent(home.this, top_picks.class);
                startActivity(to_top_book);
            }
        });
        ll_book_voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_promo = new Intent(home.this, Promo.class);
                startActivity(to_promo);
            }
        });


        ll_book_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_cart = new Intent(home.this, Cart.class);
                startActivity(to_cart);
                overridePendingTransition(0, 0);
            }
        });

        ll_book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book = new Intent(home.this, MyBook.class);
                startActivity(intent_book);
                overridePendingTransition(0, 0);
            }
        });

        ll_book_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book = new Intent(home.this, About.class);
                startActivity(intent_book);
                overridePendingTransition(0, 0);
            }
        });

        ll_horor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_horor = new Intent(home.this, list_ebuk.class);
                startActivity((intent_horor));
            }
        });
        ll_berkendara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_berkendara = new Intent(home.this, berkendara.class);
                startActivity((intent_berkendara));
            }
        });
        ll_petualangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_petualangan = new Intent(home.this, petualangan.class);
                startActivity((intent_petualangan));
            }
        });
        ll_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_audio = new Intent(home.this, audio.class);
                startActivity((intent_audio));
            }
        });
        ll_geo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_audio = new Intent(home.this, geography.class);
                startActivity((intent_audio));
            }
        });

    }
    }






