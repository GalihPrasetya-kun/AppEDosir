package com.example.aplikasiedosirdatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetSehat.KetSehatListModel;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk.KkListModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class TambahBerkasKetsehatActivity extends AppCompatActivity {
    Button btnBack, btnSave, btnPilihKetsehat;
    Uri filepath;
    EditText etNamaKetsehat, etTglLahirKetsehat;

    StorageReference mStore;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_berkas_ketsehat);
        mStore = FirebaseStorage.getInstance().getReference();
        mData = FirebaseDatabase.getInstance().getReference("Berkas Ketsehat");

        etNamaKetsehat = findViewById(R.id.etNamaKetsehat);
        etTglLahirKetsehat = findViewById(R.id.etTglLahirKetsehat);

        btnPilihKetsehat = findViewById(R.id.btn_pilihFileKetsehat);
        btnPilihKetsehat.setOnClickListener(v -> {
            Dexter.withContext(getApplicationContext())
                    .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                            Intent intent = new Intent();
                            intent.setType("application/pdf");
                            intent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(intent, "Pilih File Berkas"), 101);
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                            permissionToken.continuePermissionRequest();
                        }
                    }).check();
        });

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(v -> {
            uploadFile(filepath);
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v ->{
            startActivity(new Intent(getApplicationContext(), MainTambahBerkasActivity.class));
            finish();
        });
    }

    private void uploadFile(Uri filepath) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("File Uploading....");
        dialog.show();

        StorageReference mRef = mStore.child("Berkas Ketsehat/"+System.currentTimeMillis()+".pdf");
        mRef.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        mRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                KetSehatListModel listKetsehat = new KetSehatListModel(etNamaKetsehat.getText().toString(), etTglLahirKetsehat.getText().toString(), uri.toString());
                                mData.child(mData.push().getKey()).setValue(listKetsehat);

                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "File Terupload.", Toast.LENGTH_SHORT).show();

                                etNamaKetsehat.setText("");
                                etTglLahirKetsehat.setText("");
                            }
                        });
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        float percent = (100*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                        dialog.setMessage("Sedang mengupload : "+(int)percent+"%");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==101 && resultCode==RESULT_OK){
            filepath = data.getData();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainTambahBerkasActivity.class));
        finish();
        return;
    }
}