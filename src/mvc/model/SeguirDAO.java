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
 * @author diogo
 */

public class SeguirDAO {
    List<Seguir> seguidores;
    private final Login login = new Login();
    String sql;
    PessoaDAO pessoaDAO;
    Seguir s;
    PostDAO postDAO;    
    
    public SeguirDAO(PessoaDAO pessoaDAO, PostDAO postDAO) {
        this.pessoaDAO = pessoaDAO;
        this.postDAO = postDAO;
        //this.adicionar(new Seguir(pessoaLogada, pessoaSeguindo));
    }
    
    //ADICIONAR
    public void adicionar(Seguir seguidor){
        sql = "insert into seguir"
        + " (idPessoaOrigem, idPessoaSeguindo, dataCriacao, dataModificacao)"
        + " values (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, seguidor.getPessoaOrigem().getId());
            ps.setLong(2, seguidor.getPessoaSeguindo().getId());
            ps.setDate(3, java.sql.Date.valueOf(seguidor.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(seguidor.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Seguidor inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar esse seguidor no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public void remover(long idSeguidor){
        sql = "delete from seguir where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, idSeguidor);
            
            ps.execute();
            
            System.out.println("\n Seguidor removido com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o seguidor!", e);
        }
    }
    
    //ALTERAR
    public void alterar(long idSeguidor, Seguir seguidorNova){
        sql = "update seguir set idPessoaOrigem = ?, idPessoaSeguindo = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, seguidorNova.getPessoaOrigem().getId());
            ps.setLong(2, seguidorNova.getPessoaSeguindo().getId());
            ps.setDate(3, java.sql.Date.valueOf(seguidorNova.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(seguidorNova.getDataModificacao()));
            ps.setLong(5, idSeguidor);
            
            ps.execute();
            
            System.out.println("\n Seguidor alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o seguidor!", e);
        }
    }
    
    //BUSCAR
    public Seguir buscar(long idSeguidor){
        sql = "select * from seguir where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, idSeguidor);
            try(ResultSet rs = ps.executeQuery()){
                s = new Seguir();
                
                if(rs.next()){
                    s.setId(rs.getLong("id"));
                    s.setPessoaOrigem(pessoaDAO.buscar(rs.getLong("idPessoaOrigem")));
                    s.setPessoaSeguindo(pessoaDAO.buscar(rs.getLong("idPessoaSeguindo")));
                    s.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    s.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return s;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o usuario!", e);
        }
    }
     
//    public String timeline(Pessoa pessoaLogada, PostDAO postDAO){
//        StringBuilder sb = new StringBuilder();
//        for (Seguir seguir : seguidores) {
//            if(seguir != null && seguir.getPessoaOrigem().equals(pessoaLogada)){
//                System.out.println(postDAO);
//            }
//        }
//
//        return sb.toString();
//    }
    
    public List<Seguir> listar(){
        sql = "select * from seguir";

        seguidores = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                s = new Seguir();
                s.setId(rs.getLong("id"));
                s.setPessoaOrigem(pessoaDAO.buscar(rs.getLong("idPessoaOrigem")));
                s.setPessoaSeguindo(pessoaDAO.buscar(rs.getLong("idPessoaSeguindo")));
                s.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                s.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                seguidores.add(s);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return seguidores;
    }

    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n ==== SEGUIDORES ====");
        for (Seguir seguidor : seguidores) {
            if(seguidor != null && seguidor.getPessoaOrigem().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(seguidor.getId()).
                append("\n Nome: ").append(seguidor.getPessoaSeguindo().getNome()).
                append("\n ====================");
            }
        }
        return sb.toString();
    }
}