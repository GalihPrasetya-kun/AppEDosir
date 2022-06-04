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
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasSerah.SerahAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasSerah.SerahListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasSerahListActivity extends AppCompatActivity {
    RecyclerView recyclerViewSerah;
    SerahAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_serah_list);
        recyclerViewSerah = findViewById(R.id.recyclerViewSerah);
        recyclerViewSerah.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<SerahListModel> ops = new FirebaseRecyclerOptions.Builder<SerahListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Serah"), SerahListModel.class)
                .build();

        adapter = new SerahAdapter(ops);
        recyclerViewSerah.setAdapter(adapter);

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
        FirebaseRecyclerOptions<SerahListModel> opslist = new FirebaseRecyclerOptions.Builder<SerahListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Serah").orderByChild("namaserah").startAt(str).endAt(str+"\uf8ff"), SerahListModel.class)
                .build();
        adapter = new SerahAdapter(opslist);
        adapter.startListening();
        recyclerViewSerah.setAdapter(adapter);
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