package com.aeropuertos.bl.Sala;

public class Sala {

    private String nombre;
    private String codigo;

    public Sala(){
        this.nombre = "";
        this.codigo = "";
    }

    public Sala(String nombre, String codigo) {
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

        if(!(pObjeto instanceof Sala)) return false;

        Sala sala = (Sala) pObjeto;

        if(this.getCodigo().equals(sala.getCodigo())) return true;

        return false;
    }
}
