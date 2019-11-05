package com.aeropuertos.tl;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Enrutador {

    /*

    UBICACIONES ADMINISTRADOR

    */

    @FXML
    public void irAeronaves(ActionEvent event) throws IOException {
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Aeronaves.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irAeropuertos(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Aeropuertos.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irInicio(ActionEvent event) throws IOException {
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Inicio.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irLineasAereas(ActionEvent event)throws IOException {
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Lineas_Aereas.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irPaises(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Paises.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irPerfil(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Perfil.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irPuertasSalida(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Salas.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irUbicaciones(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Ubicaciones.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irVuelos(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Admin_Vuelos.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irInicioCliente(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Cliente_Inicio.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irVuelosCliente(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Cliente_Vuelos.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void irPerfilCliente(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Cliente_Perfil.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void salir(ActionEvent event) throws IOException{
        Parent parentScene = FXMLLoader.load(getClass().getResource("../ui/FXML/Login.fxml"));
        Scene newScene = new Scene(parentScene);

        Stage window = (Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

}
