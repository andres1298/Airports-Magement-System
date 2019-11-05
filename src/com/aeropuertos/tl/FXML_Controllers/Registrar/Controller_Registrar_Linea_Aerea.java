package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.LineaAerea.LineaAereaDAO;
import com.aeropuertos.bl.LineaAerea.LineaArea;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller_Registrar_Linea_Aerea {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private LineaAereaDAO dao;

    @FXML
    private TextField txtPrimero;

    @FXML
    private TextField txtSegundo;

    @FXML
    private TextField txtTercero;

    @FXML
    private TextField txtCuarto;

    @FXML
    void registrarDatos(ActionEvent event) {
        String nombrecomercial,cedulajuridica,empresa,codigoPais;
        dao = factory.getLineaAereaDAO();
        boolean error = false;

        nombrecomercial = txtPrimero.getText();
        cedulajuridica = txtSegundo.getText();
        empresa = txtTercero.getText();
        codigoPais = txtCuarto.getText();

        if(nombrecomercial.equals("")){
            error = true;
        }
        if(cedulajuridica.equals("")){
            error = true;
        }
        if(empresa.equals("")){
            error = true;
        }
        if(codigoPais.equals("")){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarLineaAerea(cedulajuridica)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                Pais pais = obtenerPais(codigoPais);
                if (pais != null) {
                    LineaArea lineaArea =  new LineaArea(nombrecomercial,cedulajuridica,empresa,pais);

                    dao.insertar(lineaArea);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El pais no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean buscarLineaAerea(String cedulajuridica){
        ArrayList<LineaArea> lista;

        try {

            lista = dao.listar();

            for(LineaArea objeto: lista){
                if(objeto.getCedulaJuridica().equals(cedulajuridica)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private Pais obtenerPais(String pais){
        ArrayList<Pais> lista;
        PaisDAO paisDAO = factory.getPaisDAO();
        try{

            lista = paisDAO.listar();

            for(Pais objeto: lista){
                if(objeto.getCodigo().equals(pais)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

}
