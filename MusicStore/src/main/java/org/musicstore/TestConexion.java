package org.musicstore;

import org.musicstore.database.Conexion;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = Conexion.getConexion();
        if (conn != null) {
            System.out.println("Conexion exitosa a la base de datos.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}

