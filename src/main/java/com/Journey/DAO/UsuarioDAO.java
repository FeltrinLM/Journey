package com.Journey.DAO;

import com.Journey.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean inserir(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Usuario (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean atualizar(Usuario usuario) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Usuario SET nome = ?, email = ?, senha = ? WHERE usuario_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId_usuario());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean excluir(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Usuario WHERE usuario_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    public List<Usuario> listar() throws SQLException, ClassNotFoundException {
        String sql = "SELECT usuario_id, nome, email, senha FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setid_usuario(rs.getInt("usuario_id"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
        }
        return usuarios;
    }

    public Usuario buscarPorId(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT usuario_id, nome, email, senha FROM USAURIO WHERE usuario_id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setid_usuario(rs.getInt("usuario_id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    return u;
                }
            }
        }
        return null;
    }

    public Usuario buscarPorEmail(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT usuario_id, nome, email, senha FROM USUARIO WHERE email = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setid_usuario(rs.getInt("usuario_id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    return u;
                }
            }
        }
        return null;
    }

    public Usuario buscarPorEmailESenha(String email, String senha) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM USUARIO WHERE email = ? AND senha = ?";

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);  // ← AGORA É STRING!

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setid_usuario(rs.getInt("usuario_id"));
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                    u.setSenha(rs.getString("senha"));
                    return u;
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

