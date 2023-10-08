/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;

/**
 *
 * @author User
 */
public class AvaliacaoDAO {
    Avaliacao avaliacoes[] = new Avaliacao[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(Avaliacao avaliacao){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i] == null){
                avaliacoes[i] = avaliacao;
                return "Avaliação adicionada com sucesso!";
            } 
        }
        return "Erro - Avaliação não adicionada!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(Avaliacao avaliacao){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].equals(avaliacao)){
                avaliacoes[i] = null;
                return "Avaliação removida com sucesso!";
            }
        }
        return "Erro - Avaliação não removida!";
    }
    
    //ALTERAR
    public String alterar(Avaliacao avaliacao, Avaliacao avaliacaoNovo){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i].equals(avaliacao)){
                avaliacoes[i] = avaliacaoNovo;
                return "Avaliação alterada com sucesso!";
            }
        }
        return "Erro - Avaliação não alterada!";
    }
}
