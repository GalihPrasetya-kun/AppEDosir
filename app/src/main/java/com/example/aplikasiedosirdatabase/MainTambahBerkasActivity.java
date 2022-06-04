package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainTambahBerkasActivity extends AppCompatActivity {
    Button btnBerkasAssessment, btnBerkasBpjs, btnBerkasIdentifikasi, btnBerkasIntake, btnBerkasKematian ,
            btnBerkasKetsehat, btnBerkasKettidakmampu, btnBerkasKk, btnBerkasKontrak, btnBerkasKtp,
            btnBerkasKunjungan, btnBerkasPernyataan, btnBerkasRegistrasi, btnBerkasRekomendasi, btnBerkasSerah;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tambah_berkas);
        btnBerkasAssessment = findViewById(R.id.btn_berkas_assessment);
        btnBerkasAssessment.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasAssessmentActivity.class));
            finish();
        });
        btnBerkasBpjs = findViewById(R.id.btn_berkas_bpjs);
        btnBerkasBpjs.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasBpjsActivity.class));
            finish();
        });
        btnBerkasIdentifikasi = findViewById(R.id.btn_berkas_identifikasi);
        btnBerkasIdentifikasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasIdentifikasiActivity.class));
            finish();
        });
        btnBerkasIntake = findViewById(R.id.btn_berkas_intake);
        btnBerkasIntake.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasIntakeActivity.class));
            finish();
        });
        btnBerkasKematian = findViewById(R.id.btn_berkas_kematian);
        btnBerkasKematian.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKematianActivity.class));
            finish();
        });
        btnBerkasKetsehat = findViewById(R.id.btn_berkas_ketsehat);
        btnBerkasKetsehat.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKetsehatActivity.class));
            finish();
        });
        btnBerkasKettidakmampu = findViewById(R.id.btn_berkas_kettidakmampu);
        btnBerkasKettidakmampu.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKettidakmampuActivity.class));
            finish();
        });
        btnBerkasKk = findViewById(R.id.btn_berkas_kk);
        btnBerkasKk.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKkActivity.class));
            finish();
        });
        btnBerkasKontrak = findViewById(R.id.btn_berkas_kontrak);
        btnBerkasKontrak.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKontrakActivity.class));
            finish();
        });
        btnBerkasKtp = findViewById(R.id.btn_berkas_ktp);
        btnBerkasKtp.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKtpActivity.class));
            finish();
        });
        btnBerkasKunjungan = findViewById(R.id.btn_berkas_kunjungan);
        btnBerkasKunjungan.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasKunjunganActivity.class));
            finish();
        });
        btnBerkasPernyataan = findViewById(R.id.btn_berkas_pernyataan);
        btnBerkasPernyataan.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasPernyataanActivity.class));
            finish();
        });
        btnBerkasRegistrasi = findViewById(R.id.btn_berkas_registrasi);
        btnBerkasRegistrasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasRegistrasiActivity.class));
            finish();
        });
        btnBerkasRekomendasi = findViewById(R.id.btn_berkas_rekomendasi);
        btnBerkasRekomendasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasRekomendasiActivity.class));
            finish();
        });
        btnBerkasSerah = findViewById(R.id.btn_berkas_serah);
        btnBerkasSerah.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahBerkasSerahActivity.class));
            finish();
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), MainTambahActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainTambahActivity.class));
        finish();
        return;
    }
}