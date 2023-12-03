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
    private final Login login = new Login();

    public PostDAO(Pessoa pessoaLogada) {
        this.adicionar(new Post(pessoaLogada,"Boa noite, amigos!"));
    }
     
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
    public boolean remover(long idPost){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].getId() == idPost){
                posts[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idPost, Post postNovo){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].getId() == idPost){
                posts[i] = postNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public boolean buscar (long idPost){
         for (Post post1 : posts) {
             if (post1.getId() == idPost) {
                 return true;
             }
         }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n ============= POSTS =============");
        for (Post post : posts) {
            if(post != null && post.getPessoa().equals(login.getPessoaLogada())){
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

