package com.aeropuertos.tl.FXML_Controllers.Registrar;

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

public class Controller_Registrar_Pais {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private PaisDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    void registrarDatos(ActionEvent event) {
        String codigo, nombre;
        dao = factory.getPaisDAO();
        boolean error = false;

        nombre = txtPrimero.getText();
        codigo = txtSegundo.getText();

        if(codigo.equals("")){
            error = true;
        }
        if(nombre.equals("")){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            if(buscarPais(codigo)){
                Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
            else{
                try{
                    Pais pais = new Pais(codigo,nombre);

                    dao.insertar(pais);
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

    private boolean buscarPais(String codigo){
        ArrayList<Pais> lista;

        try {
            dao = factory.getPaisDAO();
            lista = dao.listar();

            for(Pais objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
