package com.patriciamape.appbdtesoros;

/**
 * Created by Patri on 03/02/2016.
 */
public class Tesoro {
    private int id;
    private String nombre;
    private int estrellas;

    public Tesoro() {
    }

    public Tesoro(String nombre, int estrellas) {
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    public Tesoro(int id, String nombre, int estrellas) {
        this.id = id;
        this.nombre = nombre;
        this.estrellas = estrellas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
}
