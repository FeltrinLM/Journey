package com.Journey.controller;

import com.Journey.model.Peca;
import com.Journey.model.Colecao;
import com.Journey.model.Estampa;
import com.Journey.service.DashboardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class VisualizacaoGeralServlet extends HttpServlet {

    private final DashboardService dashboardService = new DashboardService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            List<Peca> pecas = dashboardService.listarPecas();
            List<Colecao> colecoes = dashboardService.listarColecoes();
            List<Estampa> estampas = dashboardService.listarEstampas();

            request.setAttribute("pecas", pecas);
            request.setAttribute("colecoes", colecoes);
            request.setAttribute("estampas", estampas);

            request.getRequestDispatcher("visualizacao-geral.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao carregar dados para a visualização.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            switch (acao) {
                case "excluir" -> dashboardService.excluirPeca(id);
                case "excluir-colecao" -> dashboardService.excluirColecao(id);
                case "excluir-estampa" -> dashboardService.excluirEstampa(id);
            }

            response.sendRedirect("dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao processar ação no dashboard.", e);
        }
    }
}
