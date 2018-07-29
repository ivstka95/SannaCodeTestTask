package com.example.ivstk.sannacodetesttask.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ForecastView extends MvpView {

//    @StateStrategyType(OneExecutionStateStrategy.class)

}