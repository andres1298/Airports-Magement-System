package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Administrador.Administrador;
import com.aeropuertos.bl.Administrador.AdministradorDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Controller_Registrar_Administrador {
    private FactoryDAO factory = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private AdministradorDAO dao;

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
    private TextArea txtOctavo;

    @FXML
    private TextField txtNoveno;


    @FXML
    private Button btnRegistrar;

    @FXML
    void registrarDatos(ActionEvent event) {
        String nombre = "", apellidos= "", identificacion= "", correo= "", nacionalidad= "", direccion= "", genero = "",contrasena= "";
        LocalDate fechaNacimiento = LocalDate.now();
        int edad = 0;
        boolean error = false;
        dao = factory.getAdministradorDAO();

        try{
            nombre = txtPrimero.getText();
            apellidos = txtSegundo.getText();
            identificacion = txtTercero.getText();
            correo = txtCuarto.getText();
            nacionalidad = txtQuinto.getText();
            fechaNacimiento = txtSexto.getValue();
            genero = txtSetimo.getText();
            direccion = txtOctavo.getText();
            contrasena = txtNoveno.getText();
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
            if(genero.equals("")){
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
        else if(buscarAdministrador(identificacion)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            try{
                Administrador administrador = new Administrador(nombre, apellidos,identificacion,correo,direccion,nacionalidad,fechaNacimiento,
                        edad,genero,"Administrador",contrasena);

                dao.insertar(administrador);
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

    private boolean buscarAdministrador(String identificacion){
        ArrayList<Administrador> lista;

        try {
            lista = dao.listar();

            for(Administrador objeto: lista){
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
