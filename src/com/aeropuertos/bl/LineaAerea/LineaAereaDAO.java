package com.aeropuertos.bl.LineaAerea;

import java.util.ArrayList;

public interface LineaAereaDAO {
    public void insertar(LineaArea lineaArea) throws Exception;
    public void modificar(LineaArea lineaArea) throws Exception;
    public void eliminar(String lineaArea) throws Exception;
    public ArrayList<LineaArea> listar() throws Exception;
}
