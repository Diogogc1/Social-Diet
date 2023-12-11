/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 *
 * @author User
 */
public class AvaliacaoDAO {
    Avaliacao avaliacoes[] = new Avaliacao[10];
    private final Login login = new Login();
    String sql;

    public AvaliacaoDAO(Pessoa pessoaLogada){
//        this.adicionar(new Avaliacao(pessoaLogada, 70, 160, 25, 35, 70, 90));
//        this.adicionar(new Avaliacao(pessoaLogada, 71, 161, 26, 36, 71, 91));
//        this.adicionar(new Avaliacao(pessoaLogada, 72, 162, 27, 37, 72, 92));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
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
            
            System.out.println("\n Avaliacao inserida com sucesso! \n");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar avaliacao no banco!", e);
        }
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(long idAvaliacao){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].getId() == idAvaliacao){
                avaliacoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idAvaliacao, Avaliacao avaliacaoNova){
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId() == idAvaliacao) {
                avaliacao.setPeso(avaliacaoNova.getPeso());
                avaliacao.setAltura(avaliacaoNova.getAltura());
                avaliacao.setIdade(avaliacaoNova.getIdade());
                avaliacao.setPescoco(avaliacaoNova.getPescoco());
                avaliacao.setCintura(avaliacaoNova.getCintura());
                avaliacao.setQuadril(avaliacaoNova.getQuadril());
                avaliacao.setImc(avaliacaoNova.getImc());
                avaliacao.setTmb(avaliacaoNova.getTmb());
                avaliacao.setBf(avaliacaoNova.getBf());
                avaliacao.setDataModificacao(LocalDate.now());
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Avaliacao buscar (Long idAvaliacao){
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId() == idAvaliacao) {
                return avaliacao;
            }
        }
        return null;
    }
    
    //BUSCAR PESSOA AVALIACAO FISICA
    public Avaliacao buscarPessoa (Pessoa pessoaLogada){
        for(Avaliacao avaliacao : avaliacoes) {
            if (avaliacao != null && avaliacao.getPessoa().equals(pessoaLogada)) {
                return avaliacao;
            }
        }
        return null;
    }

    @Override
    public String toString() {
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