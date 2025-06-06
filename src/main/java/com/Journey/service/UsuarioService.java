package com.Journey.service;

import com.Journey.DAO.UsuarioDAO;
import com.Journey.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private static final UsuarioDAO dao = new UsuarioDAO();

    public ArrayList<Usuario> listarUsuarios() throws Exception {
        List<Usuario> resultado = dao.listar();
        if (resultado == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(resultado);
    }
}
