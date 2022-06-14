package com.example.aplikasiedosirdatabase.ModelData;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.DetailDataPenerimaActivity;
import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk.KkListModel;
import com.example.aplikasiedosirdatabase.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DataRecyclerAdapter {
    static Context mContext;
    DataListAdapter mDataAdapter;
    DataListAdapter mSearchAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<DataListModel> list, List<String> keys){
        mContext = context;
        mDataAdapter = new DataListAdapter(list, keys, mDataAdapter.dataClickListener);
        mSearchAdapter = new DataListAdapter(list, keys, mSearchAdapter.dataClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDataAdapter);
    }

    static class DataListView extends RecyclerView.ViewHolder{
        TextView txtNoinduk, txtNoktp, txtNama, txtTgllahir, txtJkelamin, txtStatus, txtPendidikan, txtAgama, txtAlamat, txtAsrama, txtNohub, txtPjawab, txtTglmasuk, txtCatatanPM, txtUrlProfile;
        ImageView image;
        String key;

        public DataListView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.item_data, parent, false));
            image = (ImageView) itemView.findViewById(R.id.image);
            txtUrlProfile = (TextView) itemView.findViewById(R.id.txtUrlProfile);
            txtNoinduk = (TextView) itemView.findViewById(R.id.txtNoinduk);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtNoktp = (TextView) itemView.findViewById(R.id.txtNoktp);
            txtTgllahir = (TextView) itemView.findViewById(R.id.txtTglLahir);
            txtJkelamin = (TextView) itemView.findViewById(R.id.txtJKelamin);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            txtPendidikan = (TextView) itemView.findViewById(R.id.txtPendidikan);
            txtAgama = (TextView) itemView.findViewById(R.id.txtAgama);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
            txtAsrama = (TextView) itemView.findViewById(R.id.txtAsrama);
            txtNohub = (TextView) itemView.findViewById(R.id.txtNoHub);
            txtPjawab = (TextView) itemView.findViewById(R.id.txtPJawab);
            txtTglmasuk = (TextView) itemView.findViewById(R.id.txtTglMasuk);
            txtCatatanPM = (TextView) itemView.findViewById(R.id.txtCatatanPM);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailDataPenerimaActivity.class);
                    intent.putExtra("key", key);
                    intent.putExtra("urlprofile", txtUrlProfile.getText().toString());
                    intent.putExtra("noinduk", txtNoinduk.getText().toString());
                    intent.putExtra("noktp", txtNoktp.getText().toString());
                    intent.putExtra("nama", txtNama.getText().toString());
                    intent.putExtra("tgllahir", txtTgllahir.getText().toString());
                    intent.putExtra("jkelamin", txtJkelamin.getText().toString());
                    intent.putExtra("status", txtStatus.getText().toString());
                    intent.putExtra("pendidikan", txtPendidikan.getText().toString());
                    intent.putExtra("agama", txtAgama.getText().toString());
                    intent.putExtra("alamat", txtAlamat.getText().toString());
                    intent.putExtra("asrama", txtAsrama.getText().toString());
                    intent.putExtra("nohub", txtNohub.getText().toString());
                    intent.putExtra("pjawab", txtPjawab.getText().toString());
                    intent.putExtra("tglmasuk", txtTglmasuk.getText().toString());
                    intent.putExtra("catatanpm", txtCatatanPM.getText().toString());

                    mContext.startActivity(intent);
                }
            });
        }

        public void bind(DataListModel listData, String key){
            txtUrlProfile.setText(listData.getUrlprofile());
            txtNoinduk.setText(listData.getNoinduk());
            txtNama.setText(listData.getNama());
            txtNoktp.setText(listData.getNoktp());
            txtTgllahir.setText(listData.getTgllahir());
            txtJkelamin.setText(listData.getJkelamin());
            txtStatus.setText(listData.getStatus());
            txtPendidikan.setText(listData.getPendidikan());
            txtAgama.setText(listData.getAgama());
            txtAlamat.setText(listData.getAlamat());
            txtAsrama.setText(listData.getAsrama());
            txtNohub.setText(listData.getNohub());
            txtPjawab.setText(listData.getPjawab());
            txtTglmasuk.setText(listData.getTglmasuk());
            txtCatatanPM.setText(listData.getCatatanpm());
            this.key = key;
        }
    }

    public static class DataListAdapter extends RecyclerView.Adapter<DataListView> implements Filterable {
        List<DataListModel> mlist;
        List<String> mkeys;
        List<DataListModel> mlistFull = new ArrayList<>();
        public DataClickListener dataClickListener;

        public interface DataClickListener{
            void selectData(DataListModel dataListModel);
        }

        public DataListAdapter(List<DataListModel> mlist, List<String> mkeys, DataClickListener dataClickListener) {
            this.mlist = mlist;
            this.mkeys = mkeys;
        //    this.mlistFull = mlistFull;
        //    this.dataClickListener = dataClickListener;
        }

        @NonNull
        @Override
        public DataListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DataListView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DataListView holder, int position) {
            holder.bind(mlist.get(position), mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();
                    if (charSequence == null || charSequence.length() == 0){
                        filterResults.values = mlistFull;
                        filterResults.count = mlistFull.size();
                    }else {
                        String searchStr = charSequence.toString().toLowerCase(Locale.ROOT);
                        List<DataListModel> dataModel = new ArrayList<>();
                        for (DataListModel listModel: mlistFull){
                            if (listModel.getNama().toLowerCase(Locale.ROOT).contains(searchStr)){
                                dataModel.add(listModel);
                            }
                        }
                        filterResults.values = dataModel;
                        filterResults.count = dataModel.size();
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                    mlist = (List<DataListModel>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }
}
