package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainTambahActivity extends AppCompatActivity {
    Button btnTambahData, btnTambahBerkas, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tambah);
        btnTambahData = findViewById(R.id.btn_tambah_data);
        btnTambahBerkas = findViewById(R.id.btn_tambah_berkas);
        btnBack = findViewById(R.id.btn_back);

        btnTambahData.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), TambahDataPenerimaActivity.class));
            finish();
        });

        btnTambahBerkas.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), MainTambahBerkasActivity.class));
            finish();
        });

        btnBack.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        return;
    }
}