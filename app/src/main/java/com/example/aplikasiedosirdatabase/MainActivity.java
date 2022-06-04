package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnTambah, btnPenerima, btnBerkas, btnLogout;

    long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTambah = findViewById(R.id.btn_tambah);
        btnPenerima = findViewById(R.id.btn_penerima);
        btnBerkas = findViewById(R.id.btn_berkas);
        btnLogout = findViewById(R.id.btn_logout);

        btnTambah.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), MainTambahActivity.class));
            finish();
        });
        btnPenerima.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), PenerimaListActivity.class));
            finish();
        });
        btnBerkas.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), BerkasListActivity.class));
            finish();
        });
        btnLogout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}