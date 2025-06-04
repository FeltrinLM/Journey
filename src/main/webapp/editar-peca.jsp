<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Peca" %>

<%
    Peca peca = (Peca) request.getAttribute("peca");

    if (peca == null) {
        response.sendRedirect("dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Peça</title>
</head>
<body>
<h2>Editar Peça</h2>

<form action="editar-peca" method="post">
    <input type="hidden" name="id" value="<%= peca.getPeca_id() %>">

    Modelo: <input type="text" name="modelo" value="<%= peca.getModelo() %>" required><br>
    Tamanho: <input type="text" name="tamanho" value="<%= peca.getTamanho() %>" required><br>
    Cor: <input type="text" name="cor" value="<%= peca.getCor() %>" required><br>
    ID da Coleção: <input type="number" name="id_colecao" value="<%= peca.getId_colecao() %>" required><br><br>

    <input type="submit" value="Salvar Alterações"
        style="background-color: dodgerblue; color: white; padding: 8px 15px; border: none;">
</form>

<br>
<a href="dashboard">Voltar</a>
</body>
</html>
