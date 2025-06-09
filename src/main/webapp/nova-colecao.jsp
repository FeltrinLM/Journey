<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Coleção</title>
</head>
<body>

<h2>Cadastrar Nova Coleção</h2>

<%-- Exibir mensagem de erro, se houver --%>
<%
    String erro = (String) request.getAttribute("erro");
    if (erro != null) {
%>
<p style="color:red;"><%= erro %></p>
<%
    }
%>

<form method="post" action="nova-colecao">
    Nome: <input type="text" name="nome" required><br><br>
    Data Início: <input type="date" name="data_inicio" required><br><br>
    Data Fim: <input type="date" name="data_fim"><br><br>

    <input type="submit" value="Salvar"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br>
<a href="dashboard">Voltar para o Dashboard</a>

</body>
</html>
