<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.Journey.model.Peca" %>
<%@ page import="com.Journey.model.Gerente" %>
<%@ page import="com.Journey.model.Colecao" %>

<%
    Gerente usuario = (Gerente) session.getAttribute("usuario");
    List<Peca> pecas = (List<Peca>) request.getAttribute("pecas");

    if (usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
<h2>Bem-vindo, <%= usuario.getNome() %></h2>
<h3>Lista de Peças</h3>
<br>

<table border="1">
    <tr>
        <th>Modelo</th>
        <th>Tamanho</th>
        <th>Cor</th>
        <th>Coleção</th>
        <th>Ações</th>
    </tr>
    <% for (Peca p : pecas) { %>
    <tr>
        <td><%= p.getModelo() %></td>
        <td><%= p.getTamanho() %></td>
        <td><%= p.getCor() %></td>
        <td><%= p.getId_colecao() %></td>
        <td>
            <!-- Botão Excluir -->
            <form method="post" action="dashboard" style="display:inline;">
                <input type="hidden" name="acao" value="excluir">
                <input type="hidden" name="id" value="<%= p.getPeca_id() %>">
                <input type="submit" value="Excluir" style="background-color: red; color: white; border: none; padding: 5px 10px; cursor: pointer;">
            </form>

            <!-- Botão Editar -->
            <form method="get" action="editar-peca" style="display:inline; margin-left: 5px;">
                <input type="hidden" name="id" value="<%= p.getPeca_id() %>">
                <input type="submit" value="Editar" style="background-color: dodgerblue; color: white; border: none; padding: 5px 10px; cursor: pointer;">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<!-- Botão Adicionar Nova Peça -->
<form action="nova-peca.jsp" method="get">
    <input type="submit" value="Adicionar nova peça"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br><br>
<h3>Lista de Coleções</h3>

<table border="1">
    <tr>
        <th>Nome</th>
        <th>Data Início</th>
        <th>Data Fim</th>
        <th>Ações</th>
    </tr>
    <%
        List<Colecao> colecoes = (List<Colecao>) request.getAttribute("colecoes");
        for (Colecao c : colecoes) {
    %>
    <tr>
        <td><%= c.getNome() %></td>
        <td><%= c.getData_inicio() %></td>
        <td><%= c.getData_fim() %></td>
        <td>
            <!-- Botão Excluir -->
            <form method="post" action="dashboard" style="display:inline;">
                <input type="hidden" name="acao" value="excluir-colecao">
                <input type="hidden" name="id" value="<%= c.getId_colecao() %>">
                <input type="submit" value="Excluir" style="background-color: red; color: white; border: none; padding: 5px;">
            </form>

            <!-- Botão Editar -->
            <form method="get" action="editar-colecao" style="display:inline; margin-left: 5px;">
                <input type="hidden" name="id" value="<%= c.getId_colecao() %>">
                <input type="submit" value="Editar" style="background-color: dodgerblue; color: white; border: none; padding: 5px 10px; cursor: pointer;">
            </form>
        </td>
    </tr>
    <% } %>
</table>

<!-- Botão nova coleção -->
<br>
<form method="get" action="nova-colecao.jsp">
    <input type="submit" value="Cadastrar nova coleção"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<h3>Lista de Usuários</h3>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Email</th>
    </tr>
    <%
        List<Gerente> usuarios = (List<Gerente>) request.getAttribute("usuarios");
        for (Gerente g : usuarios) {
    %>
    <tr>
        <td><%= g.getNome() %></td>
        <td><%= g.getEmail() %></td>
    </tr>
    <% } %>
</table>

<!-- Botão novo usuário -->
<br>
<form action="usuario-form.jsp" method="get">
    <input type="submit" value="Cadastrar novo usuário"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

</body>
</html>
