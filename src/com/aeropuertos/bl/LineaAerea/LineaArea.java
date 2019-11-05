package com.aeropuertos.bl.LineaAerea;

import com.aeropuertos.bl.Pais.Pais;

public class LineaArea {

    private String nombreComercial;
    private String cedulaJuridica;
    private String empresa;
    private Pais pais;

    public LineaArea(){
        this.nombreComercial = "";
        this.cedulaJuridica = "";
        this.empresa = "";
        this.pais = new Pais();
    }

    public LineaArea(String nombreComercial, String cedulaJuridica, String empresa, Pais pais) {
        this.nombreComercial = nombreComercial;
        this.cedulaJuridica = cedulaJuridica;
        this.empresa = empresa;
        this.pais = pais;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPais() {
        return pais.getNombre();
    }

    public String getCodigoPais() {
        return pais.getCodigo();
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public boolean equals(Object pObjeto){
        if(this == pObjeto) return true;

        if(pObjeto == null) return false;

        if(!(pObjeto instanceof LineaArea)) return false;

        LineaArea lineaArea = (LineaArea) pObjeto;

        if(this.getCedulaJuridica().equals(lineaArea.getCedulaJuridica())) return true;

        return false;
    }
}
