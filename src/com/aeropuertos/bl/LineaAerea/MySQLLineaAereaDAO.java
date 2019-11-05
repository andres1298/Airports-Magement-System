package com.aeropuertos.bl.LineaAerea;

import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.dl.Conector;

import javax.sound.sampled.Line;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLLineaAereaDAO implements LineaAereaDAO {
    private String sql= "";

    @Override
    public void insertar(LineaArea lineaArea) throws Exception {
        try{
            sql = "INSERT INTO LINEASAEREAS (nombrecomercial,cedulajuridica,empresa,pais)" +
                    "VALUES('"+lineaArea.getNombreComercial() +"','"+ lineaArea.getCedulaJuridica()+"','"+ lineaArea.getEmpresa()+"','"
                    + lineaArea.getCodigoPais() + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println("La linea aerea no pudo ser agregada");
        }
    }

    @Override
    public void modificar(LineaArea lineaArea) throws Exception {

    }

    @Override
    public void eliminar(String lineaArea) throws Exception {

    }

    @Override
    public ArrayList<LineaArea> listar() throws Exception {
        ArrayList<LineaArea> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            LineaArea objeto = null;
            sql = "select lin.cedulajuridica, lin.nombrecomercial, lin.empresa, lin.pais, pais.nombre, pais.codigo " +
                    "from lineasaereas lin " +
                    "join paises pais on (lin.pais = pais.codigo);";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                Pais pais = new Pais(rs.getString("pais.codigo"),rs.getString("pais.nombre"));

                objeto = new LineaArea(rs.getString("lin.nombrecomercial"),
                rs.getString("lin.cedulajuridica"), rs.getString("lin.empresa"),pais);

                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
