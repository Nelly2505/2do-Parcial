package org.musicstore.util;

import java.util.Scanner;

public class ReadUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("ingresa un numero valido.");
            scanner.next(); // descarta entrada inválida
            System.out.print(mensaje);
        }
        return scanner.nextInt();
    }

    public static float readFloat(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextFloat()) {
            System.out.println("Ingresa un numero decimal valido.");
            scanner.next();
            System.out.print(mensaje);
        }
        return scanner.nextFloat();
    }

    public static String readString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}

