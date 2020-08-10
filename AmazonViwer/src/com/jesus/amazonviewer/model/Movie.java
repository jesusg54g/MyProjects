package com.jesus.amazonviewer.model;

import com.jesus.amazonviewer.dao.MovieDAO;

import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Movie</h1>
 * <p>
 * La clase Movie hereda de {@link Film} e implementa de {@link IVisualizable}
 * y nos permite visualizar el catologo de peliculas a traves de metodo
 * {@code makeMovieList} y visualizar las peliculas con el metodo abstracto
 * {@code view()} y ademas conocer cuales peliculas ya hemos visto.
 * </p>
 *
 * @author Drakj
 * @version 1.1
 * @since 2020
 * */

public class Movie extends Film implements IVisualizable, MovieDAO {
    private int id;
    private int timeViwed;

    public Movie() {

    }

    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTimeViwed() {
        return timeViwed;
    }

    public void setTimeViwed(int timeViwed) {
        this.timeViwed = timeViwed;
    }

    @Override
    public String toString() {
        return "\n::: MOVIE :::" +
                "\nTitle: " + getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nCreator: " + getCreator() +
                "\nDuration: " + getDuration();
    }

    /**
     * {@inheritDoc}
     * */

    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    /**
     * {@inheritDoc}
     * */

    @Override
    public void stopToSee(Date dataI, Date dateF) {
        if (dateF.getTime() > dataI.getTime()) {
            setTimeViwed((int) (dateF.getTime() - dataI.getTime()));
        } else {
            setTimeViwed(0);
        }
    }

    public static ArrayList<Movie> makeMovieList() {
        Movie movie = new Movie();
        return movie.read();
    }

    /**
     * {@inheritDoc}
     * */

    @Override
    public void view() {
        setViewed(true);
        Movie movie = new Movie();
        movie.setMovieViewed(this);

        Date dateI = startToSee(new Date());

        for (int i = 0; i < 100; i++) {
            System.out.println("☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻");
        }

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println("");
        System.out.println("Viste: " + toString());
        System.out.println("Por: " + getTimeViwed() + " milisegundos");
    }
}
