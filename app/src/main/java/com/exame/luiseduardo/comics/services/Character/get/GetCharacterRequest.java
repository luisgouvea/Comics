package com.exame.luiseduardo.comics.services.Character.get;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.models.ResultCharacterMarvel;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Character.CharacterMethodsInterface;
import com.exame.luiseduardo.comics.services.ServicesURL;
import com.exame.luiseduardo.comics.util.LibraryUtil;

import retrofit2.Call;
import retrofit2.Callback;

public class GetCharacterRequest {
    private GetCharacterCallback getCharacterCallback;

    public GetCharacterRequest(GetCharacterCallback getCharacterCallback) {
        this.getCharacterCallback = getCharacterCallback;
    }

    public void getCharacter(int idCharacter) {
        execute(idCharacter);
    }

    private void execute(int idCharacter) {
        final CharacterMethodsInterface characterMethodsInterface = InitialRetrofit.getRetrofit().create(CharacterMethodsInterface.class);
        Call<ResultCharacterMarvel> call = characterMethodsInterface.getCharacter(idCharacter, ServicesURL.API_KEY, ServicesURL.HASH, ServicesURL.TS);
        call.enqueue(new Callback<ResultCharacterMarvel>() {
            @Override
            public void onResponse(Call<ResultCharacterMarvel> call, retrofit2.Response<ResultCharacterMarvel> response) {
                CharacterMarvel character = LibraryUtil.parseObjectToOtherObject(response.body(), CharacterMarvel.class);
                getCharacterCallback.getCharacterCallbackSuccess(character);
            }

            @Override
            public void onFailure(Call<ResultCharacterMarvel> call, Throwable t) {
                getCharacterCallback.getCharacterCallbackFail(t);
            }
        });
    }
}