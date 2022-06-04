package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKematian;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk.KkAdapter;
import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKematianActivity;
import com.example.aplikasiedosirdatabase.ViewPdfKkActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KematianAdapter extends FirebaseRecyclerAdapter<KematianListModel, KematianAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KematianAdapter(@NonNull FirebaseRecyclerOptions<KematianListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KematianListModel model) {
        holder.txtNamaKematian.setText(String.valueOf(model.getNamakematian()));
        holder.txtTglLahirKematian.setText(String.valueOf(model.getTgllahirkematian()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKematianActivity.class);
                intent.putExtra("namakematian", model.getNamakematian());
                intent.putExtra("tgllahirkematian", model.getTgllahirkematian());
                intent.putExtra("urlkematian", model.getUrlkematian());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kematian, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKematian, txtTglLahirKematian, txtUrlKematian;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKematian = itemView.findViewById(R.id.txtNamaKematian);
            txtTglLahirKematian = itemView.findViewById(R.id.txtTglLahirKematian);
            txtUrlKematian = itemView.findViewById(R.id.txtUrlKematian);
        }
    }
}
