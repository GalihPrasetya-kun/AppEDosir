package com.example.aplikasiedosirdatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasiedosirdatabase.ModelData.DataFirebaseHelper;
import com.example.aplikasiedosirdatabase.ModelData.DataListModel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class EditDetailDataActivity extends AppCompatActivity {
    EditText etNoinduk, etNoktp, etNama, etTgllahir, etJkelamin, etStatus, etPendidikan, etAgama, etAlamat, etAsrama, etNohub, etPjawab, etTglmasuk, etCatatanPM;
    TextView txtUrlProfile;
    Button btnSave, btnBack;
    Button btnPilihProfile, btnLihatProfile;
    ImageView imgProfile;

    String sImgProfile;
    String key, noinduk, noktp, nama, tgllahir, jkelamin, status, pendidikan, agama, alamat, asrama, nohub, pjawab, tglmasuk, catatanpm, urlprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_detail_data);
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

        imgProfile = findViewById(R.id.imgProfile);

        btnPilihProfile = findViewById(R.id.btn_pilih_profile);
        btnPilihProfile.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(EditDetailDataActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(EditDetailDataActivity.this, new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE
                }, 1);
            }else {
                selectImage();
            }
        });

        btnLihatProfile = findViewById(R.id.btn_lihat_profile);
        btnLihatProfile.setOnClickListener(v -> {
            byte[] bytes = Base64.decode(sImgProfile, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            imgProfile.setImageBitmap(bitmap);
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), PenerimaListActivity.class));
            finish();
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
                        Toast.makeText(EditDetailDataActivity.this, "Data Berhasil Diupdate", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), PenerimaListActivity.class));
                        return;
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
    }

    private void selectImage() {
        txtUrlProfile.setText("");
        imgProfile.setImageBitmap(null);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent,"Pilih Foto"), 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectImage();
        }else {
            Toast.makeText(getApplicationContext(), "Permission Denied.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!=null){
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100,stream);
                byte[] bytes = stream.toByteArray();
                sImgProfile = Base64.encodeToString(bytes, Base64.DEFAULT);
                txtUrlProfile.setText(sImgProfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        return;
    }
}