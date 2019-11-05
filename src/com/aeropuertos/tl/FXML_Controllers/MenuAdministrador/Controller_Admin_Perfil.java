package com.aeropuertos.tl.FXML_Controllers.MenuAdministrador;

import com.aeropuertos.tl.Enrutador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class Controller_Admin_Perfil {

    Enrutador enrutador = new Enrutador();

    @FXML
    private TableView<?> tblAeropuertos;

    @FXML
    private TableColumn<?, ?> colUno;

    @FXML
    private TableColumn<?, ?> colDos;

    @FXML
    private TableColumn<?, ?> colTres;

    @FXML
    private TableColumn<?, ?> colCuatro;

    @FXML
    private TableColumn<?, ?> colCinco;
    @FXML
    private Button btnInicio;

    @FXML
    private Button btnAeropuertos;

    @FXML
    private Button btnVuelos;

    @FXML
    private Button btnLineasAereas;

    @FXML
    private Button btnAeronaves;

    @FXML
    private Button btnPuertaSalida;

    @FXML
    private Button btnUbicaciones;

    @FXML
    private Button btnPaises;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnSalir;

    @FXML
    void irAeronaves(ActionEvent event) throws IOException {
        enrutador.irAeronaves(event);
    }

    @FXML
    void irAeropuertos(ActionEvent event) throws IOException{
        enrutador.irAeropuertos(event);
    }

    @FXML
    void irInicio(ActionEvent event) throws IOException {
        enrutador.irInicio(event);
    }

    @FXML
    void irLineasAereas(ActionEvent event)throws IOException {
        enrutador.irLineasAereas(event);
    }

    @FXML
    void irPaises(ActionEvent event) throws IOException{
        enrutador.irPaises(event);
    }

    @FXML
    void irPerfil(ActionEvent event) throws IOException{
        enrutador.irPerfil(event);
    }

    @FXML
    void irPuertasSalida(ActionEvent event) throws IOException{
        enrutador.irPuertasSalida(event);
    }

    @FXML
    void irUbicaciones(ActionEvent event) throws IOException{
        enrutador.irUbicaciones(event);
    }

    @FXML
    void irVuelos(ActionEvent event) throws IOException{
        enrutador.irVuelos(event);
    }

    @FXML
    void salir(ActionEvent event) throws IOException{
        enrutador.salir(event);
    }
}
