package com.exame.luiseduardo.comics.services.Character.get;

import com.exame.luiseduardo.comics.models.CharacterMarvel;

public interface GetCharacterCallback {
    void getCharacterCallbackSuccess(CharacterMarvel listCharacterMarvel);
    void getCharacterCallbackFail(Throwable errorResponseAPI);
}