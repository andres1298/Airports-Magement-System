package com.aeropuertos.bl.Sala;

import com.aeropuertos.bl.Ubicacion.Ubicacion;

import java.util.ArrayList;

public interface SalaDAO {
    public void insertar(Sala sala, Ubicacion ubicacion) throws Exception;
    public void modificar(Sala sala) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Sala> listar() throws Exception;
}
