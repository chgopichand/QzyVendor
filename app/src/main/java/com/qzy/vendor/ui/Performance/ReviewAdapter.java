package com.qzy.vendor.ui.Performance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public ReviewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rating_item,parent,false);
        ReviewItemHolder reviewItemHolder = new ReviewItemHolder(view);
        return reviewItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ReviewItemHolder){
            ReviewItemHolder reviewItemHolder = (ReviewItemHolder)holder;
            reviewItemHolder.ratingNo.setText(Integer.toString(position+1));
            reviewItemHolder.progressBar.setProgress(position*20);
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class ReviewItemHolder extends RecyclerView.ViewHolder {
        TextView ratingNo;
        ProgressBar progressBar;

        public ReviewItemHolder(@NonNull View itemView) {
            super(itemView);
            ratingNo = itemView.findViewById(R.id.rating_num);
            progressBar = itemView.findViewById(R.id.rating_progress);
        }
    }
}
