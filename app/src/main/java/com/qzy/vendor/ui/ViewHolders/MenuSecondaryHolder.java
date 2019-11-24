package com.qzy.vendor.ui.ViewHolders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.qzyCustom.QzyTextView;

public class MenuSecondaryHolder  extends RecyclerView.ViewHolder{

    public QzyTextView itemName,itemPrice,itemStatus;
    public SwitchCompat stockSwitch;

    public MenuSecondaryHolder(@NonNull View itemView) {
        super(itemView);
        itemName =itemView.findViewById(R.id.itemName);
        itemPrice =itemView.findViewById(R.id.itemPrice);
        stockSwitch = itemView.findViewById(R.id.stock_switch);
        itemStatus = itemView.findViewById(R.id.stock_status);
    }
}
