package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk.KkAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk.KkListModel;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKunjungan.KunjunganAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKunjungan.KunjunganListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasKunjunganListActivity extends AppCompatActivity {
    RecyclerView recyclerViewKunjungan;
    KunjunganAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_kunjungan_list);
        recyclerViewKunjungan = findViewById(R.id.recyclerViewKunjungan);
        recyclerViewKunjungan.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<KunjunganListModel> ops = new FirebaseRecyclerOptions.Builder<KunjunganListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kunjungan"), KunjunganListModel.class)
                .build();

        adapter = new KunjunganAdapter(ops);
        recyclerViewKunjungan.setAdapter(adapter);

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
        FirebaseRecyclerOptions<KunjunganListModel> opslist = new FirebaseRecyclerOptions.Builder<KunjunganListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kunjungan").orderByChild("namakunjungan").startAt(str).endAt(str+"\uf8ff"), KunjunganListModel.class)
                .build();
        adapter = new KunjunganAdapter(opslist);
        adapter.startListening();
        recyclerViewKunjungan.setAdapter(adapter);
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