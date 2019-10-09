package com.exame.luiseduardo.comics.services.Comics;

import com.exame.luiseduardo.comics.models.ResultComics;
import com.exame.luiseduardo.comics.services.ServicesURL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ComicsMethodsInterface {
    @GET(ServicesURL.LIST_COMICS)
        //ta errado isso
    Call<ResultComics> listComics(@Path("idCharacter") int idCharacter, @Query("apikey") String apikey, @Query("hash") String hash, @Query("ts") String ts);
}