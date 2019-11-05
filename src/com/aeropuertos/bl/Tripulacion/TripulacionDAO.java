package com.aeropuertos.bl.Tripulacion;

import java.util.ArrayList;

public interface TripulacionDAO {
    public void insertar(Tripulacion tripulacion) throws Exception;
    public void modificar(Tripulacion tripulacion) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Tripulacion> listar() throws Exception;
}
