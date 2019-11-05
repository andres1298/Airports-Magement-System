package com.aeropuertos.bl.Tiquete;

import java.time.LocalDate;

public class Tiquete {

    private int numeroAsiento;
    private String codigoTiquete;
    private LocalDate fechaSalida;
    private String codigoAeropuertoSalida;
    private String codigoAeropuertoDestino;
    private String codigoPaisSalida;
    private double precio;
    private String numeroVuelo;
    private String tipoAsiento;
    private String identificacionUsuario;


    public Tiquete(){
        this.numeroAsiento = 0;
        this.codigoTiquete = "";
        this.fechaSalida = LocalDate.now();
        this.codigoAeropuertoSalida = "";
        this.codigoAeropuertoDestino = "";
        this.codigoPaisSalida = "";
        this.precio = 0;
        this.numeroVuelo = "";
        this.tipoAsiento = "";
        this.identificacionUsuario = "";
    }

    public String getCodigoTiquete() {
        return codigoTiquete;
    }

    public void setCodigoTiquete(String codigoTiquete) {
        this.codigoTiquete = codigoTiquete;
    }

    public Tiquete(int numeroAsiento, String codigoTiquete, LocalDate fechaSalida, String codigoAeropuertoSalida, String codigoAeropuertoDestino, String codigoPaisSalida, int precio, String numeroVuelo, String tipoAsiento, String identificacionUsuario) {
        this.numeroAsiento = numeroAsiento;
        this.codigoTiquete = codigoTiquete;
        this.fechaSalida = fechaSalida;
        this.codigoAeropuertoSalida = codigoAeropuertoSalida;
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
        this.codigoPaisSalida = codigoPaisSalida;
        this.precio = precio;
        this.numeroVuelo = numeroVuelo;
        this.tipoAsiento = tipoAsiento;
        this.identificacionUsuario = identificacionUsuario;
    }

    public Tiquete(int numeroAsiento, String codigoTiquete, LocalDate fechaSalida, double precio, String numeroVuelo, String tipoAsiento, String identificacionUsuario) {
        this.numeroAsiento = numeroAsiento;
        this.codigoTiquete = codigoTiquete;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
        this.numeroVuelo = numeroVuelo;
        this.tipoAsiento = tipoAsiento;
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getCodigoAeropuertoSalida() {
        return codigoAeropuertoSalida;
    }

    public void setCodigoAeropuertoSalida(String codigoAeropuertoSalida) {
        this.codigoAeropuertoSalida = codigoAeropuertoSalida;
    }

    public String getCodigoAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    public void setCodigoAeropuertoDestino(String codigoAeropuertoDestino) {
        this.codigoAeropuertoDestino = codigoAeropuertoDestino;
    }

    public String getCodigoPaisSalida() {
        return codigoPaisSalida;
    }

    public void setCodigoPaisSalida(String codigoPaisSalida) {
        this.codigoPaisSalida = codigoPaisSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Tiquete)) return false;

        Tiquete tiquete = (Tiquete) pObjeto;

        if(this.getIdentificacionUsuario().equals(tiquete.getIdentificacionUsuario()) && this.getNumeroVuelo() == tiquete.getNumeroVuelo()) return true;

        return false;
    }
}
