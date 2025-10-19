package com.cine.model;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String tipoUsuario;
    private boolean activo;

    // Constructores
    public Usuario() {}

    public Usuario(String username, String password, String tipoUsuario) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.activo = true;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public String toString() {
        return String.format("Usuario{id=%d, username='%s', tipo='%s', activo=%s}",
                id, username, tipoUsuario, activo);
    }
}