package com.exame.luiseduardo.comics.util;

import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.Primitives;

import java.lang.reflect.Type;

import retrofit2.Response;

public class LibraryUtil {

    public static <T> T parseObjectToOtherObject(Object responseAPI, Class<T> classToParse) {
        Gson gSerializer = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

        String json = gSerializer.toJson(responseAPI);

        Object object = gSerializer.fromJson(json, (Type) classToParse);

        return Primitives.wrap(classToParse).cast(object);
    }

    /*
     * IsTextFieldEmpty
     * Verify whether text field is empty or not
     **/
    public static boolean IsTextFieldEmpty(EditText editText) {

        String input = editText.getText().toString().trim();
        return input.length() == 0;

    }
}
