/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;

/**
 *
 * @author diogo
 */
public class RefeicaoDAO {
    Refeicao refeicoes[] = new Refeicao[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] == null){
                refeicoes[i] = refeicao;
                return "Refeicao adicionada com sucesso!";
            } 
        }
        return "Erro - Refeicao não adicionada!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public String remover(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = null;
                return "Refeicao removida com sucesso!";
            }
        }
        return "Erro - Refeicao não removida!";
    }
    
    //ALTERAR
    public String alterar(Refeicao refeicao, Refeicao refeicaoNovo){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = refeicaoNovo;
                return "Refeição alterado com sucesso!";
            }
        }
        return "Erro - Refeição não alterado!";
    }
}
