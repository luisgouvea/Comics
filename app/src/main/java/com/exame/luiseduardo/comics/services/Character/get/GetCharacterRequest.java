package com.exame.luiseduardo.comics.services.Character.get;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Character.CharacterMethodsInterface;
import com.exame.luiseduardo.comics.util.LibraryUtil;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class GetCharacterRequest {
    private GetCharacterCallback getCharacterCallback;

    public GetCharacterRequest(GetCharacterCallback getCharacterCallback) {
        this.getCharacterCallback = getCharacterCallback;
    }

    public void getOrderRequest(String numberOrder) {
        execute(numberOrder);
    }

    private void execute(String numberOrder) {
        final CharacterMethodsInterface characterMethodsInterface = InitialRetrofit.getRetrofit().create(CharacterMethodsInterface.class);
        /*Call<ArrayList<CharacterMarvel>> call = characterMethodsInterface.listCharacter("d", "001ac6c73378bbfff488a36141458af2", "", "");
        call.enqueue(new Callback<ArrayList<CharacterMarvel>>() {
            @Override
            public void onResponse(Call<ArrayList<CharacterMarvel>> call, retrofit2.Response<ArrayList<CharacterMarvel>> response) {
                CharacterMarvel character = LibraryUtil.parseObjectToOtherObject(response.body(), CharacterMarvel.class);
                getCharacterCallback.getCharacterCallbackSuccess(character);
            }

            @Override
            public void onFailure(Call<ArrayList<CharacterMarvel>> call, Throwable t) {
                getCharacterCallback.getCharacterCallbackFail(t);
            }
        });*/
    }
}