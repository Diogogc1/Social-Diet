/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class RefeicaoDAO {
    Refeicao refeicoes[] = new Refeicao[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] == null){
                refeicoes[i] = refeicao;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public boolean remover(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Refeicao refeicao, Refeicao refeicaoNova){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = refeicaoNova;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
     public boolean buscar(Refeicao refeicao){
        for (Refeicao r : refeicoes) {
            if (refeicao.equals(r)) {
                return true;
            } 
        }
        return false;
    }
}
