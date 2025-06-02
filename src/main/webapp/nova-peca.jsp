<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Peça</title>
</head>
<body>
<h2>Adicionar Nova Peça</h2>

<form method="post" action="nova-peca">
    Modelo: <input type="text" name="modelo" required><br>
    Tamanho: <input type="text" name="tamanho" required><br>
    Cor: <input type="text" name="cor" required><br>
    ID da Coleção: <input type="number" name="id_colecao" required><br><br>

    <input type="submit" value="Cadastrar">
</form>

<br>
<a href="dashboard">Voltar</a>
</body>
</html>
