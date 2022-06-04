package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIntake;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfIntakeActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class IntakeAdapter extends FirebaseRecyclerAdapter<IntakeListModel, IntakeAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public IntakeAdapter(@NonNull FirebaseRecyclerOptions<IntakeListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull IntakeListModel model) {
        holder.txtNamaIntake.setText(String.valueOf(model.getNamaintake()));
        holder.txtTglLahirIntake.setText(String.valueOf(model.getTgllahirintake()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfIntakeActivity.class);
                intent.putExtra("namaintake", model.getNamaintake());
                intent.putExtra("tgllahirintake", model.getTgllahirintake());
                intent.putExtra("urlintake", model.getUrlintake());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_intake, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaIntake, txtTglLahirIntake, txtUrlIntake;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaIntake = itemView.findViewById(R.id.txtNamaIntake);
            txtTglLahirIntake = itemView.findViewById(R.id.txtTglLahirIntake);
            txtUrlIntake = itemView.findViewById(R.id.txtUrlIntake);
        }
    }
}
