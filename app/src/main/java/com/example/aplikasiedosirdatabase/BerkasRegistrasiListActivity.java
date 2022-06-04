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
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRegistrasi.RegistrasiAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRegistrasi.RegistrasiListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasRegistrasiListActivity extends AppCompatActivity {
    RecyclerView recyclerViewRegistrasi;
    RegistrasiAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_registrasi_list);
        recyclerViewRegistrasi = findViewById(R.id.recyclerViewRegistrasi);
        recyclerViewRegistrasi.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<RegistrasiListModel> ops = new FirebaseRecyclerOptions.Builder<RegistrasiListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Registrasi"), RegistrasiListModel.class)
                .build();

        adapter = new RegistrasiAdapter(ops);
        recyclerViewRegistrasi.setAdapter(adapter);

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
        FirebaseRecyclerOptions<RegistrasiListModel> opslist = new FirebaseRecyclerOptions.Builder<RegistrasiListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Registrasi").orderByChild("namaregistrasi").startAt(str).endAt(str+"\uf8ff"), RegistrasiListModel.class)
                .build();
        adapter = new RegistrasiAdapter(opslist);
        adapter.startListening();
        recyclerViewRegistrasi.setAdapter(adapter);
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