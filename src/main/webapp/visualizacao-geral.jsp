<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Journey.model.Peca" %>
<%@ page import="com.Journey.model.Colecao" %>
<%@ page import="com.Journey.model.Estampa" %>
<%@ page import="com.Journey.model.Usuario" %>

<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("index.jsp?erro=session_expired");
        return;
    }

    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");
    List<Colecao> colecoes = (List<Colecao>) request.getAttribute("colecoes");
    List<Estampa> estampas = (List<Estampa>) request.getAttribute("estampas");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Visualização Geral</title>
</head>
<body>

<h2>Bem-vindo, <%= usuario.getNome() %></h2>

<!-- Lista de Peças -->
<h3>Lista de Peças</h3>
<table border="1">
    <tr>
        <th>Tipo</th>
        <th>Tamanho</th>
        <th>Cor</th>
        <th>Quantidade</th>
        <th>Ações</th>
    </tr>
    <% if (pecas != null) {
        for (Peca p : pecas) { %>
    <tr>
        <td><%= p.getTipo() %></td>
        <td><%= p.getTamanho() %></td>
        <td><%= p.getCor() %></td>
        <td><%= p.getQuantidade() %></td>
        <td>
            <form method="post" action="dashboard" style="display:inline;">
                <input type="hidden" name="acao" value="excluir">
                <input type="hidden" name="id" value="<%= p.getPeca_id() %>">
                <input type="submit" value="Excluir" style="background-color:red; color:white;">
            </form>
            <form method="get" action="editar-peca" style="display:inline;">
                <input type="hidden" name="id" value="<%= p.getPeca_id() %>">
                <input type="submit" value="Editar" style="background-color:blue; color:white;">
            </form>
        </td>
    </tr>
    <%  }} %>
</table>
<form action="nova-peca.jsp" method="get">
    <input type="submit" value="Adicionar nova peça" style="background-color:green; color:white;">
</form>

<!-- Lista de Coleções -->
<h3>Lista de Coleções</h3>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Data Início</th>
        <th>Data Fim</th>
        <th>Ações</th>
    </tr>
    <% if (colecoes != null) {
        for (Colecao c : colecoes) { %>
    <tr>
        <td><%= c.getNome() %></td>
        <td><%= c.getData_inicio() %></td>
        <td><%= c.getData_fim() %></td>
        <td>
            <form method="post" action="dashboard" style="display:inline;">
                <input type="hidden" name="acao" value="excluir-colecao">
                <input type="hidden" name="id" value="<%= c.getId_colecao() %>">
                <input type="submit" value="Excluir" style="background-color:red; color:white;">
            </form>
            <form method="get" action="editar-colecao" style="display:inline;">
                <input type="hidden" name="id" value="<%= c.getId_colecao() %>">
                <input type="submit" value="Editar" style="background-color:blue; color:white;">
            </form>
        </td>
    </tr>
    <%  }} %>
</table>
<form method="get" action="nova-colecao.jsp">
    <input type="submit" value="Cadastrar nova coleção" style="background-color:green; color:white;">
</form>

<!-- Lista de Estampas -->
<h3>Lista de Estampas</h3>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Quantidade</th>
        <th>ID Coleção</th>
        <th>Ações</th>
    </tr>
    <% if (estampas != null) {
        for (Estampa e : estampas) { %>
    <tr>
        <td><%= e.getNome() %></td>
        <td><%= e.getQuantidade() %></td>
        <td><%= e.getId_colecao() %></td>
        <td>
            <form method="post" action="dashboard" style="display:inline;">
                <input type="hidden" name="acao" value="excluir-estampa">
                <input type="hidden" name="id" value="<%= e.getId_estampa() %>">
                <input type="submit" value="Excluir" style="background-color:red; color:white;">
            </form>
            <!-- Editar -->
            <form method="get" action="editar-estampa" style="display:inline;">
                <input type="hidden" name="estampa_id" value="<%= e.getId_estampa() %>">
                <input type="submit" value="Editar" style="background-color:blue; color:white;">
            </form>
        </td>
    </tr>
    <%  }} %>
</table>

</body>
</html>
