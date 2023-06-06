package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.LeaveModel;

import java.util.ArrayList;
import java.util.List;

public class AllLeaveApplicationsAdapter extends RecyclerView.Adapter<AllLeaveApplicationsAdapter.ViewHolder> {

    private List<LeaveModel> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AllLeaveApplicationsAdapter(Context context, List<LeaveModel> data) {
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
        View view = mInflater.inflate(R.layout.leave_applications_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("mudususuu", "onBindViewHolder: " + mData.get(position).leavetype);


        if (mData.get(position).applydate != null) {
            holder.tv_name_value.setText("" + mData.get(position).leaveappid);
        }

        if (mData.get(position).leavetype != null) {
            holder.leave.setText(mData.get(position).leavetype);
        }

        if (mData.get(position).enddate != null) {
            holder.applyDate.setText(mData.get(position).enddate);
        } else {
            holder.applyDate.setText("NULL");
        }

        if (mData.get(position).status != null) {
            holder.status.setText(mData.get(position).status);
        }

        holder.bt_detail.setOnClickListener(v -> {
            this.mClickListener.onItemClick(v, mData.get(position).leaveappid);
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return String.valueOf(mData.get(id).leaveappid);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int id);

        void onDeleteClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView tv_name_value, leave, applyDate, status;

        Button bt_detail;


        ViewHolder(View itemView) {
            super(itemView);
            tv_name_value = itemView.findViewById(R.id.tv_name_value);
            leave = itemView.findViewById(R.id.tv_number_value);
            applyDate = itemView.findViewById(R.id.tv_cnic_value);
            status = itemView.findViewById(R.id.tv_apply_value_value);
            bt_detail = itemView.findViewById(R.id.bt_detail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).leaveappid);
        }
    }
}