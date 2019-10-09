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
import com.exame.luiseduardo.comics.models.Price;
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

        LinearLayout comicsCardContent;
        TextView textViewTitle;
        ImageView imageViewThumbnail;
        TextView textViewNumberPages;
        TextView textViewPrice;

        public ClickListener clickListner;

        public ViewHolder(View itemView) {
            super(itemView);
            comicsCardContent = itemView.findViewById(R.id.comicsCardContent);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageViewThumbnail = itemView.findViewById(R.id.imageViewThumbnail);
            textViewNumberPages = itemView.findViewById(R.id.textViewNumberPages);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }

        public void bindData(final Comics comics, ClickListener listner) {
            clickListner = listner;
            comicsCardContent.setOnClickListener(this);
            setInfDefault();
            setInfComicsTarget(comics);
        }

        private void setInfDefault() {
            this.textViewTitle.setText("Não foi informado");
            this.textViewNumberPages.setText("Não foi informado");
        }

        private void setInfComicsTarget(Comics comics) {
            this.textViewTitle.setText(comics.getTitle());

            String url = comics.getThumbnail().getPath() + "/portrait_xlarge." + comics.getThumbnail().getExtension();
            Picasso.get().load(url).into(this.imageViewThumbnail);

            this.textViewNumberPages.setText(String.valueOf(comics.getPageCount()) + " páginas");

            ArrayList<Price> prices = comics.getPrices();
            double price = 1.00;
            if (prices.size() > 1) {
                price  = prices.get(1).getPrice();
            } else {
                price  = prices.get(0).getPrice();
            }

            String g = Double.toString(price);
            this.textViewPrice.setText(g);
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