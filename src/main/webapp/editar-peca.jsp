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

<form method="post" action="editar-peca">
    <input type="hidden" name="peca_id" value="<%= peca.getPeca_id() %>">

    Tipo: <input type="text" name="tipo" value="<%= peca.getTipo() %>" required><br><br>
    Tamanho: <input type="text" name="tamanho" value="<%= peca.getTamanho() %>" required><br><br>
    Cor: <input type="text" name="cor" value="<%= peca.getCor() %>" required><br><br>
    Quantidade: <input type="number" name="quantidade" value="<%= peca.getQuantidade() %>" required><br><br>

    <input type="submit" value="Salvar alterações"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br>
<a href="dashboard">Cancelar</a>

</body>
</html>
