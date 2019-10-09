package com.exame.luiseduardo.comics.services.Character.list;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.models.ResultListCharacter;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Character.CharacterMethodsInterface;
import com.exame.luiseduardo.comics.services.ServicesURL;
import com.exame.luiseduardo.comics.util.LibraryUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ListCharacterRequest {
    private ListCharacterCallback listCharacterCallback;

    public ListCharacterRequest(ListCharacterCallback listCharacterCallback) {
        this.listCharacterCallback = listCharacterCallback;
    }

    public void listCharacter(String limit) {
        execute(limit);
    }

    private void execute(String limit) {
        final CharacterMethodsInterface characterMethodsInterface = InitialRetrofit.getRetrofit().create(CharacterMethodsInterface.class);
        Call<ResultListCharacter> call = characterMethodsInterface.listCharacter(limit, ServicesURL.API_KEY, ServicesURL.HASH, ServicesURL.TS);
        call.enqueue(new Callback<ResultListCharacter>() {
            @Override
            public void onResponse(Call<ResultListCharacter> call, retrofit2.Response<ResultListCharacter> response) {
                ResultListCharacter resultListCharacter = LibraryUtil.parseObjectToOtherObject(response.body(), ResultListCharacter.class);
                listCharacterCallback.listCharacterCallbackSuccess(resultListCharacter.getData().getResults());
            }

            @Override
            public void onFailure(Call<ResultListCharacter> call, Throwable t) {
                listCharacterCallback.listCharacterCallbackFail(t);
            }
        });
    }
}
