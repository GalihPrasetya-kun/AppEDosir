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

public class ViewPdfPernyataanActivity extends AppCompatActivity {
    TextView txtNamaPernyataan, txtTglLahirPernyataan, txtUrlPernyataan;
    Button btnBack, btnDelete;
    PDFView pdfViewPernyataan;

    String namapernyataan, tgllahirpernyataan, urlpernyataan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_pernyataan);
        namapernyataan = getIntent().getStringExtra("namapernyataan");
        tgllahirpernyataan = getIntent().getStringExtra("tgllahirpernyataan");
        urlpernyataan = getIntent().getStringExtra("urlpernyataan");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasPernyataanListActivity.class));
            finish();
        });

        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ViewPdfPernyataanActivity.this);
            builder.setTitle("Hapus Data")
                    .setMessage("Apakah anda yakin ingin menghapus data ini ?")
                    .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Berkas Pernyataan");
                            mRef.orderByChild("namakk").equalTo(namapernyataan).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                                        dataSnapshot.getRef().removeValue();
                                        Toast.makeText(ViewPdfPernyataanActivity.this, "File Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), BerkasPernyataanListActivity.class));
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(ViewPdfPernyataanActivity.this, "File Gagal Dihapus!", Toast.LENGTH_SHORT).show();
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

        txtNamaPernyataan = findViewById(R.id.txtNamaPernyataan);
        txtNamaPernyataan.setText(namapernyataan);
        txtTglLahirPernyataan = findViewById(R.id.txtTglLahirPernyataan);
        txtTglLahirPernyataan.setText(tgllahirpernyataan);
        txtUrlPernyataan = findViewById(R.id.txtUrlPernyataan);
        txtUrlPernyataan.setText(urlpernyataan);

        pdfViewPernyataan = findViewById(R.id.pdfViewPernyataan);
        new PdfDownload().execute(urlpernyataan);
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
            pdfViewPernyataan.fromStream(inputStream).load();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), BerkasPernyataanListActivity.class));
        finish();
        return;
    }
}