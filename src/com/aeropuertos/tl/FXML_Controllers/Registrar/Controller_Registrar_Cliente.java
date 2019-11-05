package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Cliente.Cliente;
import com.aeropuertos.bl.Cliente.ClienteDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controller_Registrar_Cliente {

    private FactoryDAO factory = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private ClienteDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private TextField txtCuarto;

    @FXML
    private TextField txtQuinto;

    @FXML
    private DatePicker txtSexto;

    @FXML
    private TextField txtSetimo;

    @FXML
    private TextField txtOctavo;

    @FXML
    private TextField txtNoveno;

    @FXML
    private TextArea txtDecimo;

    @FXML
    private TextField txtUndecimo;


    @FXML
    void registrarDatos(ActionEvent event) {
        String nombre = "", apellidos= "", identificacion= "", correo= "", nacionalidad= "", direccion= "", canton= "", distrito= "", provincia= "",contrasena= "";
        LocalDate fechaNacimiento = LocalDate.now();
        int edad = 0;
        dao = factory.getClienteDAO();
        boolean error = false;
        try{
            nombre = txtPrimero.getText();
            apellidos = txtSegundo.getText();
            identificacion = txtTercero.getText();
            correo = txtCuarto.getText();
            nacionalidad = txtQuinto.getText();
            fechaNacimiento = txtSexto.getValue();
            distrito = txtSetimo.getText();
            canton = txtOctavo.getText();
            provincia = txtNoveno.getText();
            direccion = txtDecimo.getText();
            contrasena = txtUndecimo.getText();
            Period period = Period.between(fechaNacimiento, LocalDate.now());
            edad  = period.getYears();


            if(nombre.equals("")){
                error = true;
            }
            if(apellidos.equals("")){
                error = true;
            }
            if(identificacion.equals("")){
                error = true;
            }
            if(correo.equals("")){
                error = true;
            }
            if(nacionalidad.equals("")){
                error = true;
            }
            if(fechaNacimiento.equals("")){
                error = true;
            }
            if(distrito.equals("")){
                error = true;
            }
            if(canton.equals("")){
                error = true;
            }
            if(provincia.equals("")){
                error = true;
            }
            if(direccion.equals("")){
                error = true;
            }
            if(contrasena.equals("")){
                error = true;
            }
        }catch (Exception e){
            error = true;
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al obtener los valores. Por favor compruebe los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.out.println(e);
        }


        if (error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarCliente(identificacion)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            try{
                Cliente cliente = new Cliente(nombre, apellidos,identificacion,correo,direccion,nacionalidad,fechaNacimiento,
                distrito,canton,provincia,edad,"Cliente",contrasena);

                dao.insertar(cliente);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                alert.setHeaderText(null);
                alert.showAndWait();

                Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                window.close();
            }catch(Exception e){
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error al registrar el usuario. Intente de nuevo");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
    }
    private boolean buscarCliente(String identificacion){
        ArrayList<Cliente> lista;

        try {
            lista = dao.listar();

            for(Cliente objeto: lista){
                if(objeto.getIdentificacion().equals(identificacion)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
