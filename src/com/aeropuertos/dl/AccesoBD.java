package com.aeropuertos.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conn = null;
    private Statement stmt = null;

    // driver = "com.mysql.jdbc.Driver"
    // url= jdbc:mysql://localhost/laboratorio?autoReconnect=true&useSSL=false
    // user = prueba
    // pasword= ""
    public AccesoBD(String driver,String url, String user, String passwod) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,passwod);
        stmt = conn.createStatement();
    }

    // Se usa para Inseret, Update, Delete
    public void ejecutarSql(String query) throws Exception {
        stmt.executeUpdate(query);
    }

    // Este se usa para los select
    public ResultSet ejecutarQuery(String query) throws Exception {
        ResultSet rs = null;
        rs = stmt.executeQuery(query);
        return rs;
    }

}
