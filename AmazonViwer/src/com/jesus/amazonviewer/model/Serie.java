package com.jesus.amazonviewer.model;

import java.util.ArrayList;

/**
 * <h1>Serie</h1>
 * <p>
 * La clase Serie hereda de la clase {@link Film} y nos permite visualizar el
 * catalogo de series a traves del metodo {@code makeSeriesList} y el metodo
 * abstracto {@code view()} nos muestra cuales series hemos terminado de ver.
 * </p>
 *
 * @author Drakj
 * @version 1.1
 * @since 2020
 * */

public class Serie extends Film {

    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public Serie(String title, String genre, String creator,
                 int duration, int sessionQuantity) {
        super(title, genre, creator, duration);
        this.sessionQuantity = sessionQuantity;
    }


    public int getId() {
        return id;
    }

    public int getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(int sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return  "\n :: SERIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    public static ArrayList<Serie> makeSeriesList() {
        ArrayList<Serie> series = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Serie serie = new Serie("Serie "+i, "genero "+i,
                    "creador "+i, 1200, 5);
            serie.setChapters(Chapter.makeChaptersList(serie));
            series.add(serie);

        }
        return series;
    }

    /**
     * {@inheritDoc}
     * */

    @Override
    public void view() {
        setViewed(true);
    }
}
