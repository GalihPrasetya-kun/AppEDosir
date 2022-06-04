package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIndentifikasi.IdentifikasiAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIndentifikasi.IdentifikasiListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasIdentifikasiListActivity extends AppCompatActivity {
    RecyclerView recyclerViewIdentifikasi;
    IdentifikasiAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_identifikasi_list);
        recyclerViewIdentifikasi = findViewById(R.id.recyclerViewIdentifikasi);
        recyclerViewIdentifikasi.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<IdentifikasiListModel> ops = new FirebaseRecyclerOptions.Builder<IdentifikasiListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Identifikasi"), IdentifikasiListModel.class)
                .build();

        adapter = new IdentifikasiAdapter(ops);
        recyclerViewIdentifikasi.setAdapter(adapter);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), BerkasListActivity.class));
            finish();
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String str) {
                searchList(str);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String str) {
                searchList(str);
                return false;
            }
        });
    }

    private void searchList(String str) {
        FirebaseRecyclerOptions<IdentifikasiListModel> opslist = new FirebaseRecyclerOptions.Builder<IdentifikasiListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Identifikasi").orderByChild("namaidentifikasi").startAt(str).endAt(str+"\uf8ff"), IdentifikasiListModel.class)
                .build();
        adapter = new IdentifikasiAdapter(opslist);
        adapter.startListening();
        recyclerViewIdentifikasi.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), BerkasListActivity.class));
        finish();
        return;
    }
}