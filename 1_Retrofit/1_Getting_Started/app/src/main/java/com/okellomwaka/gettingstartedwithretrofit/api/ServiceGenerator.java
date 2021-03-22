package com.okellomwaka.gettingstartedwithretrofit.api;

import com.okellomwaka.gettingstartedwithretrofit.api.service.GitHubClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static String BASE_URL() {
        return "https://api.github.com/";
    }


    static   Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL())
            .addConverterFactory(GsonConverterFactory.create());


    static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
