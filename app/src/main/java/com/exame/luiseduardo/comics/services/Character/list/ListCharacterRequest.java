package com.exame.luiseduardo.comics.services.Character.list;

import com.exame.luiseduardo.comics.models.ResultCharacterMarvel;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Character.CharacterMethodsInterface;
import com.exame.luiseduardo.comics.services.ServicesURL;
import com.exame.luiseduardo.comics.util.LibraryUtil;

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
        Call<ResultCharacterMarvel> call = characterMethodsInterface.listCharacter(limit, ServicesURL.API_KEY, ServicesURL.HASH, ServicesURL.TS);
        call.enqueue(new Callback<ResultCharacterMarvel>() {
            @Override
            public void onResponse(Call<ResultCharacterMarvel> call, retrofit2.Response<ResultCharacterMarvel> response) {
                ResultCharacterMarvel resultCharacterMarvelListCharacter = LibraryUtil.parseObjectToOtherObject(response.body(), ResultCharacterMarvel.class);
                listCharacterCallback.listCharacterCallbackSuccess(resultCharacterMarvelListCharacter.getDataCharacterMarvel().getResults());
            }

            @Override
            public void onFailure(Call<ResultCharacterMarvel> call, Throwable t) {
                listCharacterCallback.listCharacterCallbackFail(t);
            }
        });
    }
}
