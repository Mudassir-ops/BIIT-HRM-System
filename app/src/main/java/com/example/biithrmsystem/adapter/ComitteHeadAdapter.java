package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.UserRoleResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class ComitteHeadAdapter extends RecyclerView.Adapter<ComitteHeadAdapter.ViewHolder> {
    private final LayoutInflater mInflater;
    public List<UserRoleResponse> mData;
    Context context;
    private ItemClickListener mClickListener;

    public ComitteHeadAdapter(Context context, List<UserRoleResponse> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<UserRoleResponse> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.comittie_head_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mData.get(position).fname != null) {
            holder.title.setText(mData.get(position).fname);
        }

        if (mData.get(position).image != null) {

            //holder.title.setText(mData.get(position).image);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return mData.get(id).fname;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ShapeableImageView image;
        ConstraintLayout cardView;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name);
            image = itemView.findViewById(R.id.iv_applicant_dp);
            cardView = itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).uid);
        }
    }
}