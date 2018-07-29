package com.example.ivstk.sannacodetesttask.presentation.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.ivstk.sannacodetesttask.ForecastApplication;
import com.example.ivstk.sannacodetesttask.R;
import com.example.ivstk.sannacodetesttask.model.repo.ForecastRepo;
import com.example.ivstk.sannacodetesttask.presentation.view.ForecastView;
import com.example.ivstk.sannacodetesttask.utils.system.NetworkUtil;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class ForecastPresenter extends BasePresenter<ForecastView> {
    private static final String KEY_CITY_ID = "city_id";
    private int selectedCityId;
    private boolean shouldFetch = true;

    @Inject
    ForecastRepo forecastRepo;
    @Inject
    SharedPreferences preferences;
    @Inject
    Context context;

    public ForecastPresenter() {
        ForecastApplication.getAppComponent().inject(this);
        selectedCityId = getLastCityId();
        Log.e(toString(), "ForecastPresenter: constuctor");
    }

    private void saveLastCityId() {
        preferences.edit().putInt(KEY_CITY_ID, selectedCityId).apply();
    }

    private int getLastCityId() {
        return preferences.getInt(KEY_CITY_ID, R.id.kyiv);
    }

    public void onCreate() {
        loadCache();
        if (shouldFetch)
            fetchForecast();
    }

    public void onCitySelected(int cityId) {
        if (selectedCityId != cityId) {
            selectedCityId = cityId;
            saveLastCityId();
            loadCache();
            fetchForecast();
        }
    }

    private void fetchForecast() {
        Log.e(toString(), "fetchForecast: ");
        if (NetworkUtil.isNetworkConnected(context)) {
            getViewState().showProgress();
            Disposable disposable = forecastRepo.fetchForecast(selectedCityId, getCoordinatesForCity())
                    .subscribe(forecast -> {
                                getViewState().showForecast(forecast, getTitleResForCity());
                                shouldFetch = false;
                            },
                            throwable -> {
                                getViewState().hideProgress();
                                getViewState().showErrorOccured();
                            },
                            () -> getViewState().hideProgress());
            disposeOnDestroy(disposable);
        } else {
            getViewState().hideProgress();
            getViewState().showNetworkSettingsDialog();
        }

    }

    private String getCoordinatesForCity() {
        switch (selectedCityId) {
            case R.id.houston:
                return "29.7604267,-95.3698028";
            case R.id.galveston:
                return "29.487425,-94.922562";
            case R.id.boston:
                return "42.361145,-71.057083";
            case R.id.miami:
                return "25.761681,-80.191788";
            default:
                selectedCityId = R.id.kyiv;
                return "50.45466,30.5238";
        }
    }

    private int getTitleResForCity() {
        switch (selectedCityId) {
            case R.id.kyiv:
                return R.string.kyiv;
            case R.id.houston:
                return R.string.houston;
            case R.id.galveston:
                return R.string.galveston;
            case R.id.boston:
                return R.string.boston;
            case R.id.miami:
                return R.string.miami;
            default:
                selectedCityId = R.id.kyiv;
                return R.string.kyiv;
        }
    }

    private void loadCache() {
        Disposable disposable = forecastRepo.getForecastFromCache(selectedCityId)
                .subscribe(forecast -> getViewState().showForecast(forecast, getTitleResForCity()));
        disposeOnDestroy(disposable);
    }

    public void onRefresh() {
        fetchForecast();
    }
}
