package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.Job;

import java.util.List;

public class AllJobsAdapter extends RecyclerView.Adapter<AllJobsAdapter.ViewHolder> {

    private final List<Job> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AllJobsAdapter(Context context, List<Job> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.jobs_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Job job = mData.get(position);
        if (job.getTitle() != null) {
            holder.title.setText(job.getTitle());
        }
        if (job.getSalary() != null) {
            holder.salary.setText(job.getSalary());
        }
        if (job.getLocation() != null) {
            holder.location.setText(job.getLocation());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView salary;
        TextView location;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name_value);
            salary = itemView.findViewById(R.id.tv_number_value);
            location = itemView.findViewById(R.id.tv_cnic_value);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }


    String getItem(int id) {
        return mData.get(id).getTitle();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}