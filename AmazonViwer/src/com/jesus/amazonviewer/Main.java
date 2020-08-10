package com.jesus.amazonviewer;

import com.anncode.makereport.Report;
import com.jesus.amazonviewer.model.*;
import com.jesus.util.AmazonUtil;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * <h1>AmazonViewer</h1>
 * AmazonViewer es un programa que permite visualizar Movies, Series con sus
 * respectivos Chapters, Books y Magazines. Te permite ademas generar reportes
 * generales y con fecha del dia.
 *
 * <p>
 * Existen algunas reglas como que todos los elementos pueden ser visualizados
 * o leidos a excepcion de las Magazines, que estas solo pueden ser vistas a
 * modo de exposicion sin ser leidas.
 * </p>
 *
 * @author Drakj
 * @version 1.1
 * @since 2020
 * */

public class Main {
    public static void main(String[] args) {
        showMenu();
    }
    public static int exit = 1;

    public static void showMenu() {

        do {
            System.out.println("BIENVENIDOS AMAZON VIEWER");
            System.out.println("");
            System.out.println("Selecciona el numero de la opcion deseasa:");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");

            //Leer la respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0, 6);

            switch (response) {
                case 0:
                    //salir
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    break;
                case 6:
                    /* Otra manera de crear un objeto es
                    * agreandolo directamente a un argumento
                    * ya el interpete de java lo detecta como
                    * un objeto date
                    */
                    makeReport(new Date());
                    break;
                default:
                    System.out.println("");
                    System.out.println("•••••¡¡Selecciona una opcion valida!!•••••");
                    System.out.println("");
                    break;
            }

        } while (exit > 0);
    }

    static ArrayList<Movie> movies = new ArrayList<>();
    public static void showMovies() {
        movies = Movie.makeMovieList();
        do {
            System.out.println("");
            System.out.println("::: MOVIES :::");
            System.out.println("");

            AtomicInteger atomicInteger = new AtomicInteger(1);
            movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() + ". " +
                    m.getTitle() + " Visto: " + m.isViewed()));

            /*
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(i + 1 + ". " + movies.get(i).getTitle() +
                        " Visto: " + movies.get(i).isViewed());
            } */

            System.out.println("0. Regresar al Menu");

            //Leer respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0, movies.size());

            if (response > 0) {
                Movie movieSelected = movies.get(response - 1);
                movieSelected.view();
            } else {
                showMenu();
            }

        } while (exit != 0);
    }

    static ArrayList<Serie> series = Serie.makeSeriesList();
    public static void showSeries() {

        do {
            System.out.println("");
            System.out.println("::: SERIES :::");
            System.out.println("");

            for (int i = 0; i < series.size(); i++) {
                System.out.println(i + 1 + ". " + series.get(i).getTitle() +
                        " Visto: " + series.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu Principal");

            //Leer respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0, series.size());

            if (response > 0 && response <= series.size()) {
                showChapters(series.get(response - 1).getChapters());
            } else {
                showMenu();
            }

        } while (exit != 0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {

        do {
            System.out.println("");
            System.out.println("::: CHAPTERS :::");
            System.out.println("");

            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
                System.out.println(i + 1 + ". " +
                        chaptersOfSerieSelected.get(i).getTitle() +
                        " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
            }

            System.out.println("0. Regresar al Menu de Series");

            //Leer respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0,
                    chaptersOfSerieSelected.size());

            if (response > 0) {
                Chapter chapterSelected = chaptersOfSerieSelected.get(response - 1);
                chapterSelected.view();
            } else {
                showSeries();
            }

        } while (exit != 0);
    }
    static ArrayList<Book> books= Book.makeBookList();
    public static void showBooks() {

        do {
            System.out.println("");
            System.out.println("::: BOOKS :::");
            System.out.println("");

            for (int i = 0; i < books.size(); i++) { //1. Book 1
                System.out.println(i+1 + ". " + books.get(i).getTitle() +
                        " Leido: " + books.get(i).isReaded());
            }

            System.out.println("0. Regresar al Menu");

            //Leer respuesta del usuario
            int response = AmazonUtil.validateUserResponseMenu(0, books.size());

            if (response > 0) {
                Book bookSelected = books.get(response-1);
                bookSelected.view();
            } else {
                showMenu();
            }

        } while (exit != 0);
    }

    public static void showMagazines() {
        ArrayList<Magazine> magazines = Magazine.makeMagazineList();

        do {
            System.out.println();
            System.out.println(":: MAGAZINES ::");
            System.out.println();

            for (int i = 0; i < magazines.size(); i++) { //1. Book 1
                System.out.println(i+1 + ". " + magazines.get(i).getTitle());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, 0);

            if(response == 0) {
                exit = 0;
                showMenu();
            }


        }while(exit !=0);
    }

    public static void makeReport() {

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");

        StringBuilder contentReport = new StringBuilder();
        movies.stream()
                .filter(Film::getIsViewed)
                .forEach(m -> contentReport.append(m.toString() + "\n"));

        /*
        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        } */

        Consumer<Serie> seriesEach = s -> {
            ArrayList<Chapter> chapters = s.getChapters();
            chapters.stream().filter(Film::getIsViewed)
                    .forEach(c -> contentReport.append(c.toString() + "\n"));
        };

        /*
        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";
                }
            }
        } */

        books.stream()
                .filter(Book::getIsReaded)
                .forEach(m -> contentReport.append(m.toString() + "\n"));

        /*
        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";

            }
        } */

        report.setContent(String.valueOf(contentReport));
        report.makeReport();
        System.out.println("Reporte Generado");
        System.out.println("");
    }

    static ArrayList<Movie> moviesDaily = Movie.makeMovieList();
    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);

        Report report = new Report();
        report.setNameFile("Reporte " + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");


        SimpleDateFormat dfNameDays = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss");
        dateString = dfNameDays.format(date);
        String contentReport = "Date: " + dateString + "\n";

        for (Movie movie : moviesDaily) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }

        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";

                }
            }
        }

        for (Book book : books) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";
            }
        }

        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado");
        System.out.println();
    }
}
