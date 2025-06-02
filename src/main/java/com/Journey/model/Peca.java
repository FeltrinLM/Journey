package com.Journey.model;

public class Peca {
    private int peca_id;
    private int id_colecao;
    private String modelo;
    private String tamanho;
    private String cor;

    public Peca(){}

    public int getPeca_id() {
        return peca_id;
    }

    public void setPeca_id(int peca_id) {
        this.peca_id = peca_id;
    }

    public int getId_colecao() {
        return id_colecao;
    }

    public void setId_colecao(int id_gerente) {
        this.id_colecao = id_gerente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}