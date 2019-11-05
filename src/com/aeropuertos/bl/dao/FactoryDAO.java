package com.aeropuertos.bl.dao;

import com.aeropuertos.bl.Administrador.AdministradorDAO;
import com.aeropuertos.bl.Aeronave.AeronaveDAO;
import com.aeropuertos.bl.Aeropuerto.AeropuertoDAO;
import com.aeropuertos.bl.Cliente.ClienteDAO;
import com.aeropuertos.bl.LineaAerea.LineaAereaDAO;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.Persona.PersonaDAO;
import com.aeropuertos.bl.Sala.SalaDAO;
import com.aeropuertos.bl.Tiquete.TiqueteDAO;
import com.aeropuertos.bl.Tripulacion.TripulacionDAO;
import com.aeropuertos.bl.Ubicacion.UbicacionDAO;
import com.aeropuertos.bl.Vuelo.VueloDAO;

public abstract class FactoryDAO{

    public static final int MYSQL = 1;

    public static FactoryDAO getFactoryDAO(int idRepository){
        switch(idRepository){
            // Retorna repositorio MySQL
            case MYSQL: return new MySQLFactoryDAO();

            default: return null;
        }
    }

    public abstract ClienteDAO getClienteDAO();
    public abstract PaisDAO getPaisDAO();
    public abstract AeronaveDAO getAeronaveDAO();
    public abstract SalaDAO getSalaDAO();
    public abstract UbicacionDAO getUbicacionDAO();
    public abstract AeropuertoDAO getAeropuertoDAO();
    public abstract LineaAereaDAO getLineaAereaDAO();
    public abstract AdministradorDAO getAdministradorDAO();
    public abstract PersonaDAO getPersonaDAO();
    public abstract VueloDAO getVueloDAO();
    public abstract TripulacionDAO getTripulacionDAO();
    public abstract TiqueteDAO getTiqueteDAO();
}
