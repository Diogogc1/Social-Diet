/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class SeguirDAO {
    Seguir seguidores[] = new Seguir[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Seguir seguidor){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] == null){
                seguidores[i] = seguidor;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public boolean remover(Seguir seguidor){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].equals(seguidor)){
                seguidores[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Seguir seguidor, Seguir seguidorNova){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].equals(seguidor)){
                seguidores[i] = seguidorNova;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
     public boolean buscar(Seguir seguidor){
        for (Seguir s : seguidores) {
            if (seguidor.equals(s)) {
                return true;
            } 
        }
        return false;
    }
}
