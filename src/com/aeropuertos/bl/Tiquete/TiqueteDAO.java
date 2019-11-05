package com.aeropuertos.bl.Tiquete;

import java.util.ArrayList;

public interface TiqueteDAO {
    public void insertar(Tiquete tiquete) throws Exception;
    public void modificar(Tiquete tiquete) throws Exception;
    public void eliminar(String string) throws Exception;
    public ArrayList<Tiquete> listar() throws Exception;
}
