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
    int cont;
    
    private double carboidrato;
    private double porcao;
    private double proteina;
    private double gordura;
    private double calorias;
    
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
    public int numeroDeRefeicaoDaDieta(Dieta dieta){
        cont = 0;
        for (Refeicao r : refeicoes) {
            if (r.getDieta().equals(dieta)) {
                cont++;
                if(cont >= dieta.getNumeroRefeicoes()){
                    return cont;
                }
            } 
        }
        return cont;
    }
     
    public boolean isVazio(){
        for(Refeicao refeicao : refeicoes){
            if(refeicao != null){
                return false;
            }
        }
        return true;
    }
    
    public boolean bateuMetaDieta(Refeicao refeicaoNova){
        for (Refeicao refeicao : refeicoes) {
            if(refeicao != null && refeicaoNova.getDieta().equals(refeicao.getDieta())){
                carboidrato += (refeicao.getCarboidrato() * 100) / refeicaoNova.getDieta().getTipoDieta().getCarboidrato();
                proteina += (refeicao.getProteina() * 100) / refeicaoNova.getDieta().getTipoDieta().getProteina();
                gordura += (refeicao.getGordura() * 100) / refeicaoNova.getDieta().getTipoDieta().getGordura();
            }
            
            if(carboidrato >= 100 && proteina >= 100 && gordura >= 100 && calorias >= 100){
                carboidrato = 0;
                proteina = 0;
                gordura = 0;
                return true;
            }
        }     
        return false;
    }
    
    public String toString(Pessoa pessoaLogada) {
        StringBuilder sb = new StringBuilder();
        sb.append("====== REFEICOES ======");
        for(Refeicao refeicao : refeicoes) {
            if(refeicao != null && refeicao.getDieta().getPessoa().equals(pessoaLogada)){
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
