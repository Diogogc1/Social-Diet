/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class AvaliacaoDAO {
    Avaliacao avaliacoes[] = new Avaliacao[10];
    
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
    public boolean remover(Avaliacao avaliacao){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].equals(avaliacao)){
                avaliacoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idAvaliacao, Avaliacao avaliacaoNovo){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].getId() == idAvaliacao){
                avaliacoes[i] = avaliacaoNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Avaliacao buscar (Long idAvaliacao){
        for(int i = 0; i < avaliacoes.length; i++){
           if(avaliacoes[i].getId() == idAvaliacao){
               return avaliacoes[i];
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
        sb.append("====== AVALIACAO ======");
        for (Avaliacao avaliacao : avaliacoes) {
            if(avaliacao != null){
                sb.append("\n ID: ").append(avaliacao.getId()).
                append("\n Nome: ").append(avaliacao.getPeso()).
                append("\n Altura: ").append(avaliacao.getAltura()).
                append("\n Idade: ").append(avaliacao.getIdade()).
                append("\n Pescoco: ").append(avaliacao.getPescoco()).
                append("\n Cintura ").append(avaliacao.getCintura()).
                append("\n Quadril: ").append(avaliacao.getQuadril()).
                append("\n Data de Criacao: ").append(avaliacao.getDataCriacao()).
                append("\n Data de Modificacao: ").append(avaliacao.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
    
    
    
}
