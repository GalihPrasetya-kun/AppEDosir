package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasBpjs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfBpjsActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class BpjsAdapter extends FirebaseRecyclerAdapter<BpjsListModel, BpjsAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BpjsAdapter(@NonNull FirebaseRecyclerOptions<BpjsListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull BpjsListModel model) {
        holder.txtNamaBpjs.setText(String.valueOf(model.getNamabpjs()));
        holder.txtTglLahirBpjs.setText(String.valueOf(model.getTgllahirbpjs()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfBpjsActivity.class);
                intent.putExtra("namabpjs", model.getNamabpjs());
                intent.putExtra("tgllahirbpjs", model.getTgllahirbpjs());
                intent.putExtra("urlbpjs", model.getUrlbpjs());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_bpjs, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaBpjs, txtTglLahirBpjs, txtUrlBpjs;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaBpjs = itemView.findViewById(R.id.txtNamaBpjs);
            txtTglLahirBpjs = itemView.findViewById(R.id.txtTglLahirBpjs);
            txtUrlBpjs = itemView.findViewById(R.id.txtUrlBpjs);
        }
    }
}
