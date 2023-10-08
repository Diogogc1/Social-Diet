/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class AlimentoRefeicoesDAO {
    AlimentoRefeicoes alimentoRefeicoes[] = new AlimentoRefeicoes[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(AlimentoRefeicoes alimentoRefeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i] == null){
                alimentoRefeicoes[i] = alimentoRefeicao;
                return "Alimento da Refeição adicionado com sucesso!";
            } 
        }
        return "Erro - Alimento da Refeição não adicionado!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(AlimentoRefeicoes alimentoRefeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].equals(alimentoRefeicao)){
                alimentoRefeicoes[i] = null;
                return "Alimento da Refeição removido com sucesso!";
            }
        }
        return "Erro - Alimento da Refeição não removido!";
    }
    
    //ALTERAR
    public String alterar(AlimentoRefeicoes alimentoRefeicao, AlimentoRefeicoes alimentoRefeicaoNovo){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].equals(alimentoRefeicao)){
                alimentoRefeicoes[i] = alimentoRefeicaoNovo;
                return "Alimento da Refeição alterado com sucesso!";
            }
        }
        return "Erro - Alimento da Refeição não alterado!";
    }
}
