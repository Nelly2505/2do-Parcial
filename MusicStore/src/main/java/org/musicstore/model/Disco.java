package org.musicstore.model;

import java.util.Date;

public class Disco {
    private int id;
    private String titulo;
    private float precio;
    private int existencia;
    private float descuento;
    private Date fechaLanzamiento;
    private String imagen;
    private int idDisquera;
    private int idArtista;
    private int idGeneroMusical;

    public Disco() {}

    public Disco(int id, String titulo, float precio, int existencia, float descuento, Date fechaLanzamiento, String imagen, int idDisquera, int idArtista, int idGeneroMusical) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.existencia = existencia;
        this.descuento = descuento;
        this.fechaLanzamiento = fechaLanzamiento;
        this.imagen = imagen;
        this.idDisquera = idDisquera;
        this.idArtista = idArtista;
        this.idGeneroMusical = idGeneroMusical;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdDisquera() {
        return idDisquera;
    }

    public void setIdDisquera(int idDisquera) {
        this.idDisquera = idDisquera;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getIdGeneroMusical() {
        return idGeneroMusical;
    }

    public void setIdGeneroMusical(int idGeneroMusical) {
        this.idGeneroMusical = idGeneroMusical;
    }
}

