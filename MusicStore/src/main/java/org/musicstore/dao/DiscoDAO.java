package org.musicstore.dao;

import org.musicstore.database.Conexion;
import org.musicstore.model.Disco;

import java.sql.*;
import java.util.ArrayList;

public class DiscoDAO {

    public static boolean insertar(Disco disco) {
        try (Connection conn = Conexion.getConexion()) {
            String sql = "INSERT INTO disco (titulo, precio, existencia, descuento, fecha_lanzamiento, imagen, id_disquera, id_artista, id_genero_musical) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, disco.getTitulo());
            stmt.setFloat(2, disco.getPrecio());
            stmt.setInt(3, disco.getExistencia());
            stmt.setFloat(4, disco.getDescuento());
            stmt.setDate(5, new java.sql.Date(disco.getFechaLanzamiento().getTime()));
            stmt.setString(6, disco.getImagen());
            stmt.setInt(7, disco.getIdDisquera());
            stmt.setInt(8, disco.getIdArtista());
            stmt.setInt(9, disco.getIdGeneroMusical());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Disco> listar() {
        ArrayList<Disco> lista = new ArrayList<>();
        try (Connection conn = Conexion.getConexion()) {
            String sql = "SELECT * FROM disco";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Disco d = new Disco();
                d.setId(rs.getInt("id"));
                d.setTitulo(rs.getString("titulo"));
                d.setPrecio(rs.getFloat("precio"));
                d.setExistencia(rs.getInt("existencia"));
                d.setDescuento(rs.getFloat("descuento"));
                d.setFechaLanzamiento(rs.getDate("fecha_lanzamiento"));
                d.setImagen(rs.getString("imagen"));
                d.setIdDisquera(rs.getInt("id_disquera"));
                d.setIdArtista(rs.getInt("id_artista"));
                d.setIdGeneroMusical(rs.getInt("id_genero_musical"));
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

