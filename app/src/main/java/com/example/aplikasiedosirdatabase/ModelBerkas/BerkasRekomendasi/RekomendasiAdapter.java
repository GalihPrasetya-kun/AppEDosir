package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRekomendasi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfRekomendasiActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RekomendasiAdapter extends FirebaseRecyclerAdapter<RekomendasiListModel, RekomendasiAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RekomendasiAdapter(@NonNull FirebaseRecyclerOptions<RekomendasiListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull RekomendasiListModel model) {
        holder.txtNamaRekomendasi.setText(String.valueOf(model.getNamarekomendasi()));
        holder.txtTglLahirRekomendasi.setText(String.valueOf(model.getTgllahirrekomendasi()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfRekomendasiActivity.class);
                intent.putExtra("namarekomendasi", model.getNamarekomendasi());
                intent.putExtra("tgllahirrekomendasi", model.getTgllahirrekomendasi());
                intent.putExtra("urlrekomendasi", model.getUrlrekomendasi());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_rekomendasi, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaRekomendasi, txtTglLahirRekomendasi, txtUrlRekomendasi;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaRekomendasi = itemView.findViewById(R.id.txtNamaRekomendasi);
            txtTglLahirRekomendasi = itemView.findViewById(R.id.txtTglLahirRekomendasi);
            txtUrlRekomendasi = itemView.findViewById(R.id.txtUrlRekomendasi);
        }
    }
}
