package com.jesus.util;

import java.util.Scanner;

/**
 * <h1>AmazonUtil</h1>
 * Permite ingresar datos por consola.
 * <p>
 * Cuando se ingresa la informacion valida que el dato ingresado sea
 * de 0 a 6 mediante el metodo {@code validateUserResponseMenu()}.
 * </p>
 *
 * @author Drakj
 * @version 1.1
 * @since 2020
 * */

public class AmazonUtil {

    /**
     * El metodo {@code validateUserResponseMenu()} de las clase {@link AmazonUtil}
     * recibe dos parametros:
     * @param min el valor maximo de tipo {@code int}
     * @param max el vaor minimo de tipo {@code int}
     * @return retorna un valor de tipo {@code int}
     * */

    public static int validateUserResponseMenu(int min, int max) {
        //Leer la respuesta del usuario
        Scanner sc = new Scanner(System.in);

        //Validar respuesta int
        while(!sc.hasNextInt()) {
            sc.next();
            System.out.println("No ingresaste una opción válida");
            System.out.println("Intenta otra vez");
        }

        int response = sc.nextInt();

        //Validar rango de respuesta
        while(response < min || response > max) {
            //Solicitar de nuevo la respuesta
            System.out.println("No ingresaste una opción válida");
            System.out.println("Intenta otra vez");

            while(!sc.hasNextInt()) {
                sc.next();
                System.out.println("No ingresaste una opción válida");
                System.out.println("Intenta otra vez");
            }
            response = sc.nextInt();
        }
        System.out.println("Tu Respuesta fue: " + response + "\n");
        return response;
    }

}
