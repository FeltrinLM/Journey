package com.Journey.controller;

import com.Journey.DAO.UsuarioDAO;
import com.Journey.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1) Pegar dados do formulário
        String nome  = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // 2) Criar objeto Gerente
        Gerente gerente = new Gerente();
        gerente.setNome(nome);
        gerente.setEmail(email);
        gerente.setSenha(senha);

        // 3) Inserir no banco
        GerenteDAO dao = new GerenteDAO();
        try {
            boolean inseriu = dao.inserir(gerente);

            if (inseriu) {
                // Redireciona para o dashboard para recarregar os dados
                response.sendRedirect("dashboard");
            } else {
                // Falhou ao inserir - volta para o formulário com mensagem
                request.setAttribute("mensagem", "Falha ao cadastrar usuário.");
                request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            request.setAttribute("mensagem", "Erro ao cadastrar: " + ex.getMessage());
            request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Exibe formulário para cadastrar usuário
        request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
    }
}
