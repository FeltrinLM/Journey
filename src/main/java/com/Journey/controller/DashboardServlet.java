package com.Journey.controller;

import com.Journey.model.Peca;
import com.Journey.model.Colecao;
import com.Journey.model.Usuario;
import com.Journey.model.Estampa;
import com.Journey.DAO.PecaDAO;
import com.Journey.DAO.ColecaoDAO;
import com.Journey.DAO.UsuarioDAO;
import com.Journey.DAO.EstampaDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            List<Peca> pecas = new PecaDAO().listarPecas();
            List<Colecao> colecoes = new ColecaoDAO().listar();
            List<Usuario> usuarios = new UsuarioDAO().listar();
            List<Estampa> estampas = new EstampaDAO().listar();

            request.setAttribute("pecas", pecas);
            request.setAttribute("colecoes", colecoes);
            request.setAttribute("usuarios", usuarios);

            request.getRequestDispatcher("dashboard.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao carregar dados para o dashboard.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        try {
            if ("excluir".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                new PecaDAO().removerPeca(id);

            } else if ("excluir-colecao".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                new ColecaoDAO().excluir(id);
            }

            // Redireciona para atualizar a tela com os dados
            response.sendRedirect("dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Erro ao processar ação no dashboard.", e);
        }
    }
}
