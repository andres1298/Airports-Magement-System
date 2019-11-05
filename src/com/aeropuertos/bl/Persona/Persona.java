package com.aeropuertos.bl.Persona;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String direccion;
    private String nacionalidad;
    private LocalDate fechaNacimiento;
    private String tipo;
    private String contrasena;

    public Persona(){
        this.nombre = "";
        this.apellidos = "";
        this.identificacion = "";
        this.correo = "";
        this.direccion = "";
        this.nacionalidad = "";
        this.fechaNacimiento = LocalDate.now();
        this.tipo = "";
        this.contrasena = "";
    }

    public Persona(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento,String tipo,String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Persona)) return false;

        Persona usuario = (Persona) pObjeto;

        if(this.getIdentificacion().equals(usuario.getIdentificacion())) return true;

        return false;
    }
}
