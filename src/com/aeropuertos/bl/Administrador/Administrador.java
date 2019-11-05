package com.aeropuertos.bl.Administrador;

import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.bl.Persona.Persona;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador extends Persona {

    private int edad;
    private String genero;
    private ArrayList<Aeropuerto> aeropuertos;

    public Administrador(){
        super();
        this.edad = 0;
        this.genero = "";
        this.aeropuertos = new ArrayList<>();
    }

    public Administrador(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, String tipo, String contrasena){
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.edad = 0;
        this.genero = "";
        this.aeropuertos = new ArrayList<>();
    }

    public Administrador(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, int edad, String genero, String tipo, String contrasena) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.edad = edad;
        this.genero = genero;
        this.aeropuertos = new ArrayList<>();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Administrador)) return false;

        Persona persona = (Administrador) pObjeto;

        if(this.getIdentificacion().equals(persona.getIdentificacion())) return true;

        return false;
    }
}
