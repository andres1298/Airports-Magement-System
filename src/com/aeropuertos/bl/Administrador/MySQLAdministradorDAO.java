package com.aeropuertos.bl.Administrador;

import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySQLAdministradorDAO implements AdministradorDAO{
    String sql = "";

    @Override
    public void insertar(Administrador administrador) throws Exception {
        try{
            sql = "INSERT INTO USUARIOS (identificacion,nombre,apellido,correo,nacionalidad,fechanacimiento,direccion,edad,tipo,contrasena)" +
                    "VALUES('"+administrador.getIdentificacion() +"','"+ administrador.getNombre()+"','"+ administrador.getApellidos()
                    +"','"+ administrador.getCorreo()+"','"+ administrador.getNacionalidad() +"','"+ administrador.getFechaNacimiento()
                    +"','"+ administrador.getDireccion() +"','"+ administrador.getEdad() +"','"+ administrador.getTipo()
                    +"','"+ administrador.getContrasena()  + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println(ex);
            System.out.println("El usuario no pudo ser agregado");
        }
    }

    @Override
    public void modificar(Administrador administrador) throws Exception {

    }

    @Override
    public void eliminar(String codigo) throws Exception {

    }

    @Override
    public ArrayList<Administrador> listar() throws Exception {
        ArrayList<Administrador> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Administrador objeto = null;
            sql = "SELECT nombre,apellido,identificacion,correo,nacionalidad,direccion,edad,genero,tipo,contrasena, " +
             "day(fechanacimiento) day, month(fechanacimiento) month, year(fechanacimiento) year " +
                    "FROM usuarios " +
                    "WHERE tipo = 'Administrador';";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                LocalDate fechaNacimiento = LocalDate.of(rs.getInt("year"),rs.getInt("month"),rs.getInt("day"));

                objeto = new Administrador(rs.getString("nombre"), rs.getString("apellido")
                        , rs.getString("identificacion"), rs.getString("correo")
                        , rs.getString("direccion"), rs.getString("nacionalidad")
                        , fechaNacimiento, rs.getString("tipo"),rs.getString("contrasena"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
