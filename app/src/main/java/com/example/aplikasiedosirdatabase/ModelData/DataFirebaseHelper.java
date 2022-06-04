package com.example.aplikasiedosirdatabase.ModelData;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataFirebaseHelper {
    FirebaseDatabase mData;
    DatabaseReference mRef;
    List<DataListModel> list = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<DataListModel> list, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public DataFirebaseHelper(){
        mData = FirebaseDatabase.getInstance();
        mRef = mData.getReference("Penerima");
    }

    public void readData(DataStatus dataStatus){
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                List<String> keys = new ArrayList<>();
                for(DataSnapshot keyNode : snapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    DataListModel listData = keyNode.getValue(DataListModel.class);
                    list.add(listData);
                }
                dataStatus.DataIsLoaded(list, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addData(DataListModel list, final DataStatus dataStatus){
        String key = mRef.push().getKey();
        mRef.child(key).setValue(list).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void updateData(String key, DataListModel list, final DataStatus dataStatus){
        mRef.child(key).setValue(list).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteData(String key, final DataStatus dataStatus) {
        mRef.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}
