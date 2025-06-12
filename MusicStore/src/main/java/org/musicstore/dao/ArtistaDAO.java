package org.musicstore.dao;

import org.musicstore.database.Conexion;
import org.musicstore.model.Artista;

import java.sql.*;
import java.util.ArrayList;

public class ArtistaDAO {

    public static boolean insertar(Artista artista) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "INSERT INTO artista (nombre) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, artista.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Artista> listar() {
        ArrayList<Artista> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM artista";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Artista a = new Artista();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                lista.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean actualizar(Artista artista) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "UPDATE artista SET nombre = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, artista.getNombre());
            stmt.setInt(2, artista.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar(int id) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "DELETE FROM artista WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
