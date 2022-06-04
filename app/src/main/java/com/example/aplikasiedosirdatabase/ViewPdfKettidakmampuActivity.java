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

public class ViewPdfKettidakmampuActivity extends AppCompatActivity {
    TextView txtNamaKettidakmampu, txtTglLahirKettidakmampu, txtUrlKettidakmampu;
    Button btnBack, btnDelete;
    PDFView pdfViewKettidakmampu;

    String namakettidakmampu, tgllahirkettidakmampu, urlkettidakmampu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf_kettidakmampu);
        namakettidakmampu = getIntent().getStringExtra("namakettidakmampu");
        tgllahirkettidakmampu = getIntent().getStringExtra("tgllahirkettidakmampu");
        urlkettidakmampu = getIntent().getStringExtra("urlkettidakmampu");

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasKettidakmampuListActivity.class));
            finish();
        });

        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ViewPdfKettidakmampuActivity.this);
            builder.setTitle("Hapus Data")
                    .setMessage("Apakah anda yakin ingin menghapus data ini ?")
                    .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Berkas Kettidakmampu");
                            mRef.orderByChild("namakk").equalTo(namakettidakmampu).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                                        dataSnapshot.getRef().removeValue();
                                        Toast.makeText(ViewPdfKettidakmampuActivity.this, "File Berhasil Dihapus!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), BerkasKettidakmampuListActivity.class));
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Toast.makeText(ViewPdfKettidakmampuActivity.this, "File Gagal Dihapus!", Toast.LENGTH_SHORT).show();
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

        txtNamaKettidakmampu = findViewById(R.id.txtNamaKettidakmampu);
        txtNamaKettidakmampu.setText(namakettidakmampu);
        txtTglLahirKettidakmampu = findViewById(R.id.txtTglLahirKettidakmampu);
        txtTglLahirKettidakmampu.setText(tgllahirkettidakmampu);
        txtUrlKettidakmampu = findViewById(R.id.txtUrlKettidakmampu);
        txtUrlKettidakmampu.setText(urlkettidakmampu);

        pdfViewKettidakmampu = findViewById(R.id.pdfViewKettidakmampu);
        new PdfDownload().execute(urlkettidakmampu);
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
            pdfViewKettidakmampu.fromStream(inputStream).load();
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), BerkasKettidakmampuListActivity.class));
        finish();
        return;
    }
}