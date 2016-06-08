package com.patriciamape.appbdtesoros;

/**
 * Created by Patri on 01/03/2016.
 */
public class Pista {
    private int idPista;
    private String nombrePista;
    private String pregunta;
    private String solucion;
    private int respuesta;
    private int id;



    public Pista() {
    }

    public Pista(String nombrePista, int idPista, String pregunta, String solucion, int respuesta, int id) {
        this.nombrePista = nombrePista;
        this.idPista = idPista;
        this.pregunta = pregunta;
        this.solucion = solucion;
        this.respuesta = respuesta;
        this.id = id;
    }

    public int getIdPista() {
        return idPista;
    }

    public String getNombrePista() {
        return nombrePista;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getSolucion() {
        return solucion;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public void setNombrePista(String nombrePista) {
        this.nombrePista = nombrePista;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public void setRespuesta(int respuesta) {

        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
