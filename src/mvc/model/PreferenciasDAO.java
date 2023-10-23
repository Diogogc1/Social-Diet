/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author User
 */
public class PreferenciasDAO {
    Preferencias preferencias[] = new Preferencias[10];
    private int aux;
    
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
    public boolean remover(long idPreferencia){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].getId() == idPreferencia){
                preferencias[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idPreferencia, Preferencias preferenciaNovo){
        for (int i = 0; i < preferencias.length; i++) {
            if(preferencias[i].getId() == idPreferencia){
                preferencias[i] = preferenciaNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR POR ID
    public Preferencias buscarPorId(long idPreferencia){
        for(int i=0; i<preferencias.length; i++){
            if(preferencias[i].getId() == idPreferencia){
                return preferencias[i];
            }
        }
        return null;
    }
    
    
    //BUSCAR
    public Preferencias buscar(int cont){
        aux = 0;
        for(Preferencias preferencia1 : preferencias) {
            if (preferencia1 != null && aux == cont){
                aux++;
            }else{
                if(preferencia1 == null){
                    aux = 0;
                }
            }
        }
        return preferencias[aux];
    }
    
    public String toString(Pessoa pessoaLogada){
        StringBuilder sb = new StringBuilder();
        sb.append("====== PREFERENCIAS ======");
        for(Preferencias preferencia : preferencias) {
            if(preferencia != null && preferencia.getPessoa().equals(pessoaLogada)){
                sb.append("\n ID: ").append(preferencia.getId()).
                append("\n Alimento: ").append(preferencia.getAlimento()).
                append("\n\n ///Data de Criacao:/// ").append(preferencia.getDataCriacao()).
                append("\n\n ///Data de Modificacao:/// ").append(preferencia.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}


