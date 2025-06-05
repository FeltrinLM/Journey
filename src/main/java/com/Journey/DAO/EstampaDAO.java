package com.Journey.DAO;

import com.Journey.model.Estampa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstampaDAO {

    public List<Estampa> listar() {
        List<Estampa> lista = new ArrayList<>();
        String sql = "SELECT * FROM Estampa";

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estampa e = new Estampa();
                e.setId_estampa(rs.getInt("id_estampa"));
                e.setNome(rs.getString("nome"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setId_colecao(rs.getInt("id_colecao"));
                lista.add(e);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar estampas: " + e.getMessage());
        }

        return lista;
    }

    public Estampa buscarPorId(int id) {
        String sql = "SELECT * FROM Estampa WHERE id_estampa = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Estampa e = new Estampa();
                e.setId_estampa(rs.getInt("id_estampa"));
                e.setId_colecao(rs.getInt("id_colecao"));
                e.setNome(rs.getString("nome"));
                e.setQuantidade(rs.getInt("quantidade"));
                return e;
            }

        } catch (Exception e) {
            System.err.println("Erro ao buscar estampas: " + e.getMessage());
        }

        return null;
    }

    public boolean inserir(Colecao colecao) {
        String sql = "INSERT INTO Colecao (nome, data_inicio, data_fim) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, colecao.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(colecao.getData_inicio()));

            if (colecao.getData_fim() == null || colecao.getData_fim().isEmpty()) {
                stmt.setNull(3, java.sql.Types.DATE);
            } else {
                stmt.setDate(3, java.sql.Date.valueOf(colecao.getData_fim()));
            }

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Erro ao inserir coleção: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public boolean atualizar(Colecao c) {
        String sql = "UPDATE Colecao SET nome = ?, data_inicio = ?, data_fim = ? WHERE id_colecao = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());

            if (c.getData_inicio() == null || c.getData_inicio().isEmpty()) {
                throw new IllegalArgumentException("Data de início é obrigatória");
            }
            stmt.setDate(2, java.sql.Date.valueOf(c.getData_inicio()));

            // Tratar data_fim (opcional)
            if (c.getData_fim() == null || c.getData_fim().isEmpty()) {
                stmt.setNull(3, java.sql.Types.DATE);
            } else {
                stmt.setDate(3, java.sql.Date.valueOf(c.getData_fim()));
            }

            stmt.setInt(4, c.getId_colecao());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                System.err.println("Nenhum registro foi atualizado - ID possivelmente não existe");
            }
            return rowsAffected > 0;

        } catch (IllegalArgumentException e) {
            System.err.println("Formato de data inválido: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println("Erro ao atualizar coleção: " + e.getMessage());
            e.printStackTrace();
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
