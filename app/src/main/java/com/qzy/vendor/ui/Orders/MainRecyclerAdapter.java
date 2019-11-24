package com.qzy.vendor.ui.Orders;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    RecyclerView orderRecycler;


    public MainRecyclerAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == -1){
            View view = LayoutInflater.from(activity).inflate(R.layout.orders_main_recyler, parent, false);
            return new OrdersMainViewHolder(view);
        }else {
            View view = LayoutInflater.from(activity).inflate(R.layout.layout_empty, parent, false);
            return new ItemHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String orderType = null;
        if(holder instanceof OrdersMainViewHolder) {
            OrdersMainViewHolder orderMainViewHolder = (OrdersMainViewHolder) holder;
            if (position == 0) {
                orderMainViewHolder.textView.setText("Order Requests");
                orderType = "tostart";
            } else if (position == 1) {
                orderMainViewHolder.textView.setText("Pending Orders");
                orderType = "pending";
            } else if (position == 2) {
                orderMainViewHolder.textView.setText("Previous Orders");
                orderType = "completed";
            }
            orderRecycler = orderMainViewHolder.recyclerView;
            setOrderAdapter(orderType);
        }
    }

    private void setOrderAdapter(String orderType) {
        orderRecycler.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.VERTICAL,false));
        OrderRecyclerAdapter orderRecyclerAdapter = new OrderRecyclerAdapter(activity,orderType);
        orderRecycler.setAdapter(orderRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position<3){
            return -1;
        }else{
            return -2;
        }
    }

    private class OrdersMainViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        public OrdersMainViewHolder(View view) {
            super(view);
            textView=view.findViewById(R.id.main_recycler_text);
            recyclerView = view.findViewById(R.id.main_recycler_item);
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(View view) {
            super(view);
        }
    }

}
