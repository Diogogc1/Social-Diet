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
public class Seguir {
    //id, pessoa origem, pessoa seguindo, dataCriacao, dataModificacao
    private long id;
    private Pessoa pessoaOrigem;  //DIOGO
    private Pessoa pessoaSeguindo; //MATHEUS, ALE
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Seguir(){
        
    }

    public Seguir(Pessoa pessoaOrigem, Pessoa pessoaSeguindo) {
        this.pessoaOrigem = pessoaOrigem;
        this.pessoaSeguindo = pessoaSeguindo;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoaOrigem() {
        return pessoaOrigem;
    }

    public void setPessoaOrigem(Pessoa pessoaOrigem) {
        this.pessoaOrigem = pessoaOrigem;
    }

    public Pessoa getPessoaSeguindo() {
        return pessoaSeguindo;
    }

    public void setPessoaSeguindo(Pessoa pessoaSeguindo) {
        this.pessoaSeguindo = pessoaSeguindo;
    }

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
        return "Seguir{" + "id=" + id + ", pessoaOrigem=" + pessoaOrigem + ", pessoaSeguindo=" + pessoaSeguindo + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    //EQUALS E HASH CODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.pessoaOrigem);
        hash = 17 * hash + Objects.hashCode(this.pessoaSeguindo);
        hash = 17 * hash + Objects.hashCode(this.dataCriacao);
        hash = 17 * hash + Objects.hashCode(this.dataModificacao);
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
        final Seguir other = (Seguir) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.pessoaOrigem, other.pessoaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaSeguindo, other.pessoaSeguindo)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    } 
}
