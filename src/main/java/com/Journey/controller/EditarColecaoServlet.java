package com.Journey.controller;

import com.Journey.DAO.ColecaoDAO;
import com.Journey.model.Colecao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/editar-colecao")
public class EditarColecaoServlet extends HttpServlet {

    // Mostra a tela de edição
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(">> Entrou no doGet de EditarColecaoServlet");

        int id = Integer.parseInt(request.getParameter("id"));
        Colecao colecao = new ColecaoDAO().buscarPorId(id);

        if (colecao != null) {
            request.setAttribute("colecao", colecao);
            request.getRequestDispatcher("editar-colecao.jsp").forward(request, response);
        } else {
            System.out.println("Coleção não encontrada. ID: " + id);
            response.sendRedirect("dashboard");
        }
    }

    // Salva a edição
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(">> Entrou no doPost de EditarColecaoServlet");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String dataInicio = request.getParameter("data_inicio");
            String dataFim = request.getParameter("data_fim");

            System.out.println("ID recebido: " + id);
            System.out.println("Nome: " + nome);
            System.out.println("Data início: " + dataInicio);
            System.out.println("Data fim: " + dataFim);

            Colecao c = new Colecao();
            c.setId_colecao(id);
            c.setNome(nome);
            c.setData_inicio(dataInicio);
            c.setData_fim(dataFim);

            boolean sucesso = new ColecaoDAO().atualizar(c);

            if (sucesso) {
                System.out.println("Coleção atualizada com sucesso.");
            } else {
                System.out.println("Falha ao atualizar coleção.");
            }

            response.sendRedirect("dashboard");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("dashboard"); // fallback
        }
    }
}
