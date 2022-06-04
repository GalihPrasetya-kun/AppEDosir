package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetSehat;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKetsehatActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KetSehatAdapter extends FirebaseRecyclerAdapter<KetSehatListModel, KetSehatAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KetSehatAdapter(@NonNull FirebaseRecyclerOptions<KetSehatListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KetSehatListModel model) {
        holder.txtNamaKetsehat.setText(String.valueOf(model.getNamaketsehat()));
        holder.txtTglLahirKetsehat.setText(String.valueOf(model.getTgllahirketsehat()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKetsehatActivity.class);
                intent.putExtra("namaketsehat", model.getNamaketsehat());
                intent.putExtra("tgllahirketsehat", model.getTgllahirketsehat());
                intent.putExtra("urlketsehat", model.getUrlketsehat());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_ketsehat, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKetsehat, txtTglLahirKetsehat, txtUrlKetsehat;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKetsehat = itemView.findViewById(R.id.txtNamaKetsehat);
            txtTglLahirKetsehat = itemView.findViewById(R.id.txtTglLahirKetsehat);
            txtUrlKetsehat = itemView.findViewById(R.id.txtUrlKetsehat);
        }
    }
}
