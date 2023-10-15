/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import mvc.model.AvaliacaoDAO;
import mvc.model.AlimentoDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.view.GUI;

/**
 *
 * @author diogo e matheus
 */
public class Programa {
    private GUI gui = new GUI(); 
    
    private int menu;
    private Pessoa pessoaLogada;
    private Pessoa pessoaNova;
    
    //DAOs
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
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
                            System.out.print(avaliacaoDAO.buscar(gui.buscarAvaliacao()));
                        }
                        case 3 -> {
                            avaliacaoDAO.alterar(gui.alterarAvaliacao(), gui.fazerAvaliacao(pessoaLogada));
                        }
                        case 4 -> {
                        }
                        case 5 ->{
                            System.out.print(avaliacaoDAO);
                        }
                        case 6 ->{
                            menu = -1;
                        }
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
                    menuDieta();
                    menu = 0;
                }
                //MENU REFEIÇÕES
                case 6 -> {
                    //menuRefeicao();
                    menu = 0;
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
                        System.out.println("\n Nao ha alimentos cadastrados! Cadastre alimentos");
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
    
    public void menuDieta(){
        do{
            switch(gui.menuDieta()){
                //DIETA AUTOMÁTICA
                case 1 -> {
                    
                }
                
                //CADASTRAR DIETA
                case 2 -> {
                    //gui.cadastrarDieta(pessoaNova, avaliacao, tipoDieta);
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
    
    public void menuReficao(){
        do{
            switch(gui.menuAlimentos()){
                //VER REFEICOES
                case 1 -> {
                    if(alimentoDAO.isVazio()){
                        System.out.println("\n Nao ha refeicoes cadastradas! Cadastre refeicoes");
                    }else{
                        System.out.println("\n");
                        System.out.println(alimentoDAO);
                    }
                }
                //CADASTAR REFEICOES
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
