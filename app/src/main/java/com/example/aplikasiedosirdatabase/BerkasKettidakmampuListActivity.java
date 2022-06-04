package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetTidakMampu.KetTidakMampuAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetTidakMampu.KetTidakMampuListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasKettidakmampuListActivity extends AppCompatActivity {
    RecyclerView recyclerViewKettidakmampu;
    KetTidakMampuAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_kettidakmampu_list);
        recyclerViewKettidakmampu = findViewById(R.id.recyclerViewKettidakmampu);
        recyclerViewKettidakmampu.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<KetTidakMampuListModel> ops = new FirebaseRecyclerOptions.Builder<KetTidakMampuListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kettidakmampu"), KetTidakMampuListModel.class)
                .build();

        adapter = new KetTidakMampuAdapter(ops);
        recyclerViewKettidakmampu.setAdapter(adapter);

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
        FirebaseRecyclerOptions<KetTidakMampuListModel> opslist = new FirebaseRecyclerOptions.Builder<KetTidakMampuListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Kettidakmampu").orderByChild("namakettidakmampu").startAt(str).endAt(str+"\uf8ff"), KetTidakMampuListModel.class)
                .build();
        adapter = new KetTidakMampuAdapter(opslist);
        adapter.startListening();
        recyclerViewKettidakmampu.setAdapter(adapter);
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