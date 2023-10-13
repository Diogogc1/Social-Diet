/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diogo
 */
public class DietaDAO {
    Dieta[] dietas = new Dieta[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Dieta dieta){
        for (int i = 0; i < dietas.length; i++) {
            if(dietas[i] == null){
                dietas[i] = dieta;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA O REGISTRODIETA PARA SER REMOVIDO
    public boolean remover(Dieta dieta){
        for (int i = 0; i < dietas.length; i++) {
            if(dietas[i].equals(dieta)){
                dietas[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Dieta dieta, Dieta dietaNovo){
        for (int i = 0; i < dietas.length; i++) {
            if(dietas[i].equals(dieta)){
                dietas[i] = dietaNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
     public boolean buscar(Dieta dieta){
        for (Dieta rd: dietas) {
            if (dieta.equals(rd)) {
                return true;
            } 
        }
        return false;
    }
}
