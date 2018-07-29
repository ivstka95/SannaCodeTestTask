package com.example.ivstk.sannacodetesttask.model.repo;

import android.util.Log;

import com.example.ivstk.sannacodetesttask.ForecastApplication;
import com.example.ivstk.sannacodetesttask.model.db.ForecastDao;
import com.example.ivstk.sannacodetesttask.model.entity.Forecast;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public class ForecastRepoImpl implements ForecastRepo {
    private static final String TAG = "ForecastRepoImpl";
    @Inject
    ForecastDao forecastDao;

    public ForecastRepoImpl() {
        ForecastApplication.getAppComponent().inject(this);
        Log.e(TAG, "ForecastRepoImpl: constructor");
    }

    @Override
    public Observable<Object> fetchForecast(Object params) {
        return null;
    }

    @Override
    public Maybe<Forecast> getForecastFromCache(Object params) {
        return forecastDao.getForecast();
    }
}
