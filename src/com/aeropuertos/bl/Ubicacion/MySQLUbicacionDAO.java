package com.aeropuertos.bl.Ubicacion;

import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLUbicacionDAO implements UbicacionDAO {
    String sql = "";
    @Override
    public void insertar(Ubicacion ubicacion, Aeropuerto aeropuerto) throws Exception {
        try{
            sql = "INSERT INTO UBICACIONES (codigo,nombre,aeropuerto) VALUES('"+ubicacion.getCodigo()+"','"
            + ubicacion.getNombre()+"','"+ aeropuerto.getCodigo() + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void modificar(Ubicacion ubicacion) throws Exception {

    }

    @Override
    public void eliminar(String ubicacion) throws Exception {

    }

    @Override
    public ArrayList<Ubicacion> listar() throws Exception {
        ArrayList<Ubicacion> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Ubicacion objeto = null;
            sql = "SELECT * FROM UBICACIONES";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Ubicacion(rs.getString("nombre"),
                        rs.getString("codigo"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
