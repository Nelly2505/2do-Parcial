package org.musicstore.dao;

import org.musicstore.database.Conexion;
import org.musicstore.model.Disquera;

import java.sql.*;
import java.util.ArrayList;

public class DisqueraDAO {

    public static boolean insertar(Disquera disquera) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "INSERT INTO disquera (nombre) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, disquera.getNombre());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Disquera> listar() {
        ArrayList<Disquera> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM disquera";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Disquera d = new Disquera();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static boolean actualizar(Disquera disquera) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "UPDATE disquera SET nombre = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, disquera.getNombre());
            stmt.setInt(2, disquera.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminar(int id) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "DELETE FROM disquera WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

