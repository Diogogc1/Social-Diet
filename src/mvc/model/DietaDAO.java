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
import java.util.Locale;

/**
 *
 * @author diogo
 */
public class DietaDAO {
    List<Dieta> dietas;
    private final Login login = new Login();
    private String sql;
    private final PessoaDAO pessoaDAO;
    private final AvaliacaoDAO avaliacaoDAO;
    private final TipoDietaDAO tipoDietaDAO;
    private Dieta d;
    
    public DietaDAO(PessoaDAO pessoaDAO, AvaliacaoDAO avaliacaoDAO, TipoDietaDAO tipoDietaDAO) {
        this.pessoaDAO = pessoaDAO;
        this.avaliacaoDAO = avaliacaoDAO;
        this.tipoDietaDAO = tipoDietaDAO;
    }
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public final void adicionar(Dieta dieta){
        sql = "insert into dieta"
                + " (idPessoa, idAvaliacao, idTipoDieta, objetivo, caloria, numeroRefeicoes, dataCriacao, dataModificacao)"
                + " values (?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, dieta.getPessoa().getId());
            ps.setLong(2, dieta.getAvaliacao().getId());
            ps.setLong(3, dieta.getTipoDieta().getId());
            ps.setString(4, dieta.getObjetivo());
            ps.setDouble(5, dieta.getCaloria());
            ps.setInt(6, dieta.getNumeroRefeicoes());
            ps.setDate(7, java.sql.Date.valueOf(dieta.getDataCriacao()));
            ps.setDate(8, java.sql.Date.valueOf(dieta.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Dieta inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar essa Dieta no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA O REGISTRODIETA PARA SER REMOVIDO
    public void remover(Dieta dieta){
        sql = "delete from dieta where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, dieta.getId());
            
            ps.execute();
            
            System.out.println("\n Dieta removida com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a Dieta!", e);
        }
    }
    
    //ALTERAR
    public void alterar(Dieta dieta, Dieta dietaNovo){
        sql = "update alimento set idPessoa = ?, idAvaliacao = ?, idTipoDieta = ?, objetivo = ?, caloria = ?, numeroRefeicoes = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, dieta.getPessoa().getId());
            ps.setLong(2, dieta.getAvaliacao().getId());
            ps.setLong(3, dieta.getTipoDieta().getId());
            ps.setString(4, dieta.getObjetivo());
            ps.setDouble(5, dieta.getCaloria());
            ps.setInt(6, dieta.getNumeroRefeicoes());
            ps.setDate(8, java.sql.Date.valueOf(dieta.getDataCriacao()));
            ps.setDate(9, java.sql.Date.valueOf(dieta.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Dieta alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar a Dieta!", e);
        }
    }
    
    //BUSCAR DIETA POR ID
    public Dieta buscar(long id){
        sql = "select * from dieta where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                d = new Dieta();
                
                if(rs.next()){
                    d.setId(rs.getLong("id"));
                    d.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                    d.setAvaliacao(avaliacaoDAO.buscar(rs.getLong("idAvaliacao")));
                    d.setTipoDieta(tipoDietaDAO.buscar(rs.getLong("idPessoa")));
                    d.setCaloria(rs.getDouble("caloria"));
                    d.setNumeroRefeicoes(rs.getInt("numeroRefeicoes"));
                    d.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    d.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return d;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar a dieta!", e);
        }
    }
    
    //BUSCAR PESSOA AVALIACAO FISICA
    public Dieta buscarPessoa (Pessoa pessoaLogada){
        for(Dieta dieta : dietas){
            if (dieta != null && dieta.getPessoa().equals(pessoaLogada)){
                return dieta;
            }
        }
        return null;
    }
    
    public List<Dieta> listar(){
        sql = "select * from dieta";

        dietas = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                d = new Dieta();
                d.setId(rs.getLong("id"));
                d.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                d.setAvaliacao(avaliacaoDAO.buscar(rs.getLong("idAvaliacao")));
                d.setTipoDieta(tipoDietaDAO.buscar(rs.getLong("idTipoDieta")));
                d.setCaloria(rs.getDouble("caloria"));
                d.setNumeroRefeicoes(rs.getInt("numeroRefeicoes"));
                d.setObjetivo(rs.getString("objetivo"));
                d.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                d.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                dietas.add(d);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }
        return dietas;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n============= DIETAS =============");
        for(Dieta dieta : dietas) {
            if(dieta != null && dieta.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(dieta.getId()).
                append("\n Tipo de Dieta: ").append(dieta.getTipoDieta().getNome()).
                append("\n Objetivo: ").append(dieta.getObjetivo()).
                append("\n Calorias: ").append(String.format(Locale.US, "%.2f", dieta.getCaloria())).
                append("\n Numero de Refeicoes: ").append(dieta.getNumeroRefeicoes()).
                append("\n Data de Criacao: ").append(dieta.getDataCriacao()).
                append("\n Data de Modificacao: ").append(dieta.getDataModificacao()).
                append("\n =================================");
            }
        }
        return sb.toString();
    }
}
