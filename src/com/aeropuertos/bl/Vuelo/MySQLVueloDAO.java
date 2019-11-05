package com.aeropuertos.bl.Vuelo;

import com.aeropuertos.bl.LineaAerea.LineaArea;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Sala.Sala;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLVueloDAO implements VueloDAO {
    String sql = "";
    @Override
    public void insertar(Vuelo vuelo) throws Exception {
        try{
            sql = "INSERT INTO VUELOS (codigo,tipo,horasalida,horallegada,estado,precio,sala,lineaarea,aeropuertosalida," +
             "aeropuertodestino,paisorigen,aeronave,tripulacion)" +
                    "VALUES('"+vuelo.getCodigo() +"','"+ vuelo.getTipo()+"','"+ vuelo.getHoraSalida()+"','"
                            + vuelo.getHoraLlegada()+"','"+ vuelo.getEstado()+"','"+ vuelo.getPrecio()
                            +"','"+ vuelo.getSala().getCodigo()+"','"+ vuelo.getLineaArea().getCedulaJuridica()
                            +"','"+ vuelo.getAeropuertoSalida().getCodigo()+"','"+ vuelo.getAeropuertoDestino().getCodigo()
                            +"','"+ vuelo.getPaisSalida().getCodigo()+"','"+ vuelo.getAeronave().getPlaca()+"','"
                            + vuelo.getTripulacion().getCodigo() +  "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void modificar(Vuelo vuelo) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Vuelo> listar() throws Exception {
        ArrayList<Vuelo> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Vuelo objeto = null;
            sql = "SELECT vu.codigo,vu.tipo,vu.horasalida,vu.estado,vu.sala,vu.lineaarea," +
                    "pais.codigo,pais.nombre," +
                    "sa.codigo,sa.nombre," +
                    "lin.nombrecomercial,lin.cedulajuridica,lin.empresa,lin.pais,paislin.codigo,paislin.nombre " +
                    "FROM vuelos vu " +
                    "JOIN paises pais on (vu.paisorigen = pais.codigo) " +
                    "JOIN salas sa on (vu.sala = sa.codigo) " +
                    "JOIN lineasaereas lin on (vu.lineaarea = lin.cedulajuridica) " +
                    "JOIN paises paislin on (lin.pais = paislin.codigo);";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                Pais paisOrigen = new Pais(rs.getString("pais.codigo"),rs.getString("pais.codigo"));
                Sala sala = new Sala(rs.getString("sa.nombre"),rs.getString("sa.codigo"));

                Pais paisLineaAerea = new Pais(rs.getString("paislin.codigo"),rs.getString("paislin.nombre"));
                LineaArea lineaArea = new LineaArea(rs.getString("lin.nombrecomercial"),
                rs.getString("lin.cedulajuridica"), rs.getString("lin.empresa"),paisLineaAerea);

                objeto = new Vuelo(rs.getString("vu.codigo"),
                        rs.getString("vu.estado"), paisOrigen, sala, lineaArea,
                        rs.getString("vu.horasalida"),  rs.getString("vu.tipo"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
