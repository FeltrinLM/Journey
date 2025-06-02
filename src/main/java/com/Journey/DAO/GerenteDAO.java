package com.Journey.DAO;

import com.Journey.model.Gerente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO {

    public boolean inserir(Gerente gerente) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Gerente (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getEmail());
            stmt.setString(3, gerente.getSenha());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean atualizar(Gerente gerente) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Gerente SET nome = ?, email = ?, senha = ? WHERE gerente_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, gerente.getNome());
            stmt.setString(2, gerente.getEmail());
            stmt.setString(3, gerente.getSenha());
            stmt.setInt(4, gerente.getId_gerente());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Gerente WHERE gerente_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Gerente> listar() throws SQLException, ClassNotFoundException {
        String sql = "SELECT gerente_id, nome, email, senha FROM Gerente";
        List<Gerente> usuarios = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gerente g = new Gerente();
                g.setId_gerente(rs.getInt("gerente_id"));
                g.setNome(rs.getString("nome"));
                g.setEmail(rs.getString("email"));
                g.setSenha(rs.getString("senha"));
                usuarios.add(g);
            }
        }
        return usuarios;
    }

    public Gerente buscarPorId(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT gerente_id, nome, email, senha FROM Gerente WHERE gerente_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Gerente g = new Gerente();
                    g.setId_gerente(rs.getInt("gerente_id"));
                    g.setNome(rs.getString("nome"));
                    g.setEmail(rs.getString("email"));
                    g.setSenha(rs.getString("senha"));
                    return g;
                }
            }
        }
        return null;
    }

    public Gerente buscarPorEmail(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT gerente_id, nome, email, senha FROM Gerente WHERE email = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Gerente g = new Gerente();
                    g.setId_gerente(rs.getInt("gerente_id"));
                    g.setNome(rs.getString("nome"));
                    g.setEmail(rs.getString("email"));
                    g.setSenha(rs.getString("senha"));
                    return g;
                }
            }
        }
        return null;
    }

    public Gerente buscarPorEmailESenha(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Gerente WHERE email = ? AND senha = ?";

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);  // ← AGORA É STRING!

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Gerente g = new Gerente();
                    g.setId_gerente(rs.getInt("gerente_id"));
                    g.setNome(rs.getString("nome"));
                    g.setEmail(rs.getString("email"));
                    g.setSenha(rs.getString("senha"));
                    return g;
                } else {
                    return null;
                }
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao buscar gerente por email e senha: " + ex.getMessage());
            return null;
        }
    }
}

