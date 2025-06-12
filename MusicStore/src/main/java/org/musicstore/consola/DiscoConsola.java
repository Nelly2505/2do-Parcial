package org.musicstore.consola;

import org.musicstore.dao.DiscoDAO;
import org.musicstore.model.Disco;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DiscoConsola {

    public static void menu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Discos ---");
            System.out.println("1. Insertar disco");
            System.out.println("2. Listar discos");
            System.out.println("0. Regresar");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Precio: ");
                        float precio = scanner.nextFloat();
                        System.out.print("Existencia: ");
                        int existencia = scanner.nextInt();
                        System.out.print("Descuento (0.0 - 1.0): ");
                        float descuento = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Fecha de lanzamiento (yyyy-MM-dd): ");
                        String fechaStr = scanner.nextLine();
                        Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr);
                        System.out.print("Ruta de imagen: ");
                        String imagen = scanner.nextLine();
                        System.out.print("ID Disquera: ");
                        int idDisquera = scanner.nextInt();
                        System.out.print("ID Artista: ");
                        int idArtista = scanner.nextInt();
                        System.out.print("ID Género Musical: ");
                        int idGenero = scanner.nextInt();

                        Disco disco = new Disco(0, titulo, precio, existencia, descuento, fecha, imagen, idDisquera, idArtista, idGenero);
                        if (DiscoDAO.insertar(disco)) System.out.println("Disco insertado correctamente");
                    } catch (Exception e) {
                        System.out.println("Error al insertar disco: " + e.getMessage());
                    }
                    break;
                case 2:
                    ArrayList<Disco> discos = DiscoDAO.listar();
                    for (Disco d : discos) {
                        System.out.println(d.getId() + " - " + d.getTitulo() + " ($" + d.getPrecio() + ")");
                    }
                    break;
            }
        } while (opcion != 0);
    }
}

