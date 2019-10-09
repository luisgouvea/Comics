package com.exame.luiseduardo.comics.services.Character;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.services.ServicesURL;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CharacterMethodsInterface {
    ////http://gateway.marvel.com/v1/public/characters?limit=1&ts=thesoer&apikey=001ac6c73378bbfff488a36141458af2&hash=72e5ed53d1398abb831c3ceec263f18b
    @GET(ServicesURL.LIST_CHARACTER)
    Call<ArrayList<CharacterMarvel>> listCharacter(@Query("limit") String limit);

    @GET(ServicesURL.GET_CHARACTER)
    Call<CharacterMarvel> getCharacter(int idCharacter);
}
