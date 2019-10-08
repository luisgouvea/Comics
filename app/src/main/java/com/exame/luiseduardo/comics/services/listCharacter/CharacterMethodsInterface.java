package com.exame.luiseduardo.comics.services.listCharacter;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.services.ServicesURL;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterMethodsInterface {
    @GET(ServicesURL.LIST_CHARACTER)
    Call<ArrayList<CharacterMarvel>> listCharacter(@Query("numberOrder") String numberOrder);
}
