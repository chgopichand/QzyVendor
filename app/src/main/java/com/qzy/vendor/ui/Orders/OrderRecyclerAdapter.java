package com.qzy.vendor.ui.Orders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;

    public OrderRecyclerAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_order,parent,false);
        OrderViewHolder holder = new OrderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OrderViewHolder order = (OrderViewHolder) holder;
        order.orderNo.setText("#"+position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView statusText;
        TextView orderNo;
        TextView orderContents;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            statusText = itemView.findViewById(R.id.status_text);
            orderNo = itemView.findViewById(R.id.order_no);
            orderContents = itemView.findViewById(R.id.order_contents);

        }
    }
}
