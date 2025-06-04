package com.Journey.controller;
import com.Journey.DAO.ColecaoDAO;
import com.Journey.model.Colecao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/nova-colecao")
public class NovaColecaoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String dataInicio = request.getParameter("data_inicio");
        String dataFim = request.getParameter("data_fim");

        // Preenche a coleção
        Colecao colecao = new Colecao();
        colecao.setNome(nome);
        colecao.setData_inicio(dataInicio);
        colecao.setData_fim(dataFim);

        // Insere no banco
        boolean sucesso = new ColecaoDAO().inserir(colecao);

        if (sucesso) {
            response.sendRedirect("dashboard");
        } else {
            request.setAttribute("erro", "Erro ao cadastrar a coleção.");
            request.getRequestDispatcher("nova-colecao.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("nova-colecao.jsp").forward(request, response);
    }
}
