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
import com.example.biithrmsystem.api.datamodel.AttendanceRecord;

import java.util.ArrayList;
import java.util.List;

public class AttendenceReportAdapter extends RecyclerView.Adapter<AttendenceReportAdapter.ViewHolder> {

    private List<AttendanceRecord> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AttendenceReportAdapter(Context context, List<AttendanceRecord> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<AttendanceRecord> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.attendence_report_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("mudususuu", "onBindViewHolder: " + mData.get(position).date);
        if (mData.get(position).date != null) {
            holder.title.setText(mData.get(position).date);
        }
        if (mData.get(position).records.get(0).status != null) {
            holder.salary.setText(mData.get(position).records.get(0).status);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
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

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name_value);
            salary = itemView.findViewById(R.id.tv_number_value);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, Integer.parseInt(mData.get(getAdapterPosition()).date));
        }
    }
}