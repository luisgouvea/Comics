package com.exame.luiseduardo.comics.activity;

import android.content.Intent;
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

public class ListCharacterActivity extends BaseActivity implements ListCharacterCallback, ListCharacterAdapter.ClickListener {

    private RecyclerView recyclerView;

    private ArrayList<CharacterMarvel> listCharacter;
    private ListCharacterCallback callback = this;
    private ListCharacterAdapter.ClickListener clickListener = this;
    private String limit = "10";

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
    }

    @Override
    public void setHandlerInterface() {
    }

    private void buildRecyclerView() {
        if (listCharacter != null && listCharacter.size() > 0 ) {
            ListCharacterAdapter listCharacterAdapter = new ListCharacterAdapter(listCharacter, clickListener);
            recyclerView.setAdapter(listCharacterAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
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

    @Override
    public void openDetailsCharacter(View v, int position) {
        CharacterMarvel character = listCharacter.get(position);
        DetailsCharacterActivity.idCharacter = character.getId();

        Intent intentCharge = new Intent(getContext(), DetailsCharacterActivity.class);
        getContext().startActivity(intentCharge);
    }
}
