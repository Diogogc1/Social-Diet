/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.util.Scanner;
import model.Alimento;
import model.Avaliacao;
import model.Dieta;
import model.Pessoa;
import model.Refeicao;
import model.TipoDieta;

/**
 *
 * @author diogo
 */
public class GUI {
    Scanner scanner = new Scanner(System.in);
  
    //LOGIN
    String email;
    String senha;
    
    //CADASTRO
    String nome;
    String sexo;
    LocalDate dataNascimento;
    
    //ALIMENTOS
    double carboidratos;
    double proteinas;
    double gorduras;
    double calorias;
    int porcao;
    
    //DIETA
    String objetivo;
    int nrRefeicoes;
    
    //METÓDOS
    public int menuInicial(){
        System.out.print("""
                        ========== POSTFIT  ==========

                        1. Login
                        2. Cadastro
                        3. SAIR
                        """);
        
        System.out.print("\n Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String email(){
        System.out.print("\n E-mail: ");
        return scanner.nextLine();
    }
    
    public String senha(){
        System.out.print("\n Senha: ");
        return scanner.nextLine();
    }
    
    public Pessoa cadastro(){
        System.out.print("Nome");
        nome = scanner.nextLine();
        
        System.out.print("E-mail: ");
        email = scanner.nextLine();
        
        System.out.print("Senha: ");
        senha = scanner.nextLine();
        
        System.out.print("""
                        Qual o seu sexo?

                        1. Masculino
                        2. Femino
                        """);
        
        System.out.print("\n Escolha uma opção: ");
        
        //O VALOR DE SEXO É TRATADO NO CONTROLLER, NA CLASSE PROGRAMA
        sexo = scanner.nextLine();
        
        System.out.print("Data de nascimento: ");
        dataNascimento = LocalDate.parse(scanner.nextLine());
        
        return new Pessoa(nome, sexo, dataNascimento, email, senha);
    }
   
    public int menuPrincipal(){
        System.out.print("""
                        /// MENU ///

                        1. FitPerson
                        2. PostFit
                        3. SAIR
                        """);
        
        System.out.print("\n Escolha uma opção: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuFitPerson(){
        System.out.println("""
                           //// FitPeson ////
                           
                           1. Avaliação Física
                           2. Alimentos
                           3. Preferências
                           4. Dietas
                           5. Refeicoes
                           """);
        
        System.out.print("\n Escolha uma opção: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    //AVALIAÇÃO FÍSICA
    
    public Alimento cadastrarAlimentos(Pessoa pessoa){
        /*nome, carboidratos, proteínas, gorduras, 
        calorias, porcao, pessoa, dataCriacao, dataModificacao*/
        
        System.out.println("/// CADASTRE UM ALIMENTO ///");
        
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        
        System.out.println("Proteínas: ");
        proteinas = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Gordura: ");
        gorduras = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Carboidratos: ");
        carboidratos = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Calorias: ");
        calorias = Double.parseDouble(scanner.nextLine());
        
        System.out.println("porcao: ");
        porcao = Integer.parseInt(scanner.nextLine());
        
        return new Alimento(nome, carboidratos, proteinas, gorduras, porcao, pessoa);
    }
    
    public Dieta cadastrarDieta(Pessoa pessoa, Avaliacao avaliacao, TipoDieta tipoDieta){
        /*id, pessoa, avaliacao fisica, tipo dieta, objetivo, 
        calorias, nro refeicoes, dataCriacao, dataModificacao*/
        
        System.out.println("/// Monte uma Dieta ///");
        System.out.println("1. Qual o seu objetivo?");
        System.out.println("2. Diminuir o peso");
        System.out.println("3. Manter o peso");
        System.out.println("4. Melhorar composicao corporal");
        System.out.println("5. Aumentar o peso");
        
        //O VALOR DO OBJETIVO É TRATADO NO CONTROLLER, NA CLASSE PROGRAMA
        objetivo = scanner.nextLine();
        
        System.out.println("Numero de Refeicoes: ");
        nrRefeicoes = Integer.parseInt(scanner.nextLine());
        
        //CALORIAS DA DIETA SÃO DEFINIDAS NO CONTROLLER, NA CLASSE PROGRAMA
        return new Dieta(pessoa, avaliacao, tipoDieta, objetivo, calorias, nrRefeicoes);
    }
    
    public Refeicao cadastrarRefeicao(Dieta dieta){
        /*id, dieta, carboidrato, proteína, gordura, 
        calorias, nome da refeição, dataCriacao, dataModificacao.*/
        
        System.out.println("/// Monte uma Refeição ///");
        
        System.out.println("Proteínas: ");
        proteinas = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Gordura: ");
        gorduras = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Carboidratos: ");
        carboidratos = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Calorias: ");
        calorias = Double.parseDouble(scanner.nextLine());
        
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        
        return new Refeicao(dieta, carboidratos, proteinas, gorduras, calorias, nome);
    }
}