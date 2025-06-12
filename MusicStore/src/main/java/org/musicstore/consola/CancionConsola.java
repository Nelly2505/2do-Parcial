package org.musicstore.consola;

import org.musicstore.dao.CancionDAO;
import org.musicstore.model.Cancion;

import java.util.ArrayList;
import java.util.Scanner;

public class CancionConsola {

    public static void menu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestion de Canciones ---");
            System.out.println("1. Insertar cancion");
            System.out.println("2. Listar canciones");
            System.out.println("0. Regresar");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Duracion (hh:mm:ss): ");
                    String duracion = scanner.nextLine();
                    System.out.print("ID del disco: ");
                    int idDisco = scanner.nextInt();

                    Cancion cancion = new Cancion(0, titulo, duracion, idDisco);
                    if (CancionDAO.insertar(cancion)) {
                        System.out.println("Cancion insertada correctamente");
                    }
                    break;
                case 2:
                    ArrayList<Cancion> canciones = CancionDAO.listar();
                    for (Cancion c : canciones) {
                        System.out.println(c.getId() + ". " + c.getTitulo() + " [" + c.getDuracion() + "]");
                    }
                    break;
            }
        } while (opcion != 0);
    }
}

