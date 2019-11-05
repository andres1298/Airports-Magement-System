package com.aeropuertos.bl.Ubicacion;

import com.aeropuertos.bl.Sala.Sala;

import java.util.ArrayList;

public class Ubicacion {
    private String nombre;
    private String codigo;
    private ArrayList<Sala> salas;

    public Ubicacion(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = codigo;
        this.salas = new ArrayList<>();
    }

    public Ubicacion(){
        this.nombre = "";
        this.codigo = "";
        this.salas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Ubicacion)) return false;

        Ubicacion ubicacion = (Ubicacion) pObjeto;

        if(this.getCodigo().equals(ubicacion.getCodigo())) return true;

        return false;
    }

    public Sala crearSala(String codigo, String nombre){
        Sala sala = new Sala(nombre,codigo);
        salas.add(sala);
        return sala;
    }
}
