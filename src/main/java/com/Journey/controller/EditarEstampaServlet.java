package com.Journey.controller;

import com.Journey.DAO.EstampaDAO;
import com.Journey.model.Estampa;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class EditarEstampaServlet extends HttpServlet {

    // Mostra a tela de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(">> Entrou no doGet de EditarEstampaServlet");

        int id = Integer.parseInt(request.getParameter("id"));
        Estampa estampa = new EstampaDAO().buscarPorId(id);

        if (estampa != null) {
            request.setAttribute("estampa", estampa);
            request.getRequestDispatcher("editar-estampa.jsp").forward(request, response);
        } else {
            System.out.println("Estampa não encontrada. ID: " + id);
            response.sendRedirect("dashboard");
        }
    }

    // Salva a edição
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            Integer quantidade = Integer.valueOf(request.getParameter("quantidade"));
            Integer id_colecao = Integer.parseInt(request.getParameter("id_colecao"));

            System.out.println("ID recebido: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("quantidade: " + quantidade);
            System.out.println("colecao: " + id_colecao);


            Estampa e = new Estampa();
            e.setId_estampa(id);
            e.setNome(nome);
            e.setQuantidade(quantidade);
            e.setId_colecao(id_colecao);

            boolean sucesso = new EstampaDAO().atualizar(e);

            if (sucesso) {
                System.out.println("Estampa atualizada com sucesso.");
            } else {
                System.out.println("Falha ao atualizar estampa.");
            }

            response.sendRedirect("dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard"); // fallback
        }
    }
}