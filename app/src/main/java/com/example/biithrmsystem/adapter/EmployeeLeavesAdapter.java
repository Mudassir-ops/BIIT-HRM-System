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
import com.example.biithrmsystem.api.datamodel.LeaveModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLeavesAdapter extends RecyclerView.Adapter<EmployeeLeavesAdapter.ViewHolder> {

    private List<LeaveModel> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public EmployeeLeavesAdapter(Context context, List<LeaveModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<LeaveModel> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.employee_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("mudususuu", "onBindViewHolder: " + mData.get(position).status);
        if (mData.get(position).status != null) {
            holder.title.setText(mData.get(position).status);
        }
        if (mData.get(position).startdate != null) {
            holder.salary.setText(mData.get(position).startdate);
        }
        if (mData.get(position).enddate != null) {
            holder.location.setText(mData.get(position).enddate);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    int getItem(int id) {
        return mData.get(id).leaveappid;
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

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name_value);
            salary = itemView.findViewById(R.id.tv_number_value);
            location = itemView.findViewById(R.id.tv_cnic_value);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).leaveappid);
        }
    }
}