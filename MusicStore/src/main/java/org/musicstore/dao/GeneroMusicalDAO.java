package org.musicstore.dao;

import org.musicstore.database.Conexion;
import org.musicstore.model.GeneroMusical;

import java.sql.*;
import java.util.ArrayList;

public class GeneroMusicalDAO {

    public static boolean insertar(GeneroMusical genero) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "INSERT INTO genero_musical (descripcion) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, genero.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<GeneroMusical> listar() {
        ArrayList<GeneroMusical> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM genero_musical";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                GeneroMusical g = new GeneroMusical();
                g.setId(rs.getInt("id"));
                g.setNombre(rs.getString("descripcion"));
                lista.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean actualizar(GeneroMusical genero) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "UPDATE genero_musical SET descripcion = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, genero.getNombre());
            stmt.setInt(2, genero.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar(int id) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "DELETE FROM genero_musical WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

