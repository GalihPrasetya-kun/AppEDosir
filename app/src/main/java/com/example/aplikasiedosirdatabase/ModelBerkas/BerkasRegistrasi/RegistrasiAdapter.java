package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRegistrasi;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfRegistrasiActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class RegistrasiAdapter extends FirebaseRecyclerAdapter<RegistrasiListModel, RegistrasiAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RegistrasiAdapter(@NonNull FirebaseRecyclerOptions<RegistrasiListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull RegistrasiListModel model) {
        holder.txtNamaRegistrasi.setText(String.valueOf(model.getNamaregistrasi()));
        holder.txtTglLahirRegistrasi.setText(String.valueOf(model.getTgllahirregistrasi()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfRegistrasiActivity.class);
                intent.putExtra("namaregistrasi", model.getNamaregistrasi());
                intent.putExtra("tgllahirregistrasi", model.getTgllahirregistrasi());
                intent.putExtra("urlregistrasi", model.getUrlregistrasi());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_registrasi, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaRegistrasi, txtTglLahirRegistrasi, txtUrlRegistrasi;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaRegistrasi = itemView.findViewById(R.id.txtNamaRegistrasi);
            txtTglLahirRegistrasi = itemView.findViewById(R.id.txtTglLahirRegistrasi);
            txtUrlRegistrasi = itemView.findViewById(R.id.txtUrlRegistrasi);
        }
    }
}
