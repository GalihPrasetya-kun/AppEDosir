package com.example.aplikasiedosirdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.aplikasiedosirdatabase.ModelData.DataAdapter;
import com.example.aplikasiedosirdatabase.ModelData.DataListModel;

import java.util.ArrayList;
import java.util.List;

public class DataListActivity extends AppCompatActivity {

    RecyclerView rcView;
    DataAdapter dataAdapter;
    List<DataListModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        rcView = findViewById(R.id.rcView);
        setData();

    }

    private void setData() {
        modelList.add(new DataListModel("islam", "jln", "bima", "aaaa", "laki", "galih", "1", "1", "s1", "tijas", "belum", "pwt", "21 mei 2022", ""));
    }
}