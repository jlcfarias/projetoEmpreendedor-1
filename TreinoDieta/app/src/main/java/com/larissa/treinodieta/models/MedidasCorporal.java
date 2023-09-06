package com.larissa.treinodieta.models;

import java.io.Serializable;

public class MedidasCorporal implements Serializable {

    private Long id;
    private String data;
    private String antebracoD;
    private String antebracoE;
    private String bracoE;
    private String bracoD;
    private String cintura;
    private String quadril;
    private String pernaE;
    private String pernaD;
    private String peito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAntebracoD() {
        return antebracoD;
    }

    public void setAntebracoD(String antebracoD) {
        this.antebracoD = antebracoD;
    }

    public String getAntebracoE() {
        return antebracoE;
    }

    public void setAntebracoE(String antebracoE) {
        this.antebracoE = antebracoE;
    }

    public String getBracoD() {
        return bracoD;
    }

    public void setBracoD(String bracoD) {
        this.bracoD = bracoD;
    }

    public String getBracoE() {
        return bracoE;
    }

    public void setBracoE(String bracoE) {
        this.bracoE = bracoE;
    }

    public String getCintura() {
        return cintura;
    }

    public void setCintura(String cintura) {
        this.cintura = cintura;
    }

    public String getQuadril() {
        return quadril;
    }

    public void setQuadril(String quadril) {
        this.quadril = quadril;
    }

    public String getPernaE() {
        return pernaE;
    }

    public void setPernaE(String pernaE) {
        this.pernaE = pernaE;
    }

    public String getPernaD() {
        return pernaD;
    }

    public void setPernaD(String pernaD) {
        this.pernaD = pernaD;
    }

    public String getPeito() {
        return peito;
    }

    public void setPeito(String peito) {
        this.peito = peito;
    }

    @Override
    public String toString() {
        return  "Data: " + getData() + "\r\n\n" +
                "Cintura: " + getCintura() + " cm; " +
                "Quadril: " + getQuadril() + " cm; " +
                "Peito: " + getPeito() + " cm \r\n" +
                "Antebraço: (D) " + getAntebracoD() + " cm; (E) " + getAntebracoE() + " cm \r\n" +
                "Braço: (D) " + getBracoD() + " cm; (E) " + getBracoE() + " cm \r\n" +
                "Perna: (D) " + getPernaD() + " cm; (E) " + getPernaE() + " cm \r\n";
    }
}
