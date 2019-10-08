package com.exame.luiseduardo.comics.services.listCharacter.list;

import com.exame.luiseduardo.comics.models.CharacterMarvel;

import java.util.ArrayList;

public interface ListCharacterCallback {
    void listCharacterCallbackSuccess(ArrayList<CharacterMarvel> listCharacterMarvel);
    void listCharacterCallbackFail(Throwable errorResponseAPI);
}
