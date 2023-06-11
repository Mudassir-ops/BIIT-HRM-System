package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.JobResponse;

import java.util.ArrayList;
import java.util.List;

public class AllJobsAdapter extends RecyclerView.Adapter<AllJobsAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<JobResponse> mData;
    private ItemClickListener mClickListener;

    public AllJobsAdapter(Context context, List<JobResponse> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<JobResponse> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.jobs_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("mudususuu", "onBindViewHolder: " + mData.get(position).title);
        if (mData.get(position).title != null) {
            holder.title.setText(mData.get(position).title);
        }
        if (mData.get(position).salary != null) {
            holder.salary.setText(mData.get(position).salary);
        }
        if (mData.get(position).location != null) {
            holder.location.setText(mData.get(position).location);
        }
        holder.noOfVaccancyies.setText("" + mData.get(position).noofvacancie);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return mData.get(id).title;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView salary;
        TextView location;
        TextView noOfVaccancyies;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name_value);
            salary = itemView.findViewById(R.id.tv_number_value);
            location = itemView.findViewById(R.id.tv_cnic_value);
            noOfVaccancyies = itemView.findViewById(R.id.tv_vacancyies);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).jid);
        }
    }
}