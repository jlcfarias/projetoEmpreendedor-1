package com.larissa.treinodieta.models;

import java.io.Serializable;

public class CaloriasDiarias implements Serializable {

    private Long id;
    private String data;
    private Float caloriasDisponiveis;

    public Long getId() { return id; }
    public String getData() { return data; }
    public Float getCaloriasDisponiveis() { return caloriasDisponiveis; }

    public void setId(Long id) { this.id = id; }
    public void setData(String data) { this.data = data; }
    public void setCaloriasDisponiveis(Float caloriasDisponiveis) { this.caloriasDisponiveis = caloriasDisponiveis; }
}