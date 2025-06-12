<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Peça</title>
    <link rel="stylesheet" href="CSS/nova-peca.css">
</head>
<body>

<div class="form-container">
    <h2>Cadastrar Nova Peça</h2>

    <form method="post" action="nova-peca">
        <label>Tipo:</label><br>
        <select name="tipo" required>
            <option value="">Selecione</option>
            <option value="Camiseta">Camiseta</option>
            <option value="Moletom">Moletom</option>
            <option value="Casaco">Casaco</option>
        </select><br>

        <label>Tamanho:</label><br>
        <select name="tamanho" required>
            <option value="">Selecione</option>
            <option value="PP">PP</option>
            <option value="P">P</option>
            <option value="M">M</option>
            <option value="G">G</option>
            <option value="GG">GG</option>
            <option value="EXG">EXG</option>
        </select><br>

        <label>Cor:</label><br>
        <select name="cor" required>
            <option value="">Selecione</option>
            <option value="Preto">Preto</option>
            <option value="Branco">Branco</option>
            <option value="Amarelo">Amarelo</option>
            <option value="Azul marinho">Azul marinho</option>
            <option value="Off white">Off white</option>
            <option value="Vermelho">Vermelho</option>
            <option value="Roxo">Roxo</option>
        </select><br>

        <label>Quantidade:</label><br>
        <input type="number" name="quantidade" required><br>

        <input type="submit" value="Salvar" class="btn-salvar">
    </form>

    <a href="dashboard" class="btn-voltar">Voltar para o Dashboard</a>
</div>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background-color: white;
        padding: 30px;
        border-radius: 8px;
        border: 1px solid #ccc;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
        width: 350px;
        text-align: center;
    }

    .form-container h2 {
        margin-bottom: 20px;
    }

    .form-container select,
    .form-container input[type="number"] {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .btn-salvar {
        background-color: green;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .btn-salvar:hover {
        background-color: #006400;
    }

    .btn-voltar {
        display: inline-block;
        margin-top: 10px;
        color: #007BFF;
        text-decoration: none;
    }

    .btn-voltar:hover {
        text-decoration: underline;
    }

</style>
</body>
</html>
