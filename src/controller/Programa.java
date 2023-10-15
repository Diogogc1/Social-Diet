/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.AvaliacaoDAO;
import model.Pessoa;
import model.PessoaDAO;
import view.GUI;

/**
 *
 * @author diogo e matheus
 */
public class Programa {
    private GUI gui = new GUI(); 
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    private int menu;
    private Pessoa pessoaLogada;
    private Pessoa pessoaNova;
    
    public Programa() {
        do{
            switch(gui.menuInicial()){
                case 1 -> {  
                    String email = gui.email();
                    String senha = gui.senha();
                    
                    if(pessoaDAO.validarLogin(email, senha)){
                        pessoaLogada = pessoaDAO.buscarLogin(email, senha);
                        
                        //MENU PRINCIPAL
                        menuPrincipal();
                        menu = -1;
                    }
                    else{
                        System.out.println("\n Email ou senha incorreto");
                    }
                }
                
                case 2 -> {
                    pessoaNova = gui.cadastro();
                    if(pessoaDAO.adicionar(pessoaNova)){
                        System.out.println("Pessoa adicionada com sucesso!");
                    }else{
                        System.out.println("Erro - Pessoa não adicionada!");
                    }
                }
                
                case 3 -> {
                    menu = -1;
                }

                default -> {
                    System.out.println("\n Valor inválido!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuPrincipal(){
        do{
            switch(gui.menuPrincipal()){
                case 1 -> {
                    menuFitPerson();
                }
                
                case 2 -> {
                    menuPostFit();
                }
                
                case 3 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuFitPerson(){
        do{
            switch(gui.menuFitPerson()){
                case 1 -> {
                    switch(gui.menuAvaliacao()){
                        case 1 ->{
                           avaliacaoDAO.adicionar(gui.fazerAvaliacao(pessoaLogada)); 
                        }
                        case 2 ->{
                            avaliacaoDAO.buscar(gui.buscarAvaliacao());
                        }
                        case 3 -> {
                            avaliacaoDAO.alterar(gui.alterarAvaliacao(), gui.fazerAvaliacao(pessoaLogada));
                        }
                        case 4 -> {
                        }
                        case 5 ->{
                            System.out.print(avaliacaoDAO);
                        }
                    }
                    
                    if(gui.menuAvaliacao() == 1){
                        avaliacaoDAO.adicionar(gui.fazerAvaliacao(pessoaLogada));
                    }else{
                        avaliacaoDAO.toString();
                    }
                }
                
                case 2 -> {
                    gui.cadastrarAlimentos(pessoaLogada);
                    System.out.println("Alimento cadastrado com sucesso!");
                }
                
                case 3 -> {
                    //PREFÊRENCIAS
                }
                
                case 4 -> {
                    
                   
                    
                }
                
                case 5 -> {
                    
                }
                
                case 6 -> {
                    
                }
                
                
                
                default -> {
                    System.out.println("Opcao Invalida!");
                }
            }
        }while(menu == -1);
    }
    
    public void menuPostFit(){
        
    }
    
    
}
