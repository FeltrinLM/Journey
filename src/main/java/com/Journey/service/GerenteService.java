package com.Journey.service;

import com.Journey.DAO.GerenteDAO;
import com.Journey.model.Gerente;

import java.util.ArrayList;
import java.util.List;

public class GerenteService {
    private static final GerenteDAO dao = new GerenteDAO();

    public ArrayList<Gerente> listarGerentes() throws Exception {
        // dao.listar() retorna List<Gerente>. Convertendo para ArrayList:
        List<Gerente> resultado = dao.listar();
        if (resultado == null) {
            return new ArrayList<>();
        }
        // Cria um ArrayList a partir do List retornado
        return new ArrayList<>(resultado);
    }
}
