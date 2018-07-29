package com.example.ivstk.sannacodetesttask.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ivstk.sannacodetesttask.R;


public class HoursFragment extends Fragment {


    public HoursFragment() {
        // Required empty public constructor
    }


    public static HoursFragment newInstance() {
        HoursFragment fragment = new HoursFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hours, container, false);
    }

}
