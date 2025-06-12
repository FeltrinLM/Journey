<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Colecao" %>

<%
    Colecao colecao = (Colecao) request.getAttribute("colecao");
    String erro = (String) request.getAttribute("erro");

    if (colecao == null) {
        response.sendRedirect("dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Coleção</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/editar-colecao.css">
</head>
<body>

<div class="form-container">
    <h2>Editar Coleção</h2>

    <form action="editar-colecao" method="post">
        <input type="hidden" name="id" value="<%= colecao.getId_colecao() %>">

        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" value="<%= colecao.getNome() %>" required>

        <label for="data_inicio">Data Início:</label>
        <input type="date" name="data_inicio" id="data_inicio" value="<%= colecao.getData_inicio() %>" required>

        <label for="data_fim">Data Fim:</label>
        <input type="date" name="data_fim" id="data_fim"
               value="<%= colecao.getData_fim() != null ? colecao.getData_fim() : "" %>">

        <% if (erro != null) { %>
        <p class="mensagem-erro" id="erro-msg"><%= erro %></p>
        <script>
            setTimeout(() => {
                const msg = document.getElementById('erro-msg');
                if (msg) msg.style.display = 'none';
            }, 5000);
        </script>
        <% } %>

        <div class="btn-group">
            <a href="dashboard" class="btn-voltar">Voltar</a>
            <input type="submit" value="Salvar" class="btn-salvar">
        </div>
    </form>
</div>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: white;
        padding: 30px 40px;
        border-radius: 8px;
        border: 1px solid #ccc;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 400px;
        text-align: center;
    }

    .form-container h2 {
        margin-bottom: 20px;
        font-size: 22px;
    }

    .form-container form {
        display: flex;
        flex-direction: column;
        align-items: stretch;
    }

    .form-container input[type="text"],
    .form-container input[type="date"] {
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .btn-group {
        display: flex;
        justify-content: center;
        gap: 10px;
        margin-top: 15px;
    }

    .btn-salvar,
    .btn-voltar {
        padding: 8px 16px;
        font-size: 14px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .btn-salvar {
        background-color: green;
        color: white;
        width: 150px;
    }

    .btn-salvar:hover {
        background-color: #006400;
    }

    .btn-voltar {
        background-color: red;
        color: white;
        text-decoration: none;
        display: inline-block;
        line-height: 26px;
        text-align: center;
        width: 100px;
    }

    .btn-voltar:hover {
        background-color: #990000;
    }

    .mensagem-erro {
        color: red;
        margin-bottom: 15px;
    }

</style>

</body>
</html>
