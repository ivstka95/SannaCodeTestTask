package com.example.ivstk.sannacodetesttask.model.repo;


import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ForecastRepo {

    Observable<Forecast> fetchForecast(int cityId, String coordinates);

    Maybe<Forecast> getForecastFromCache(int cityId);
}
