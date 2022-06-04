package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIntake.IntakeAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIntake.IntakeListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasIntakeListActivity extends AppCompatActivity {
    RecyclerView recyclerViewIntake;
    IntakeAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_intake_list);
        recyclerViewIntake = findViewById(R.id.recyclerViewIntake);
        recyclerViewIntake.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<IntakeListModel> ops = new FirebaseRecyclerOptions.Builder<IntakeListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Intake"), IntakeListModel.class)
                .build();

        adapter = new IntakeAdapter(ops);
        recyclerViewIntake.setAdapter(adapter);

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
        FirebaseRecyclerOptions<IntakeListModel> opslist = new FirebaseRecyclerOptions.Builder<IntakeListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Intake").orderByChild("namaintake").startAt(str).endAt(str+"\uf8ff"), IntakeListModel.class)
                .build();
        adapter = new IntakeAdapter(opslist);
        adapter.startListening();
        recyclerViewIntake.setAdapter(adapter);
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