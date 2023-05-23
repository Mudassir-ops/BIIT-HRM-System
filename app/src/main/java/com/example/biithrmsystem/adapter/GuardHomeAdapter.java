package com.example.biithrmsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biithrmsystem.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class GuardHomeAdapter extends RecyclerView.Adapter<GuardHomeAdapter.ViewHolder> {
    public List<Employees> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;

    public GuardHomeAdapter(Context context, List<Employees> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // method for filtering our recyclerview items.
    public void filterList(ArrayList<Employees> filterlist) {
        mData = filterlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.guard_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mData.get(position).getTitle() != null) {
            holder.title.setText(mData.get(position).getTitle());
        }
        if (mData.get(position).getTitle() != null) {
            holder.image.setImageResource(mData.get(position).getSrcImg());
        }
        if (mData.get(position).isCheckedIn) {
            holder.cardView.setBackground(ContextCompat.getDrawable(context, R.drawable.guard_check_in_bg));
        } else {
            holder.cardView.setBackground(ContextCompat.getDrawable(context, R.drawable.gaurd_bg));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    String getItem(int id) {
        return mData.get(id).getTitle();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public void updateItem(int pos) {
        mData.get(pos).isCheckedIn = !mData.get(pos).isCheckedIn;
        notifyItemChanged(pos);
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
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}