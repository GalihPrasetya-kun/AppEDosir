package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasiedosirdatabase.ModelData.DataFirebaseHelper;
import com.example.aplikasiedosirdatabase.ModelData.DataListModel;
import com.example.aplikasiedosirdatabase.ModelData.DataRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class PenerimaListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Button btnBack;

    SearchView searchView;
    DataRecyclerAdapter.DataListAdapter adapter;

    FirebaseDatabase mData;
    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference("Penerima");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penerima_list);
        mRecyclerView = findViewById(R.id.recyclerView);
        new DataFirebaseHelper().readData(new DataFirebaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<DataListModel> list, List<String> keys) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                new DataRecyclerAdapter().setConfig(mRecyclerView, PenerimaListActivity.this, list, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        searchView = findViewById(R.id.searchView);


        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        return;
    }
}