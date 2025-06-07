<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<h2>Entrar no sistema</h2>

<form action="login" method="post">
    <label>Email: <input type="email" name="email" required /></label><br><br>
    <label>Senha: <input type="password" name="senha" required /></label><br><br>

    <input type="submit" value="Entrar"
           style="background-color: #007bff; color: white; padding: 8px 15px; border: none; cursor: pointer;" />
</form>


<% if (request.getAttribute("erro") != null) { %>
<p style="color: red;"><%= request.getAttribute("erro") %></p>
<% } %>

<!-- Botão Voltar -->
<form action="index.jsp" method="get">
    <input type="submit" value="Voltar"
           style="margin-top: 10px; background-color: gray; color: white; padding: 6px 12px; border: none; cursor: pointer;" />
</form>

</body>
</html>
