package com.Journey.controller;

import com.Journey.DAO.UsuarioDAO;
import com.Journey.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean sucesso = false;
        try {
            sucesso = usuarioDAO.inserir(usuario);

            if (sucesso) {
                // Buscar o usuário completo (com ID) após inserção
                Usuario usuarioCadastrado = usuarioDAO.buscarPorEmail(email);

                // Criar sessão para o usuário
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioCadastrado);

                // Redirecionar para a visualização geral
                response.sendRedirect("dashboard");
            } else {
                request.setAttribute("mensagem", "Erro ao cadastrar usuário. Tente novamente.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao cadastrar: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
