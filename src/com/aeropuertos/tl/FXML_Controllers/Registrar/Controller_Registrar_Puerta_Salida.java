package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Sala.Sala;
import com.aeropuertos.bl.Sala.SalaDAO;
import com.aeropuertos.bl.Ubicacion.Ubicacion;
import com.aeropuertos.bl.Ubicacion.UbicacionDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller_Registrar_Puerta_Salida {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private SalaDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;


    @FXML
    void registrarDatos(ActionEvent event) {
        String nombre,codigo,ubicacion;
        dao = factory.getSalaDAO();
        boolean error = false;

        nombre = txtPrimero.getText();
        codigo = txtSegundo.getText();
        ubicacion = txtTercero.getText();

        if(codigo.equals("")){
            error = true;
        }
        if(nombre.equals("")){
            error = true;
        }
        if(ubicacion.equals("")){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarSala(codigo)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                Ubicacion contenedor = obtenerUbicacion(ubicacion);
                if (contenedor != null) {
                    Sala sala = contenedor.crearSala(codigo, nombre);

                    dao.insertar(sala, contenedor);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La ubicacion no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    private boolean buscarSala(String codigo){
        ArrayList<Sala> lista;

        try {

            lista = dao.listar();

            for(Sala objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Ubicacion obtenerUbicacion(String codigo){
        ArrayList<Ubicacion> lista;
        UbicacionDAO ubicacionDAO = factory.getUbicacionDAO();
        try{

            lista = ubicacionDAO.listar();

            for(Ubicacion objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

}
