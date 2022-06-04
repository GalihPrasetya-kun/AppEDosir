package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasAssessment.AssessmentAdapter;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasAssessment.AssessmentListModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class BerkasAssessmentListActivity extends AppCompatActivity {
    RecyclerView recyclerViewAssessment;
    AssessmentAdapter adapter;
    Button btnBack;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berkas_assessment_list);
        recyclerViewAssessment = findViewById(R.id.recyclerViewAssessment);
        recyclerViewAssessment.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.progressBar).setVisibility(View.GONE);

        FirebaseRecyclerOptions<AssessmentListModel> ops = new FirebaseRecyclerOptions.Builder<AssessmentListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Assessment"), AssessmentListModel.class)
                .build();

        adapter = new AssessmentAdapter(ops);
        recyclerViewAssessment.setAdapter(adapter);

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
        FirebaseRecyclerOptions<AssessmentListModel> opslist = new FirebaseRecyclerOptions.Builder<AssessmentListModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Berkas Assessment").orderByChild("namaassessment").startAt(str).endAt(str+"\uf8ff"), AssessmentListModel.class)
                .build();
        adapter = new AssessmentAdapter(opslist);
        adapter.startListening();
        recyclerViewAssessment.setAdapter(adapter);
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