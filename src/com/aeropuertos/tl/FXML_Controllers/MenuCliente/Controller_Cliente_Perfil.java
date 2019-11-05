package com.aeropuertos.tl.FXML_Controllers.MenuCliente;

import com.aeropuertos.tl.Enrutador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Controller_Cliente_Perfil {
    Enrutador enrutador = new Enrutador();
    @FXML
    private Button btnInicio;

    @FXML
    private Button btnVuelos;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnSalir;

    @FXML
    void irInicioCliente(ActionEvent event) throws IOException {
        enrutador.irInicioCliente(event);
    }

    @FXML
    void irPerfilCliente(ActionEvent event) throws IOException{
        enrutador.irPerfilCliente(event);
    }

    @FXML
    void irVuelosCliente(ActionEvent event) throws IOException {
        enrutador.irVuelosCliente(event);
    }

    @FXML
    void salir(ActionEvent event) throws IOException{
        enrutador.salir(event);
    }

}
