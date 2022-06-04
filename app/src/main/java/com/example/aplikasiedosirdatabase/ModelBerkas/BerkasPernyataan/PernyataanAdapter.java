package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasPernyataan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfPernyataanActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PernyataanAdapter extends FirebaseRecyclerAdapter<PernyataanListModel, PernyataanAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PernyataanAdapter(@NonNull FirebaseRecyclerOptions<PernyataanListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull PernyataanListModel model) {
        holder.txtNamaPernyataan.setText(String.valueOf(model.getNamapernyataan()));
        holder.txtTglLahirPernyataan.setText(String.valueOf(model.getTgllahirpernyataan()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfPernyataanActivity.class);
                intent.putExtra("namapernyataan", model.getNamapernyataan());
                intent.putExtra("tgllahirpernyataan", model.getTgllahirpernyataan());
                intent.putExtra("urlpernyataan", model.getUrlpernyataan());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_pernyataan, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaPernyataan, txtTglLahirPernyataan, txtUrlPernyataan;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaPernyataan = itemView.findViewById(R.id.txtNamaPernyataan);
            txtTglLahirPernyataan = itemView.findViewById(R.id.txtTglLahirPernyataan);
            txtUrlPernyataan = itemView.findViewById(R.id.txtUrlPernyataan);
        }
    }
}
