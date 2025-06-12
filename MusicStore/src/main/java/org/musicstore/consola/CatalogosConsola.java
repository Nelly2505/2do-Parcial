package org.musicstore.consola;

import org.musicstore.dao.ArtistaDAO;
import org.musicstore.dao.DisqueraDAO;
import org.musicstore.dao.GeneroMusicalDAO;
import org.musicstore.model.Artista;
import org.musicstore.model.Disquera;
import org.musicstore.model.GeneroMusical;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogosConsola {

    public static void menuGenero(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestion de Generos Musicales ---");
            System.out.println("1. Insertar genero");
            System.out.println("2. Listar generos");
            System.out.println("3. Actualizar genero");
            System.out.println("4. Eliminar genero");
            System.out.println("0. Regresar");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del genero: ");
                    String nombreG = scanner.nextLine();
                    GeneroMusical genero = new GeneroMusical(0, nombreG);
                    if (GeneroMusicalDAO.insertar(genero)) System.out.println("Insertado correctamente");
                    break;
                case 2:
                    ArrayList<GeneroMusical> generos = GeneroMusicalDAO.listar();
                    generos.forEach(g -> System.out.println(g.getId() + ". " + g.getNombre()));
                    break;
                case 3:
                    System.out.print("ID a actualizar: ");
                    int idG = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoG = scanner.nextLine();
                    if (GeneroMusicalDAO.actualizar(new GeneroMusical(idG, nuevoG)))
                        System.out.println("Actualizado correctamente");
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idGE = scanner.nextInt();
                    if (GeneroMusicalDAO.eliminar(idGE)) System.out.println("Eliminado correctamente");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuDisquera(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestion de Disqueras ---");
            System.out.println("1. Insertar disquera");
            System.out.println("2. Listar disqueras");
            System.out.println("3. Actualizar disquera");
            System.out.println("4. Eliminar disquera");
            System.out.println("0. Regresar");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la disquera: ");
                    String nombreD = scanner.nextLine();
                    Disquera disquera = new Disquera(0, nombreD);
                    if (DisqueraDAO.insertar(disquera)) System.out.println("Insertado correctamente");
                    break;
                case 2:
                    ArrayList<Disquera> disqueras = DisqueraDAO.listar();
                    disqueras.forEach(d -> System.out.println(d.getId() + ". " + d.getNombre()));
                    break;
                case 3:
                    System.out.print("ID a actualizar: ");
                    int idD = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoD = scanner.nextLine();
                    if (DisqueraDAO.actualizar(new Disquera(idD, nuevoD)))
                        System.out.println("Actualizado correctamente");
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idDE = scanner.nextInt();
                    if (DisqueraDAO.eliminar(idDE)) System.out.println("Eliminado correctamente");
                    break;
            }
        } while (opcion != 0);
    }

    public static void menuArtista(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestion de Artistas ---");
            System.out.println("1. Insertar artista");
            System.out.println("2. Listar artistas");
            System.out.println("3. Actualizar artista");
            System.out.println("4. Eliminar artista");
            System.out.println("0. Regresar");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del artista: ");
                    String nombreA = scanner.nextLine();
                    Artista artista = new Artista(0, nombreA);
                    if (ArtistaDAO.insertar(artista)) System.out.println("Insertado correctamente");
                    break;
                case 2:
                    ArrayList<Artista> artistas = ArtistaDAO.listar();
                    artistas.forEach(a -> System.out.println(a.getId() + ". " + a.getNombre()));
                    break;
                case 3:
                    System.out.print("ID a actualizar: ");
                    int idA = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoA = scanner.nextLine();
                    if (ArtistaDAO.actualizar(new Artista(idA, nuevoA)))
                        System.out.println("Actualizado correctamente");
                    break;
                case 4:
                    System.out.print("ID a eliminar: ");
                    int idAE = scanner.nextInt();
                    if (ArtistaDAO.eliminar(idAE)) System.out.println("Eliminado correctamente");
                    break;
            }
        } while (opcion != 0);
    }
}

