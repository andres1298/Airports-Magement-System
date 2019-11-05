package com.aeropuertos.tl.FXML_Controllers.MenuCliente;

import com.aeropuertos.bl.dao.FactoryDAO;
import com.aeropuertos.tl.Enrutador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Controller_Cliente_Inicio {

    Enrutador enrutador = new Enrutador();

    @FXML
    private TextField txtBuscar;

    @FXML
    void irInicioCliente(ActionEvent event) throws IOException{
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
