package com.cine.dao;

import com.cine.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, username, password, tipo_usuario, activo FROM usuarios";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                usuario.setActivo(rs.getBoolean("activo"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Error obteniendo usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    // Método simple para probar inserción
    public boolean crearUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, tipo_usuario) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getTipoUsuario());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error creando usuario: " + e.getMessage());
            return false;
        }
    }
}
