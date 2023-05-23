package com.android.maibuk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Search extends AppCompatActivity {
  private   EditText searchEditText;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchEditText = findViewById(R.id.mysearch);
        searchEditText.requestFocus();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(getColor(R.color.white));
        }
        ImageView sc_btn = findViewById(R.id.back_button_sc);

        sc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }
}