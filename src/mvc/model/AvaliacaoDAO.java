/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author User
 */
public class AvaliacaoDAO {
    List<Avaliacao> avaliacoes;
    private final Login login = new Login();
    private PessoaDAO pessoaDAO;
    private String sql;
    private Avaliacao a;

    public AvaliacaoDAO(PessoaDAO pessoaDAO){
        this.pessoaDAO = pessoaDAO;
//        this.adicionar(new Avaliacao(pessoaLogada, 70, 160, 25, 35, 70, 90));
//        this.adicionar(new Avaliacao(pessoaLogada, 71, 161, 26, 36, 71, 91));
//        this.adicionar(new Avaliacao(pessoaLogada, 72, 162, 27, 37, 72, 92));
    }
    
    //ADICIONAR
    public final void adicionar(Avaliacao avaliacao){
        sql = "insert into avaliacao"
                + " (idPessoa, peso, altura, idade, pescoco, cintura, quadril, imc, tmb, bf, massaGorda, massaMagra, dataCriacao, dataModificacao)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, login.getPessoaLogada().getId());
            ps.setDouble(2, avaliacao.getPeso());
            ps.setDouble(3, avaliacao.getAltura());
            ps.setDouble(4, avaliacao.getIdade());
            ps.setDouble(5, avaliacao.getPescoco());
            ps.setDouble(6, avaliacao.getCintura());
            ps.setDouble(7, avaliacao.getQuadril());
            ps.setDouble(8, avaliacao.getImc());
            ps.setDouble(9, avaliacao.getTmb());
            ps.setDouble(10, avaliacao.getBf());
            ps.setDouble(11, avaliacao.getMassaGorda());
            ps.setDouble(12, avaliacao.getMassaMagra());   
            
            ps.setDate(13, java.sql.Date.valueOf(avaliacao.getDataCriacao()));
            ps.setDate(14, java.sql.Date.valueOf(avaliacao.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Avaliacao inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar a avaliacao no banco!", e);
        }
    }
    
    //REMOVER
    public void remover(long id){
        sql = "delete from avaliacao where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, id);
            
            ps.execute();
            
            System.out.println("\n Avaliacao removida com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a Avaliacao!", e);
        }
    }
    
    //ALTERAR
    public void alterar(long idAvaliacao, Avaliacao avaliacaoNova){
        sql = "update avaliacao set idPessoa = ?, peso = ?, altura = ?, idade = ?, pescoco = ?, cintura = ?, quadril = ?, imc = ?, tmb = ?, bf = ?, massaGorda = ?, massaMagra = ?, dataModificacao = ?"
                + " where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, login.getPessoaLogada().getId());
            ps.setDouble(2, avaliacaoNova.getPeso());
            ps.setDouble(3, avaliacaoNova.getAltura());
            ps.setDouble(4, avaliacaoNova.getIdade());
            ps.setDouble(5, avaliacaoNova.getPescoco());
            ps.setDouble(6, avaliacaoNova.getCintura());
            ps.setDouble(7, avaliacaoNova.getQuadril());
            ps.setDouble(8, avaliacaoNova.getImc());
            ps.setDouble(9, avaliacaoNova.getTmb());
            ps.setDouble(10, avaliacaoNova.getBf());
            ps.setDouble(11, avaliacaoNova.getMassaGorda());
            ps.setDouble(12, avaliacaoNova.getMassaMagra());   
            ps.setDate(13, java.sql.Date.valueOf(avaliacaoNova.getDataModificacao()));
            ps.setLong(14, idAvaliacao);
            
            ps.execute();
            
            System.out.println("\n Avaliacao alterada com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar a Avaliacao!", e);
        }   
    }
    
    //BUSCAR
    public Avaliacao buscar (Long id){
        sql = "select * from avaliacao where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                a = new Avaliacao();
                
                if(rs.next()){
                    a.setId(rs.getLong("id"));
                    a.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                    a.setPeso(rs.getDouble("peso"));
                    a.setAltura(rs.getDouble("altura"));
                    a.setPescoco(rs.getDouble("pescoco"));
                    a.setCintura(rs.getDouble("cintura"));
                    a.setQuadril(rs.getDouble("quadril"));
                    a.setImc(rs.getDouble("imc"));
                    a.setTmb(rs.getDouble("tmb"));
                    a.setBf(rs.getDouble("bf"));
                    a.setMassaGorda(rs.getDouble("massaGorda"));
                    a.setMassaMagra(rs.getDouble("massaMagra"));
                    a.setDataCriacao((rs.getDate("dataCriacao").toLocalDate()));
                    a.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return a;
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar a Avaliacao!", e);
        }
    }
    
    //BUSCAR PESSOA AVALIACAO FISICA
//    public Avaliacao buscarPessoa (Pessoa pessoaLogada){
//        for(Avaliacao avaliacao : avaliacoes) {
//            if (avaliacao != null && avaliacao.getPessoa().equals(pessoaLogada)) {
//                return avaliacao;
//            }
//        }
//        return null;
//    }

    public List<Avaliacao> listar(){
        sql = "select * from avaliacao";

        avaliacoes = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                a = new Avaliacao();
                a.setId(rs.getLong("id"));
                a.setPessoa(pessoaDAO.buscar(rs.getLong("idPessoa")));
                a.setPeso(rs.getDouble("peso"));
                a.setAltura(rs.getDouble("altura"));
                a.setPescoco(rs.getDouble("pescoco"));
                a.setCintura(rs.getDouble("cintura"));
                a.setQuadril(rs.getDouble("quadril"));
                a.setImc(rs.getDouble("imc"));
                a.setTmb(rs.getDouble("tmb"));
                a.setBf(rs.getDouble("bf"));
                a.setMassaGorda(rs.getDouble("massaGorda"));
                a.setMassaMagra(rs.getDouble("massaMagra"));
                a.setDataCriacao((rs.getDate("dataCriacao").toLocalDate()));
                a.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                avaliacoes.add(a);
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return avaliacoes;
    }
    
    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("====== AVALIACOES ======");
        for (Avaliacao avaliacao : avaliacoes) {
           if(avaliacao != null && avaliacao.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(avaliacao.getId()).
                append("\n Peso: ").append(avaliacao.getPeso()).
                append("\n Altura: ").append(avaliacao.getAltura()).
                append("\n Idade: ").append(avaliacao.getIdade()).
                append("\n Pescoco: ").append(avaliacao.getPescoco()).
                append("\n Cintura ").append(avaliacao.getCintura()).
                append("\n Quadril: ").append(avaliacao.getQuadril()).
                append("\n IMC: ").append(avaliacao.getImc()).
                append("\n TMB: ").append(avaliacao.getTmb()).
                append("\n BF: ").append(avaliacao.getBf()).
                append("\n Data de Criacao: ").append(avaliacao.getDataCriacao()).
                append("\n Data de Modificacao: ").append(avaliacao.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }   
}