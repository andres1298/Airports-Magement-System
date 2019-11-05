package com.aeropuertos.bl.Aeropuerto;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Pais.Pais;

import java.util.ArrayList;

public interface AeropuertoDAO {
    public void insertar(Aeropuerto aeropuerto) throws Exception;
    public void modificar(Aeropuerto aeropuerto) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Aeropuerto> listar() throws Exception;
}
