package com.Journey.controller;

import com.Journey.DAO.PecaDAO;
import com.Journey.model.Peca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditarPecaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPeca = Integer.parseInt(request.getParameter("id"));

        PecaDAO dao = new PecaDAO();
        Peca peca = dao.buscarPorId(idPeca);


        if (peca != null) {
            request.setAttribute("peca", peca);
            request.getRequestDispatcher("editar-peca.jsp").forward(request, response);
        } else {
            response.sendRedirect("visualizacao-geral.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");
        String tamanho = request.getParameter("tamanho");
        String cor = request.getParameter("cor");

        Peca peca = new Peca();
        peca.setPeca_id(id);
        peca.setTipo(tipo);
        peca.setTamanho(tamanho);
        peca.setCor(cor);

        PecaDAO dao = new PecaDAO();
        dao.atualizar(peca);

        response.sendRedirect("visualizacao-geral.jsp");
    }
}
