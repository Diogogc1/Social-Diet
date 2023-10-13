package model;

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
    public String adicionar(Post post){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i] == null){
                posts[i] = post;
                return "Post adicionado com sucesso!";
            } 
        }
        return "Erro - Post não adicionado!";
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public String remover(Post post){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].equals(post)){
                posts[i] = null;
                return "Post removido com sucesso!";
            }
        }
        return "Erro - Post não removido!";
    }
    
    //ALTERAR
    public String alterar(Post post, Post postNovo){
        for (int i = 0; i < posts.length; i++) {
            if(posts[i].equals(post)){
                posts[i] = postNovo;
                return "Post alterado com sucesso!";
            }
        }
        return "Erro - Post não alterado!";
    }
    
    //LER
    public void ler (Post post){
        System.out.println("Registros: \n");
        for (int i = 0; i < posts.length; i++){
            System.out.println(posts[i] + " ");
        }
    }
}
