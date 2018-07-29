package com.example.ivstk.sannacodetesttask.model.repo;


import com.example.ivstk.sannacodetesttask.model.entity.Forecast;

import io.reactivex.Maybe;
import io.reactivex.Observable;

public interface ForecastRepo {

    Observable<Object> fetchForecast(Object params);

    Maybe<Forecast> getForecastFromCache(Object params);
}
