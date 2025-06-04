package com.Journey.DAO;

import com.Journey.model.Peca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO {
    //metodo para listar pecas cadastradas
    public ArrayList<Peca> listarPecas(){
        String sql = "SELECT * FROM Peca";
        ArrayList<Peca> funcionarios = new ArrayList<Peca>();

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while(rs.next()){
                Peca p= new Peca();
                p.setPeca_id(rs.getInt("peca_id"));
                p.setId_colecao(rs.getInt("id_colecao"));
                p.setModelo(rs.getString("modelo"));
                p.setTamanho(rs.getString("tamanho"));
                p.setCor(rs.getString("cor"));
                funcionarios.add(p);
            }
        } catch (SQLException e) {
            System.err.println("erro ao listar as pecas " + e.getMessage());
            return null;
        }
        return funcionarios;
    }

    public Peca buscarPeca(int idPeca){
        String sql = "SELECT * FROM Peca WHERE peca_id = ?";
        Peca peca = null;
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idPeca);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                peca = new Peca();
                peca.setPeca_id(rs.getInt("peca_id"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionario " + e.getMessage());
        }
        return peca;
    }

    public boolean removerPeca(int idPeca){
        String sql = "DELETE FROM Peca WHERE  peca_id = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idPeca);
            stmt.execute();
            if(stmt.getUpdateCount()<=0){
                System.out.println("Nenhuma peca com id " + idPeca + " encontrado");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao exlcuir peca " + e.getMessage());
            return false;
        }
        System.out.println("peca id: " + idPeca + " excluida com sucesso");
        return true;
    }

    //método para alterar uma peca
    public boolean alterarPeca(Peca p){
        String sql = "UPDATE peca SET id_colecao = ?, modelo = ?, tamanho = ?, cor = ? WHERE peca_id = ?";
        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, p.getId_colecao());
            stmt.setString(2, p.getModelo());
            stmt.setString(3, p.getTamanho());
            stmt.setString(4, p.getCor());
            stmt.setInt(5, p.getPeca_id());
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("erro ao alterar peca " + e.getMessage());
            return false;
        }
        System.out.println("peca id: " + p.getPeca_id() + " alterada");
        return true;
    }

    //método para inserir um nova peca
    public boolean inserirPeca(Peca peca) {
        String sql = "INSERT INTO Peca (modelo, tamanho, cor, id_colecao) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoBanco.getConexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, peca.getModelo());
            stmt.setString(2, peca.getTamanho());
            stmt.setString(3, peca.getCor());
            stmt.setInt(4, peca.getId_colecao());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (Exception e) {
            System.err.println("Erro ao inserir peça: " + e.getMessage());
            return false;
        }
    }
}
