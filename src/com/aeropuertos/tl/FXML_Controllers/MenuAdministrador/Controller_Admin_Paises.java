package com.aeropuertos.tl.FXML_Controllers.MenuAdministrador;

import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import com.aeropuertos.tl.Enrutador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Admin_Paises implements Initializable {

    Enrutador enrutador = new Enrutador();
    //Se crea la instancia de Factory, donde se traen las formas de guardado para MySQL
    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    //Se crea la instancia de PaisDAO, que contiene los MDL de Paises
    private PaisDAO dao;

    ArrayList<Pais> lista;
    ObservableList<Pais> datos = FXCollections.observableArrayList();

    @FXML
    private TableView tblAeropuertos;

    @FXML
    private TableColumn<Pais, String> colUno;

    @FXML
    private TableColumn<Pais, String> colDos;

    @FXML
    private TextField txtBuscar;

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

    @FXML
    void abrirFormularioRegistro(ActionEvent event){
        try{

            AnchorPane root = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Registrar_Pais.fxml"));
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
    void abrirFormularioModificar(ActionEvent event) {

    }

    @FXML
    void buscarElemento(ActionEvent event) {
        String busqueda = txtBuscar.getText();
        datos.clear();
        tblAeropuertos.getItems().clear();
        try {
            dao = factory.getPaisDAO();
            lista = dao.listar();

            for(Pais objeto: lista){
                if (objeto.getNombre().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getCodigo().toUpperCase().contains(busqueda.toUpperCase())){
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
            dao = factory.getPaisDAO();
            lista = dao.listar();

            for(Pais objeto: lista){
                datos.addAll(objeto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        tblAeropuertos.setItems(datos);

    }
}
