package com.exame.luiseduardo.comics.recyclerView.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exame.luiseduardo.comics.R;
import com.exame.luiseduardo.comics.models.CharacterMarvel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListCharacterAdapter extends RecyclerView.Adapter<ListCharacterAdapter.ViewHolder>{
    private ArrayList<CharacterMarvel> listCharacter;
    private ClickListener mListener;

    public ListCharacterAdapter(ArrayList<CharacterMarvel> listCharacter, ClickListener listener) {
        this.listCharacter = listCharacter;
        this.mListener = listener;
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
        CharacterMarvel singleSale = this.listCharacter.get(position);
        holder.bindData(singleSale, mListener);
    }

    @Override
    public int getItemCount() {
        return listCharacter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout characterCardContent;
        TextView textViewName;
        ImageView imageViewThumbnail;
        TextView textViewNumberComics;
        public ClickListener clickListner;

        public ViewHolder(View itemView) {
            super(itemView);
            characterCardContent = itemView.findViewById(R.id.characterCardContent);
            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
            textViewNumberComics = itemView.findViewById(R.id.textViewNumberComics);
        }

        public void bindData(final CharacterMarvel characterMarvel, ClickListener listner) {
            clickListner = listner;
            characterCardContent.setOnClickListener(this);
            setInfDefault();
            setInfCharacterTarget(characterMarvel);
        }

        private void setInfDefault() {
            this.textViewName.setText("Não foi informado");
            this.textViewNumberComics.setText("Não foi informado");
        }

        private void setInfCharacterTarget(CharacterMarvel characterMarvel) {
            this.textViewName.setText(characterMarvel.getName());
            this.textViewNumberComics.setText(String.valueOf(characterMarvel.getComics().getAvailable()));

            String url = characterMarvel.getThumbnail().getPath() + "/portrait_xlarge." + characterMarvel.getThumbnail().getExtension();
            Picasso.get().load(url).into(this.imageViewThumbnail);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.characterCardContent) {
                clickListner.openDetailsCharacter(view, getAdapterPosition());
            }
        }
    }

    public interface ClickListener {
        void openDetailsCharacter(View v, int position);
    }
}