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
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class AlimentoRefeicoesDAO {
    List<AlimentoRefeicoes> alimentoRefeicoes;
    private final Login login = new Login();
        
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    Preferencias preferenciaNova;
    private int cont;
    private String sql;
    AlimentoDAO alimentoDAO;
    RefeicaoDAO refeicaoDAO;
    AlimentoRefeicoes ar;
    
    public AlimentoRefeicoesDAO(AlimentoDAO alimentoDAO, RefeicaoDAO refeicaoDAO){
        this.alimentoDAO = alimentoDAO;
        this.refeicaoDAO = refeicaoDAO;
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(AlimentoRefeicoes alimentoRefeicao){
        sql = "insert into alimentorefeicoes"
        + " (idRefeicao, idAlimento, porcao, carboidrato, proteina, gordura, caloria, dataCriacao, dataModificacao)"
        + " values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, alimentoRefeicao.getRefeicao().getId());
            ps.setLong(2, alimentoRefeicao.getAlimento().getId());
            ps.setInt(3, alimentoRefeicao.getPorcao());
            ps.setDouble(4, alimentoRefeicao.getCarboidrato());
            ps.setDouble(5, alimentoRefeicao.getProteina());
            ps.setDouble(6, alimentoRefeicao.getGordura());
            ps.setDouble(7, alimentoRefeicao.getCaloria());
            ps.setDate(8, java.sql.Date.valueOf(alimentoRefeicao.getDataCriacao()));
            ps.setDate(9, java.sql.Date.valueOf(alimentoRefeicao.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n AlimentoRefeicao inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar esse AlimentoRefeicao no banco!", e);
        }
    }
    
    //REMOVER ALIMENTO
    public void removerAlimento(Alimento alimento){
        sql = "delete from alimentorefeicoes where idAlimento = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, alimento.getId());
            
            ps.execute();
            
            System.out.println("\n Alimento removido com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o alimento!", e);
        }
    }
    
    //REMOVER REFEICAO
    public void removerRefeicao(Refeicao refeicao){
        sql = "delete from alimentorefeicoes where idRefeicao = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, refeicao.getId());
            
            ps.execute();
            
            System.out.println("\n Refeicao removida com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a refeicao!", e);
        }
    }
    
    //ALTERAR
    public void alterar(AlimentoRefeicoes alimentoRefeicao, AlimentoRefeicoes alimentoRefeicaoNovo){
        sql = "update alimentorefeicoes set idRefeicao = ?, idAlimento = ?, porcao = ?, carboidrato = ?, proteina = ?, gordura = ?, caloria = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, alimentoRefeicaoNovo.getRefeicao().getId());
            ps.setLong(2, alimentoRefeicaoNovo.getAlimento().getId());
            ps.setInt(3, alimentoRefeicaoNovo.getPorcao());
            ps.setDouble(4, alimentoRefeicaoNovo.getCarboidrato());
            ps.setDouble(5, alimentoRefeicaoNovo.getProteina());
            ps.setDouble(6, alimentoRefeicaoNovo.getGordura());
            ps.setDouble(7, alimentoRefeicaoNovo.getCaloria());
            ps.setDate(8, java.sql.Date.valueOf(alimentoRefeicaoNovo.getDataCriacao()));
            ps.setDate(9, java.sql.Date.valueOf(alimentoRefeicaoNovo.getDataModificacao()));
            ps.setLong(9, alimentoRefeicao.getId());
            
            ps.execute();
            
            System.out.println("\n AlimentoRefeicoes alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o AlimentoRefeicoes!", e);
        }
    }
    
    //BUSCAR REFEICAO
    public AlimentoRefeicoes buscarAlimentosDeUmaRefeicao(Refeicao refeicaoEscolhida, int flag){
        sql = "select * from alimentorefeicoes where idRefeicao = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, refeicaoEscolhida.getId());

            try (ResultSet rs = ps.executeQuery()) {
                cont = 1;

                while (rs.next()) {
                    ar = new AlimentoRefeicoes();

                    ar.setId(rs.getLong("id"));
                    ar.setRefeicao(refeicaoDAO.buscar(rs.getLong("idRefeicao")));
                    ar.setAlimento(alimentoDAO.buscar(rs.getLong("idAlimento")));
                    ar.setPorcao(rs.getInt("porcao"));
                    ar.setCarboidrato(rs.getDouble("carboidrato"));
                    ar.setProteina(rs.getDouble("proteina"));
                    ar.setGordura(rs.getDouble("gordura"));
                    ar.setCaloria(rs.getDouble("caloria"));
                    ar.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    ar.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());

                    if (cont == flag) {
                        return ar;
                    }

                    cont++;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar o alimentoRefeicoes!", e);
        }

        return null;
    }
    
    
    public boolean bateuMetaRefeicao(Refeicao refeicaoNova){
        carboidrato = 0;
        proteina = 0;
        gordura = 0;
        calorias = 0;
        
        if(alimentoRefeicoes != null){
            for (AlimentoRefeicoes alimentoRefeicao : alimentoRefeicoes) {
                if(alimentoRefeicao != null && alimentoRefeicao.getRefeicao().equals(refeicaoNova)){
                    carboidrato += (alimentoRefeicao.getAlimento().getCarboidrato() * alimentoRefeicao.getAlimento().getPorcao()) / refeicaoNova.getCarboidrato();
                    proteina += (alimentoRefeicao.getAlimento().getProteina() * alimentoRefeicao.getAlimento().getPorcao()) / refeicaoNova.getProteina();
                    gordura += (alimentoRefeicao.getAlimento().getGordura() * alimentoRefeicao.getAlimento().getPorcao()) / refeicaoNova.getGordura();
                    calorias += (alimentoRefeicao.getAlimento().getCaloria() * alimentoRefeicao.getAlimento().getPorcao()) / refeicaoNova.getCaloria();
                }
            }
        }
        return carboidrato >= 1 && proteina >= 1 && gordura >= 1 && calorias >= 1;
    }
    
    public AlimentoRefeicoes cadastrarAutomaticoAlimentoRefeicoes(Refeicao refeicao, int j, PreferenciasDAO preferenciasDAO){
        preferenciaNova = preferenciasDAO.buscarNaoNulo(j);
        
        //GUARDANDO A PORCENTAGEM QUE O ALIMENTO REPRESENTA EM RELAÇÃO AO TOTAL DA REFEIÇÃO
        if(preferenciaNova != null){
            carboidrato = (preferenciaNova.getAlimento().getCarboidrato() * 100 * preferenciaNova.getAlimento().getPorcao()) / refeicao.getCarboidrato();
            proteina = (preferenciaNova.getAlimento().getProteina() * 100 * preferenciaNova.getAlimento().getPorcao()) / refeicao.getProteina();
            gordura = (preferenciaNova.getAlimento().getGordura() * 100 * preferenciaNova.getAlimento().getPorcao()) / refeicao.getGordura();
            calorias = (preferenciaNova.getAlimento().getCaloria() * 100 * preferenciaNova.getAlimento().getPorcao()) / refeicao.getCaloria();
        }else{
            return null;
        }

        return new AlimentoRefeicoes(refeicao, preferenciaNova.getAlimento(), preferenciaNova.getAlimento().getPorcao(), carboidrato, proteina, gordura, calorias);
    }
    
    public List<AlimentoRefeicoes> listar(){
        sql = "select * from alimentorefeicoes";

        alimentoRefeicoes = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                ar = new AlimentoRefeicoes();

                ar.setRefeicao(refeicaoDAO.buscar(rs.getLong("idRefeicao")));
                ar.setAlimento(alimentoDAO.buscar(rs.getLong("idAlimento")));
                ar.setPorcao(rs.getInt("porcao"));
                ar.setCarboidrato(rs.getDouble("carboidrato"));
                ar.setProteina(rs.getDouble("proteina"));
                ar.setGordura(rs.getDouble("gordura"));
                ar.setCaloria(rs.getDouble("caloria"));
                ar.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                ar.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                alimentoRefeicoes.add(ar);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return alimentoRefeicoes;
    }
    
    //TO STRING
    @Override
    public String toString(){
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("====== ALIMENTOS DAS REFEICOES ======");
        for(AlimentoRefeicoes alimentoRefeicao : alimentoRefeicoes) {
            if(alimentoRefeicao != null && alimentoRefeicao.getAlimento().getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append( alimentoRefeicao.getId()).
                append("\n Alimento: ").append( alimentoRefeicao.getAlimento().getNome()).
                append("\n Refeicao: ").append( alimentoRefeicao.getAlimento().getNome()).
                append("\n Porcao: ").append(alimentoRefeicao.getPorcao()).
                append("\n Carboidratos: ").append(alimentoRefeicao.getAlimento().getCarboidrato()).
                append("\n Proteinas: ").append(alimentoRefeicao.getAlimento().getProteina()).
                append("\n Gorduras: ").append(alimentoRefeicao.getAlimento().getGordura()).
                append("\n Calorias: ").append(alimentoRefeicao.getAlimento().getCaloria()).
                append("\n\n Data de Criacao: ").append( alimentoRefeicao.getDataCriacao()).
                append("\n Data de Modificacao: ").append( alimentoRefeicao.getDataModificacao()).
                append("\n ======================================== \n");
            }
        }
        return sb.toString();
    }
}
