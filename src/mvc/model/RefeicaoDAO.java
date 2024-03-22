/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public class RefeicaoDAO {
    List<Refeicao> refeicoes;
    private final Login login = new Login();
    int cont;
    String sql;
    DietaDAO dietaDAO;
    Refeicao r;
    
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    
    public RefeicaoDAO(DietaDAO dietaDAO) {
        this.dietaDAO = dietaDAO;
//        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Café da Manhã"));
//        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Almoco"));
//        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Janta"));
    }
    
    //ADICIONAR
    public void adicionar(Refeicao refeicao){
        sql = "insert into refeicao"
        + " (idDieta, nome, carboidrato, proteina, gordura, caloria, dataCriacao, dataModificacao)"
        + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, refeicao.getDieta().getId());
            ps.setString(2, refeicao.getNomeDaRefeicao());
            ps.setDouble(3, refeicao.getCarboidrato());
            ps.setDouble(4, refeicao.getProteina());
            ps.setDouble(5, refeicao.getGordura());
            ps.setDouble(6, refeicao.getCaloria());
            ps.setDate(7, java.sql.Date.valueOf(refeicao.getDataCriacao()));
            ps.setDate(8, java.sql.Date.valueOf(refeicao.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Refeicao inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar essa refeicao no banco!", e);
        }
    }
    
    //REMOVER
    public void remover(Refeicao refeicao){
        sql = "delete from refeicao where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, refeicao.getId());
            
            ps.execute();
            
            System.out.println("\n Refeicao removida com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a Refeicao!", e);
        }
    }
    
    //ALTERAR
    public void alterar(Refeicao refeicao, Refeicao refeicaoNova){
        sql = "update refeicao set idDieta = ?, nome = ?, carboidrato = ?, proteina = ?, gordura = ?, caloria = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, refeicao.getDieta().getId());
            ps.setString(2, refeicao.getNomeDaRefeicao());
            ps.setDouble(3, refeicao.getCarboidrato());
            ps.setDouble(4, refeicao.getProteina());
            ps.setDouble(5, refeicao.getGordura());
            ps.setDouble(6, refeicao.getCaloria());
            ps.setDate(7, java.sql.Date.valueOf(refeicao.getDataCriacao()));
            ps.setDate(8, java.sql.Date.valueOf(refeicao.getDataModificacao()));
            ps.setLong(9, refeicao.getId());
            ps.execute();
            
            System.out.println("\n Refeicao alterada com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar a Refeicao!", e);
        }
    }
    
    //BUSCAR
    public Refeicao buscar(long id){
        sql = "select * from refeicao where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                r = new Refeicao();
                
                if(rs.next()){
                    r.setId(rs.getLong("id"));
                    r.setDieta(dietaDAO.buscar(rs.getLong("idDieta")));
                    r.setNomeDaRefeicao(rs.getString("nome"));
                    r.setCarboidrato(rs.getDouble("carboidrato"));
                    r.setProteina(rs.getDouble("proteina"));
                    r.setGordura(rs.getDouble("gordura"));
                    r.setCaloria(rs.getDouble("caloria"));
                    r.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    r.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return r;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar a refeicao!", e);
        }
    }
    
    //BUSCAR NOME
    public Refeicao buscarNome(String nome){
        sql = "select * from refeicao where nome = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setString(1, nome);
            try(ResultSet rs = ps.executeQuery()){
                r = new Refeicao();
                
                if(rs.next()){
                    r.setId(rs.getLong("id"));
                    r.setDieta(dietaDAO.buscar(rs.getLong("idDieta")));
                    r.setNomeDaRefeicao(rs.getString("nome"));
                    r.setCarboidrato(rs.getDouble("carboidrato"));
                    r.setProteina(rs.getDouble("proteina"));
                    r.setGordura(rs.getDouble("gordura"));
                    r.setCaloria(rs.getDouble("caloria"));
                    r.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    r.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return r;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar a refeicao!", e);
        }
    }
    
    public int numeroDeRefeicaoDaDieta(Dieta dieta) {
        cont = 0;
        sql = "SELECT COUNT(*) AS numRefeicoes FROM refeicao WHERE idDieta = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, dieta.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cont = rs.getInt("numRefeicoes");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível obter a quantidade de refeições da dieta!", e);
        }

        return cont;
    }
     
    public boolean isVazio(){
        sql = "SELECT COUNT(*) FROM refeicao";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int totalRegistros = rs.getInt(1);
                return totalRegistros == 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar se a tabela de refeicoes está vazia!", e);
        }

        return true;
    }
    
    public boolean bateuMetaDieta(Dieta dietaSelecionada){
        carboidrato = 0;
        proteina = 0;
        gordura = 0;
        calorias = 0;
        for (Refeicao refeicao : refeicoes) {
            if(refeicao != null && dietaSelecionada.equals(refeicao.getDieta())){
                carboidrato += refeicao.getCarboidrato() / (dietaSelecionada.getTipoDieta().getCarboidrato() * dietaSelecionada.getCaloria());
                proteina    += refeicao.getProteina()    / (dietaSelecionada.getTipoDieta().getProteina() * dietaSelecionada.getCaloria());
                gordura     += refeicao.getGordura()     / (dietaSelecionada.getTipoDieta().getGordura() * dietaSelecionada.getCaloria());
                calorias    += refeicao.getCaloria()    / (dietaSelecionada.getCaloria());
            }
            
            if(carboidrato >= 1 && proteina >= 1 && gordura >= 1 && calorias >= 1){
                return true;
            }
        }     
        return false;
    }
    
    public List<Refeicao> listar(){
        sql = "select * from refeicao";

        refeicoes = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                r = new Refeicao();
                r.setId(rs.getLong("id"));
                r.setDieta(dietaDAO.buscar(rs.getLong("idDieta")));
                r.setNomeDaRefeicao(rs.getString("nome"));
                r.setCarboidrato(rs.getDouble("carboidrato"));
                r.setProteina(rs.getDouble("proteina"));
                r.setGordura(rs.getDouble("gordura"));
                r.setCaloria(rs.getDouble("caloria"));
                r.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                r.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                refeicoes.add(r);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return refeicoes;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("========== REFEICOES ==========");
        for(Refeicao refeicao : refeicoes) {
            if(refeicao != null && refeicao.getDieta().getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(refeicao.getId()).
                append("\n Nome: ").append(refeicao.getNomeDaRefeicao()).
                append("\n Carboidratos: ").append(refeicao.getCarboidrato()).
                append("\n Proteinas: ").append(refeicao.getProteina()).
                append("\n Gorduras: ").append(refeicao.getGordura()).
                append("\n Calorias: ").append(refeicao.getCaloria()).
                append("\n Data de Criacao: ").append(refeicao.getDataCriacao()).
                append("\n Data de Modificacao: ").append(refeicao.getDataModificacao()).
                append("\n ================================");
            }
        }
        return sb.toString();
    }
}
