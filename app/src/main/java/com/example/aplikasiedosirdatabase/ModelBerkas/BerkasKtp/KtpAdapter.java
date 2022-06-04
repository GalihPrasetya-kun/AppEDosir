package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKtp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfKtpActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class KtpAdapter extends FirebaseRecyclerAdapter<KtpListModel, KtpAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public KtpAdapter(@NonNull FirebaseRecyclerOptions<KtpListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull KtpListModel model) {
        holder.txtNamaKtp.setText(String.valueOf(model.getNamaktp()));
        holder.txtTglLahirKtp.setText(String.valueOf(model.getTgllahirktp()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfKtpActivity.class);
                intent.putExtra("namaktp", model.getNamaktp());
                intent.putExtra("tgllahirktp", model.getTgllahirktp());
                intent.putExtra("urlktp", model.getUrlktp());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_ktp, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaKtp, txtTglLahirKtp, txtUrlKtp;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaKtp = itemView.findViewById(R.id.txtNamaKtp);
            txtTglLahirKtp = itemView.findViewById(R.id.txtTglLahirKtp);
            txtUrlKtp = itemView.findViewById(R.id.txtUrlKtp);
        }
    }
}
