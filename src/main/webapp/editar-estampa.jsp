<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Estampa" %>
<%
    Estampa estampa = (Estampa) request.getAttribute("estampa");
    if (estampa == null) {
        response.sendRedirect("dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Estampa</title>
</head>
<body>

<h2>Editar Estampa</h2>
<form method="post" action="editar-estampa">
    <input type="hidden" name="estampa_id" value="<%= estampa.getId_estampa() %>">

    Nome: <input type="text" name="nome" value="<%= estampa.getNome() %>" required><br>
    Quantidade: <input type="number" name="quantidade" value="<%= estampa.getQuantidade() %>" required><br>
    ID Coleção: <input type="number" name="id_colecao" value="<%= estampa.getId_colecao() %>" required><br>

    <input type="submit" value="Salvar alterações">
</form>
<br>
<form action="dashboard" method="get">
    <input type="submit" value="Cancelar">
</form>

</body>
</html>
