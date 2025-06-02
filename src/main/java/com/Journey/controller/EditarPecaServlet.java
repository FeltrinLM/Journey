package com.Journey.controller;

import com.Journey.DAO.PecaDAO;
import com.Journey.model.Peca;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editar-peca")
public class EditarPecaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idPeca = Integer.parseInt(request.getParameter("id"));

        PecaDAO dao = new PecaDAO();
        Peca peca = dao.buscarPeca(idPeca);

        if (peca != null) {
            request.setAttribute("peca", peca);
            request.getRequestDispatcher("editar-peca.jsp").forward(request, response);
        } else {
            response.sendRedirect("dashboard");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String modelo = request.getParameter("modelo");
        String tamanho = request.getParameter("tamanho");
        String cor = request.getParameter("cor");
        int id_colecao = Integer.parseInt(request.getParameter("id_colecao"));

        Peca peca = new Peca();
        peca.setPeca_id(id);
        peca.setModelo(modelo);
        peca.setTamanho(tamanho);
        peca.setCor(cor);
        peca.setId_colecao(id_colecao);

        PecaDAO dao = new PecaDAO();
        dao.alterarPeca(peca);

        response.sendRedirect("dashboard");
    }
}
