package com.qzy.vendor.ui.Performance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qzy.vendor.R;
import com.qzy.vendor.qzyCustom.QzyTextView;

public class PerformanceFragment extends Fragment {
    RecyclerView revenueRecycler,ratingDetailRecycler;
    QzyTextView ratingTextView;
    RatingBar ratingBar;
    Fragment fragment;
    String rating;
    Button reviewDetails;


    private PerformanceViewModel performanceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragment = this;
        performanceViewModel =
                ViewModelProviders.of(this).get(PerformanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_performance, container, false);
        revenueRecycler = root.findViewById(R.id.revenue_recycler);
        ratingDetailRecycler = root.findViewById(R.id.rating_detail_recycler);
        ratingTextView = root.findViewById(R.id.rating);
        ratingBar = root.findViewById(R.id.rating_bar);
        reviewDetails = root.findViewById(R.id.see_reviews);
        rating = "4.3";

        reviewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(),"Reviews Coming Soon",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        setRecyclers();
        setRating(rating);
        return root;
    }

    private void setRating(String rating) {
        float rat = Float.parseFloat(rating);
        ratingBar.setRating(rat);
        ratingTextView.setText("Avg Rating "+rating);
    }

    private void setRecyclers() {
        try {
            revenueRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
            RevenueAdapter revenueAdapter = new RevenueAdapter(getContext());
            revenueRecycler.setAdapter(revenueAdapter);
        }catch (Exception e){
            System.out.println("Error while setting revenue Adapter");
            e.printStackTrace();
            throw e;
        }
        try {
            ratingDetailRecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true));
            ReviewAdapter reviewAdapter = new ReviewAdapter(getContext());
            ratingDetailRecycler.setAdapter(reviewAdapter);
        }catch (Exception e){
            System.out.println("Error while setting review Adapter");
            e.printStackTrace();
            throw e;
        }

    }
}