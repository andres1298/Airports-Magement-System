package com.aeropuertos.dl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Conector {

    static final String NOMBRE_ARCHIVO = "src/com/aeropuertos/Archivo.txt";

    private static AccesoBD conectorBD = null;

    public static AccesoBD getConnector() throws Exception{

        String[] datosConector = leerArchivo();

        if(conectorBD == null) {
            conectorBD = new AccesoBD(datosConector[0],
                    datosConector[1],datosConector[2],datosConector[3]);
        }
        return conectorBD;
    }

    private static String[] leerArchivo(){
        String[] datosConector = new String[4];
        try
        {
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            int posicion = 0;
            while((datos = buffer.readLine()) != null)
            {
                datosConector[posicion] = datos;
                posicion++;
            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return datosConector;
    }
}
