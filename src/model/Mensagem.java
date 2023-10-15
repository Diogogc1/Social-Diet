/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
/**
 *
 * @author User
 */
/*CRUD MENSAGENS. INFORMAÇÕES IMPORTANTES: ID,
PESSOA ORIGEM, PESSOA DESTINO, MENSAGEM,
DATACRIACAO, DATAMODIFICACAO.*/
public class Mensagem {
    private static long serial;
    private final long id;
    private Pessoa pessoaOrigem;
    private Pessoa pessoaDestino;
    private String mensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;

    public long getId() {
        return id;
    }

    public String getSerial() {
        return "Atualmente há " + serial + "mensagens no sistema";
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

    public LocalDate getDataModificao() {
        return dataModificao;
    }

    public void setDataModificao(LocalDate dataModificao) {
        this.dataModificao = dataModificao;
    }

    public Mensagem(Pessoa pessoaOrigem, Pessoa pessoaDestino, String mensagem, LocalDate dataCriacao, LocalDate dataModificao) {
        this.id = ++serial;
        this.pessoaOrigem = pessoaOrigem;
        this.pessoaDestino = pessoaDestino;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.dataModificao = dataModificao;
    }
    
    
}
