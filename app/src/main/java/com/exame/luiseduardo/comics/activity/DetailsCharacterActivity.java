package com.exame.luiseduardo.comics.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exame.luiseduardo.comics.R;
import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.services.Character.get.GetCharacterCallback;
import com.exame.luiseduardo.comics.services.Character.get.GetCharacterRequest;

public class DetailsCharacterActivity extends BaseActivity implements View.OnClickListener, GetCharacterCallback {


    private CharacterMarvel character;
    private GetCharacterCallback callback = this;

    public static int idCharacter;

    //elements interface (dava para fazer melhor)
    private ImageView imageViewThumbnail;
    private TextView textViewName;
    private TextView textViewModified;
    private TextView textViewComics;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_character);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.initialInterfaceActivity();
        getCharacterRequest();
        setCharacter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //stopLoaderCustom(false);
    }

    @Override
    public void initialInterfaceActivity() {
        super.initialInterfaceActivity();
        this.setInterfacesFindView();
        this.setHandlerInterface();
    }

    @Override
    public void setInterfacesFindView() {
        imageViewThumbnail = findViewById(R.id.imageViewThumbnail);
        textViewName = findViewById(R.id.textViewName);
        textViewModified = findViewById(R.id.textViewModified);
        textViewComics = findViewById(R.id.textViewComics);
        textViewDescription = findViewById(R.id.textViewDescription);
    }

    @Override
    public void setHandlerInterface() {
    }

    private void setCharacter() {
        if (character != null) {
            this.textViewName.setText(character.getName());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnGoComicsList) {
//            Intent intent = new Intent(this, ListComicsActivity.class);
//            startActivity(intent);
        }

    }

    public void getCharacterRequest() {
        GetCharacterRequest getCharacterRequest = new GetCharacterRequest(callback);
        getCharacterRequest.getCharacter(idCharacter);
    }

    @Override
    public void getCharacterCallbackSuccess(CharacterMarvel character) {
        this.character = character;
        this.setCharacter();
    }

    @Override
    public void getCharacterCallbackFail(Throwable errorResponseAPI) {

    }
}
