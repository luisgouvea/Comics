package com.exame.luiseduardo.comics.services.Comics.list;

import com.exame.luiseduardo.comics.models.ResultComics;
import com.exame.luiseduardo.comics.retrofit.InitialRetrofit;
import com.exame.luiseduardo.comics.services.Comics.ComicsMethodsInterface;
import com.exame.luiseduardo.comics.services.ServicesURL;
import com.exame.luiseduardo.comics.util.LibraryUtil;

import retrofit2.Call;
import retrofit2.Callback;

public class ListComicsRequest {
    private ListComicsCallback listComicsCallback;

    public ListComicsRequest(ListComicsCallback listComicsCallback) {
        this.listComicsCallback = listComicsCallback;
    }

    public void listComics(int idCharacter) {
        execute(idCharacter);
    }

    private void execute(int idCharacter) {
        final ComicsMethodsInterface comicsMethodsInterface = InitialRetrofit.getRetrofit().create(ComicsMethodsInterface.class);
        Call<ResultComics> call = comicsMethodsInterface.listComics(idCharacter, ServicesURL.API_KEY, ServicesURL.HASH, ServicesURL.TS);
        call.enqueue(new Callback<ResultComics>() {
            @Override
            public void onResponse(Call<ResultComics> call, retrofit2.Response<ResultComics> response) {
                ResultComics resultComics = LibraryUtil.parseObjectToOtherObject(response.body(), ResultComics.class);
                listComicsCallback.listComicsCallbackSuccess(resultComics.getDataComics().getResults());
            }

            @Override
            public void onFailure(Call<ResultComics> call, Throwable t) {
                listComicsCallback.listComicsCallbackFail(t);
            }
        });
    }
}
