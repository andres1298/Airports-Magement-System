package com.aeropuertos.bl.Aeronave;

import com.aeropuertos.bl.Aeronave.Aeronave;

import java.util.ArrayList;

public interface AeronaveDAO {
    public void insertar(Aeronave aeronave) throws Exception;
    public void modificar(Aeronave aeronave) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Aeronave> listar() throws Exception;
}
