/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.util.Objects;
/**
 *
 * @author User
 */
/*CRUD MENSAGENS. INFORMAÇÕES IMPORTANTES: ID,
PESSOA ORIGEM, PESSOA DESTINO, MENSAGEM,
DATACRIACAO, DATAMODIFICACAO.*/
public class Mensagem {
    private long id;
    private Pessoa pessoaOrigem;
    private Pessoa pessoaDestino;
    private String mensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

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

    public Pessoa getPessoaDestino() {
        return pessoaDestino;
    }

    public void setPessoaDestino(Pessoa pessoaDestino) {
        this.pessoaDestino = pessoaDestino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
    
    public Mensagem(){
        
    }
    
    public Mensagem(Pessoa pessoaOrigem, Pessoa pessoaDestino, String mensagem) {
        this.pessoaOrigem = pessoaOrigem;
        this.pessoaDestino = pessoaDestino;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.pessoaOrigem);
        hash = 37 * hash + Objects.hashCode(this.pessoaDestino);
        hash = 37 * hash + Objects.hashCode(this.mensagem);
        hash = 37 * hash + Objects.hashCode(this.dataCriacao);
        hash = 37 * hash + Objects.hashCode(this.dataModificacao);
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
        final Mensagem other = (Mensagem) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.mensagem, other.mensagem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaOrigem, other.pessoaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pessoaDestino, other.pessoaDestino)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n =========== MENSAGEM ===========");

        sb.append("\n ID: ").append(id).
        append("\n Remetente: ").append(pessoaOrigem.getNome()).
        append("\n Destinatário: ").append(pessoaDestino.getNome()).
        append("\n Mensagem: ").append(mensagem). 
        append("\n Data de Criacao: ").append(dataCriacao).
        append("\n Data de Modificacao: ").append(dataModificacao).
        append("\n =================================");

        return sb.toString();
    }    
}