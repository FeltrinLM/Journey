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

        String nome  = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        UsuarioDAO dao = new UsuarioDAO();
        try {
            boolean inseriu = dao.inserir(usuario);

            if (inseriu) {
                response.sendRedirect("dashboard");
            } else {
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
        request.getRequestDispatcher("usuario-form.jsp").forward(request, response);
    }
}
