/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.Avaliacao;
import mvc.model.Dieta;
import mvc.model.Pessoa;
import mvc.model.Refeicao;
import mvc.model.TipoDieta;

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
    
    //AVALIACAO
    double peso;
    double altura;
    int idade;
    double pescoco;
    double cintura;
    double quadril;
    long idAvaliacao;
    
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
        
        System.out.print("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String email(){
        System.out.print("\n E-mail: ");
        return scanner.nextLine();
    }
    
    public String senha(){
        System.out.print(" Senha: ");
        return scanner.nextLine();
    }
    
    public Pessoa cadastro(){
        System.out.print("Nome: 2");
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
        
        System.out.print("\n Escolha uma opcao: ");
        
        //O VALOR DE SEXO É TRATADO NO CONTROLLER, NA CLASSE PROGRAMA
        sexo = scanner.nextLine();
        
        System.out.print("Data de nascimento: ");
        dataNascimento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return new Pessoa(nome, sexo, dataNascimento, email, senha);
    }
   
    public int menuPrincipal(){
        System.out.println("\n");
        System.out.print("""
                        ======== MENU ========

                        1. FitPerson
                        2. PostFit
                        3. SAIR
                        """);
        
        System.out.print("\n Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuFitPerson(){
        System.out.println("""
                           ====== FitPeson ======
                           
                           1. Avaliação Física
                           2. Alimentos
                           3. Preferencias
                           4. Tipo de Dieta
                           5. Dietas
                           6. Refeicoes
                           7. SAIR
                           """);
        
        System.out.print("\n Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuAvaliacao(){
        System.out.println("""
                           //// AVALIACAO ////
                           
                           1. Fazer Avaliacao Física
                           2. Buscar avaliacao
                           3. Alterar avaliacao
                           4. Deletar avaliacao
                           5. Ver avaliacoes
                           6. Sair
                           """);
        System.out.print("\n Escolha uma opção: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Avaliacao fazerAvaliacao(Pessoa pessoa){
        /*PESSOA, PESO, ALTURA, IDADE, PESCOCO,
        CINTURA, QUADRIL, IMC, TMB, BF, MASSA GORDA KG, MASSA MAGRA KG,
        DATACRIACAO, DATAMODIFICACAO.*/
        
        System.out.println("/// FAZER AVALIACAO ///");
        
        System.out.print("Peso: ");
        peso = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Altura: ");
        altura = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Idade: ");
        idade = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Pescoco: ");
        pescoco = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Cintura: ");
        cintura = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Quadril: ");
        quadril = Double.parseDouble(scanner.nextLine());
        
        return new Avaliacao(pessoa, peso, altura, idade, pescoco, cintura, quadril);
    }
    
    public long buscarAvaliacao(){
        System.out.println("/// BUSCAR AVALIACAO ///");
        
        System.out.print("Informe o id para busca: ");
        idAvaliacao = Long.parseLong(scanner.nextLine());
        
        return idAvaliacao;
    }
    
    public long alterarAvaliacao(){
        System.out.println("/// ALTERAR AVALIACAO ///");
        
        System.out.print("Informe o id que deseja: ");
        idAvaliacao = Long.parseLong(scanner.nextLine());
        
        return idAvaliacao; 
    }
    
    public int menuAlimentos(){
        System.out.println("""
                           /// ALIMENTOS ///

                           1. Ver Alimentos
                           2. Cadastar Alimento
                           3. SAIR
                           """);
        System.out.println("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
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
    
    public int cadastrarTipoDieta(){
        System.out.println("""
                           ========= TIPO DIETA =========
                           1. Equilibrada 
                           2. Low Carb
                           3. Cetogenica                         
                           """);
        System.out.println("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuDieta(){
        System.out.println("""
                           ======== DIETA ========
                           1. Gerar Dieta Automatica
                           2. Montar sua propria Dieta
                           3. SAIR
                           """);
        System.out.println("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
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
    
    public int menuRefeicao(){
        System.out.println("""
                           ======= REFEICAO =======

                           1. Ver Refeicoes
                           2. Cadastar Refeicao
                           3. SAIR
                           """);
        System.out.println("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
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
