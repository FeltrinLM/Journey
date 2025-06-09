package com.Journey.controller;

import com.Journey.DAO.ColecaoDAO;
import com.Journey.DAO.EstampaDAO;
import com.Journey.model.Colecao;
import com.Journey.model.Estampa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EditarEstampaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEstampa = Integer.parseInt(request.getParameter("estampa_id"));

        EstampaDAO dao = new EstampaDAO();
        Estampa estampa = dao.buscarPorId(idEstampa);

        if (estampa != null) {
            List<Colecao> colecoes = new ColecaoDAO().listar();
            request.setAttribute("estampa", estampa);
            request.setAttribute("colecoes", colecoes);
            request.getRequestDispatcher("editar-estampa.jsp").forward(request, response);
        } else {
            response.sendRedirect("dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("estampa_id"));
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        int id_colecao = Integer.parseInt(request.getParameter("id_colecao"));

        Estampa estampa = new Estampa();
        estampa.setId_estampa(id);
        estampa.setNome(nome);
        estampa.setQuantidade(quantidade);
        estampa.setId_colecao(id_colecao);

        EstampaDAO dao = new EstampaDAO();
        dao.atualizar(estampa);

        response.sendRedirect("dashboard");
    }
}
