package com.exame.luiseduardo.comics.models;

public class CharacterMarvel {
    private int id;
    private String name;
    private Thumbnail thumbnail;
    private Comics comics;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
