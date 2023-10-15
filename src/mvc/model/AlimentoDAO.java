/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class AlimentoDAO {
    Alimento alimentos[] = new Alimento[10];

    public AlimentoDAO(Pessoa pessoa) {
        adicionar(new Alimento("Ovo", 100, 100, 100, 1, pessoa));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Alimento alimento){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i] == null){
                alimentos[i] = alimento;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA O ALIMENTO PARA SER REMOVIDO
    public boolean remover(Alimento alimento){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].equals(alimento)){
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Alimento alimento, Alimento novoAlimento){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimento.equals(alimentos[i])){
                alimentos[i] = novoAlimento;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar(Alimento alimento){
        for (Alimento a : alimentos) {
            if (alimento.equals(a)) {
                return true;
            } 
        }
        return false;
    }
     
    public boolean isVazio(){
        for (Alimento alimento : alimentos) {
            if(alimento != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== Alimentos ======");
        for (Alimento alimento : alimentos) {
            if(alimento != null){
                sb.append("\n ID: ").append(alimento.getId()).
                append("\n Nome: ").append(alimento.getNome()).
                append("\n Carboidratos: ").append(alimento.getCarboidratos()).
                append("\n Proteinas: ").append(alimento.getProteinas()).
                append("\n Gorduras: ").append(alimento.getGorduras()).
                append("\n Calorias: ").append(alimento.getCalorias()).
                append("\n Data de Criacao: ").append(alimento.getDataCriacao()).
                append("\n Data de Modificacao: ").append(alimento.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
