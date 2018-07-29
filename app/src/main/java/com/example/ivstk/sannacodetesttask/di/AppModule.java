package com.example.ivstk.sannacodetesttask.di;

import android.content.Context;

import com.example.ivstk.sannacodetesttask.model.db.ForecastDao;
import com.example.ivstk.sannacodetesttask.model.db.MyDataBase;
import com.example.ivstk.sannacodetesttask.model.repo.ForecastRepo;
import com.example.ivstk.sannacodetesttask.model.repo.ForecastRepoImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public ForecastDao forecastDao(Context context) {
        return MyDataBase.getDatabase(context)
                .forecatDao();
    }

    @Provides
    public ForecastRepo forecastRepo() {
        return new ForecastRepoImpl();
    }
}
