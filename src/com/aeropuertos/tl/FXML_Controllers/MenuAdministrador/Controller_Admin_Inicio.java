package com.aeropuertos.tl.FXML_Controllers.MenuAdministrador;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Cliente.Cliente;
import com.aeropuertos.bl.Persona.Persona;
import com.aeropuertos.bl.Persona.PersonaDAO;
import com.aeropuertos.bl.Tripulante.Tripulante;
import com.aeropuertos.bl.dao.FactoryDAO;
import com.aeropuertos.tl.Enrutador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Admin_Inicio implements Initializable {

    Enrutador enrutador = new Enrutador();
    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private PersonaDAO dao;

    ArrayList<Persona> lista;
    ObservableList<Persona> datos = FXCollections.observableArrayList();

    @FXML
    private TextField txtBuscar;


    @FXML
    private TableView tblAeropuertos;

    @FXML
    private TableColumn colUno;

    @FXML
    private TableColumn colDos;

    @FXML
    private TableColumn colTres;

    @FXML
    private TableColumn colCuatro;

    @FXML
    void irAeronaves(ActionEvent event) throws IOException{
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

    @FXML
    void comprarTiquete(ActionEvent event) {
        try{

            AnchorPane root = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Registrar_Tiquete.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuevo registro");
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.setScene(new Scene(root));
            stage.show();

        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void buscarElemento(ActionEvent event) {
        String busqueda = txtBuscar.getText();
        datos.clear();
        tblAeropuertos.getItems().clear();
        try {
            dao = factory.getPersonaDAO();
            lista = dao.listar();

            for(Persona objeto: lista){
                if (objeto.getNombre().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getApellidos().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getIdentificacion().contains(busqueda) || objeto.getCorreo().toUpperCase().contains(busqueda.toUpperCase())){
                    datos.addAll(objeto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblAeropuertos.setItems(datos);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            dao = factory.getPersonaDAO();
            lista = dao.listar();

            for(Persona objeto: lista){
                datos.addAll(objeto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("identificacion"));

        tblAeropuertos.setItems(datos);
    }

}
