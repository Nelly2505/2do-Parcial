package org.musicstore.dao;

import org.musicstore.database.Conexion;
import org.musicstore.model.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDAO {

    public static boolean insertar(Cancion cancion) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "INSERT INTO cancion (titulo, duracion, id_disco) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cancion.getTitulo());
            stmt.setString(2, cancion.getDuracion());
            stmt.setInt(3, cancion.getIdDisco());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Cancion> listar() {
        ArrayList<Cancion> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM cancion";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cancion c = new Cancion();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo"));
                c.setDuracion(rs.getString("duracion"));
                c.setIdDisco(rs.getInt("id_disco"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

