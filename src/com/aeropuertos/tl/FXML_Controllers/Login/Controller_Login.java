package com.aeropuertos.tl.FXML_Controllers.Login;

import com.aeropuertos.bl.Cliente.Cliente;
import com.aeropuertos.bl.Cliente.ClienteDAO;
import com.aeropuertos.bl.Persona.Persona;
import com.aeropuertos.bl.Persona.PersonaDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Login implements Initializable {

    private FactoryDAO factory = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private PersonaDAO dao;

    @FXML
    private TextField txtCorreo;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    void crearCuenta(ActionEvent event) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Cliente_Registrar.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuevo registro");
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void validarDatos(ActionEvent event) {
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        boolean registrado = false;
        boolean error = false;

        error = validarCampos(correo, contrasena);

        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            registrado = buscarUsuario(correo, contrasena);
            if (registrado) {
                String tipoUsuario = obtenerTipoUsuario(correo, contrasena);
                cambiarEscena(tipoUsuario,event);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "El usuario no se encuentra registrado");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
    }

    @FXML
    void ingresar(ActionEvent event) throws IOException {
    }

    private boolean validarCampos(String correo, String contrasena) {
        boolean error = false;

        if (correo.equals("")) {
            error = true;
        }
        if (contrasena.equals("")) {
            error = true;
        }
        return error;
    }

    private boolean buscarUsuario(String correo, String contrasena) {
        ArrayList<Persona> lista;

        try {
            dao = factory.getPersonaDAO();
            lista = dao.listar();

            for (Persona objeto : lista) {
                if (objeto.getCorreo().equals(correo) && objeto.getContrasena().equals(contrasena)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String obtenerTipoUsuario(String correo, String contrasena) {
        ArrayList<Persona> lista;

        try {
            dao = factory.getPersonaDAO();
            lista = dao.listar();

            for (Persona objeto : lista) {
                if (objeto.getCorreo().equals(correo) && objeto.getContrasena().equals(contrasena)) {
                    return objeto.getTipo();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void cambiarEscena(String tipoUsuario, ActionEvent event){
        try {
            switch (tipoUsuario) {
                case "Administrador":
                    Parent parentScene = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Admin_Inicio.fxml"));
                    Scene newScene = new Scene(parentScene);

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                    window.setScene(newScene);
                    window.show();
                    break;

                case "Cliente":
                    Parent parentScene2 = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Cliente_Inicio.fxml"));
                    Scene newScene2 = new Scene(parentScene2);

                    Stage window2 = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

                    window2.setScene(newScene2);
                    window2.show();
                    break;

                case "Tripulante":
                    System.out.println("tripu");
                    break;
            }

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al cambiar de ventana. Intente de nuevo.");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.out.println(e);
        }
    }

    public boolean validarAdministrador(){
        ArrayList<Persona> lista;
        dao = factory.getPersonaDAO();
        try{
            lista = dao.listar();
            for(Persona objeto : lista){
                if(objeto.getTipo().equals("Administrador")){
                    return true;
                }
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error al verificar los administradores");
        }
        return false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!validarAdministrador()){
            try {

                Parent root = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Registrar_Administrador.fxml"));
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Nuevo registro");
                stage.resizableProperty().setValue(Boolean.FALSE);
                stage.setScene(new Scene(root));
                stage.showAndWait();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("comprobado");
    }
}
