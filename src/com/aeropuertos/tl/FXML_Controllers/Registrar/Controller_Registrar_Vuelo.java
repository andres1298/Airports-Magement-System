package com.aeropuertos.tl.FXML_Controllers.Registrar;

import com.aeropuertos.bl.Aeronave.Aeronave;
import com.aeropuertos.bl.Aeronave.AeronaveDAO;
import com.aeropuertos.bl.Aeropuerto.Aeropuerto;
import com.aeropuertos.bl.Aeropuerto.AeropuertoDAO;
import com.aeropuertos.bl.LineaAerea.LineaAereaDAO;
import com.aeropuertos.bl.LineaAerea.LineaArea;
import com.aeropuertos.bl.Pais.Pais;
import com.aeropuertos.bl.Pais.PaisDAO;
import com.aeropuertos.bl.Sala.Sala;
import com.aeropuertos.bl.Sala.SalaDAO;
import com.aeropuertos.bl.Tripulacion.Tripulacion;
import com.aeropuertos.bl.Tripulacion.TripulacionDAO;
import com.aeropuertos.bl.Vuelo.Vuelo;
import com.aeropuertos.bl.Vuelo.VueloDAO;
import com.aeropuertos.bl.dao.FactoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller_Registrar_Vuelo implements Initializable {

    private FactoryDAO factory  = FactoryDAO.getFactoryDAO(FactoryDAO.MYSQL);
    private VueloDAO dao;

    @FXML
    private TextField txtInicial;

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
    private TextField txtSexto;

    @FXML
    private TextField txtSetimo;

    @FXML
    private TextField txtOctavo;

    @FXML
    private ComboBox<String> comboPrimero;

    @FXML
    private ComboBox<String> comboSegundo;

    @FXML
    private TextField txtUndecimo;

    @FXML
    private TextField txtDuodecimo;

    @FXML
    private TextField txtDecimotercero;

    @FXML
    private TextField txtDecimocuarto;

    @FXML
    private Button btnRegistrar;

    @FXML
    void registrarDatos(ActionEvent event) {
        String codigo ="",lineaAerea="",aeropuertoSalida="",aeropuertoDestino="";
        String tripulacion="",paisOrigen="",horaSalida="",horaLlegada="",estado="",tipo="",sala="",aeronave="";
        double precio = 0;
        dao = factory.getVueloDAO();
        boolean error = false;

        try{

            codigo = txtInicial.getText();
            lineaAerea = txtPrimero.getText();
            aeropuertoSalida = txtSegundo.getText();
            aeropuertoDestino = txtTercero.getText();
            paisOrigen = txtCuarto.getText();
            horaSalida = txtQuinto.getText() + ":" + txtSexto.getText();
            horaLlegada = txtSetimo.getText() + ":" + txtOctavo.getText();
            estado = comboPrimero.getValue();
            tipo = comboSegundo.getValue();
            sala = txtUndecimo.getText();
            tripulacion = txtDuodecimo.getText();
            precio = Double.parseDouble(txtDecimocuarto.getText());
            aeronave = txtDecimotercero.getText();


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error al obtener los datos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }

        if(codigo.equals("")){
            error = true;
        }
        if(lineaAerea.equals("")){
            error = true;
        }
        if(aeropuertoSalida.equals("")){
            error = true;
        }
        if(aeropuertoDestino.equals("")){
            error = true;
        }
        if(paisOrigen.equals("")){
            error = true;
        }
        if(horaSalida.equals("")){
            error = true;
        }
        if(horaLlegada.equals("")){
            error = true;
        }
        if(estado.equals("")){
            error = true;
        }
        if(tipo.equals("")){
            error = true;
        }
        if(sala.equals("")){
            error = true;
        }
        if(tripulacion.equals("")){
            error = true;
        }
        if(aeronave.equals("")){
            error = true;
        }
        if(precio == 0){
            error = true;
        }
        if(error){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Por favor complete los campos");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else if(buscarVuelo(codigo)){
            Alert alert = new Alert(Alert.AlertType.ERROR, "El registro ya existe");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            try {
                LineaArea objetoLineaArea = obtenerLineaAerea(lineaAerea);
                Pais objetoPais = obtenerPais(paisOrigen);
                Aeropuerto objetoAeropuertoSal = obtenerAeropuerto(aeropuertoSalida);
                Aeropuerto objetoAeropuertoDes = obtenerAeropuerto(aeropuertoDestino);
                Sala objetoSala = obtenerSala(sala);
                Tripulacion objetoTripulacion = obtenerTripulacion(tripulacion);
                Aeronave objetoAeronave = obtenerAeronave(aeronave);

                if (objetoLineaArea == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La línea aérea no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if (objetoPais == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El país no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if (objetoAeropuertoDes == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El aeropuerto de destino no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if (objetoAeropuertoSal == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "El aeropuerto de salida no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if(objetoSala == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La sala no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if(objetoTripulacion == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La tripulacion no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else if(objetoAeronave == null){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "La aeronave no existe");
                    alert.setHeaderText(null);
                    alert.showAndWait();
                }
                else{
                    Vuelo vuelo = new Vuelo(codigo,objetoLineaArea,objetoAeropuertoSal,objetoAeropuertoDes,objetoPais,horaSalida,horaLlegada,estado,tipo,objetoAeronave,objetoSala,objetoTripulacion,precio);

                    dao.insertar(vuelo);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "El registro ha sido agregado");
                    alert.setHeaderText(null);
                    alert.showAndWait();

                    Stage window = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    window.close();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private boolean buscarVuelo(String codigo){
        ArrayList<Vuelo> lista;

        try {

            lista = dao.listar();

            for(Vuelo objeto: lista){
                if(objeto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private LineaArea obtenerLineaAerea(String lineaAerea){
        ArrayList<LineaArea> lista;
        LineaAereaDAO lineaAereaDAO = factory.getLineaAereaDAO();
        try {

            lista = lineaAereaDAO.listar();

            for(LineaArea objeto: lista){
                if(objeto.getCedulaJuridica().equals(lineaAerea)){
                    return objeto;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Aeropuerto obtenerAeropuerto(String aeropuerto){
        ArrayList<Aeropuerto> lista;
        AeropuertoDAO aeropuertoDAO = factory.getAeropuertoDAO();
        try{

            lista = aeropuertoDAO.listar();

            for(Aeropuerto objeto: lista){
                if(objeto.getCodigo().equals(aeropuerto)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
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

    private Sala obtenerSala(String sala){
        ArrayList<Sala> lista;
        SalaDAO salaDAO = factory.getSalaDAO();
        try{

            lista = salaDAO.listar();

            for(Sala objeto: lista){
                if(objeto.getCodigo().equals(sala)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

    private Tripulacion obtenerTripulacion(String tripulacion){
        ArrayList<Tripulacion> lista;
        TripulacionDAO tripulacionDAO = factory.getTripulacionDAO();
        try{

            lista = tripulacionDAO.listar();

            for(Tripulacion objeto: lista){
                if(objeto.getCodigo().equals(tripulacion)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }

    private Aeronave obtenerAeronave(String aeronave){
        ArrayList<Aeronave> lista;
        AeronaveDAO aeronaveDAO = factory.getAeronaveDAO();
        try{

            lista = aeronaveDAO.listar();

            for(Aeronave objeto: lista){
                if(objeto.getPlaca().equals(aeronave)){
                    return objeto;
                }
            }

        }catch (Exception e){
            System.out.println("Error al obtener los datos");
        }
        return null;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboPrimero.getItems().removeAll(comboPrimero.getItems());
        comboPrimero.getItems().addAll("A tiempo", "Retrasado", "Cancelado");
        comboPrimero.getSelectionModel().select("A tiempo");

        comboSegundo.getItems().removeAll(comboSegundo.getItems());
        comboSegundo.getItems().addAll("Llegada", "Salida");
        comboSegundo.getSelectionModel().select("Llegada");
    }
}
