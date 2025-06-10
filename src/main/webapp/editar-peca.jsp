<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Journey.model.Peca" %>
<%
    Peca peca = (Peca) request.getAttribute("peca");
    if (peca == null) {
        response.sendRedirect("dashboard");
        return;
    }

    String[] tamanhos = {"PP", "P", "M", "G", "GG", "EXG"};
    String[] tipos = {"Camiseta", "Moletom", "Casaco"};
    String[] cores = {"Preto", "Branco", "Amarelo", "Azul marinho", "Off white", "Vermelho", "Roxo"};
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Peça</title>
    <link rel="stylesheet" href="CSS/editar-peca.css">
</head>
<body>

<h2>Editar Peça</h2>

<form method="post" action="editar-peca">
    <input type="hidden" name="peca_id" value="<%= peca.getPeca_id() %>">

    Tipo:
    <select name="tipo" required>
        <% for (String t : tipos) { %>
        <option value="<%= t %>" <%= t.equals(peca.getTipo()) ? "selected" : "" %>><%= t %></option>
        <% } %>
    </select><br><br>

    Tamanho:
    <select name="tamanho" required>
        <% for (String t : tamanhos) { %>
        <option value="<%= t %>" <%= t.equals(peca.getTamanho()) ? "selected" : "" %>><%= t %></option>
        <% } %>
    </select><br><br>

    Cor:
    <select name="cor" required>
        <% for (String c : cores) { %>
        <option value="<%= c %>" <%= c.equals(peca.getCor()) ? "selected" : "" %>><%= c %></option>
        <% } %>
    </select><br><br>

    Quantidade: <input type="number" name="quantidade" value="<%= peca.getQuantidade() %>" required><br><br>

    <input type="submit" value="Salvar alterações"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br>
<a href="dashboard">Cancelar</a>

</body>
</html>
