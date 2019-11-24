package com.qzy.vendor.ui.Menu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.ui.Models.MenuModel;
import com.qzy.vendor.ui.ViewHolders.MenuPrimaryHolder;


import java.util.ArrayList;

public class MenuPrimaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Activity mActivity;
    ArrayList<MenuModel> menuModels;
    String pos;

    public MenuPrimaryAdapter(Activity activity, ArrayList<MenuModel> menuModels) {
        this.mActivity=activity;
        this.menuModels=menuModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == -1) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.menu_layout, parent, false);
            MenuPrimaryHolder holder = new MenuPrimaryHolder(view);
            return holder;
        }else {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_empty, parent, false);
            return new ItemHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MenuPrimaryHolder){
            MenuModel menuModel = menuModels.get(position);
            final MenuPrimaryHolder primaryHolder = (MenuPrimaryHolder) holder;
            primaryHolder.categoryName.setText(menuModel.getName());
            LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity,RecyclerView.VERTICAL,false);
            MenuSecondaryAdapter secondaryAdapter = new MenuSecondaryAdapter(mActivity,menuModel.getMenuItemList());

            primaryHolder.categoryRecylerView.setAdapter(secondaryAdapter);
            primaryHolder.categoryRecylerView.setLayoutManager(layoutManager);
            primaryHolder.categoryMinimizeIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(primaryHolder.categoryRecylerView.getVisibility() == View.VISIBLE){
                        primaryHolder.categoryMinimizeIcon.setImageDrawable(mActivity.getDrawable(R.drawable.ic_down_icon));
                        primaryHolder.categoryRecylerView.setVisibility(View.GONE);
                    }
                    else{
                        primaryHolder.categoryMinimizeIcon.setImageDrawable(mActivity.getDrawable(R.drawable.ic_up_icon));
                        primaryHolder.categoryRecylerView.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return menuModels.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position<menuModels.size()){
            return -1;
        }else{
            return -2;
        }
    }

    private class ItemHolder extends RecyclerView.ViewHolder {
        public ItemHolder(View view) {
            super(view);
        }
    }
}
