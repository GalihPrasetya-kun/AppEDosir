package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKontrak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKontrakActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KontrakAdapter extends FirebaseRecyclerAdapter<KontrakListModel, KontrakAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KontrakAdapter(@NonNull FirebaseRecyclerOptions<KontrakListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KontrakListModel model) {
        holder.txtNamaKontrak.setText(String.valueOf(model.getNamakontrak()));
        holder.txtTglLahirKontrak.setText(String.valueOf(model.getTgllahirkontrak()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKontrakActivity.class);
                intent.putExtra("namakontrak", model.getNamakontrak());
                intent.putExtra("tgllahirkontrak", model.getTgllahirkontrak());
                intent.putExtra("urlkontrak", model.getUrlkontrak());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kontrak, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKontrak, txtTglLahirKontrak, txtUrlKontrak;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKontrak = itemView.findViewById(R.id.txtNamaKontrak);
            txtTglLahirKontrak = itemView.findViewById(R.id.txtTglLahirKontrak);
            txtUrlKontrak = itemView.findViewById(R.id.txtUrlKontrak);
        }
    }
}
