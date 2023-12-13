package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class PostDAO {
    List<Post> posts;
    private final Login login = new Login();
    String sql;
    PessoaDAO pessoaDAO;
    Post p;

    public PostDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
//        this.adicionar(new Post(pessoaLogada,"Boa noite, amigos!"));
    }
     
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(Post post){
        sql = "insert into post"
        + " (idPessoa, conteudoMensagem, dataCriacao, dataModificacao)"
        + " values (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, post.getPessoa().getId());
            ps.setString(2, post.getConteudoMensagem());
            ps.setDate(3, java.sql.Date.valueOf(post.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(post.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n post inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar esse post no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public void remover(long idPost){
        sql = "delete from post where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, idPost);
            
            ps.execute();
            
            System.out.println("\n Post removido com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o post!", e);
        }
    }
    
    //ALTERAR
    public void alterar(long idPost, Post postNovo){
        sql = "update post set idPessoa = ?, conteudoMensagem = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, postNovo.getPessoa().getId());
            ps.setString(2, postNovo.getConteudoMensagem());
            ps.setDate(3, java.sql.Date.valueOf(postNovo.getDataCriacao()));
            ps.setDate(4, java.sql.Date.valueOf(postNovo.getDataModificacao()));
            ps.setLong(5, idPost);
            
            ps.execute();
            
            System.out.println("\n Post alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o post!", e);
        }
    }
    
    //BUSCAR
    public Post buscar (long idPost){
        sql = "select * from post where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, idPost);
            try(ResultSet rs = ps.executeQuery()){
                p = new Post();
                
                if(rs.next()){
                    p.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                    p.setConteudoMensagem(rs.getString("conteudoMensagem"));
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return p;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o usuario!", e);
        }
    }
    
    public List<Post> listar(){
        sql = "select * from post";

        posts = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                p = new Post();
                p.setId(rs.getLong("id"));
                p.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                p.setConteudoMensagem(rs.getString("conteudoMensagem"));
                p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                p.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                posts.add(p);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return posts;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n ============= POSTS =============");
        for (Post post : posts) {
            if(post != null && post.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(post.getId()).
                append("\n Conteudo Mensagem: ").append(post.getConteudoMensagem()).
                append("\n Data de Criacao: ").append(post.getDataCriacao()).
                append("\n Data de Modificacao: ").append(post.getDataModificacao()).
                append("\n ========================================");
            }
        }
       
        return sb.toString();
    }
}

