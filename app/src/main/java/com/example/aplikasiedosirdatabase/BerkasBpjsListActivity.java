package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasBpjs.BpjsAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasBpjs.BpjsListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasBpjsListActivity extends AppCompatActivity {
    RecyclerView recyclerViewBpjs;
    BpjsAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_bpjs_list);
        recyclerViewBpjs = findViewById(R.id.recyclerViewBpjs);
        recyclerViewBpjs.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<BpjsListModel> ops = new FirebaseRecyclerOptions.Builder<BpjsListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas KK"), BpjsListModel.class)
                .build();

        adapter = new BpjsAdapter(ops);
        recyclerViewBpjs.setAdapter(adapter);

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
        FirebaseRecyclerOptions<BpjsListModel> opslist = new FirebaseRecyclerOptions.Builder<BpjsListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Bpjs").orderByChild("namabpjs").startAt(str).endAt(str+"\uf8ff"), BpjsListModel.class)
                .build();
        adapter = new BpjsAdapter(opslist);
        adapter.startListening();
        recyclerViewBpjs.setAdapter(adapter);
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