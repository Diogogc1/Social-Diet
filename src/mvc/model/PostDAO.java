package mvc.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class PostDAO {
     Post posts[] = new Post[10];
      
     
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Post post){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] == null){
                posts[i] = post;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(Post post){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].equals(post)){
                posts[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Post post, Post postNovo){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].equals(post)){
                posts[i] = postNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar (Post post){
         for (Post post1 : posts) {
             if (post1.equals(post)) {
                 return true;
             }
         }
        return false;
    }
    
    public String toString(Pessoa pessoaLogada) {
        StringBuilder sb = new StringBuilder();
        sb.append("====== MENSAGENS ======");
        for (Post post : posts) {
            if(post != null && post.getPessoa().equals(pessoaLogada)){
                sb.append("\n ID: ").append(post.getId()).
                append("\n Conteudo Mensagem: ").append(post.getConteudoMensagem()).
                append("\n Data de Criacao: ").append(post.getDataCriacao()).
                append("\n Data de Modificacao: ").append(post.getDataModificacao()).
                append("\n ========================================");
            }
        }
       
        return sb.toString();
    }
}

