/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;

/**
 *
 * @author User
 */
public class TipoDietaDAO {
    TipoDieta tiposDieta[] = new TipoDieta[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(TipoDieta tipoDieta){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i] == null){
                tiposDieta[i] = tipoDieta;
                return "Tipo de Dieta adicionado com sucesso!";
            } 
        }
        return "Erro - Tipo de Dieta não adicionado!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(TipoDieta tipoDieta){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i].equals(tipoDieta)){
                tiposDieta[i] = null;
                return "Tipo de Dieta removido com sucesso!";
            }
        }
        return "Erro - Tipo de Dieta não removido!";
    }
    
    //ALTERAR
    public String alterar(TipoDieta tipoDieta, TipoDieta tipoDietaNovo){
        for (int i = 0; i < tiposDieta.length; i++) {
            if(tiposDieta[i].equals(tipoDieta)){
                tiposDieta[i] = tipoDietaNovo;
                return "Tipo de Dieta alterado com sucesso!";
            }
        }
        return "Erro - Tipo de Dieta não alterado!";
    }
}
