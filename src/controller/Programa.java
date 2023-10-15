/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.AvaliacaoDAO;
import model.AlimentoDAO;
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
    
    //DAOs
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private AlimentoDAO alimentoDAO = new AlimentoDAO(pessoaLogada);
    
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
                //MENU AVALIACAO FISICA
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
                //MENU ALIMENTOS
                case 2 -> {
                    menuAlimentos();
                    menu = 0;
                }
                //MENU PREFÊRENCIAS
                case 3 -> {
 
                }
                //MENU TIPO DE DIETA
                case 4 -> {
                    
                   
                    
                }
                //MENU DIETA
                case 5 -> {
                    
                }
                //MENU REFEIÇÕES
                case 6 -> {
                    
                }
                
                
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuAlimentos(){
        do{
            switch(gui.menuAlimentos()){
                //VER ALIMENTOS
                case 1 -> {
                    if(alimentoDAO.isVazio()){
                        System.out.println("\n Nao ha alimentos cadastrados! Cadastre um alimento");
                    }else{
                        System.out.println("\n");
                        System.out.println(alimentoDAO);
                    }
                }
                //CADASTAR ALIMENTOS
                case 2 -> {
                    if(alimentoDAO.adicionar(gui.cadastrarAlimentos(pessoaLogada))){
                        System.out.println("\n Alimento cadastrado com sucesso!");
                    }else{
                        System.out.println("ERRO - Alimento nao cadastrado!");
                    }
                }
                //SAIR
                case 3 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuPostFit(){
        
    }
    
    
}
