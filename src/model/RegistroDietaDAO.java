/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diogo
 */
public class RegistroDietaDAO {
    RegistroDieta registrosDietas[] = new RegistroDieta[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(RegistroDieta registroDieta){
        for (int i = 0; i < registrosDietas.length; i++) {
            if(registrosDietas[i] == null){
                registrosDietas[i] = registroDieta;
                return "RegistroDieta adicionada com sucesso!";
            } 
        }
        return "Erro - RegistroDieta não adicionada!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA O REGISTRODIETA PARA SER REMOVIDO
    public String remover(RegistroDieta registroDieta){
        for (int i = 0; i < registrosDietas.length; i++) {
            if(registrosDietas[i].equals(registroDieta)){
                registrosDietas[i] = null;
                return "RegistroDieta removida com sucesso!";
            }
        }
        return "Erro - RegistroDieta não removida!";
    }
    
    //ALTERAR
    public String alterar(RegistroDieta alimento, RegistroDieta alimentoNovo){
        for (int i = 0; i < registrosDietas.length; i++) {
            if(registrosDietas[i].equals(alimento)){
                registrosDietas[i] = alimentoNovo;
                return "RegistroDieta alterado com sucesso!";
            }
        }
        return "Erro - RegistroDieta não alterado!";
    }
}
