package com.cine;

import com.cine.dao.DatabaseConnection;
import com.cine.dao.UsuarioDAO;
import com.cine.model.Usuario;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("🎬 Sistema de Cine - Prueba de CONSULTA solamente");

        // 1. Probar conexión
        boolean conexionExitosa = DatabaseConnection.testConnection();
        if (!conexionExitosa) {
            System.exit(1);
        }

        // 2. Solo consultar usuarios existentes
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        System.out.println("\n📋 Usuarios en la base de datos:");
        List<Usuario> usuarios = usuarioDAO.obtenerTodos();

        if (usuarios.isEmpty()) {
            System.out.println("   No hay usuarios registrados");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println("   " + usuario);
            }
            System.out.println("   Total: " + usuarios.size() + " usuarios");
        }

        System.out.println("\n✅ Prueba de CONSULTA completada exitosamente!");
    }
}