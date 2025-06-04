package com.Journey.controller;

import com.Journey.DAO.PecaDAO;
import com.Journey.model.Peca;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NovaPecaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String modelo = request.getParameter("modelo");
        String tamanho = request.getParameter("tamanho");
        String cor = request.getParameter("cor");
        int id_colecao = Integer.parseInt(request.getParameter("id_colecao"));

        Peca peca = new Peca();
        peca.setModelo(modelo);
        peca.setTamanho(tamanho);
        peca.setCor(cor);
        peca.setId_colecao(id_colecao);

        PecaDAO dao = new PecaDAO();
        dao.inserirPeca(peca);

        response.sendRedirect("dashboard");
    }
}
