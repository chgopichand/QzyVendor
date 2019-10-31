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
        View view = LayoutInflater.from(activity).inflate(R.layout.orders_main_recyler, parent, false);
        return new OrdersMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OrdersMainViewHolder orderMainViewHolder = (OrdersMainViewHolder) holder;
        if(position == 0 ){
            orderMainViewHolder.textView.setText("Order Requests");
        }else if(position == 1){
            orderMainViewHolder.textView.setText("Accepted Orders");
        }else if(position == 2){
            orderMainViewHolder.textView.setText("Previous Orders");
        }
        orderRecycler = orderMainViewHolder.recyclerView;
        setOrderAdapter();
    }

    private void setOrderAdapter() {
        orderRecycler.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.VERTICAL,false));
        OrderRecyclerAdapter orderRecyclerAdapter = new OrderRecyclerAdapter(activity);
        orderRecycler.setAdapter(orderRecyclerAdapter);
    }

    @Override
    public int getItemCount() {
        return 3;
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


}
