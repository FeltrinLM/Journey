<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Usuario" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp?erro=session_expired");
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
    ID da Coleção: <input type="number" name="id_colecao" required><br>
    <input type="submit" value="Cadastrar">
</form>

<br>
<form action="dashboard" method="get">
    <input type="submit" value="Cancelar">
</form>

</body>
</html>
