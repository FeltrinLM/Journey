package com.Journey.service;

import com.Journey.DAO.GerenteDAO;
import com.Journey.model.Gerente;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final UsuarioDAO dao = new UsuarioDAO();

    public ArrayList<Gerente> listarGerentes() throws Exception {
        List<Gerente> resultado = dao.listar();
        if (resultado == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(resultado);
    }
}
