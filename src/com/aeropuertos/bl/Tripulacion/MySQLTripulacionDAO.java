package com.aeropuertos.bl.Tripulacion;

import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLTripulacionDAO implements TripulacionDAO{
    String sql = "";
    @Override
    public void insertar(Tripulacion tripulacion) throws Exception {

    }

    @Override
    public void modificar(Tripulacion tripulacion) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Tripulacion> listar() throws Exception {
        ArrayList<Tripulacion> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Tripulacion objeto = null;
            sql = "SELECT codigo,nombre FROM TRIPULACIONES";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Tripulacion(rs.getString("codigo"),
                        rs.getString("nombre"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
