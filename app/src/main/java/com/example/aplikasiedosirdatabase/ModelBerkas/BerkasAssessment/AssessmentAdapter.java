package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasAssessment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiedosirdatabase.R;
import com.example.aplikasiedosirdatabase.ViewPdfAssessmentActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AssessmentAdapter extends FirebaseRecyclerAdapter<AssessmentListModel, AssessmentAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AssessmentAdapter(@NonNull FirebaseRecyclerOptions<AssessmentListModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull AssessmentListModel model) {
        holder.txtNamaAssessment.setText(String.valueOf(model.getNamaassessment()));
        holder.txtTglLahirAssessment.setText(String.valueOf(model.getTgllahirassessment()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ViewPdfAssessmentActivity.class);
                intent.putExtra("namaassessment", model.getNamaassessment());
                intent.putExtra("tgllahirassessment", model.getTgllahirassessment());
                intent.putExtra("urlassessment", model.getUrlassessment());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_assessment, parent, false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView txtNamaAssessment, txtTglLahirAssessment, txtUrlAssessment;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            txtNamaAssessment = itemView.findViewById(R.id.txtNamaAssessment);
            txtTglLahirAssessment = itemView.findViewById(R.id.txtTglLahirAssessment);
            txtUrlAssessment = itemView.findViewById(R.id.txtUrlAssessment);
        }
    }
}
