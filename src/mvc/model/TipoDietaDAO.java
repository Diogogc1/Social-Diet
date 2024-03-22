/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TipoDietaDAO {
    List<TipoDieta> tiposDieta;
    private String sql;
    private TipoDieta td;

    public TipoDietaDAO() {
//        adicionar(new TipoDieta("Equilibrada", 0.4, 0.3, 0.3));
//        adicionar(new TipoDieta("Low Carb", 0.3, 0.5, 0.2));
//        adicionar(new TipoDieta("Cetogenica", 0.15, 0.15, 0.7));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(TipoDieta tipoDieta){
        sql = "insert into tipoDieta"
        + " (nome, carboidrato, proteina, gordura, dataCriacao, dataModificacao)"
        + " values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setString(1, tipoDieta.getNome());
            ps.setDouble(2, tipoDieta.getCarboidrato());
            ps.setDouble(3, tipoDieta.getProteina());
            ps.setDouble(4, tipoDieta.getGordura());
            ps.setDate(5, java.sql.Date.valueOf(tipoDieta.getDataCriacao()));
            ps.setDate(6, java.sql.Date.valueOf(tipoDieta.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n TipoDieta inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar esse tipoDieta no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public void remover(TipoDieta tipoDieta){
        sql = "delete from tipoDieta where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, tipoDieta.getId());
            
            ps.execute();
            
            System.out.println("\n TipoDieta removido com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o tipoDieta!", e);
        }
    }
    
    //ALTERAR
    public void alterar(TipoDieta tipoDieta, TipoDieta tipoDietaNovo){
        sql = "update tipoDieta set nome = ?, carboidrato = ?, proteina = ?, gordura = ?, caloria = ? dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, tipoDieta.getNome());
            ps.setDouble(2, tipoDieta.getCarboidrato());
            ps.setDouble(3, tipoDieta.getProteina());
            ps.setDouble(4, tipoDieta.getGordura());
            ps.setDate(5, java.sql.Date.valueOf(tipoDieta.getDataCriacao()));
            ps.setDate(6, java.sql.Date.valueOf(tipoDieta.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n TipoDieta alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o tipoDieta!", e);
        }
    }
    
    //BUSCAR
    public TipoDieta buscar (long id){
        sql = "select * from tipoDieta where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                td = new TipoDieta();
                
                if(rs.next()){
                    td.setId(rs.getLong("id"));
                    td.setNome(rs.getString("nome"));
                    td.setCarboidrato(rs.getDouble("carboidrato"));
                    td.setProteina(rs.getDouble("proteina"));
                    td.setGordura(rs.getDouble("gordura"));
                    td.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    td.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                }else{
                    throw new SQLException();
                }

                return td;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o TipoDieta!", e);
        }
    }
    
    //LISTAR
    public List<TipoDieta> listar(){
        sql = "select * from tipoDieta";

        tiposDieta = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                td = new TipoDieta();
                td.setId(rs.getLong("id"));
                td.setNome(rs.getString("nome"));
                td.setCarboidrato(rs.getDouble("carboidrato"));
                td.setProteina(rs.getDouble("proteina"));
                td.setGordura(rs.getDouble("gordura"));
                td.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                td.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                tiposDieta.add(td);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return tiposDieta;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n ====== Seguidores ======");
        for (TipoDieta tipoDieta : tiposDieta) {
            if(tipoDieta != null){
                sb.append("\n ID: ").append(tipoDieta.getId()).
                append("\n Nome: ").append(tipoDieta.getNome()).
                append("\n Carboidratos: ").append(tipoDieta.getCarboidrato()).
                append("\n Proteinas: ").append(tipoDieta.getProteina()).
                append("\n Gorduras: ").append(tipoDieta.getGordura()).
                append("\n Data de Criacao: ").append(tipoDieta.getDataCriacao()).
                append("\n Data de Modificacao: ").append(tipoDieta.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}