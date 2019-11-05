package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.bl.Aeropuerto.AeropuertoDAO;
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

public class Controller_Registrar_Ubicacion {
    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private UbicacionDAO dao;
    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private Button btnRegistrar;

    @FXML
    void registrarDatos(ActionEvent event) {
        String nombre,codigo,aeropuerto;
        dao = factory.getUbicacionDAO();
        boolean error = false;

        nombre = txtPrimero.getText();
        codigo = txtSegundo.getText();
        aeropuerto = txtTercero.getText();

        if(codigo.equals("")){
            error = true;
        }
        if(nombre.equals("")){
            error = true;
        }
        if(aeropuerto.equals("")){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarUbicacion(codigo)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                Aeropuerto contenedor = obtenerAeropuerto(aeropuerto);
                if (contenedor != null) {
                    Ubicacion ubicacion = contenedor.crearUbicacion(codigo, nombre);

                    dao.insertar(ubicacion, contenedor);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El aeropuerto no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean buscarUbicacion(String codigo){
        ArrayList<Ubicacion> lista;

        try {

            lista = dao.listar();

            for(Ubicacion objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Aeropuerto obtenerAeropuerto(String aeropuerto){
        ArrayList<Aeropuerto> lista;
        AeropuertoDAO aeropuertoDAO = factory.getAeropuertoDAO();
        try{

            lista = aeropuertoDAO.listar();

            for(Aeropuerto objeto: lista){
                if(objeto.getCodigo().equals(aeropuerto)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

}
