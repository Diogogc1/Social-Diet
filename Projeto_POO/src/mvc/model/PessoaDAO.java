/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diogo
 */
public class PessoaDAO {
    private List<Pessoa> pessoas;
    private String sql;
    private Pessoa p = new Pessoa();

    public PessoaDAO() {

    }
    
    //ADICIONAR
    public void adicionar(Pessoa pessoa){
        sql = "insert into pessoa"
                + " (nome, sexo, dataNascimento, email, senha, dataCriacao, dataModificacao)"
                + " values (?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSexo());
            
            ps.setDate(3, java.sql.Date.valueOf(pessoa.getDataDeNascimento()));
            ps.setString(4, pessoa.getEmail());
            ps.setString(5, pessoa.getSenha());
            ps.setDate(6, java.sql.Date.valueOf(pessoa.getDataCriacao()));
            ps.setDate(7, java.sql.Date.valueOf(pessoa.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Usuario inserido com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar usuario no banco!", e);
        }
    }
    
    //REMOVER
    public void remover(Pessoa pessoa){
        sql = "delete from pessoa where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, pessoa.getId());
            
            ps.execute();
            
            System.out.println("\n Usuario removido com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o usuario!", e);
        }
    }
    
    public void alterarNome(Pessoa pessoaLogada, String nomeNovo){
        sql = "update pessoa set nome = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, nomeNovo);
            ps.setLong(2, pessoaLogada.getId());
            
            ps.execute();
            
            System.out.println("\n Nome alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o nome!", e);
        }
    }
    
    public void alterarEmail(Pessoa pessoaLogada, String emailNovo){
        sql = "update pessoa set email = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, emailNovo);
            ps.setLong(2, pessoaLogada.getId());
            
            ps.execute();
            
            System.out.println("\n Email alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o email!", e);
        }
    }
    
    public void alterarSenha(Pessoa pessoaLogada, String senhaNova){
        sql = "update pessoa set senha = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, senhaNova);
            ps.setLong(2, pessoaLogada.getId());
            
            ps.execute();
            
            System.out.println("\n Senha alterada com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o senha!", e);
        }
    }
    
    public Pessoa buscar(long id){
        sql = "select * from pessoa where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                p = new Pessoa();
                
                if(rs.next()){
                    p.setId(rs.getLong("id"));
                    p.setNome(rs.getString("nome"));
                    p.setSexo(rs.getString("sexo"));
                    p.setEmail(rs.getString("email"));
                    p.setSenha(rs.getString("senha"));
                    p.setDataDeNascimento((rs.getDate("dataNascimento").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return p;
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o usuario!", e);
        }
    }
    
    public Pessoa buscarLogin(String email, String senha){
        sql = "select * from pessoa where email = ? and senha = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, email);
            ps.setString(2, senha);

            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    p = new Pessoa();
                    p.setId(rs.getLong("id"));
                    p.setNome(rs.getString("nome"));
                    p.setSexo(rs.getString("sexo"));
                    p.setDataDeNascimento((rs.getDate("dataNascimento").toLocalDate()));
                    p.setEmail(rs.getString("email"));
                    p.setSenha(rs.getString("senha"));
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                }else{
                    throw new SQLException();
                }
                return p;
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Email ou senha incorretos!", e);
        }
    }
    
    public List<Pessoa> listar(){
        sql = "select * from pessoa";

        pessoas = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                p = new Pessoa();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setSexo(rs.getString("sexo"));
                p.setDataDeNascimento((rs.getDate("dataNascimento").toLocalDate()));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return pessoas;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("====== PESSOAS ======");
        for(Pessoa pessoa : pessoas) {
            if(pessoa != null){
                sb.append("\n ID: ").append(pessoa.getId()).
                append("\n Nome: ").append(pessoa.getNome()).
                append("\n Sexo: ").append(pessoa.getSexo()).
                append("\n Data de nascimento: ").append(pessoa.getDataDeNascimento()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
