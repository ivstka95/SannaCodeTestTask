package com.example.ivstk.sannacodetesttask.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ivstk.sannacodetesttask.R;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.ForecastDataSet;
import com.example.ivstk.sannacodetesttask.ui.activities.ForecastActivity;
import com.example.ivstk.sannacodetesttask.ui.adapters.ForecastAdapter;
import com.example.ivstk.sannacodetesttask.utils.system.DateUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ForecastFragment extends Fragment {
    private static final String ARG_POSITION = "ARG_POSITION";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private int index;
    private ForecastAdapter adapter;


    public ForecastFragment() {
        // Required empty public constructor
    }

    public static ForecastFragment newInstance(int i) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            index = getArguments().getInt(ARG_POSITION);
        if (index > 0)
            adapter = new ForecastAdapter(DateUtils.DAY_FORMAT);
        else adapter = new ForecastAdapter(DateUtils.TIME_FORMAT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        ((ForecastActivity) getActivity()).setForecastFragment(this, index);
        if (index > 0)
            ((ForecastActivity) getActivity()).onFragmentsCreated();
    }

    public void showData(ForecastDataSet dataSet) {
        adapter.setItems(dataSet.getData());
    }
}
