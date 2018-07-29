package com.example.ivstk.sannacodetesttask.di;

import android.content.Context;

import com.example.ivstk.sannacodetesttask.ForecastApplication;
import com.example.ivstk.sannacodetesttask.model.repo.ForecastRepoImpl;
import com.example.ivstk.sannacodetesttask.presentation.presenter.ForecastPresenter;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(ForecastPresenter presenter);

    void inject(ForecastRepoImpl forecastRepo);


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }
}
