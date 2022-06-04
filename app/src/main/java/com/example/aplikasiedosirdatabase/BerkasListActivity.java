package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class BerkasListActivity extends AppCompatActivity {
    Button btnBerkasAssessment, btnBerkasBpjs, btnBerkasIdentifikasi, btnBerkasIntake, btnBerkasKematian ,
            btnBerkasKetsehat, btnBerkasKettidakmampu, btnBerkasKk, btnBerkasKontrak, btnBerkasKtp,
            btnBerkasKunjungan, btnBerkasPernyataan, btnBerkasRegistrasi, btnBerkasRekomendasi, btnBerkasSerah;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_list);
        btnBerkasAssessment = findViewById(R.id.btn_berkas_assessment);
        btnBerkasAssessment.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasAssessmentListActivity.class));
            finish();
        });
        btnBerkasBpjs = findViewById(R.id.btn_berkas_bpjs);
        btnBerkasBpjs.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasBpjsListActivity.class));
            finish();
        });
        btnBerkasIdentifikasi = findViewById(R.id.btn_berkas_identifikasi);
        btnBerkasIdentifikasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasIdentifikasiListActivity.class));
            finish();
        });
        btnBerkasIntake = findViewById(R.id.btn_berkas_intake);
        btnBerkasIntake.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasIntakeListActivity.class));
            finish();
        });
        btnBerkasKematian = findViewById(R.id.btn_berkas_kematian);
        btnBerkasKematian.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKematianListActivity.class));
            finish();
        });
        btnBerkasKetsehat = findViewById(R.id.btn_berkas_ketsehat);
        btnBerkasKetsehat.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKetsehatListActivity.class));
            finish();
        });
        btnBerkasKettidakmampu = findViewById(R.id.btn_berkas_kettidakmampu);
        btnBerkasKettidakmampu.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKettidakmampuListActivity.class));
            finish();
        });
        btnBerkasKk = findViewById(R.id.btn_berkas_kk);
        btnBerkasKk.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKkListActivity.class));
            finish();
        });
        btnBerkasKontrak = findViewById(R.id.btn_berkas_kontrak);
        btnBerkasKontrak.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKontrakListActivity.class));
            finish();
        });
        btnBerkasKtp = findViewById(R.id.btn_berkas_ktp);
        btnBerkasKtp.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKtpListActivity.class));
            finish();
        });
        btnBerkasKunjungan = findViewById(R.id.btn_berkas_kunjungan);
        btnBerkasKunjungan.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKunjunganListActivity.class));
            finish();
        });
        btnBerkasPernyataan = findViewById(R.id.btn_berkas_pernyataan);
        btnBerkasPernyataan.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasPernyataanListActivity.class));
            finish();
        });
        btnBerkasRegistrasi = findViewById(R.id.btn_berkas_registrasi);
        btnBerkasRegistrasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasRegistrasiListActivity.class));
            finish();
        });
        btnBerkasRekomendasi = findViewById(R.id.btn_berkas_rekomendasi);
        btnBerkasRekomendasi.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasRekomendasiListActivity.class));
            finish();
        });
        btnBerkasSerah = findViewById(R.id.btn_berkas_serah);
        btnBerkasSerah.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasSerahListActivity.class));
            finish();
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
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