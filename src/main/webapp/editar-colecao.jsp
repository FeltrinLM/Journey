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
</head>
<body>

<h2>Editar Coleção</h2>

<% if (erro != null) { %>
<p style="color: red;"><%= erro %></p>
<% } %>

<form action="editar-colecao" method="post">
    <input type="hidden" name="id" value="<%= colecao.getId_colecao() %>">

    Nome: <input type="text" name="nome" value="<%= colecao.getNome() %>" required><br><br>
    Data Início: <input type="date" name="data_inicio" value="<%= colecao.getData_inicio() %>" required><br><br>
    Data Fim: <input type="date" name="data_fim" value="<%= colecao.getData_fim() != null ? colecao.getData_fim() : "" %>"><br><br>

    <input type="submit" value="Salvar Alterações"
           style="background-color: dodgerblue; color: white; padding: 8px 15px; border: none;">
</form>

<br>
<a href="dashboard">Voltar</a>

</body>
</html>
