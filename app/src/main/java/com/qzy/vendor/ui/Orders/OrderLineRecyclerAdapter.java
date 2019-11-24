package com.qzy.vendor.ui.Orders;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.ui.ViewHolders.OrderLineViewHolder;

public class OrderLineRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;

    public OrderLineRecyclerAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.order_itemline,parent,false);
        OrderLineViewHolder orderLineViewHolder = new OrderLineViewHolder(view);
        return orderLineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  OrderLineViewHolder){
            OrderLineViewHolder orderLineViewHolder = (OrderLineViewHolder) holder;
            if(position == 0){
                orderLineViewHolder.itemName.setText("Steamed Chicken Momos");
            }else if(position == 1){
                orderLineViewHolder.itemName.setText("Fried Chicken Momos in sauces");
            }else if(position == 2){
                orderLineViewHolder.itemName.setText("Fried vegetarian Momos in sauces");
            }
            orderLineViewHolder.itemQuantity.setText("x"+Integer.toString(position+1));
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
