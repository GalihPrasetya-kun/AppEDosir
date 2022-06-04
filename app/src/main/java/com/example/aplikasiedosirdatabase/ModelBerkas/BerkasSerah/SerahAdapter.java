package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasSerah;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfSerahActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class SerahAdapter extends FirebaseRecyclerAdapter<SerahListModel, SerahAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SerahAdapter(@NonNull FirebaseRecyclerOptions<SerahListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull SerahListModel model) {
        holder.txtNamaSerah.setText(String.valueOf(model.getNamaserah()));
        holder.txtTglLahirSerah.setText(String.valueOf(model.getTgllahirserah()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfSerahActivity.class);
                intent.putExtra("namaserah", model.getNamaserah());
                intent.putExtra("tgllahirserah", model.getTgllahirserah());
                intent.putExtra("urlserah", model.getUrlserah());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_serah, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaSerah, txtTglLahirSerah, txtUrlSerah;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaSerah = itemView.findViewById(R.id.txtNamaSerah);
            txtTglLahirSerah = itemView.findViewById(R.id.txtTglLahirSerah);
            txtUrlSerah = itemView.findViewById(R.id.txtUrlSerah);
        }
    }
}
