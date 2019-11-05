package com.aeropuertos.bl.Cliente;

import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySQLClienteDAO implements ClienteDAO {
    String sql = "";
    @Override
    public void insertar(Cliente cliente) throws Exception {
        try{
                sql = "INSERT INTO USUARIOS (identificacion,nombre,apellido,correo," +
                 "nacionalidad,fechanacimiento,direccion,distrito,canton,provincia,edad,tipo,contrasena)" +
                    "VALUES('"+cliente.getIdentificacion() +"','"+ cliente.getNombre()+"','"+ cliente.getApellidos()
                        +"','"+ cliente.getCorreo()+"','"+ cliente.getNacionalidad() +"','"+ cliente.getFechaNacimiento()
                        +"','"+ cliente.getDireccion() +"','"+ cliente.getDistrito() +"','"+ cliente.getCanton()
                        +"','"+ cliente.getProvincia() +"',"+ cliente.getEdad() + ",'Cliente'" + ",'" + cliente.getContrasena() + "')";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex){
            System.out.println(ex);
            System.out.println("El usuario no pudo ser agregado");
        }
    }

    @Override
    public void modificar(Cliente cliente) throws Exception {

    }

    @Override
    public void eliminar(int id) throws Exception {

    }

    @Override
    public ArrayList<Cliente> listar() throws Exception {
        ArrayList<Cliente> lista = new ArrayList<>();

        try{
            ResultSet rs = null;
            Cliente objeto = null;
            sql = "SELECT identificacion,nombre,apellido,correo,nacionalidad,fechanacimiento,direccion,distrito,canton,provincia,edad,tipo,contrasena " +
                    "FROM usuarios " +
                    "WHERE tipo = 'Cliente';";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                objeto = new Cliente(rs.getString("nombre"),rs.getString("apellido"),
                        rs.getString("identificacion"),rs.getString("correo"),
                        rs.getString("direccion"),rs.getString("nacionalidad"),
                        rs.getDate("fechanacimiento").toLocalDate(),rs.getString("distrito"),
                        rs.getString("canton"),rs.getString("provincia"),rs.getInt("edad"),
                        rs.getString("tipo"),rs.getString("contrasena"));
                lista.add(objeto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
