package com.Journey.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/POOW1";
    private static final String DEFAULT_USUARIO = "postgres";
    private static final String DEFAULT_SENHA = "1234";

    private static final String URL = System.getenv().getOrDefault("JDBC_DATABASE_URL", DEFAULT_URL);
    private static final String USUARIO = System.getenv().getOrDefault("JDBC_DATABASE_USER", DEFAULT_USUARIO);
    private static final String SENHA = System.getenv().getOrDefault("JDBC_DATABASE_PASSWORD", DEFAULT_SENHA);

    public static Connection getConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL não encontrado.");
            e.printStackTrace();
            throw new RuntimeException("Driver do PostgreSQL não foi carregado.", e);
        } catch (SQLException e) {
            System.err.println("Erro ao obter conexão com o banco: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Falha ao conectar no PostgreSQL.", e);
        }
    }

}
