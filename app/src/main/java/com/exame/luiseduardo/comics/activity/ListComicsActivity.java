package com.exame.luiseduardo.comics.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.exame.luiseduardo.comics.R;
import com.exame.luiseduardo.comics.models.Comics;
import com.exame.luiseduardo.comics.recyclerView.adapter.ListComicsAdapter;
import com.exame.luiseduardo.comics.services.Comics.list.ListComicsCallback;
import com.exame.luiseduardo.comics.services.Comics.list.ListComicsRequest;

import java.util.ArrayList;

public class ListComicsActivity extends BaseActivity implements ListComicsCallback, ListComicsAdapter.ClickListener {

    private RecyclerView recyclerView;

    private ArrayList<Comics> listComics;
    private ListComicsCallback callback = this;
    private ListComicsAdapter.ClickListener clickListener = this;
    public static int idCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_comics);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.initialInterfaceActivity();
        listComicsRequest();
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
        if (listComics != null && listComics.size() > 0 ) {
            ListComicsAdapter listComicsAdapter = new ListComicsAdapter(listComics, clickListener);
            recyclerView.setAdapter(listComicsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }

    public void listComicsRequest() {
        ListComicsRequest listComicsRequest = new ListComicsRequest(callback);
        listComicsRequest.listComics(idCharacter);
    }

    @Override
    public void listComicsCallbackSuccess(ArrayList<Comics> listComics) {
        this.listComics = listComics;
        buildRecyclerView();
    }

    @Override
    public void listComicsCallbackFail(Throwable errorResponseAPI) {

    }


    @Override
    public void openDetailsComics(View v, int position) {
        Comics character = listComics.get(position);
        DetailsCharacterActivity.idCharacter = character.getId();

        Intent intentCharge = new Intent(getContext(), DetailsCharacterActivity.class);
        getContext().startActivity(intentCharge);
    }


}
