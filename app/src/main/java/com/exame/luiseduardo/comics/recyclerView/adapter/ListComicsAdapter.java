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
import com.exame.luiseduardo.comics.models.Comics;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListComicsAdapter extends RecyclerView.Adapter<ListComicsAdapter.ViewHolder>{
    private ArrayList<Comics> listComics;
    private ClickListener mListener;

    public ListComicsAdapter(ArrayList<Comics> listComics, ClickListener listener) {
        this.listComics = listComics;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comics_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Comics comics = this.listComics.get(position);
        holder.bindData(comics, mListener);
    }

    @Override
    public int getItemCount() {
        return listComics.size();
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

        public void bindData(final Comics comics, ClickListener listner) {
            clickListner = listner;
            characterCardContent.setOnClickListener(this);
            setInfDefault();
            setInfComicsTarget(comics);
        }

        private void setInfDefault() {
            this.textViewName.setText("Não foi informado");
            this.textViewNumberComics.setText("Não foi informado");
        }

        private void setInfComicsTarget(Comics comics) {
            this.textViewName.setText(comics.getAvailable());

            String url = comics.getThumbnail().getPath() + "/portrait_xlarge." + comics.getThumbnail().getExtension();
            Picasso.get().load(url).into(this.imageViewThumbnail);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.characterCardContent) {
                clickListner.openDetailsComics(view, getAdapterPosition());
            }
        }
    }

    public interface ClickListener {
        void openDetailsComics(View v, int position);
    }
}