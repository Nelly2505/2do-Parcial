package org.musicstore.model;

public class Cancion {
    private int id;
    private String titulo;
    private String duracion;
    private int idDisco;

    public Cancion() {}

    public Cancion(int id, String titulo, String duracion, int idDisco) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.idDisco = idDisco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }
}

