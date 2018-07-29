package com.example.ivstk.sannacodetesttask.presentation.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.ivstk.sannacodetesttask.ForecastApplication;
import com.example.ivstk.sannacodetesttask.model.repo.ForecastRepo;
import com.example.ivstk.sannacodetesttask.presentation.ForecastContract;

import javax.inject.Inject;

public class ForecastPresenter extends BasePresenter<ForecastContract.ForecastView> {

    private static final String TAG = "ForecastPresenterImpl";
    @Inject
    ForecastRepo forecastRepo;

    public ForecastPresenter() {
        ForecastApplication.getAppComponent().inject(this);

        Log.e(TAG, "ForecastPresenterImpl: constructor");
    }
}
