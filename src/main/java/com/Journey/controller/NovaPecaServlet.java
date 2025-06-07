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

        String tipo = request.getParameter("tipo");
        String tamanho = request.getParameter("tamanho");
        String cor = request.getParameter("cor");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));

        Peca peca = new Peca();
        peca.setTipo(tipo);
        peca.setTamanho(tamanho);
        peca.setCor(cor);
        peca.setQuantidade(quantidade); // 👈 faltava isso

        PecaDAO dao = new PecaDAO();
        dao.inserir(peca);

        response.sendRedirect("dashboard");
    }

}
