package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIndentifikasi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfIdentifikasiActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class IdentifikasiAdapter extends FirebaseRecyclerAdapter<IdentifikasiListModel, IdentifikasiAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public IdentifikasiAdapter(@NonNull FirebaseRecyclerOptions<IdentifikasiListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull IdentifikasiListModel model) {
        holder.txtNamaIdentifikasi.setText(String.valueOf(model.getNamaidentifikasi()));
        holder.txtTglLahirIdentifikasi.setText(String.valueOf(model.getTgllahiridentifikasi()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfIdentifikasiActivity.class);
                intent.putExtra("namaidentifikasi", model.getNamaidentifikasi());
                intent.putExtra("tgllahiridentifikasi", model.getTgllahiridentifikasi());
                intent.putExtra("urlidentifikasi", model.getUrlidentifikasi());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_identifikasi, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaIdentifikasi, txtTglLahirIdentifikasi, txtUrlIdentifikasi;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaIdentifikasi = itemView.findViewById(R.id.txtNamaIdentifikasi);
            txtTglLahirIdentifikasi = itemView.findViewById(R.id.txtTglLahirIdentifikasi);
            txtUrlIdentifikasi = itemView.findViewById(R.id.txtUrlIdentifikasi);
        }
    }
}
