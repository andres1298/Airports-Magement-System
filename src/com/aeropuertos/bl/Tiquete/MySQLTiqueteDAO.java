package com.aeropuertos.bl.Tiquete;

import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLTiqueteDAO implements TiqueteDAO {
String sql = "";
    @Override
    public void insertar(Tiquete tiquete) throws Exception {
        try{
            sql = "INSERT INTO TIQUETES (codigo,asiento,tipoasiento,precio,fechasalida,vuelo,cliente) " +
             "VALUES('"+tiquete.getCodigoTiquete()+"',"+ tiquete.getNumeroAsiento()+",'"+ tiquete.getTipoAsiento()
                    +"',"+ tiquete.getPrecio()+",'"+ tiquete.getFechaSalida()+"','"+ tiquete.getNumeroVuelo()
                    +"','"+ tiquete.getIdentificacionUsuario() +"')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void modificar(Tiquete tiquete) throws Exception {

    }

    @Override
    public void eliminar(String string) throws Exception {

    }

    @Override
    public ArrayList<Tiquete> listar() throws Exception {
        ArrayList<Tiquete> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Tiquete objeto = null;
            sql = "select tiq.codigo,tiq.asiento,tiq.tipoasiento,tiq.precio,tiq.aeropuertosalida,tiq.aeropuertodestino,tiq.fechasalida," +
                    "tiq.paissalida,tiq.paisdestino,tiq.vuelo,tiq.cliente,vu.aeropuertosalida,vu.aeropuertodestino,vu.paisorigen " +
                    "from tiquetes tiq " +
                    "inner join vuelos vu on (tiq.vuelo = vu.codigo);";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Tiquete(rs.getInt("tiq.asiento"), rs.getString("tiq.codigo"),
                         rs.getDate("tiq.fechasalida").toLocalDate(), rs.getDouble("tiq.precio"),
                         rs.getString("tiq.vuelo"), rs.getString("tiq.tipoasiento"),
                          rs.getString("tiq.cliente"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
