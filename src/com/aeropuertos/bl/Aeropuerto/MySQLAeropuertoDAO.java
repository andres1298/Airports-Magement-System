package com.aeropuertos.bl.Aeropuerto;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySQLAeropuertoDAO implements AeropuertoDAO {
    String sql = "";

    @Override
    public void insertar(Aeropuerto aeropuerto) throws Exception {
        try{
            sql = "INSERT INTO AEROPUERTOS (codigo,nombre,pais,administrador) VALUES('"+aeropuerto.getCodigo()+"','"
                    + aeropuerto.getNombre()+"','"+ aeropuerto.getCodigoPais()+"','"+ aeropuerto.getIdentificacionAdministrador() + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void modificar(Aeropuerto aeropuerto) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Aeropuerto> listar() throws Exception {
        ArrayList<Aeropuerto> lista = new ArrayList<>();

        try {
            ResultSet rs = null;
            Aeropuerto objeto = null;
            sql = "SELECT aero.codigo,aero.nombre,aero.administrador,admins.nombre,admins.apellido,admins.identificacion,admins.correo,admins.nacionalidad,day(admins.fechanacimiento) dia," +
                    "month(admins.fechanacimiento) mes, year(admins.fechanacimiento) anno, admins.direccion,admins.nacionalidad," +
                     "admins.edad,admins.genero,admins.tipo,admins.contrasena,pais.nombre,pais.codigo " +
                    "FROM aeropuertos aero " +
                    "JOIN usuarios admins ON (aero.administrador = admins.identificacion) " +
                    "JOIN paises pais ON (aero.pais = pais.codigo);";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while (rs.next()) {

                Pais pais = new Pais(rs.getString("pais.codigo"), rs.getString("pais.nombre"));

                LocalDate fechaNacimientoAdministrador = LocalDate.of(rs.getInt("anno"),rs.getInt("mes"),rs.getInt("dia"));
                Administrador administrador = new Administrador(rs.getString("admins.nombre"),
                rs.getString("admins.apellido"),rs.getString("admins.identificacion"),
                rs.getString("admins.correo"),rs.getString("admins.direccion"),
                rs.getString("admins.nacionalidad"),fechaNacimientoAdministrador,rs.getInt("admins.edad"),
                rs.getString("admins.genero"),rs.getString("admins.tipo"),rs.getString("admins.contrasena"));

                objeto = new Aeropuerto(rs.getString("aero.nombre"),
                        rs.getString("aero.codigo"), pais,administrador);
                lista.add(objeto);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
