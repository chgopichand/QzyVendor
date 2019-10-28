package com.qzy.vendor.ui.Orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;

public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    public View root;
    public RecyclerView mainRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel =
                ViewModelProviders.of(this).get(OrdersViewModel.class);
        root = inflater.inflate(R.layout.fragment_orders, container, false);
        mainRecycler = root.findViewById(R.id.main_recycler);

        setRecycler();
        return root;
    }

    void setRecycler(){
        mainRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        MainRecyclerAdapter adapter = new MainRecyclerAdapter(getActivity());
        mainRecycler.setAdapter(adapter);
    }
}