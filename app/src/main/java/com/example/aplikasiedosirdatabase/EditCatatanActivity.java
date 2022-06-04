package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasiedosirdatabase.ModelData.DataFirebaseHelper;
import com.example.aplikasiedosirdatabase.ModelData.DataListModel;

import java.util.List;

public class EditCatatanActivity extends AppCompatActivity {
    EditText etNoinduk, etNoktp, etNama, etTgllahir, etJkelamin, etStatus, etPendidikan, etAgama, etAlamat, etAsrama, etNohub, etPjawab, etTglmasuk, etCatatanPM;
    TextView txtUrlProfile;
    Button btnSave, btnBack;

    String key, noinduk, noktp, nama, tgllahir, jkelamin, status, pendidikan, agama, alamat, asrama, nohub, pjawab, tglmasuk, catatanpm, urlprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_catatan);
        key = getIntent().getStringExtra("key");
        urlprofile = getIntent().getStringExtra("urlprofile");
        noinduk = getIntent().getStringExtra("noinduk");
        noktp = getIntent().getStringExtra("noktp");
        nama = getIntent().getStringExtra("nama");
        tgllahir = getIntent().getStringExtra("tgllahir");
        jkelamin = getIntent().getStringExtra("jkelamin");
        status = getIntent().getStringExtra("status");
        pendidikan = getIntent().getStringExtra("pendidikan");
        agama = getIntent().getStringExtra("agama");
        alamat = getIntent().getStringExtra("alamat");
        asrama = getIntent().getStringExtra("asrama");
        nohub = getIntent().getStringExtra("nohub");
        pjawab = getIntent().getStringExtra("pjawab");
        tglmasuk = getIntent().getStringExtra("tglmasuk");
        catatanpm = getIntent().getStringExtra("catatanpm");

        txtUrlProfile = findViewById(R.id.txtUrlProfile);
        txtUrlProfile.setText(urlprofile);

        etNoinduk = findViewById(R.id.etNoinduk);
        etNoinduk.setText(noinduk);
        etNoktp = findViewById(R.id.etNoktp);
        etNoktp.setText(noktp);
        etNama = findViewById(R.id.etNama);
        etNama.setText(nama);
        etTgllahir = findViewById(R.id.etTglLahir);
        etTgllahir.setText(tgllahir);
        etJkelamin = findViewById(R.id.etJKelamin);
        etJkelamin.setText(jkelamin);
        etStatus = findViewById(R.id.etStatus);
        etStatus.setText(status);
        etPendidikan = findViewById(R.id.etPendidikan);
        etPendidikan.setText(pendidikan);
        etAgama = findViewById(R.id.etAgama);
        etAgama.setText(agama);
        etAlamat = findViewById(R.id.etAlamat);
        etAlamat.setText(alamat);
        etAsrama = findViewById(R.id.etAsrama);
        etAsrama.setText(asrama);
        etNohub = findViewById(R.id.etNoHub);
        etNohub.setText(nohub);
        etPjawab = findViewById(R.id.etPJawab);
        etPjawab.setText(pjawab);
        etTglmasuk = findViewById(R.id.etTglMasuk);
        etTglmasuk.setText(tglmasuk);
        etCatatanPM = findViewById(R.id.etCatatanPM);
        etCatatanPM.setText(catatanpm);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
            return;
        });

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataListModel listData = new DataListModel();
                listData.setUrlprofile(txtUrlProfile.getText().toString());
                listData.setNoinduk(etNoinduk.getText().toString());
                listData.setNoktp(etNoktp.getText().toString());
                listData.setNama(etNama.getText().toString());
                listData.setTgllahir(etTgllahir.getText().toString());
                listData.setJkelamin(etJkelamin.getText().toString());
                listData.setStatus(etStatus.getText().toString());
                listData.setPendidikan(etPendidikan.getText().toString());
                listData.setAgama(etAgama.getText().toString());
                listData.setAlamat(etAlamat.getText().toString());
                listData.setAsrama(etAsrama.getText().toString());
                listData.setNohub(etNohub.getText().toString());
                listData.setPjawab(etPjawab.getText().toString());
                listData.setTglmasuk(etTglmasuk.getText().toString());
                listData.setCatatanpm(etCatatanPM.getText().toString());
                new DataFirebaseHelper().updateData(key, listData, new DataFirebaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<DataListModel> list, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(EditCatatanActivity.this, "Catatan Berhasil Diupdate", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        return;
    }
}