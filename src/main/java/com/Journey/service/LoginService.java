package com.Journey.service;

import com.Journey.DAO.GerenteDAO;
import com.Journey.model.Gerente;
import java.sql.SQLException;

public class LoginService {


    public boolean autenticar(String email, String senha) {

        // Usa o DAO para buscar um Gerente com email + senhaInt
        GerenteDAO dao = new GerenteDAO();
        Gerente gerente = null;
        try {
            gerente = dao.buscarPorEmailESenha(email, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return gerente != null;
    }
}
