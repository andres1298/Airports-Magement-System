package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Administrador.AdministradorDAO;
import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.bl.Aeropuerto.AeropuertoDAO;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller_Registrar_Aeropuerto {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private AeropuertoDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private TextField txtCuarto;

    @FXML
    void registrarDatos(ActionEvent event) {
        String nombre,codigo,identificacionAdministrador,codigoPais;
        dao = factory.getAeropuertoDAO();
        boolean error = false;

        nombre = txtPrimero.getText();
        codigo = txtSegundo.getText();
        codigoPais = txtTercero.getText();
        identificacionAdministrador = txtCuarto.getText();
        if(nombre.equals("")){
            error = true;
        }
        if(codigo.equals("")){
            error = true;
        }
        if(codigoPais.equals("")){
            error = true;
        }
        if(identificacionAdministrador.equals("")){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarAeropuerto(codigo)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                Pais pais = obtenerPais(codigoPais);
                Administrador administrador = obtenerAdministrador(identificacionAdministrador);
                if (pais == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El pais no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if(administrador == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El administrador no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else{
                    Aeropuerto aeropuerto = new Aeropuerto(nombre, codigo, pais, administrador);

                    dao.insertar(aeropuerto);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }


        }
    }

    private boolean buscarAeropuerto(String codigo){
        ArrayList<Aeropuerto> lista;

        try {

            lista = dao.listar();

            for(Aeropuerto objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Administrador obtenerAdministrador(String administrador){
        ArrayList<Administrador> lista;
        AdministradorDAO administradorDAO = factory.getAdministradorDAO();
        try {

            lista = administradorDAO.listar();

            for(Administrador objeto: lista){
                if(objeto.getIdentificacion().equals(administrador)){
                    return objeto;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Pais obtenerPais(String pais){
        ArrayList<Pais> lista;
        PaisDAO paisDAO = factory.getPaisDAO();
        try{

            lista = paisDAO.listar();

            for(Pais objeto: lista){
                if(objeto.getCodigo().equals(pais)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

}
