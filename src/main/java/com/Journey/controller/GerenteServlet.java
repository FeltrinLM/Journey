package com.Journey.controller;

import com.Journey.DAO.GerenteDAO;
import com.Journey.model.Gerente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usuario")
public class GerenteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1) Ler parâmetros do formulário
        String nome  = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // 2) Montar objeto Gerente
        Gerente gerente = new Gerente();
        gerente.setNome(nome);
        gerente.setEmail(email);
        gerente.setSenha(senha);

        // 3) Chamar o DAO para inserir no banco
        GerenteDAO dao = new GerenteDAO();
        String mensagem;
        try {
            boolean inseriu = dao.inserir(gerente);
            if (inseriu) {
                mensagem = "Usuário cadastrado com sucesso!";
            } else {
                mensagem = "Falha ao cadastrar usuário.";
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            mensagem = "Ocorreu um erro ao cadastrar: " + ex.getMessage();
        }

        // 4) Colocar a mensagem no request e enviar de volta para a mesma página de cadastro
        request.setAttribute("mensagem", mensagem);
        // Supondo que o JSP de cadastro seja cadastro.jsp
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se acessar /usuario por GET, simplesmente exibe a página de cadastro
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}
