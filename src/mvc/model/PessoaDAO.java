/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;

/**
 *
 * @author diogo
 */
public class PessoaDAO {
    Pessoa pessoas[] = new Pessoa[10];

    public PessoaDAO() {
        adicionar(new Pessoa("diogo", "1", LocalDate.of(2003, 10, 10), "diogo", "diogo"));
        adicionar(new Pessoa("matheus", "1", LocalDate.of(2002, 03, 04), "matheus", "matheus"));
        adicionar(new Pessoa("Benedita", "2", LocalDate.of(1947, 07, 23), "benedita", "benedita"));
    }
    
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
    
    public boolean alterarNome(Pessoa pessoaLogada, String nomeNovo){
        for (Pessoa pessoa : pessoas) {
            if (pessoaLogada.equals(pessoa)) {
                pessoa.setNome(nomeNovo);
                return true;
            }
        }
        return false;
    }
    
    public boolean alterarEmail(Pessoa pessoaLogada, String emailNovo){
        for (Pessoa pessoa : pessoas) {
            if (pessoaLogada.equals(pessoa)) {
                pessoa.setEmail(emailNovo);
                return true;
            }
        }
        return false;
    }
    
    public boolean alterarSenha(Pessoa pessoaLogada, String senhaNova){
        for (Pessoa pessoa : pessoas) {
            if (pessoaLogada.equals(pessoa)) {
                pessoa.setSenha(senhaNova);
                return true;
            }
        }
        return false;
    }
    
    public Pessoa buscar(long id){
        for(Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getId() == id){
                return pessoa;
            } 
        }
        return null;
    }
    
    public boolean validarLogin(String email, String senha){
        for (Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    public Pessoa buscarLogin(String email, String senha){
        for (Pessoa pessoa : pessoas) {
            if(pessoa != null && pessoa.getEmail().equals(email) && pessoa.getSenha().equals(senha)){
                return pessoa;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== Pessoas ======");
        for(Pessoa pessoa : pessoas) {
            if(pessoa != null){
                sb.append("\n ID: ").append(pessoa.getId()).
                append("\n Nome: ").append(pessoa.getNome()).
                append("Sexo: ").append(pessoa.getSexo()).
                append("Data de nascimento: ").append(pessoa.getDataDeNascimento()).
                append("E-mail: ").append(pessoa.getEmail()).
                append("Senha: ").append(pessoa.getSenha()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
