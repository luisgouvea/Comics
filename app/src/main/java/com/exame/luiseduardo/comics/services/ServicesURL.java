package com.exame.luiseduardo.comics.services;

public class ServicesURL {
    public static final String DOMAIN_BASE_MARVEL = "http://gateway.marvel.com/v1/public/";

    //ISSO PODERIA SER DIFERENTE
    public static final String API_KEY = "001ac6c73378bbfff488a36141458af2";
    public static final String HASH = "72e5ed53d1398abb831c3ceec263f18b";
    public static final String TS = "thesoer";
    //ISSO PODERIA SER DIFERENTE


    //SERVICES
    public static final String LIST_CHARACTER = "characters";
    public static final String GET_CHARACTER = "characters/{idCharacter}";

    public static final String LIST_COMICS = "{idCharacter}/comics";
}
