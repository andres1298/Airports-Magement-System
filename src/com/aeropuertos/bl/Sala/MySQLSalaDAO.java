package com.aeropuertos.bl.Sala;

import com.aeropuertos.bl.Ubicacion.Ubicacion;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLSalaDAO implements SalaDAO {
    String sql = "";
    @Override
    public void insertar(Sala sala, Ubicacion ubicacion) throws Exception {

        try{
            sql = "INSERT INTO SALAS (codigo,nombre,ubicacion)" +
                    "VALUES('"+sala.getCodigo() +"','"+ sala.getNombre()+"','"+ ubicacion.getCodigo() + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println("La sala no pudo ser agregada");
        }
    }

    @Override
    public void modificar(Sala sala) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Sala> listar() throws Exception {
        ArrayList<Sala> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Sala objeto = null;
            sql = "SELECT codigo,nombre FROM SALAS";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Sala(rs.getString("nombre"),
                        rs.getString("codigo"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
