<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Estampa" %>
<%@ page import="com.Journey.model.Colecao" %>
<%@ page import="java.util.List" %>

<%
    Estampa estampa = (Estampa) request.getAttribute("estampa");
    List<Colecao> colecoes = (List<Colecao>) request.getAttribute("colecoes");

    if (estampa == null || colecoes == null) {
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

    Coleção:
    <select name="id_colecao" required>
        <% for (Colecao c : colecoes) { %>
        <option value="<%= c.getId_colecao() %>" <%= c.getId_colecao() == estampa.getId_colecao() ? "selected" : "" %>>
            <%= c.getNome() %>
        </option>
        <% } %>
    </select><br>

    <input type="submit" value="Salvar alterações">
</form>

<br>
<form action="dashboard" method="get">
    <input type="submit" value="Cancelar">
</form>

</body>
</html>
