package com.qzy.vendor.ui.ViewHolders;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class OrderLineViewHolder extends RecyclerView.ViewHolder {
    public TextView itemName,itemQuantity;
    public RelativeLayout layout;

    public OrderLineViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.order_itemname);
        itemQuantity = itemView.findViewById(R.id.order_itemquantity);
        layout = itemView.findViewById(R.id.order_itemline);
    }
}
