package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetTidakMampu;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKettidakmampuActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KetTidakMampuAdapter extends FirebaseRecyclerAdapter<KetTidakMampuListModel, KetTidakMampuAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KetTidakMampuAdapter(@NonNull FirebaseRecyclerOptions<KetTidakMampuListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KetTidakMampuListModel model) {
        holder.txtNamaKettidakmampu.setText(String.valueOf(model.getNamakettidakmampu()));
        holder.txtTglLahirKettidakmampu.setText(String.valueOf(model.getTgllahirkettidakmampu()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKettidakmampuActivity.class);
                intent.putExtra("namakettidakmampu", model.getNamakettidakmampu());
                intent.putExtra("tgllahirkettidakmampu", model.getTgllahirkettidakmampu());
                intent.putExtra("urlkettidakmampu", model.getUrlkettidakmampu());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kettidakmampu, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKettidakmampu, txtTglLahirKettidakmampu, txtUrlKettidakmampu;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKettidakmampu = itemView.findViewById(R.id.txtNamaKettidakmampu);
            txtTglLahirKettidakmampu = itemView.findViewById(R.id.txtTglLahirKettidakmampu);
            txtUrlKettidakmampu = itemView.findViewById(R.id.txtUrlKettidakmampu);
        }
    }
}
