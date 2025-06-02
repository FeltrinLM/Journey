<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Coleção</title>
</head>
<body>

<h2>Cadastrar Nova Coleção</h2>

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
