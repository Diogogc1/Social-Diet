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
    public boolean adicionar(Pessoa pessoa){
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i] == null){
                pessoas[i] = pessoa;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(Pessoa pessoa){
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoas[i].equals(pessoa)){
                pessoas[i] = null;
                return true;
            }
        }
        return false;
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
    
    public boolean buscar(Pessoa pessoa){
        for (Pessoa p : pessoas) {
            if (pessoa.equals(p)) {
                return true;
            } 
        }
        return false;
    }
    
    public boolean validarLogin(String email, String senha){
        for (Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
}