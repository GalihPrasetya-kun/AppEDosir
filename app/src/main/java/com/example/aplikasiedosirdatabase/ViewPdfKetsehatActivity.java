package com.example.aplikasiedosirdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViewPdfKetsehatActivity extends AppCompatActivity {
    TextView txtNamaKetsehat, txtTglLahirKetsehat, txtUrlKetsehat;
    Button btnBack, btnDelete;
    PDFView pdfViewKetsehat;

    String namaketsehat, tgllahirketsehat, urlketsehat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_ketsehat);
        namaketsehat = getIntent().getStringExtra("namaketsehat");
        tgllahirketsehat = getIntent().getStringExtra("tgllahirketsehat");
        urlketsehat = getIntent().getStringExtra("urlketsehat");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKetsehatListActivity.class));
            finish();
        });

        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ViewPdfKetsehatActivity.this);
            builder.setTitle("Hapus Data")
                    .setMessage("Apakah anda yakin ingin menghapus data ini ?")
                    .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Berkas Ketsehat");
                            mRef.orderByChild("namakk").equalTo(namaketsehat).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                                        dataSnapshot.getRef().removeValue();
                                        Toast.makeText(ViewPdfKetsehatActivity.this, "File Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), BerkasKetsehatListActivity.class));
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(ViewPdfKetsehatActivity.this, "File Gagal Dihapus!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    })
                    .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        txtNamaKetsehat = findViewById(R.id.txtNamaKetsehat);
        txtNamaKetsehat.setText(namaketsehat);
        txtTglLahirKetsehat = findViewById(R.id.txtTglLahirKetsehat);
        txtTglLahirKetsehat.setText(tgllahirketsehat);
        txtUrlKetsehat = findViewById(R.id.txtUrlKetsehat);
        txtUrlKetsehat.setText(urlketsehat);

        pdfViewKetsehat = findViewById(R.id.pdfViewKetsehat);
        new PdfDownload().execute(urlketsehat);
    }

    private class PdfDownload extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfViewKetsehat.fromStream(inputStream).load();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), BerkasKetsehatListActivity.class));
        finish();
        return;
    }
}