/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class RefeicaoDAO {
    Refeicao refeicoes[] = new Refeicao[10];

    public RefeicaoDAO(DietaDAO dietaDAO, Pessoa pessoaLogada) {
        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 0, 0, 0, 0, "Café da Manhã"));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] == null){
                refeicoes[i] = refeicao;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public boolean remover(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Refeicao refeicao, Refeicao refeicaoNova){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = refeicaoNova;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
     public boolean buscar(Refeicao refeicao){
        for (Refeicao r : refeicoes) {
            if (refeicao.equals(r)) {
                return true;
            } 
        }
        return false;
    }
     
    public boolean isVazio(){
        for(Refeicao refeicao : refeicoes){
            if(refeicao != null){
                return false;
            }
        }
        return true;
    }
    
    public String toString(Pessoa pessoa) {
        StringBuilder sb = new StringBuilder();
        sb.append("====== REFEICOES ======");
        for(Refeicao refeicao : refeicoes) {
            if(refeicao != null && refeicao.getDieta().getPessoa().equals(pessoa)){
                sb.append("\n ID: ").append(refeicao.getId()).
                append("\n Nome: ").append(refeicao.getNomeDaRefeicao()).
                append("\n Carboidratos: ").append(refeicao.getCarboidrato()).
                append("\n Proteinas: ").append(refeicao.getProteina()).
                append("\n Gorduras: ").append(refeicao.getGordura()).
                append("\n Calorias: ").append(refeicao.getCalorias()).
                append("\n Data de Criacao: ").append(refeicao.getDataCriacao()).
                append("\n Data de Modificacao: ").append(refeicao.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
