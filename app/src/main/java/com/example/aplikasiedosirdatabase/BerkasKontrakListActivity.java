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
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKontrak.KontrakAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKontrak.KontrakListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasKontrakListActivity extends AppCompatActivity {
    RecyclerView recyclerViewKontrak;
    KontrakAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_kontrak_list);
        recyclerViewKontrak = findViewById(R.id.recyclerViewKontrak);
        recyclerViewKontrak.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<KontrakListModel> ops = new FirebaseRecyclerOptions.Builder<KontrakListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kontrak"), KontrakListModel.class)
                .build();

        adapter = new KontrakAdapter(ops);
        recyclerViewKontrak.setAdapter(adapter);

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
        FirebaseRecyclerOptions<KontrakListModel> opslist = new FirebaseRecyclerOptions.Builder<KontrakListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kontrak").orderByChild("namakontrak").startAt(str).endAt(str+"\uf8ff"), KontrakListModel.class)
                .build();
        adapter = new KontrakAdapter(opslist);
        adapter.startListening();
        recyclerViewKontrak.setAdapter(adapter);
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