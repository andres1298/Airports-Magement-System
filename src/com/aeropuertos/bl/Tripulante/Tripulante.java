package com.aeropuertos.bl.Tripulante;

import com.aeropuertos.bl.Persona.Persona;

import java.time.LocalDate;

public class Tripulante extends Persona {
    private String numeroLicencia;
    private String puesto;
    private String genero;
    private String telefono;
    private int anosExperiencia;
    private LocalDate fechaGraduacion;

    public Tripulante(){
        super();
        this.numeroLicencia = "";
        this.puesto = "";
        this.genero = "";
        this.telefono = "";
        this.anosExperiencia = 0;
        this.fechaGraduacion = LocalDate.now();
    }

    public Tripulante(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, String tipo, String contrasena){
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.numeroLicencia = "";
        this.puesto = "";
        this.genero = "";
        this.telefono = "";
        this.anosExperiencia = 0;
        this.fechaGraduacion = LocalDate.now();
    }

    public Tripulante(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, String numeroLicencia, String puesto, String genero, String telefono, int anosExperiencia, LocalDate fechaGraduacion, String tipo, String contrasena) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.numeroLicencia = numeroLicencia;
        this.puesto = puesto;
        this.genero = genero;
        this.telefono = telefono;
        this.anosExperiencia = anosExperiencia;
        this.fechaGraduacion = fechaGraduacion;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Tripulante)) return false;

        Persona persona = (Tripulante) pObjeto;

        if(this.getIdentificacion().equals(persona.getIdentificacion())) return true;

        return false;
    }
}
