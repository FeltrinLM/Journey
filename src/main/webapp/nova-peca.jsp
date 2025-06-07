<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Peça</title>
</head>
<body>

<h2>Cadastrar Nova Peça</h2>

<form method="post" action="nova-peca">
    Tipo: <input type="text" name="tipo" required><br><br>
    Tamanho: <input type="text" name="tamanho" required><br><br>
    Cor: <input type="text" name="cor" required><br><br>
    Quantidade: <input type="number" name="quantidade" required><br><br>

    <input type="submit" value="Salvar"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br>
<a href="dashboard">Voltar para o Dashboard</a>

</body>
</html>
