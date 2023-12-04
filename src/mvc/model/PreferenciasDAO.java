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
    private final Login login = new Login();
    private int aux;

    public PreferenciasDAO(Pessoa pessoaLogada, AlimentoDAO alimentoDAO) {
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(1)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(2)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(3)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(4)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(5)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(6)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(7)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(8)));
        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(9)));
    }
    
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
    
    //BUSCAR
    public Preferencias buscar(long id){
        for(Preferencias preferencia : preferencias) {
            if (preferencia != null && preferencia.getId() == id){
                return preferencia;
            }
        }
        return null;
    }
    
    public Preferencias buscarNaoNulo(int j){
        aux = 0;
        for (Preferencias preferencia : preferencias) {
            if(preferencia != null){
               aux++;
               if(j == aux){
                   return preferencia;
               }
            }
        }
        return preferencias[aux];
    }

    //É vazio
    public boolean isVazio(){
        for(Preferencias preferencia : preferencias) {
            if (preferencia != null){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("====== PREFERENCIAS ======");
        for(Preferencias preferencia : preferencias) {
            if(preferencia != null && preferencia.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(preferencia.getId()).
                append("\n Alimento: ").append(preferencia.getAlimento()).
                append("\n\n Data de Criacao: ").append(preferencia.getDataCriacao()).
                append("\n Data de Modificacao: ").append(preferencia.getDataModificacao()).
                append("\n ======================================== \n\n");
            }
        }
        return sb.toString();
    }
}


