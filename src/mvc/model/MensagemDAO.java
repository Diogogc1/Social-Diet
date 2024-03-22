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
public class MensagemDAO {
    List<Mensagem> mensagens;
    String sql;
    Mensagem m;
    PessoaDAO pessoaDAO;

    public MensagemDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
//        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Opa, bao?"));
//        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Bao e vc?"));
//        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Comecou a usar o postfit ne?"));
//        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Sim, muito bao"));
    }
    
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(Mensagem mensagem){
        sql = "insert into mensagem"
        + " (pessoaOrigem, pessoaDestino, mensagem, dataCriacao, dataModificacao)"
        + " values (?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, mensagem.getPessoaOrigem().getId());
            ps.setLong(2, mensagem.getPessoaDestino().getId());
            ps.setString(3, mensagem.getMensagem());
            ps.setDate(4, java.sql.Date.valueOf(mensagem.getDataCriacao()));
            ps.setDate(5, java.sql.Date.valueOf(mensagem.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Mensagem inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar essa mensagem no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public void remover(long idMensagem){
        sql = "delete from mensagem where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, idMensagem);
            
            ps.execute();
            
            System.out.println("\n Mensagem removida com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a mensagem!", e);
        }
    }
    
    //ALTERAR
    public void alterar(long idMensagem, Mensagem mensagemNovo){
        sql = "update mensagem set pessoaOrigem = ?, pessoaOrigem = ?, mensagem = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, mensagemNovo.getPessoaOrigem().getId());
            ps.setLong(2, mensagemNovo.getPessoaDestino().getId());
            ps.setString(3, mensagemNovo.getMensagem());
            ps.setDate(4, java.sql.Date.valueOf(mensagemNovo.getDataCriacao()));
            ps.setDate(5, java.sql.Date.valueOf(mensagemNovo.getDataModificacao()));
            ps.setLong(5, idMensagem);
            
            ps.execute();
            
            System.out.println("\n mensagem alterada com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar a mensagem!", e);
        }
    }
    
    //BUSCAR
    public Mensagem buscar (Long idMensagem){
        sql = "select * from mensagem where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, idMensagem);
            try(ResultSet rs = ps.executeQuery()){
                m = new Mensagem();
                
                if(rs.next()){
                    m.setId(rs.getLong("id"));
                    m.setPessoaOrigem(pessoaDAO.buscar(rs.getLong("pessoaOrigem")));
                    m.setPessoaDestino(pessoaDAO.buscar(rs.getLong("pessoaDestino")));
                    m.setMensagem(rs.getString("mensagem"));
                    m.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    m.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return m;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar a mensagem!", e);
        }
    }
    
    public List<Mensagem> listar(){
        sql = "select * from mensagem";

        mensagens = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                m = new Mensagem();
                m.setId(rs.getLong("id"));
                m.setPessoaOrigem(pessoaDAO.buscar(rs.getLong("pessoaOrigem")));
                m.setPessoaDestino(pessoaDAO.buscar(rs.getLong("pessoaDestino")));
                m.setMensagem(rs.getString("mensagem"));
                m.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                m.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                mensagens.add(m);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return mensagens;
    }
    

    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n =========== MENSAGENS ===========");
        for (Mensagem mensagem : mensagens) {
            if(mensagem != null){
                sb.append("\n ID: ").append(mensagem.getId()).
                append("\n Remetente: ").append(mensagem.getPessoaOrigem().getNome()).
                append("\n Destinatário: ").append(mensagem.getPessoaDestino().getNome()).
                append("\n Mensagem: ").append(mensagem.getMensagem()). 
                append("\n Data de Criacao: ").append(mensagem.getDataCriacao()).
                append("\n Data de Modificacao: ").append(mensagem.getDataModificacao()).
                append("\n =================================");
            }
        }
        return sb.toString();
    }
}
