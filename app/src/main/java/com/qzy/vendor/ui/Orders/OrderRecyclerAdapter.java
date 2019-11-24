package com.qzy.vendor.ui.Orders;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.ui.ViewHolders.OrderViewHolder;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Activity activity;
    RecyclerView recyclerView;
    String orderType;

    public OrderRecyclerAdapter(Activity activity) {
        this.activity = activity;
    }
    public OrderRecyclerAdapter(Activity activity,String orderType) {
        this.activity = activity;
        this.orderType = orderType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_order_tostart,parent,false);
        OrderViewHolder holder = new OrderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        OrderViewHolder order = (OrderViewHolder) holder;
        order.getOrderNo().setText("#"+position);
        recyclerView = order.getOrderLineItems();
        setLayoutBackground(order);
        setOrderLineAdapter();

        final ImageView arrowIcon = order.getArrowIcon();
        final RelativeLayout orderDetails = order.getOrderDetails();

        arrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrowIcon.getRotation() == 180) {
                    arrowIcon.setRotation(0);
                    orderDetails.setVisibility(View.VISIBLE);
                }else {
                    arrowIcon.setRotation(180);
                    orderDetails.setVisibility(View.GONE);
                }
            }
        });

    }

    private void setLayoutBackground(OrderViewHolder order) {
        RelativeLayout orderStatus = order.getOrderStatus();
        if(orderType == "tostart"){
            orderStatus.setBackground(activity.getDrawable(R.drawable.order_tostart_background));
            order.getStatusText().setText("To start");
        }
        else if(orderType == "pending") {
            orderStatus.setBackground(activity.getDrawable(R.drawable.order_pending_background));
            order.getStatusText().setText("Pending");
        }else{
            orderStatus.setBackground(activity.getDrawable(R.drawable.order_completed_background));
            order.getStatusText().setText("Completed");
        }
    }

    private void setOrderLineAdapter(){
        recyclerView.setLayoutManager(new LinearLayoutManager(activity,RecyclerView.VERTICAL,false));
        OrderLineRecyclerAdapter lineAdapter = new OrderLineRecyclerAdapter(activity);
        recyclerView.setAdapter(lineAdapter);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
