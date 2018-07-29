package com.example.ivstk.sannacodetesttask;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.ivstk.sannacodetesttask.di.AppComponent;
import com.example.ivstk.sannacodetesttask.di.DaggerAppComponent;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class ForecastApplication extends Application {
//
//    @Inject
//    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
//
//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }

    private static AppComponent sAppComponent;


    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .context(this)
                .build();
//        sAppComponent.inject(this);
//        CrashlyticsCore core = new CrashlyticsCore.Builder()
//                .disabled(BuildConfig.DEBUG)
//                .build();
//        Fabric.with(this, new Crashlytics.Builder().core(core).build());
//        if (BuildConfig.DEBUG)
//            Timber.plant(new Timber.DebugTree());
//        else
//            Timber.plant(new CrashlyticsTree());
//        JodaTimeAndroid.init(this);
//        FirebaseApp.initializeApp(this);
    }

//    private class CrashlyticsTree extends Timber.Tree {
//        private static final String CRASHLYTICS_KEY_PRIORITY = "priority";
//        private static final String CRASHLYTICS_KEY_TAG = "tag";
//        private static final String CRASHLYTICS_KEY_MESSAGE = "message";
//
//        @Override
//        protected void log(int priority, @Nullable String tag, @Nullable String message, @Nullable Throwable t) {
//            if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
//                return;
//            }
//            Crashlytics.setInt(CRASHLYTICS_KEY_PRIORITY, priority);
//            Crashlytics.setString(CRASHLYTICS_KEY_TAG, tag);
//            Crashlytics.setString(CRASHLYTICS_KEY_MESSAGE, message);
//            if (t == null) {
//                Crashlytics.logException(new Exception(message));
//            } else {
//                Crashlytics.logException(t);
//            }
//        }
//    }
}