package com.aeropuertos.bl.dao;

import com.aeropuertos.bl.Administrador.AdministradorDAO;
import com.aeropuertos.bl.Administrador.MySQLAdministradorDAO;
import com.aeropuertos.bl.Aeronave.AeronaveDAO;
import com.aeropuertos.bl.Aeronave.MySQLAeronaveDAO;
import com.aeropuertos.bl.Aeropuerto.AeropuertoDAO;
import com.aeropuertos.bl.Aeropuerto.MySQLAeropuertoDAO;
import com.aeropuertos.bl.Cliente.ClienteDAO;
import com.aeropuertos.bl.Cliente.MySQLClienteDAO;
import com.aeropuertos.bl.LineaAerea.LineaAereaDAO;
import com.aeropuertos.bl.LineaAerea.MySQLLineaAereaDAO;
import com.aeropuertos.bl.Pais.MySQLPaisDAO;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.Persona.MySQLPersonaDAO;
import com.aeropuertos.bl.Persona.PersonaDAO;
import com.aeropuertos.bl.Sala.MySQLSalaDAO;
import com.aeropuertos.bl.Sala.SalaDAO;
import com.aeropuertos.bl.Tiquete.MySQLTiqueteDAO;
import com.aeropuertos.bl.Tiquete.TiqueteDAO;
import com.aeropuertos.bl.Tripulacion.MySQLTripulacionDAO;
import com.aeropuertos.bl.Tripulacion.TripulacionDAO;
import com.aeropuertos.bl.Ubicacion.MySQLUbicacionDAO;
import com.aeropuertos.bl.Ubicacion.UbicacionDAO;
import com.aeropuertos.bl.Vuelo.MySQLVueloDAO;
import com.aeropuertos.bl.Vuelo.VueloDAO;

public class MySQLFactoryDAO extends FactoryDAO {
    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAO();
    }
    public PaisDAO getPaisDAO() {
        return new MySQLPaisDAO();
    }
    public AeronaveDAO getAeronaveDAO() {
    return new MySQLAeronaveDAO() {
        };
    }
    public SalaDAO getSalaDAO() {
        return new MySQLSalaDAO();
    }

    @Override
    public UbicacionDAO getUbicacionDAO() {
        return new MySQLUbicacionDAO();
    }

    @Override
    public VueloDAO getVueloDAO() {
        return new MySQLVueloDAO();
    }

    @Override
    public PersonaDAO getPersonaDAO() {
        return new MySQLPersonaDAO();
    }

    @Override
    public AdministradorDAO getAdministradorDAO() {
        return new MySQLAdministradorDAO();
    }

    @Override
    public LineaAereaDAO getLineaAereaDAO() {
        return new MySQLLineaAereaDAO();
    }

    @Override
    public AeropuertoDAO getAeropuertoDAO() {
        return new MySQLAeropuertoDAO();
    }

    @Override
    public TripulacionDAO getTripulacionDAO() {
        return new MySQLTripulacionDAO();
    }

    @Override
    public TiqueteDAO getTiqueteDAO() {
        return new MySQLTiqueteDAO();
    }
}
