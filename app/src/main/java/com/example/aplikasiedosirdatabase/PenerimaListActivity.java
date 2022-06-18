package com.example.aplikasiedosirdatabase;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PenerimaListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Button btnBack;

    SearchView searchView;
    DataRecyclerAdapter.DataListAdapter adapter;
    List<DataListModel> dataList;

    DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();

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

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String str) {
                searchData(str);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String str) {
                searchData(str);
                return false;
            }
        });
    }

    private void searchData(String str) {
        //final String lowercaseQuery = str.toLowerCase();
        //final List<DataListModel> filteredModelList = new ArrayList<>();
        //for (DataListModel model : dataList) {
        //    final String text = model.getNama().toLowerCase();
        //    final String ktp = model.getNoktp();
        //    final String induk = model.getNoinduk();
        //    if (text.contains(lowercaseQuery) || ktp.contains(lowercaseQuery) || induk.contains(lowercaseQuery)) {
        //        filteredModelList.add(model);
        //    }
        //}
        //adapter.getFilter().filter(str);
        //mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
        return;
    }
}