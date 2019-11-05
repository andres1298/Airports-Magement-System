package com.aeropuertos.tl.FXML_Controllers.MenuCliente;

import com.aeropuertos.bl.Vuelo.Vuelo;
import com.aeropuertos.bl.Vuelo.VueloDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import com.aeropuertos.tl.Enrutador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Cliente_Vuelos implements Initializable {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private VueloDAO dao;

    ArrayList<Vuelo> lista;
    ObservableList<Vuelo> datos = FXCollections.observableArrayList();
    Enrutador enrutador = new Enrutador();

    @FXML
    private TextField txtBuscar;

    @FXML
    private TableView tblAeropuertos;

    @FXML
    private TableColumn colCuatro;

    @FXML
    private TableColumn colTres;

    @FXML
    private TableColumn colDos;

    @FXML
    private TableColumn colCinco;

    @FXML
    private TableColumn colUno;

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

    @FXML
    void buscarElemento(ActionEvent event) {
        String busqueda = txtBuscar.getText();
        datos.clear();
        tblAeropuertos.getItems().clear();
        try {
            dao = factory.getVueloDAO();
            lista = dao.listar();

            for(Vuelo objeto: lista){
                if (objeto.getEstado().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getNombreSala().toUpperCase().contains(busqueda.toUpperCase())
                        || objeto.getNombreLineaAerea().toUpperCase().contains(busqueda.toUpperCase()) || objeto.getNombrePaisSalida().toUpperCase().contains(busqueda.toUpperCase())){
                    datos.addAll(objeto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblAeropuertos.setItems(datos);
    }

    @FXML
    private void llenarVuelosLlegada(){
        datos.clear();
        tblAeropuertos.getItems().clear();
        try {
            dao = factory.getVueloDAO();
            lista = dao.listar();

            for(Vuelo objeto: lista){
                if(objeto.getTipo().equals("Llegada")){
                    datos.addAll(objeto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void llenarVuelosSalida(){
        datos.clear();
        tblAeropuertos.getItems().clear();
        try {
            dao = factory.getVueloDAO();
            lista = dao.listar();

            for(Vuelo objeto: lista){
                if(objeto.getTipo().equals("Salida")){
                    datos.addAll(objeto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            dao = factory.getVueloDAO();
            lista = dao.listar();

            for(Vuelo objeto: lista){
                if(objeto.getTipo().equals("Llegada")){
                    datos.addAll(objeto);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        colUno.setCellValueFactory(new PropertyValueFactory<>("NombrePaisSalida"));
        colDos.setCellValueFactory(new PropertyValueFactory<>("NombreSala"));
        colTres.setCellValueFactory(new PropertyValueFactory<>("NombreLineaAerea"));
        colCuatro.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colCinco.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        tblAeropuertos.setItems(datos);
    }
}
