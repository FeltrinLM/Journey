<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Journey.model.Colecao" %>
<%@ page import="com.Journey.model.Usuario" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp?erro=session_expired");
        return;
    }

    List<Colecao> colecoes = (List<Colecao>) request.getAttribute("colecoes");
    if (colecoes == null) {
        response.sendRedirect("nova-estampa"); // Garante que o servlet carrega os dados
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Estampa</title>
</head>
<body>

<h2>Adicionar Nova Estampa</h2>

<form action="nova-estampa" method="post">
    Nome: <input type="text" name="nome" required><br>
    Quantidade: <input type="number" name="quantidade" required><br>

    Coleção:
    <select name="id_colecao" required>
        <option value="">Selecione uma coleção</option>
        <% for (Colecao c : colecoes) { %>
        <option value="<%= c.getId_colecao() %>"><%= c.getNome() %></option>
        <% } %>
    </select><br>

    <input type="submit" value="Cadastrar">
</form>

<br>
<form action="dashboard" method="get">
    <input type="submit" value="Cancelar">
</form>

</body>
</html>
