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
    public String adicionar(AlimentoRefeicoes alimentoRefeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i] == null){
                alimentoRefeicoes[i] = alimentoRefeicao;
                return "Alimento da Refeição adicionado com sucesso!";
            } 
        }
        return "Erro - Alimento da Refeição não adicionado!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(AlimentoRefeicoes alimentoRefeicao){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].equals(alimentoRefeicao)){
                alimentoRefeicoes[i] = null;
                return "Alimento da Refeição removido com sucesso!";
            }
        }
        return "Erro - Alimento da Refeição não removido!";
    }
    
    //ALTERAR
    public String alterar(AlimentoRefeicoes alimentoRefeicao, AlimentoRefeicoes alimentoRefeicaoNovo){
        for (int i = 0; i < alimentoRefeicoes.length; i++) {
            if(alimentoRefeicoes[i].equals(alimentoRefeicao)){
                alimentoRefeicoes[i] = alimentoRefeicaoNovo;
                return "Alimento da Refeição alterado com sucesso!";
            }
        }
        return "Erro - Alimento da Refeição não alterado!";
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
