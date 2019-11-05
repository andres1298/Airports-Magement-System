package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Aeronave.Aeronave;
import com.aeropuertos.bl.Aeronave.AeronaveDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller_Registrar_Aeronave {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private AeronaveDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private TextField txtCuarto;

    @FXML
    private Button btnRegistrar;

    @FXML
    void registrarDatos(ActionEvent event) {
        String placa, modelo, marca;
        int capacidad = 0;
        dao = factory.getAeronaveDAO();
        boolean error = false;

        placa = txtPrimero.getText();
        marca = txtSegundo.getText();
        modelo = txtTercero.getText();
        capacidad = Integer.parseInt(txtCuarto.getText());

        if(placa.equals("")){
            error = true;
        }
        if(modelo.equals("")){
            error = true;
        }
        if(marca.equals("")){
            error = true;
        }
        if(capacidad == 0){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            if(buscarAeronavae(placa)){
                Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            else{
                try{
                    Aeronave aeronave = new Aeronave(placa,marca,modelo,capacidad);

                    dao.insertar(aeronave);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                    window.close();

                }catch(Exception e) {
                    System.out.println(e);
                }
            }

        }
    }

    private boolean buscarAeronavae(String codigo){
        ArrayList<Aeronave> lista;

        try {
            dao = factory.getAeronaveDAO();
            lista = dao.listar();

            for(Aeronave objeto: lista){
                if(objeto.getPlaca().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
