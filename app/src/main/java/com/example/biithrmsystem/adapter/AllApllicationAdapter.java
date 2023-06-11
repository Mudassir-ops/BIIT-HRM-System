package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.JobApplciantResponse;

import java.util.ArrayList;
import java.util.List;

public class AllApllicationAdapter extends RecyclerView.Adapter<AllApllicationAdapter.ViewHolder> {


    private final LayoutInflater mInflater;
    private List<JobApplciantResponse> mData;
    private ItemClickListener mClickListener;

    public AllApllicationAdapter(Context context, List<JobApplciantResponse> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<JobApplciantResponse> filterlist) {
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

        Log.e("mudassir", "onBindViewHolder: " + mData.get(position).name);
        if (mData.get(position).name != null) {
            holder.title.setText(mData.get(position).name);
        } else {
            holder.title.setText("NIll");
        }

        holder.tvNumber.setText("Status:");
        if (mData.get(position).status != null) {
            holder.salary.setText(mData.get(position).name);
        } else {
            holder.salary.setText("Pending");
        }

        holder.location.setVisibility(View.GONE);
        holder.loactionName.setVisibility(View.GONE);
        holder.noOfVaccancyies.setVisibility(View.GONE);
        holder.iv_next.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return mData.get(id).name;
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
        TextView loactionName;
        TextView tvNumber;

        ImageView iv_next;


        TextView noOfVaccancyies;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name_value);
            salary = itemView.findViewById(R.id.tv_number_value);
            location = itemView.findViewById(R.id.tv_cnic_value);
            tvNumber = itemView.findViewById(R.id.tv_number);
            loactionName = itemView.findViewById(R.id.tv_cnic);
            noOfVaccancyies = itemView.findViewById(R.id.tv_vacancyies);
            iv_next = itemView.findViewById(R.id.iv_next);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).jid);
        }
    }
}