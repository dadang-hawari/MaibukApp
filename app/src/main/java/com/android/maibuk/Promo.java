package com.android.maibuk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Promo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        Button myButton = findViewById(R.id.promo_1), myButton2 =findViewById(R.id.promo_2);
        myButton.setOnLongClickListener(v -> {
            // Mengambil teks dari tombol
            String buttonText = myButton.getText().toString();

            // Menyalin teks ke clipboard
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("label", buttonText);
            clipboard.setPrimaryClip(clip);

            // Memberikan umpan balik kepada pengguna
            Toast.makeText(getApplicationContext(), "Promo disalin", Toast.LENGTH_SHORT).show();

            return true;
        });
        myButton2.setOnLongClickListener(v -> {
            // Mengambil teks dari tombol
            String buttonText2 = myButton2.getText().toString();

            // Menyalin teks ke clipboard
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip2 = ClipData.newPlainText("label", buttonText2);
            clipboard.setPrimaryClip(clip2);

            // Memberikan umpan balik kepada pengguna
            Toast.makeText(getApplicationContext(), "Promo disalin", Toast.LENGTH_SHORT).show();
            return true;
        });

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        ImageView back_btn = findViewById(R.id.back_btn_promo);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}