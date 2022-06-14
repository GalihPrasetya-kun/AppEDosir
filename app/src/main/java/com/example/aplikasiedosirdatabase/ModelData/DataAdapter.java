package com.example.aplikasiedosirdatabase.ModelData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    public List<DataListModel> dataListModels = new ArrayList<>();
    public Context context;

    public DataAdapter(List<DataListModel> dataListModels, Context context) {
        this.dataListModels = dataListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_data,parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.DataViewHolder holder, int position) {
        DataListModel dataListModel = dataListModels.get(position);
        String noinduk = dataListModel.getNoinduk();
        String nama = dataListModel.getNama();
        String noktp = dataListModel.getNoktp();
        String tgllahir = dataListModel.getTgllahir();
        String jkelamin = dataListModel.getJkelamin();
        String status = dataListModel.getStatus();
        String pendidikan = dataListModel.getPendidikan();
        String agama = dataListModel.getAgama();
        String alamat = dataListModel.getAlamat();
        String asrama = dataListModel.getAsrama();
        String nohub = dataListModel.getNohub();
        String pjawab = dataListModel.getPjawab();
        String tglmasuk = dataListModel.getTglmasuk();
        String cacatan = dataListModel.getCatatanpm();
        String urlprofile = dataListModel.getUrlprofile();

        holder.txtNoinduk.setText(noinduk);
        holder.txtNama.setText(nama);
        holder.txtNoktp.setText(noktp);
        holder.txtTgllahir.setText(tgllahir);
        holder.txtJkelamin.setText(jkelamin);
        holder.txtStatus.setText(status);
        holder.txtPendidikan.setText(pendidikan);
        holder.txtAgama.setText(agama);
        holder.txtAlamat.setText(alamat);
        holder.txtAsrama.setText(asrama);
        holder.txtNohub.setText(nohub);
        holder.txtPjawab.setText(pjawab);
        holder.txtTglmasuk.setText(tglmasuk);
        holder.txtCatatanPM.setText(cacatan);
        holder.txtUrlProfile.setText(urlprofile);

    }

    @Override
    public int getItemCount() {
        return dataListModels.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        TextView txtNoinduk, txtNoktp, txtNama, txtTgllahir, txtJkelamin, txtStatus, txtPendidikan, txtAgama, txtAlamat, txtAsrama, txtNohub, txtPjawab, txtTglmasuk, txtCatatanPM, txtUrlProfile;
        ImageView image;
        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
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
        }
    }
}
