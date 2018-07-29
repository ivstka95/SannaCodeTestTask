package com.example.ivstk.sannacodetesttask.model.repo;

import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;

import com.example.ivstk.sannacodetesttask.ForecastApplication;
import com.example.ivstk.sannacodetesttask.model.api.forecast.DarkSkyService;
import com.example.ivstk.sannacodetesttask.model.db.ForecastDao;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

import org.joda.time.DateTime;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ForecastRepoImpl implements ForecastRepo {
    @Inject
    ForecastDao forecastDao;

    public ForecastRepoImpl() {
        ForecastApplication.getAppComponent().inject(this);
    }

    public Observable<Forecast> fetchForecast(int cityId, String coordinates) {
        return DarkSkyService.instance().fetchForecast(coordinates)
                .subscribeOn(Schedulers.io())
                .doOnNext(forecast -> {
                    forecast.setCityId(cityId);
                    forecast.setSyncDate(new DateTime().toString());
                    saveInDB(forecast);
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    private void saveInDB(Forecast forecast) {
        try {
            forecastDao.insertForecast(forecast);
        } catch (SQLiteConstraintException e) {
            forecastDao.updateForecast(forecast);
        }
    }

    @Override
    public Maybe<Forecast> getForecastFromCache(int cityId) {
        return forecastDao.getForecast(cityId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
