package com.aeropuertos.bl.Tripulacion;

import com.aeropuertos.bl.Tripulante.Tripulante;

import java.util.ArrayList;

public class Tripulacion {
    private String codigo;
    private String nombre;
    private ArrayList<Tripulante> tripulantes;

    public Tripulacion(){
        this.codigo = "";
        this.nombre = "";
        this.tripulantes = new ArrayList<>();
    }

    public Tripulacion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tripulantes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(ArrayList<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Tripulacion)) return false;

        Tripulacion tripulacion = (Tripulacion) pObjeto;

        if(this.getCodigo().equals(tripulacion.getCodigo())) return true;

        return false;
    }
}
