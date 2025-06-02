package com.Journey.service;

import com.Journey.DAO.GerenteDAO;
import com.Journey.model.Gerente;

import java.sql.SQLException;

public class LoginService {

    /**
     * Tenta autenticar um gerente usando email e senha (ambos em String).
     * Converte a senha para int antes de chamar o DAO.
     *
     * @param email O email do gerente.
     * @param senha A senha do gerente em String (ex.: "1234").
     * @return      true se existir um Gerente com esse email e senha; false caso contrário.
     */
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
