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
        for (int i = 0; i < posts.length; i++){
           if(posts[i].equals(post)){
               return true;
           }
        }
        return false;
    }
}
