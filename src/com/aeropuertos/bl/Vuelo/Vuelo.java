package com.aeropuertos.bl.Vuelo;

import com.aeropuertos.bl.Aeronave.Aeronave;
import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.bl.LineaAerea.LineaArea;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Sala.Sala;
import com.aeropuertos.bl.Tripulacion.Tripulacion;

public class Vuelo {
    private String codigo;
    private LineaArea lineaArea;
    private Aeropuerto aeropuertoSalida;
    private Aeropuerto aeropuertoDestino;
    private Pais paisSalida;
    private String horaSalida;
    private String horaLlegada;
    private String estado;
    private String tipo;
    private Aeronave aeronave;
    private Sala sala;
    private Tripulacion tripulacion;
    private double precio;

    public Vuelo(){
        this.codigo = "";
        this.lineaArea = new LineaArea();
        this.aeropuertoSalida = new Aeropuerto();
        this.aeropuertoDestino = new Aeropuerto();
        this.paisSalida = new Pais();
        this.horaSalida = "";
        this.horaLlegada = "";
        this.estado = "";
        this.tipo = "";
        this.aeronave = new Aeronave();
        this.sala = new Sala();
        this.tripulacion = new Tripulacion();
        this.precio = 0;
    }

    public Vuelo(String codigo,LineaArea lineaArea, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoDestino, Pais paisSalida, String horaSalida, String horaLlegada, String estado, String tipo, Aeronave aeronave, Sala sala, Tripulacion tripulacion, double precio) {
        this.codigo = codigo;
        this.lineaArea = lineaArea;
        this.aeropuertoSalida = aeropuertoSalida;
        this.aeropuertoDestino = aeropuertoDestino;
        this.paisSalida = paisSalida;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.estado = estado;
        this.tipo = tipo;
        this.aeronave = aeronave;
        this.sala = sala;
        this.tripulacion = tripulacion;
        this.precio = precio;
    }

    public Vuelo(String codigo,String estado,Pais origen, Sala sala, LineaArea lineaArea, String horaSalida,String tipo){
        this.codigo = codigo;
        this.lineaArea = lineaArea;
        this.aeropuertoSalida = new Aeropuerto();
        this.aeropuertoDestino = new Aeropuerto();
        this.paisSalida = origen;
        this.horaSalida = horaSalida;
        this.horaLlegada = "";
        this.estado = estado;
        this.tipo = tipo;
        this.aeronave = new Aeronave();
        this.sala = sala;
        this.tripulacion = new Tripulacion();
        this.precio = 0;
    }

    public LineaArea getLineaArea() {
        return lineaArea;
    }

    public String getNombreLineaAerea(){
        return lineaArea.getNombreComercial();
    }

    public void setLineaArea(LineaArea lineaArea) {
        this.lineaArea = lineaArea;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public Pais getPaisSalida() {
        return paisSalida;
    }

    public String getNombrePaisSalida() {
        return paisSalida.getNombre();
    }

    public void setPaisSalida(Pais paisSalida) {
        this.paisSalida = paisSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public Sala getSala() {
        return sala;
    }

    public String getNombreSala() {
        return sala.getNombre();
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        this.tripulacion = tripulacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Vuelo)) return false;

        Vuelo vuelo = (Vuelo) pObjeto;

        if(this.getAeronave().equals(vuelo.getAeronave()) && this.getLineaArea() == vuelo.getLineaArea()) return true;

        return false;
    }
}
