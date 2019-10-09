package com.exame.luiseduardo.comics.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.exame.luiseduardo.comics.R;
import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.exame.luiseduardo.comics.recyclerView.adapter.ListCharacterAdapter;
import com.exame.luiseduardo.comics.services.Character.list.ListCharacterCallback;
import com.exame.luiseduardo.comics.services.Character.list.ListCharacterRequest;

import java.util.ArrayList;

public class ListCharacterActivity extends BaseActivity implements View.OnClickListener, ListCharacterCallback {

    private RecyclerView recyclerView;
    private LinearLayout linearLayoutRecyclerView;

    public static ArrayList<CharacterMarvel> listCharacter;
    private ListCharacterCallback callback = this;
    private String limit = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_character);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.initialInterfaceActivity();
        listCharacterRequest();
        buildRecyclerView();
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
        recyclerView = findViewById(R.id.idRecyclerView);
        linearLayoutRecyclerView = findViewById(R.id.linearLayoutRecyclerView);
    }

    @Override
    public void setHandlerInterface() {
    }

    private void buildRecyclerView() {
        if (listCharacter != null && listCharacter.size() > 0 ) {
            ListCharacterAdapter listCharacterAdapter = new ListCharacterAdapter(listCharacter);
            recyclerView.setAdapter(listCharacterAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    @Override
    public void onClick(View v) {

    }

    public void listCharacterRequest() {
        ListCharacterRequest listCharacterRequest = new ListCharacterRequest(callback);
        listCharacterRequest.listCharacter(this.limit);
    }

    @Override
    public void listCharacterCallbackSuccess(ArrayList<CharacterMarvel> listCharacterMarvel) {
        this.listCharacter = listCharacterMarvel;
        buildRecyclerView();
    }

    @Override
    public void listCharacterCallbackFail(Throwable errorResponseAPI) {

    }
}
