/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class PreferenciasDAO {
   Preferencias preferencias[] = new Preferencias[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Preferencias preferencia){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i] == null){
                preferencias[i] = preferencia;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(Preferencias preferencia){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].equals(preferencia)){
                preferencias[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Preferencias preferencia, Preferencias preferenciaNovo){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].equals(preferencia)){
                preferencias[i] = preferenciaNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar (Preferencias preferencia){
        for (int i = 0; i < preferencias.length; i++){
           if(preferencias[i].equals(preferencia)){
               return true;
           }
        }
        return false;
    }
}
