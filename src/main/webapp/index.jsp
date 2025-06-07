<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<h2>Bem-vindo! Crie sua conta ou utilize uma já existente para visualizar o estoque.</h2>

<form action="usuario" method="post">
    <label>Nome: <input type="text" name="nome" required /></label><br><br>
    <label>Email: <input type="text" name="email" required /></label><br><br>
    <label>Senha: <input type="password" name="senha" required /></label><br><br>
    <input type="submit" value="Cadastrar"
           style="background-color: #008000; color: white; padding: 8px 15px; border: none;" />
</form>

<p>Já tem uma conta? <a href="login.jsp">Clique aqui para fazer login</a></p>

<% if (request.getAttribute("mensagem") != null) { %>
<p style="color: red;"><%= request.getAttribute("mensagem") %></p>
<% } %>

</body>
</html>
