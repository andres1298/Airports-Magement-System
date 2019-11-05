package com.aeropuertos.bl.Cliente;

import com.aeropuertos.bl.Persona.Persona;
import com.aeropuertos.bl.Tiquete.Tiquete;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {

    private String distrito;
    private String canton;
    private String provincia;
    private int edad;
    private ArrayList<Tiquete> tiquetes;

    public Cliente(){
        super();
        this.distrito = "";
        this.canton = "";
        this.provincia = "";
        this.edad  = 0;
        this.tiquetes = new ArrayList<>();
    }

    public Cliente(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, String tipo, String contrasena){
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.distrito = "";
        this.canton = "";
        this.provincia = "";
        this.edad = 0;
        this.tiquetes = new ArrayList<>();
    }

    public Cliente(String nombre, String apellidos, String identificacion, String correo, String direccion, String nacionalidad, LocalDate fechaNacimiento, String distrito, String canton, String provincia, int edad, String tipo, String contrasena) {
        super(nombre, apellidos, identificacion, correo, direccion, nacionalidad, fechaNacimiento,tipo,contrasena);
        this.distrito = distrito;
        this.canton = canton;
        this.provincia = provincia;
        this.edad = edad;
        this.tiquetes = new ArrayList<>();
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof Cliente)) return false;

        Persona persona = (Cliente) pObjeto;

        if(this.getIdentificacion().equals(persona.getIdentificacion())) return true;

        return false;
    }
}
