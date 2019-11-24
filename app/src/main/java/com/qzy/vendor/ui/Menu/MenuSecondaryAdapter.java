package com.qzy.vendor.ui.Menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.ui.Models.MenuItemModel;
import com.qzy.vendor.ui.ViewHolders.MenuSecondaryHolder;

import java.util.ArrayList;

class MenuSecondaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity mActivity;
    ArrayList<MenuItemModel> menuItemList;

    public MenuSecondaryAdapter(Activity mActivity, ArrayList<MenuItemModel> menuItemList) {
        this.mActivity=mActivity;
        this.menuItemList=menuItemList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.menu_item_layout,parent,false);
        MenuSecondaryHolder secondaryHolder = new MenuSecondaryHolder(view);
        return secondaryHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final MenuItemModel menuModel = menuItemList.get(position);
        if(holder instanceof MenuSecondaryHolder){
            MenuSecondaryHolder menuSecondaryHolder = (MenuSecondaryHolder) holder;
            menuSecondaryHolder.itemName.setText(menuModel.getName());
            menuSecondaryHolder.itemPrice.setText("Rs. "+menuModel.getPrice());
            menuSecondaryHolder.itemStatus.setText(menuModel.getInStock());
        }
    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }
}