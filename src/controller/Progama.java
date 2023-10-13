/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pessoa;
import model.PessoaDAO;
import view.GUI;

/**
 *
 * @author diogo e matheus
 */
public class Progama {
    private GUI gui = new GUI(); 
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private int menu = 1;
    private Pessoa pessoa;
    
    public Progama() {
        while(menu != 0){
            switch(gui.menuInicial()){
                case 1 -> {                
                    if(pessoaDAO.validarLogin(gui.email(), gui.senha())){
                        //MENU PRINCIPAL
                    }
                    else{
                        System.out.println("\n Email ou senha incorreto");
                    }
                    break;
                }
                
                case 2 -> {
                    pessoa = gui.cadastro();
                    if(pessoaDAO.adicionar(pessoa)){
                        System.out.println("Pessoa adicionada com sucesso!");
                    }else{
                        System.out.println("Erro - Pessoa não adicionada!");
                    }
                }
                
                case 3 -> {
                    menu = 0;
                    break;
                }

                default -> {
                    System.out.println("\n Valor inválido!");
                }
            }
        }
    }
    
    public void menuPrincipal(){
        
    }
}
