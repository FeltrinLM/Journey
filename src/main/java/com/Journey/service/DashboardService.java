package com.Journey.service;

import com.Journey.model.Peca;
import com.Journey.model.Colecao;
import com.Journey.model.Estampa;
import com.Journey.DAO.PecaDAO;
import com.Journey.DAO.ColecaoDAO;
import com.Journey.DAO.EstampaDAO;

import java.util.List;

public class DashboardService {

    public List<Peca> listarPecas() throws Exception {
        return new PecaDAO().listar();
    }

    public List<Colecao> listarColecoes() throws Exception {
        return new ColecaoDAO().listar();
    }

    public List<Estampa> listarEstampas() throws Exception {
        return new EstampaDAO().listar();
    }

    public void excluirPeca(int id) throws Exception {
        new PecaDAO().excluir(id);
    }

    public void excluirColecao(int id) throws Exception {
        new ColecaoDAO().removerColecao(id);
    }

    public void excluirEstampa(int id) throws Exception {
        new EstampaDAO().excluir(id);
    }
}
