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
    public String adicionar(Preferencias preferencia){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i] == null){
                preferencias[i] = preferencia;
                return "Preferência adicionada com sucesso!";
            } 
        }
        return "Erro - Preferência não adicionada!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(Preferencias preferencia){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].equals(preferencia)){
                preferencias[i] = null;
                return "Preferência removida com sucesso!";
            }
        }
        return "Erro - Preferência não removida!";
    }
    
    //ALTERAR
    public String alterar(Preferencias preferencia, Preferencias preferenciaNovo){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].equals(preferencia)){
                preferencias[i] = preferenciaNovo;
                return "Preferência alterada com sucesso!";
            }
        }
        return "Erro - Preferência não alterada!";
    }
    
    //BUSCAR
     public boolean buscar(Preferencias preferencia){
        for (Preferencias pr : preferencias) {
            if (preferencia.equals(pr)) {
                return true;
            } 
        }
        return false;
    }
}
