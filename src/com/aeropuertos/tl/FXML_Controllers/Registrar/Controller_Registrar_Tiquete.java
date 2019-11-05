package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Cliente.Cliente;
import com.aeropuertos.bl.Cliente.ClienteDAO;
import com.aeropuertos.bl.Tiquete.Tiquete;
import com.aeropuertos.bl.Tiquete.TiqueteDAO;
import com.aeropuertos.bl.Vuelo.Vuelo;
import com.aeropuertos.bl.Vuelo.VueloDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Registrar_Tiquete implements Initializable {
    private FactoryDAO factory = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private TiqueteDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private ComboBox<String> txtCuarto;

    @FXML
    private TextField txtQuinto;

    @FXML
    private DatePicker txtSexto;

    @FXML
    private TextField txtSetimo;

    @FXML
    private Button btnRegistrar;

    @FXML
    void registrarDatos(ActionEvent event) {
    int asiento = 0;
    String tipoAsiento = "",vuelo = "",cliente = "",codigo = "";
    LocalDate fechaSalida = LocalDate.now();
    double precio = 0;
    dao = factory.getTiqueteDAO();
    boolean error = false;
        try{

            cliente = txtPrimero.getText();
            codigo = txtSegundo.getText();
            asiento = Integer.parseInt(txtTercero.getText());
            tipoAsiento = txtCuarto.getValue();
            vuelo = txtQuinto.getText();
            fechaSalida = txtSexto.getValue();
            precio = Double.parseDouble(txtSetimo.getText());


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al obtener los datos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

        if(cliente.equals("")){
            error = true;
        }
        if(codigo.equals("")){
            error = true;
        }
        if(asiento == 0){
            error = true;
        }
        if(tipoAsiento.equals("")){
            error = true;
        }
        if(vuelo.equals("")){
            error = true;
        }
        if(precio == 0){
            error = true;
        }
        try{
            if(fechaSalida.equals("")){
                error = true;
            }
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Complete la fecha");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.out.println(e);
            error = true;
        }

        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarTiquete(codigo)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            try{
                Vuelo vueloObjeto = obtenerVuelo(vuelo);
                Cliente clienteObjeto = obtenerCliente(cliente);
                if(vueloObjeto == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El vuelo no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if(clienteObjeto == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El cliente no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else{
                    Tiquete tiquete = new Tiquete(asiento,codigo,fechaSalida,precio,vuelo,tipoAsiento,cliente);
                    dao.insertar(tiquete);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    private boolean buscarTiquete(String codigo){
        ArrayList<Tiquete> lista;

        try {

            lista = dao.listar();

            for(Tiquete objeto: lista){
                if(objeto.getCodigoTiquete().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Cliente obtenerCliente(String cliente){
        ArrayList<Cliente> lista;
        ClienteDAO clienteDAO = factory.getClienteDAO();

        try {
            lista = clienteDAO.listar();

            for(Cliente objeto: lista){
                if(objeto.getIdentificacion().equals(cliente)){
                    return objeto;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Vuelo obtenerVuelo(String vuelo){
        ArrayList<Vuelo> lista;
        VueloDAO vueloDAO = factory.getVueloDAO();

        try {
            lista = vueloDAO.listar();

            for(Vuelo objeto: lista){
                if(objeto.getCodigo().equals(vuelo)){
                    return objeto;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtCuarto.getItems().removeAll(txtCuarto.getItems());
        txtCuarto.getItems().addAll("Ventana", "Central", "Pasillo");
        txtCuarto.getSelectionModel().select("Ventana");
    }
}

