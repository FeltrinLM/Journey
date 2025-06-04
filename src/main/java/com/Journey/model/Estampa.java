package com.Journey.model;

public class Estampa {
    private int id_estampa;
    private int id_colecao;
    private String nome;
    private int quantidade;

    public Estampa(){}

    public int getId_estampa() {
        return id_estampa;
    }

    public void setId_estampa(int id_estampa) {
        this.id_estampa = id_estampa;
    }

    public int getId_colecao() {
        return id_colecao;
    }

    public void setId_colecao(int id_colecao) {
        this.id_colecao = id_colecao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
