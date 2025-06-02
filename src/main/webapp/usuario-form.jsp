<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
</head>
<body>
<h2>Incluir novo usuário</h2>
<form action="${pageContext.request.contextPath}/usuario" method="post">
    <label>Nome: <input type="text" name="nome" required /></label><br><br>
    <label>Email: <input type="text" name="email" required /></label><br><br>
    <label>Senha: <input type="password" name="senha" required /></label><br><br>
    <input type="submit" value="Cadastrar" />
</form>

<% if (request.getAttribute("mensagem") != null) { %>
<p style="color: green;"><%= request.getAttribute("mensagem") %></p>
<% } %>
</body>
</html>

