/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author User
 */
public class TipoDietaDAO {
    TipoDieta tiposDieta[] = new TipoDieta[3];

    public TipoDietaDAO() {
//        adicionar(new TipoDieta("Equilibrada", 0.4, 0.3, 0.3));
//        adicionar(new TipoDieta("Low Carb", 0.3, 0.5, 0.2));
//        adicionar(new TipoDieta("Cetogenica", 0.15, 0.15, 0.7));
    }
    
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
    public TipoDieta buscar (int id){
        for (TipoDieta tipoDieta : tiposDieta) {
            if (tipoDieta != null && tipoDieta.getId() == id) {
                return tipoDieta;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n ====== Seguidores ======");
        for (TipoDieta tipoDieta : tiposDieta) {
            if(tipoDieta != null){
                sb.append("\n ID: ").append(tipoDieta.getId()).
                append("\n Nome: ").append(tipoDieta.getNome()).
                append("\n Carboidratos: ").append(tipoDieta.getCarboidrato()).
                append("\n Proteinas: ").append(tipoDieta.getProteina()).
                append("\n Gorduras: ").append(tipoDieta.getGordura()).
                append("\n Data de Criacao: ").append(tipoDieta.getDataCriacao()).
                append("\n Data de Modificacao: ").append(tipoDieta.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
