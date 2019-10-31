package com.qzy.vendor.ui.Performance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.qzy.vendor.R;

public class PerformanceFragment extends Fragment {

    private PerformanceViewModel performanceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        performanceViewModel =
                ViewModelProviders.of(this).get(PerformanceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_performance, container, false);
        return root;
    }
}