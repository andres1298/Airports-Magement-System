package com.aeropuertos.bl.Ubicacion;

import com.aeropuertos.bl.Aeropuerto.Aeropuerto;

import java.util.ArrayList;

public interface UbicacionDAO {
    public void insertar(Ubicacion ubicacion, Aeropuerto aeropuerto) throws Exception;
    public void modificar(Ubicacion ubicacion) throws Exception;
    public void eliminar(String ubicacion) throws Exception;
    public ArrayList<Ubicacion> listar() throws Exception;
}
