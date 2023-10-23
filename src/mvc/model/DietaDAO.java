/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
/**
 *
 * @author diogo
 */
public class DietaDAO {
    Dieta[] dietas = new Dieta[10];
    public DietaDAO(Pessoa pessoaLogada, AvaliacaoDAO avaliacaoDAO, TipoDietaDAO tipoDietaDAO) {
        adicionar(new Dieta(pessoaLogada, avaliacaoDAO.buscarPessoa(pessoaLogada), tipoDietaDAO.buscar(2), "Manter o peso", 0, 0));
    }
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
    
    //BUSCAR DIETA POR ID
    public Dieta buscar(long id){
        for(Dieta dieta : dietas){
            if (dieta != null && dieta.getId() == id){
                return dieta;
            }
        }
        return null;
    }
    
    
    //BUSCAR PESSOA AVALIACAO FISICA
    public Dieta buscarPessoa (Pessoa pessoaLogada){
        for(Dieta dieta : dietas){
            if (dieta != null && dieta.getPessoa().equals(pessoaLogada)){
                return dieta;
            }
        }
        return null;
    }
    
    public String toString(Pessoa pessoaLogada) {
        StringBuilder sb = new StringBuilder();
        sb.append("====== Dietas ======");
        for(Dieta dieta : dietas) {
            if(dieta != null && dieta.getPessoa().equals(pessoaLogada)){
                sb.append("\n ID: ").append(dieta.getId()).
                append("\n Tipo de Dieta: ").append(dieta.getTipoDieta()).
                append("\n Objetivo: ").append(dieta.getObjetivo()).
                append("\n Calorias: ").append(dieta.getCalorias()).
                append("\n Numero de Refeicoes: ").append(dieta.getNumeroRefeicoes()).
                append("\n Data de Criacao: ").append(dieta.getDataCriacao()).
                append("\n Data de Modificacao: ").append(dieta.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
