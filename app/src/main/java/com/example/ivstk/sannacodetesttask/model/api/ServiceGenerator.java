package com.example.ivstk.sannacodetesttask.model.api;


import java.util.Map;
import java.util.WeakHashMap;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ServiceGenerator {
    /**
     * Basic URL for RESTful API
     */
    private static final String API_BASE = "https://api.darksky.net/forecast/";
    /**
     * Holds registered services
     */
    private static final Map<Class<?>, Object> registeredServices;
    /**
     * Default builder for {@link Retrofit} instance
     */
    private static final Retrofit.Builder builder;

    static {
        registeredServices = new WeakHashMap<>();
        builder = new Retrofit.Builder()
                .baseUrl(API_BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
    }

    public static <S> boolean isRegistered(final Class<S> serviceClass) {
        return registeredServices.containsKey(serviceClass);
    }

    @SuppressWarnings("unchecked")
    public static synchronized <S> S generate(Class<S> serviceClass) {
        if (isRegistered(serviceClass))
            return (S) registeredServices.get(serviceClass);
        final S service = builder
                .build()
                .create(serviceClass);
        registeredServices.put(serviceClass, service);
        return service;
    }
}
