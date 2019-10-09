package com.exame.luiseduardo.comics.services.Character.list;

import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Character.CharacterMethodsInterface;
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
        Call<ArrayList<CharacterMarvel>> call = characterMethodsInterface.listCharacter(limit);
        call.enqueue(new Callback<ArrayList<CharacterMarvel>>() {
            @Override
            public void onResponse(Call<ArrayList<CharacterMarvel>> call, retrofit2.Response<ArrayList<CharacterMarvel>> response) {
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<CharacterMarvel>>() {
                }.getType();
                String stringResponse = gson.toJson(response);
                ArrayList<CharacterMarvel> listCharacterMarvel = gson.fromJson(stringResponse, listType);
                listCharacterCallback.listCharacterCallbackSuccess(listCharacterMarvel);
            }

            @Override
            public void onFailure(Call<ArrayList<CharacterMarvel>> call, Throwable t) {
                listCharacterCallback.listCharacterCallbackFail(t);
            }
        });
    }
}
