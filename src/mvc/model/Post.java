/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
/**
 *
 * @author User
 */
/*CRUD DE POST. UM OUTRO CONJUNTO DE FUNCIONALIDADES NO SOFTWARE
SÃO AS FUNCIONALIDADES DE REDES SOCIAIS. SERÁ POSSÍVEL POSTAR
INFORMAÇÕES (DIETA, FOTO DAS REFEIÇÕES, RESULTADOS OU QUAISQUER
COISAS QUE A PESSOA QUISER). INFORMAÇÕES IMPORTANTES: ID, PESSOA,
CONTEUDO DA MENSAGEM, DATACRIACAO, DATAMODIFICACAO.*/
public class Post {
    private static long serial;
    private final long id;
    private Pessoa pessoa;
    private String conteudoMensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificao;

    //GETTERS E SETTERS 
    public long getId() {
        return id;
    }

    public String getSerial() {
        return "Atualmente há " + serial + "posts no sistema";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
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
    
    //CONSTRUTOR
    public Post(Pessoa pessoa, String conteudoMensagem, LocalDate dataCriacao, LocalDate dataModificao) {
        this.id = ++serial;
        this.pessoa = pessoa;
        this.conteudoMensagem = conteudoMensagem;
        this.dataCriacao = dataCriacao;
        this.dataModificao = dataModificao;
    }   
}