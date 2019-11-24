package com.qzy.vendor.ui.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class MenuPrimaryHolder extends RecyclerView.ViewHolder{

    public TextView categoryName;
    public ImageView categoryMinimizeIcon;
    public RecyclerView categoryRecylerView;

    public MenuPrimaryHolder(@NonNull View itemView) {
        super(itemView);
        categoryName = itemView.findViewById(R.id.categoryName);
        categoryRecylerView= itemView.findViewById(R.id.categoryRecylerView);
        categoryMinimizeIcon= itemView.findViewById(R.id.minimizeIcon);
    }
}

