package com.exame.luiseduardo.comics.services.Comics.list;

import com.exame.luiseduardo.comics.models.Comics;

import java.util.ArrayList;

public interface ListComicsCallback {
    void listComicsCallbackSuccess(ArrayList<Comics> listComics);
    void listComicsCallbackFail(Throwable errorResponseAPI);
}