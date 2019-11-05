package com.aeropuertos.bl.Vuelo;

import java.util.ArrayList;

public interface VueloDAO {
    public void insertar(Vuelo vuelo) throws Exception;
    public void modificar(Vuelo vuelo) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Vuelo> listar() throws Exception;
}
