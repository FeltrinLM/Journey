package com.Journey.controller;

import com.Journey.DAO.EstampaDAO;
import com.Journey.model.Estampa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/nova-estampa")
public class NovaEstampaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int id_colecao = Integer.parseInt(request.getParameter("id_colecao"));

        Estampa estampa = new Estampa();
        estampa.setNome(nome);
        estampa.setQuantidade(quantidade);
        estampa.setId_colecao(id_colecao);

        EstampaDAO dao = new EstampaDAO();
        dao.inserir(estampa);

        response.sendRedirect("dashboard");
    }
}
