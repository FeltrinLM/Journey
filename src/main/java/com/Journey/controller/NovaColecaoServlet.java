package com.Journey.controller;

import com.Journey.DAO.ColecaoDAO;
import com.Journey.model.Colecao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet("/teste-nova-colecao")

public class NovaColecaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Colecao c = new Colecao();
        c.setNome(request.getParameter("nome"));
        c.setData_inicio(request.getParameter("data_inicio"));
        c.setData_fim(request.getParameter("data_fim"));

        new ColecaoDAO().inserir(c);
        response.sendRedirect("dashboard");
    }
}

