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
/*CRUD DE POST. UM OUTRO CONJUNTO DE FUNCIONALIDADES NO SOFTWARE
SÃO AS FUNCIONALIDADES DE REDES SOCIAIS. SERÁ POSSÍVEL POSTAR
INFORMAÇÕES (DIETA, FOTO DAS REFEIÇÕES, RESULTADOS OU QUAISQUER
COISAS QUE A PESSOA QUISER). INFORMAÇÕES IMPORTANTES: ID, PESSOA,
CONTEUDO DA MENSAGEM, DATACRIACAO, DATAMODIFICACAO.*/
public class Post {
    private long id;
    private Pessoa pessoa;
    private String conteudoMensagem;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //GETTERS E SETTERS 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    public Post(){
        
    }
    
    //CONSTRUTOR
    public Post(Pessoa pessoa, String conteudoMensagem) {
        this.pessoa = pessoa;
        this.conteudoMensagem = conteudoMensagem;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.pessoa);
        hash = 89 * hash + Objects.hashCode(this.conteudoMensagem);
        hash = 89 * hash + Objects.hashCode(this.dataCriacao);
        hash = 89 * hash + Objects.hashCode(this.dataModificacao);
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
        final Post other = (Post) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.conteudoMensagem, other.conteudoMensagem)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
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
        sb.append("\n =========== POST ===========");

        sb.append("\n ID: ").append(id).
        append("\n Pessoa que publicou: ").append(pessoa.getNome()).
        append("\n Mensagem: ").append(conteudoMensagem). 
        append("\n Data de Criacao: ").append(dataCriacao).
        append("\n Data de Modificacao: ").append(dataModificacao).
        append("\n =================================");

        return sb.toString();
    }
    
}
