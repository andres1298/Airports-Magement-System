package com.aeropuertos.bl.Aeronave;

public class Aeronave {

    private String placa;
    private String marcaFabricante;
    private String modelo;
    private int capacidad;

    public Aeronave(){
        this.placa = "";
        this.marcaFabricante = "";
        this.modelo = "";
        this.capacidad = 0;
    }

    public Aeronave(String placa, String marcaFabricante, String modelo, int capacidad) {
        this.placa = placa;
        this.marcaFabricante = marcaFabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarcaFabricante() {
        return marcaFabricante;
    }

    public void setMarcaFabricante(String marcaFabricante) {
        this.marcaFabricante = marcaFabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Aeronave)) return false;

        Aeronave aeronave = (Aeronave) pObjeto;

        if(this.getPlaca().equals(aeronave.getPlaca())) return true;

        return false;
    }
}
