package com.qzy.vendor.ui.Performance;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class RevenueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    Context context;

    public RevenueAdapter(Context context){
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cumulative_revenue_item,parent,false);
        RevenueItemHolder revenueItemHolder = new RevenueItemHolder(view);
        return revenueItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RevenueItemHolder) {
            final  RevenueItemHolder revenueItemHolder = (RevenueItemHolder) holder;
            if (position == 0) {
                revenueItemHolder.subTitle.setText("(Daily)");
                revenueItemHolder.revenueTotal.setText("Rs. 1400");
                revenueItemHolder.revenueDetails.setOnClickListener(this);
            } else if (position == 1) {
                revenueItemHolder.subTitle.setText("(Weekly)");
                revenueItemHolder.revenueTotal.setText("Rs. 11700");
                revenueItemHolder.revenueDetails.setOnClickListener(this);

            } else if (position == 2) {
                revenueItemHolder.subTitle.setText("(Monthly)");
                revenueItemHolder.revenueTotal.setText("Rs. 37000");
                revenueItemHolder.revenueDetails.setOnClickListener(this);

            }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onClick(View v) {
        Toast toast = Toast.makeText(context,"Coming Soon!",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    private class RevenueItemHolder extends RecyclerView.ViewHolder {
        TextView subTitle,revenueTotal,revenueDetails;

        public RevenueItemHolder(View view){
            super(view);
            subTitle = view.findViewById(R.id.revenue_card_subtitle);
            revenueTotal = view.findViewById(R.id.revenue_card_total);
            revenueDetails = view.findViewById(R.id.revenue_card_details);
        }
    }
}
