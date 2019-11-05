package com.aeropuertos.bl.Pais;

import java.util.ArrayList;

public interface PaisDAO {
    public void insertar(Pais pais) throws Exception;
    public void modificar(Pais pais) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Pais> listar() throws Exception;
}
