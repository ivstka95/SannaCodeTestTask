package com.example.ivstk.sannacodetesttask.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.ivstk.sannacodetesttask.model.entity.forecast.Forecast;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ForecastView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showForecast(Forecast forecast, int city);

    void showProgress();

    void hideProgress();

    void showErrorOccured();

    void showNetworkSettingsDialog();
}