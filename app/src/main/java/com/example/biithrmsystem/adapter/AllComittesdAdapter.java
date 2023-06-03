package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.example.biithrmsystem.api.datamodel.ComitteeBaseResponseModel;

import java.util.ArrayList;
import java.util.List;

public class AllComittesdAdapter extends RecyclerView.Adapter<AllComittesdAdapter.ViewHolder> {

    private List<ComitteeBaseResponseModel> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public AllComittesdAdapter(Context context, List<ComitteeBaseResponseModel> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<ComitteeBaseResponseModel> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.comitte_home_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.e("mudususuu", "onBindViewHolder: " + mData.get(position).committeeTitle);
        if (mData.get(position).committeeTitle != null) {
            holder.tv_value.setText(mData.get(position).committeeTitle);
        }
        holder.iv_delete.setOnClickListener(v -> {
            this.mClickListener.onDeleteClick(v, mData.get(position).committeeId);
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return mData.get(id).committeeTitle;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
        void onDeleteClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView tv_value;
        AppCompatImageView iv_delete;


        ViewHolder(View itemView) {
            super(itemView);
            tv_value = itemView.findViewById(R.id.tv_value);
            iv_delete = itemView.findViewById(R.id.iv_delete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, mData.get(getAdapterPosition()).committeeId);
            assert mClickListener != null;
            mClickListener.onDeleteClick(view, mData.get(getAdapterPosition()).committeeId);
        }
    }
}