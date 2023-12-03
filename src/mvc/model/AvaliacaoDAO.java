/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;


/**
 *
 * @author User
 */
public class AvaliacaoDAO {
    Avaliacao avaliacoes[] = new Avaliacao[10];
    private final Login login = new Login();

    public AvaliacaoDAO(Pessoa pessoaLogada) {
        this.adicionar(new Avaliacao(pessoaLogada, 70, 160, 25, 35, 70, 90));
        this.adicionar(new Avaliacao(pessoaLogada, 71, 161, 26, 36, 71, 91));
        this.adicionar(new Avaliacao(pessoaLogada, 72, 162, 27, 37, 72, 92));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Avaliacao avaliacao){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i] == null){
                avaliacoes[i] = avaliacao;
                return true;
            } 
        }
        return false;
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