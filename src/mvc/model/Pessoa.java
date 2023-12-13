/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author diogo
 */
public class Pessoa {
    private long id;
    private String nome;
    private String sexo;
    private LocalDate dataDeNascimento;
    private String email;
    private String senha;
    //tipoUsuario -> FALSE = USUÁRIO COMUN || TRUE = ADMINISTRADOR
    //private boolean tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Pessoa() {
 
    }

    //CONSTRUTOR
    public Pessoa(String nome, String sexo, LocalDate dataDeNascimento, String email, String senha) {
        this.nome = nome;
        
        if(sexo.equals("1")){
            this.sexo = "Masculino";
        }else{
            if(sexo.equals("2")){
                this.sexo = "Feminino";
            }
        }
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
     public void setId(Long id) {
        this.id = id;
    } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public boolean getTipoUsuario() {
//        return tipoUsuario;
//    }
//
//    public void setTipoUsuario(boolean tipoUsuario) {
//        this.tipoUsuario = tipoUsuario;
//    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    //TO STRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n =========== PESSOA ===========");

        sb.append("\n ID: ").append(id).
        append("\n Nome: ").append(nome).
        append("\n Sexo: ").append(sexo).
        append("\n Email: ").append(email). 
        append("\n Senha: ").append(senha).
        append("\n Data de Nascimento: ").append(dataDeNascimento).
        append("\n Data de Criacao: ").append(dataCriacao).
        append("\n Data de modificacao: ").append(dataModificacao).
        append("\n =================================");

        return sb.toString();
    }

    //EQUALS E HASH CODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.sexo);
        hash = 29 * hash + Objects.hashCode(this.dataDeNascimento);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.dataCriacao);
        hash = 29 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return this.id == other.id;
    }
}