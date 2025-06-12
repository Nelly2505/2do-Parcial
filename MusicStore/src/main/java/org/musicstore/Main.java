package org.musicstore;

import org.musicstore.consola.CatalogosConsola;
import org.musicstore.consola.DiscoConsola;
import org.musicstore.consola.CancionConsola;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("***** MUSIC STORE *****");
            System.out.println("1. Gestion de Generos Musicales");
            System.out.println("2. Gestion de Disqueras");
            System.out.println("3. Gestion de Artistas");
            System.out.println("4. Gestion de Discos");
            System.out.println("5. Gestion de Canciones");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    CatalogosConsola.menuGenero(scanner);
                    break;
                case 2:
                    CatalogosConsola.menuDisquera(scanner);
                    break;
                case 3:
                    CatalogosConsola.menuArtista(scanner);
                    break;
                case 4:
                    DiscoConsola.menu(scanner);
                    break;
                case 5:
                    CancionConsola.menu(scanner);
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
