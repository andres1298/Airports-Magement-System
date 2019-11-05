package com.aeropuertos.bl.Administrador;

import java.util.ArrayList;

public interface AdministradorDAO {
    public void insertar(Administrador administrador) throws Exception;
    public void modificar(Administrador administrador) throws Exception;
    public void eliminar(String codigo) throws Exception;
    public ArrayList<Administrador> listar() throws Exception;
}
