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
    Tipo:
    <select name="tipo" required>
        <option value="">Selecione</option>
        <option value="Camiseta">Camiseta</option>
        <option value="Moletom">Moletom</option>
        <option value="Casaco">Casaco</option>
    </select><br><br>

    Tamanho:
    <select name="tamanho" required>
        <option value="">Selecione</option>
        <option value="PP">PP</option>
        <option value="P">P</option>
        <option value="M">M</option>
        <option value="G">G</option>
        <option value="GG">GG</option>
        <option value="EXG">EXG</option>
    </select><br><br>

    Cor:
    <select name="cor" required>
        <option value="">Selecione</option>
        <option value="Preto">Preto</option>
        <option value="Branco">Branco</option>
        <option value="Amarelo">Amarelo</option>
        <option value="Azul marinho">Azul marinho</option>
        <option value="Off white">Off white</option>
        <option value="Vermelho">Vermelho</option>
        <option value="Roxo">Roxo</option>
    </select><br><br>

    Quantidade: <input type="number" name="quantidade" required><br><br>

    <input type="submit" value="Salvar"
           style="background-color: green; color: white; padding: 10px 15px; border: none; cursor: pointer;">
</form>

<br>
<a href="dashboard">Voltar para o Dashboard</a>

</body>
</html>
