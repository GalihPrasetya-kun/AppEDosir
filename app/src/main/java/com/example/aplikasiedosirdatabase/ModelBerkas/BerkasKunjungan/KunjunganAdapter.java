package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKunjungan;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKunjunganActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KunjunganAdapter extends FirebaseRecyclerAdapter<KunjunganListModel, KunjunganAdapter.myviewholder>{
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KunjunganAdapter(@NonNull FirebaseRecyclerOptions<KunjunganListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KunjunganListModel model) {
        holder.txtNamaKunjungan.setText(String.valueOf(model.getNamakunjungan()));
        holder.txtTglLahirKunjungan.setText(String.valueOf(model.getTgllahirkunjungan()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKunjunganActivity.class);
                intent.putExtra("namakunjungan", model.getNamakunjungan());
                intent.putExtra("tgllahirkunjungan", model.getTgllahirkunjungan());
                intent.putExtra("urlkunjungan", model.getUrlkunjungan());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kunjungan, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKunjungan, txtTglLahirKunjungan, txtUrlKunjungan;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKunjungan = itemView.findViewById(R.id.txtNamaKunjungan);
            txtTglLahirKunjungan = itemView.findViewById(R.id.txtTglLahirKunjungan);
            txtUrlKunjungan = itemView.findViewById(R.id.txtUrlKunjungan);
        }
    }
}
