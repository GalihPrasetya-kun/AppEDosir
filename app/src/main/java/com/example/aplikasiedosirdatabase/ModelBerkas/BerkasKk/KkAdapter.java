package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKkActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KkAdapter extends FirebaseRecyclerAdapter<KkListModel, KkAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KkAdapter(@NonNull FirebaseRecyclerOptions<KkListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KkListModel model) {
        holder.txtNamaKk.setText(String.valueOf(model.getNamakk()));
        holder.txtTglLahirKk.setText(String.valueOf(model.getTgllahirkk()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKkActivity.class);
                intent.putExtra("namakk", model.getNamakk());
                intent.putExtra("tgllahirkk", model.getTgllahirkk());
                intent.putExtra("urlkk", model.getUrlkk());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kk, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKk, txtTglLahirKk, txtUrlKk;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKk = itemView.findViewById(R.id.txtNamaKk);
            txtTglLahirKk = itemView.findViewById(R.id.txtTglLahirKk);
            txtUrlKk = itemView.findViewById(R.id.txtUrlKk);
        }
    }
}
