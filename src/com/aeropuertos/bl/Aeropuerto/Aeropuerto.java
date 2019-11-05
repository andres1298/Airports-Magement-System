package com.aeropuertos.bl.Aeropuerto;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Ubicacion.Ubicacion;

import java.util.ArrayList;

public class Aeropuerto {

    private String nombre;
    private String codigo;
    private Pais pais;
    private Administrador administrador;
    private ArrayList<Ubicacion> ubicaciones;

    public Aeropuerto(){
        this.nombre = "";
        this.codigo = "";
        this.pais = new Pais();
        this.administrador = new Administrador();
        this.ubicaciones = new ArrayList<>();
    }

    public Aeropuerto(String nombre, String codigo, Pais pais, Administrador administrador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.pais = pais;
        this.administrador = administrador;
        this.ubicaciones = new ArrayList<>();
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

    public String getPais() {
        return pais.getNombre();
    }

    public String getCodigoPais() {
        return pais.getCodigo();
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getAdministrador() {
        return administrador.getNombre() + " " + administrador.getApellidos();
    }

    public String getIdentificacionAdministrador() {
        return administrador.getIdentificacion();
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Aeropuerto)) return false;

        Aeropuerto aeropuerto = (Aeropuerto) pObjeto;

        if(this.getCodigo().equals(aeropuerto.getCodigo())) return true;

        return false;
    }

    public Ubicacion crearUbicacion(String codigo, String nombre){
        Ubicacion ubicacion = new Ubicacion(nombre,codigo);
        ubicaciones.add(ubicacion);
        return ubicacion;
    }
}
