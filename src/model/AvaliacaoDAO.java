/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
    public boolean alterar(Avaliacao avaliacao, Avaliacao avaliacaoNovo){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].equals(avaliacao)){
                avaliacoes[i] = avaliacaoNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar (Avaliacao avaliacao){
        for (int i = 0; i < avaliacoes.length; i++){
           if(avaliacoes[i].equals(avaliacao)){
               return true;
           }
        }
        return false;
    }

    @Override
    public String toString() {
        return "AvaliacaoDAO{" + "avaliacoes=" + avaliacoes + '}';
    }
    
    
}
