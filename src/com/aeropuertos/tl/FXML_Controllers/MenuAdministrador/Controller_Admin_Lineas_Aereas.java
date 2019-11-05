package com.aeropuertos.tl.FXML_Controllers.MenuAdministrador;

import com.aeropuertos.bl.LineaAerea.LineaAereaDAO;
import com.aeropuertos.bl.LineaAerea.LineaArea;
import com.aeropuertos.bl.Pais.Pais;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Admin_Lineas_Aereas implements Initializable {

    Enrutador enrutador = new Enrutador();
    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private LineaAereaDAO dao;

    ArrayList<LineaArea> lista;
    ObservableList<LineaArea> datos = FXCollections.observableArrayList();

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

            AnchorPane root = FXMLLoader.load(getClass().getResource("../../../ui/FXML/Registrar_Linea_Aerea.fxml"));
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
            dao = factory.getLineaAereaDAO();
            lista = dao.listar();

            for(LineaArea objeto: lista){
                if (objeto.getNombreComercial().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getCedulaJuridica().toUpperCase().contains(busqueda.toUpperCase())|| objeto.getEmpresa().toUpperCase().contains(busqueda.toUpperCase())){
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
            dao = factory.getLineaAereaDAO();
            lista = dao.listar();

            for(LineaArea objeto: lista){
                datos.addAll(objeto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        colUno.setCellValueFactory(new PropertyValueFactory<>("nombreComercial"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("cedulaJuridica"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("pais"));

        tblAeropuertos.setItems(datos);
    }
}
