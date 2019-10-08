package com.exame.luiseduardo.comics.retrofit;

import com.exame.luiseduardo.comics.services.ServicesURL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitialRetrofit {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ServicesURL.DOMAIN_BASE_MARVEL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
