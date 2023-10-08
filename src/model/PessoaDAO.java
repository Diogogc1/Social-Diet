/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author diogo
 */
public class PessoaDAO {
    Pessoa pessoas[] = new Pessoa[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public String adicionar(Pessoa pessoa){
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i] == null){
                pessoas[i] = pessoa;
                return "Pessoa adicionada com sucesso!";
            } 
        }
        return "Erro - Pessoa não adicionada!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(Pessoa pessoa){
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i].equals(pessoa)){
                pessoas[i] = null;
                return "Pessoa removida com sucesso!";
            }
        }
        return "Erro - Pessoa não removida!";
    }
    
    
    public boolean alterar(Pessoa pessoa, Pessoa novaPessoa){
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoa.equals(pessoas[i])){
                pessoas[i] = novaPessoa;
                return true;
            }
        }
        return false;
    }
}
