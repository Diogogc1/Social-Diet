/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author User
 */
public class AlimentoRefeicoesDAO {
    AlimentoRefeicoes alimentoRefeicoes[] = new AlimentoRefeicoes[10];
        
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(AlimentoRefeicoes alimentoRefeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i] == null){
                alimentoRefeicoes[i] = alimentoRefeicao;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER ALIMENTO
    public boolean removerAlimento(Alimento alimento){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i] != null && alimentoRefeicoes[i].getAlimento().equals(alimento)){
                alimentoRefeicoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //REMOVER REFEICAO
    public boolean removerRefeicao(Refeicao refeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].getRefeicao().equals(refeicao)){
                alimentoRefeicoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(AlimentoRefeicoes alimentoRefeicao, AlimentoRefeicoes alimentoRefeicaoNovo){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].equals(alimentoRefeicao)){
                alimentoRefeicoes[i] = alimentoRefeicaoNovo;
                return true;
            }
        }
        return false;
    }
    
    public boolean bateuMetaRefeicao(Refeicao refeicaoNova){
        for(AlimentoRefeicoes alimentoRefeicao : alimentoRefeicoes) {
            if(alimentoRefeicao != null && refeicaoNova.equals(alimentoRefeicao.getRefeicao())){
                carboidrato += (alimentoRefeicao.getAlimento().getCarboidratos() * 100 * alimentoRefeicao.getPorcao()) / refeicaoNova.getCarboidrato();
                proteina += (alimentoRefeicao.getAlimento().getProteinas() * 100 * alimentoRefeicao.getPorcao()) / refeicaoNova.getProteina();
                gordura += (alimentoRefeicao.getAlimento().getGorduras() * 100 * alimentoRefeicao.getPorcao()) / refeicaoNova.getGordura();
                calorias += (alimentoRefeicao.getAlimento().getCalorias() * 100 * alimentoRefeicao.getPorcao()) / refeicaoNova.getCalorias();
            }
            
            if(carboidrato >= 100 && proteina >= 100 && gordura >= 100 && calorias >= 100){
                carboidrato = 0;
                proteina = 0;
                gordura = 0;
                calorias = 0;
                return true;
            }
        }     
        return false;
    }
    
    //LER
    public void ler (AlimentoRefeicoes alimentoRefeicao){
        System.out.println("Registros: \n");
        for(int i = 0; i < alimentoRefeicoes.length; i++){
            System.out.println(alimentoRefeicoes[i] + " ");
        }
    }
}
