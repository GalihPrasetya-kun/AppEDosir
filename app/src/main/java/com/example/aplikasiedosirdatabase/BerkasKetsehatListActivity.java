package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetSehat.KetSehatAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetSehat.KetSehatListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasKetsehatListActivity extends AppCompatActivity {
    RecyclerView recyclerViewKetsehat;
    KetSehatAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_ketsehat_list);
        recyclerViewKetsehat = findViewById(R.id.recyclerViewKetsehat);
        recyclerViewKetsehat.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<KetSehatListModel> ops = new FirebaseRecyclerOptions.Builder<KetSehatListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Ketsehat"), KetSehatListModel.class)
                .build();

        adapter = new KetSehatAdapter(ops);
        recyclerViewKetsehat.setAdapter(adapter);

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
        FirebaseRecyclerOptions<KetSehatListModel> opslist = new FirebaseRecyclerOptions.Builder<KetSehatListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Ketsehat").orderByChild("namaketsehat").startAt(str).endAt(str+"\uf8ff"), KetSehatListModel.class)
                .build();
        adapter = new KetSehatAdapter(opslist);
        adapter.startListening();
        recyclerViewKetsehat.setAdapter(adapter);
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