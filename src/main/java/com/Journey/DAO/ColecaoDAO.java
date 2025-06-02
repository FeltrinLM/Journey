package com.Journey.DAO;

import com.Journey.model.Colecao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColecaoDAO {

    public List<Colecao> listar() {
        List<Colecao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Colecao";

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Colecao c = new Colecao();
                c.setId_colecao(rs.getInt("id_colecao"));
                c.setNome(rs.getString("nome"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_fim(rs.getString("data_fim"));
                lista.add(c);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar coleções: " + e.getMessage());
        }

        return lista;
    }

    public Colecao buscarPorId(int id) {
        String sql = "SELECT * FROM Colecao WHERE id_colecao = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Colecao c = new Colecao();
                c.setId_colecao(rs.getInt("id_colecao"));
                c.setNome(rs.getString("nome"));
                c.setData_inicio(rs.getString("data_inicio"));
                c.setData_fim(rs.getString("data_fim"));
                return c;
            }

        } catch (Exception e) {
            System.err.println("Erro ao buscar coleção: " + e.getMessage());
        }

        return null;
    }

    public boolean inserir(Colecao c) {
        String sql = "INSERT INTO Colecao (nome, data_inicio, data_fim) VALUES (?, ?, ?)";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getData_inicio());

            if (c.getData_fim() == null || c.getData_fim().isEmpty()) {
                stmt.setNull(3, java.sql.Types.DATE);
            } else {
                stmt.setString(3, c.getData_fim());
            }

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Erro ao inserir coleção: " + e.getMessage());
            return false;
        }
    }


    public boolean atualizar(Colecao c) {
        String sql = "UPDATE Colecao SET nome = ?, data_inicio = ?, data_fim = ? WHERE id_colecao = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getData_inicio());
            stmt.setString(3, c.getData_fim());
            stmt.setInt(4, c.getId_colecao());

            System.out.println(">> Atualizando coleção:");
            System.out.println("ID: " + c.getId_colecao());
            System.out.println("Nome: " + c.getNome());

            int linhas = stmt.executeUpdate();
            System.out.println("Linhas afetadas: " + linhas);

            return linhas > 0;
        } catch (Exception e) {
            System.err.println("Erro ao atualizar coleção: " + e.getMessage());
            return false;
        }
    }



    public boolean excluir(int id) {
        String sql = "DELETE FROM Colecao WHERE id_colecao = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Erro ao excluir coleção: " + e.getMessage());
            return false;
        }
    }
}
