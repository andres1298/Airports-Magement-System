package com.aeropuertos.bl.Pais;

public class Pais {
    private String nombre;
    private String codigo;

    public Pais(){
        this.nombre = "";
        this.codigo = "";
    }

    public Pais(String codigo, String nombre) {
        this.nombre = nombre;
        this.codigo = codigo;
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

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Pais)) return false;

        Pais pais = (Pais) pObjeto;

        if(this.getNombre().equals(pais.getNombre())) return true;

        return false;
    }
}
