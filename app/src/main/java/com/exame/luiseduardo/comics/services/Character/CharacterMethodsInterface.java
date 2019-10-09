package com.exame.luiseduardo.comics.services.Character;

import com.exame.luiseduardo.comics.models.ResultCharacterMarvel;
import com.exame.luiseduardo.comics.services.ServicesURL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterMethodsInterface {
    @GET(ServicesURL.LIST_CHARACTER)
    //ta errado isso
    Call<ResultCharacterMarvel> listCharacter(@Query("limit") String limit, @Query("apikey") String apikey, @Query("hash") String hash, @Query("ts") String ts);

    @GET(ServicesURL.GET_CHARACTER)
    Call<ResultCharacterMarvel> getCharacter(@Path("idCharacter") int idCharacter, @Query("apikey") String apikey, @Query("hash") String hash, @Query("ts") String ts);
}
