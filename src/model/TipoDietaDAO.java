/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class TipoDietaDAO {
    TipoDieta tiposDieta[] = new TipoDieta[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(TipoDieta tipoDieta){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i] == null){
                tiposDieta[i] = tipoDieta;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(TipoDieta tipoDieta){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i].equals(tipoDieta)){
                tiposDieta[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(TipoDieta tipoDieta, TipoDieta tipoDietaNovo){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i].equals(tipoDieta)){
                tiposDieta[i] = tipoDietaNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar (TipoDieta tipoDieta){
        for (int i = 0; i < tiposDieta.length; i++){
           if(tiposDieta[i].equals(tipoDieta)){
               return true;
           }
        }
        return false;
    }
}
