package com.aeropuertos.bl.Persona;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Cliente.Cliente;
import com.aeropuertos.bl.Tripulante.Tripulante;
import com.aeropuertos.dl.Conector;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class MySQLPersonaDAO implements PersonaDAO{
    private String sql= "";

    @Override
    public ArrayList<Persona> listar() throws Exception {
        ArrayList<Persona> lista = new ArrayList<>();
        LocalDate fechaNacimiento;

        try{
            ResultSet rs = null;
            Persona objeto = null;
            sql = "SELECT *, day(fechanacimiento) day, month(fechanacimiento) month, year(fechanacimiento) year FROM USUARIOS";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                switch (rs.getString("tipo")){

                    case "Administrador":
                        fechaNacimiento = LocalDate.of(rs.getInt("year"),rs.getInt("month"),rs.getInt("day"));

                        objeto = new Administrador(rs.getString("nombre"), rs.getString("apellido")
                                , rs.getString("identificacion"), rs.getString("correo")
                                , rs.getString("direccion"), rs.getString("nacionalidad")
                                , fechaNacimiento,"Administrador",rs.getString("contrasena"));
                        lista.add(objeto);

                        break;

                    case "Cliente":

                       fechaNacimiento = LocalDate.of(rs.getInt("year"),rs.getInt("month"),rs.getInt("day"));

                        objeto = new Cliente(rs.getString("nombre"), rs.getString("apellido")
                                , rs.getString("identificacion"), rs.getString("correo")
                                , rs.getString("direccion"), rs.getString("nacionalidad")
                                , fechaNacimiento,"Cliente",rs.getString("contrasena"));
                        lista.add(objeto);

                        break;

                    case "Tripulante":

                        fechaNacimiento = LocalDate.of(rs.getInt("year"),rs.getInt("month"),rs.getInt("day"));

                        objeto = new Tripulante(rs.getString("nombre"), rs.getString("apellido")
                                , rs.getString("identificacion"), rs.getString("correo")
                                , rs.getString("direccion"), rs.getString("nacionalidad")
                                , fechaNacimiento,"Tripulante",rs.getString("contrasena"));
                        lista.add(objeto);

                        break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
