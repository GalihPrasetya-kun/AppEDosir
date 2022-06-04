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

public class ViewPdfSerahActivity extends AppCompatActivity {
    TextView txtNamaSerah, txtTglLahirSerah, txtUrlSerah;
    Button btnBack, btnDelete;
    PDFView pdfViewSerah;

    String namaserah, tgllahirserah, urlserah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_serah);
        namaserah = getIntent().getStringExtra("namaserah");
        tgllahirserah = getIntent().getStringExtra("tgllahirserah");
        urlserah = getIntent().getStringExtra("urlserah");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasSerahListActivity.class));
            finish();
        });

        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ViewPdfSerahActivity.this);
            builder.setTitle("Hapus Data")
                    .setMessage("Apakah anda yakin ingin menghapus data ini ?")
                    .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Berkas Serah");
                            mRef.orderByChild("namakk").equalTo(namaserah).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                                        dataSnapshot.getRef().removeValue();
                                        Toast.makeText(ViewPdfSerahActivity.this, "File Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), BerkasSerahListActivity.class));
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(ViewPdfSerahActivity.this, "File Gagal Dihapus!", Toast.LENGTH_SHORT).show();
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

        txtNamaSerah = findViewById(R.id.txtNamaSerah);
        txtNamaSerah.setText(namaserah);
        txtTglLahirSerah = findViewById(R.id.txtTglLahirSerah);
        txtTglLahirSerah.setText(tgllahirserah);
        txtUrlSerah = findViewById(R.id.txtUrlSerah);
        txtUrlSerah.setText(urlserah);

        pdfViewSerah = findViewById(R.id.pdfViewSerah);
        new PdfDownload().execute(urlserah);
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
            pdfViewSerah.fromStream(inputStream).load();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), BerkasSerahListActivity.class));
        finish();
        return;
    }
}