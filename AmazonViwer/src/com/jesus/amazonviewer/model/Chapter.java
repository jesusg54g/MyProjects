package com.jesus.amazonviewer.model;

import java.util.ArrayList;

/**
 * <h1>Chapter</h1>
 * <p>
 * La clase Chapter hereda de {@link Movie} y nos permite visualizar
 * el catalogo de capitulos de una serie a traves del metodo
 * {@code makeChaptersList()} y visualizar los capitulos a traves del
 * metodo abstracto {@code view()} y ademas conocer cuales capitulos
 * ya hemos visto.
 * </p>
 * @see Film
 *
 * @author Drakj
 * @version 1.1
 * @since 2020
 * */

public class Chapter extends Movie{
    private int id;
    private int sessionNumber;
    private Serie serie;

    public Chapter(String title, String genre, String creator,
                   int duration, short year, int sessionNumber, Serie serie) {
        super(title, genre, creator, duration, year);
        this.setSessionNumber(sessionNumber);
        this.setSerie(serie);
    }

    @Override
    public int getId() {
        return this.id;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Serie getSerie() {
        return serie;
    }

    @Override
    public String toString() {
        return "\n ::: SERIE :::" +
                "\n Title: " + getSerie().getTitle() +
                "\n ::: CHAPTER :::" +
                "\nTitle: " + getTitle() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    public static ArrayList<Chapter> makeChaptersList(Serie serie) {
        ArrayList<Chapter> chapters = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            chapters.add(new Chapter("Capitulo: " + i, "Genero: " +
                    i, "Creador: " + i, 45, (short)(2017 + i), i, serie));
        }
        return chapters;
    }

    /**
     * {@inheritDoc}
     * */

    @Override
    public void view() {
        super.view();
        ArrayList<Chapter> chapters = getSerie().getChapters();
        int chapterViewedCounter = 0;
        for (Chapter chapter: chapters) {
            if (chapter.getIsViewed()) {
                chapterViewedCounter++;
            }
        }
        if (chapterViewedCounter == chapters.size()) {
            getSerie().view();
        }
    }

}
