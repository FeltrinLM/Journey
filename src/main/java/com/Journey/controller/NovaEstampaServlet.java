package com.Journey.controller;

import com.Journey.DAO.ColecaoDAO;
import com.Journey.DAO.EstampaDAO;
import com.Journey.model.Colecao;
import com.Journey.model.Estampa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/nova-estampa")
public class NovaEstampaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Colecao> colecoes = new ColecaoDAO().listar();
        request.setAttribute("colecoes", colecoes);
        request.getRequestDispatcher("nova-estampa.jsp").forward(request, response);
    }

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
