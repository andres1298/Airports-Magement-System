package com.aeropuertos.bl.Pais;

import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLPaisDAO implements PaisDAO {
    private String sql= "";

    @Override
    public void insertar(Pais pais) throws Exception {
        try{
            sql = "INSERT INTO PAISES (codigo,nombre) VALUES('"+pais.getCodigo()+"','"+ pais.getNombre() +"')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void modificar(Pais pais) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Pais> listar() throws Exception {
        ArrayList<Pais> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Pais objeto = null;
            sql = "SELECT * FROM PAISES";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Pais(rs.getString("codigo"),
                        rs.getString("nombre"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
