package com.aeropuertos.bl.Aeronave;

import com.aeropuertos.bl.Aeronave.Aeronave;
import com.aeropuertos.bl.Aeronave.AeronaveDAO;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLAeronaveDAO implements AeronaveDAO {
    String sql = "";

    @Override
    public void insertar(Aeronave aeronave) throws Exception {
        try{
            sql = "INSERT INTO AERONAVES (placa,fabricante,modelo,capacidad)" +
            "VALUES('"+aeronave.getPlaca() +"','"+ aeronave.getMarcaFabricante()+"','"+ aeronave.getModelo()
            + "',"+ aeronave.getCapacidad() + ")";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println("La aeronave no pudo ser agregada");
        }
    }

    @Override
    public void modificar(Aeronave aeronave) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Aeronave> listar() throws Exception {
        ArrayList<Aeronave> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Aeronave objeto = null;
            sql = "SELECT * FROM AERONAVES";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Aeronave(rs.getString("placa"),
                        rs.getString("fabricante"),
                        rs.getString("modelo"),rs.getInt("capacidad"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
