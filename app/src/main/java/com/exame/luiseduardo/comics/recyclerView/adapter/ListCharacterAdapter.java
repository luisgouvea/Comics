package com.exame.luiseduardo.comics.recyclerView.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.exame.luiseduardo.comics.R;
import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListCharacterAdapter extends RecyclerView.Adapter<ListCharacterAdapter.ViewHolder>{
    private ArrayList<CharacterMarvel> listCharacter;

    public ListCharacterAdapter(ArrayList<CharacterMarvel> listCharacter) {
        this.listCharacter = listCharacter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_character_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textViewName.setText(listCharacter.get(position).getName());
        String url = listCharacter.get(position).getThumbnail().getPath() + "/portrait_xfantastic." + listCharacter.get(position).getThumbnail().getExtension();
        Picasso.get().load(url).into(holder.imageViewThumbnail);
    }

    @Override
    public int getItemCount() {
        return listCharacter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        ImageView imageViewThumbnail;
        TextView textViewQtd;
        TextView textViewBarcode;



        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
        }
    }
}