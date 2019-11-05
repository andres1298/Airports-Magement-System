package com.aeropuertos.bl.Cliente;

import java.util.ArrayList;

public interface ClienteDAO {
    public void insertar(Cliente cliente) throws Exception;
    public void modificar(Cliente cliente) throws Exception;
    public void eliminar(int id) throws Exception;
    public ArrayList<Cliente> listar() throws Exception;
}
