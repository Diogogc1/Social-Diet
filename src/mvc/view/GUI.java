/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AlimentoDAO;
import mvc.model.AlimentoRefeicoes;
import mvc.model.Avaliacao;
import mvc.model.AvaliacaoDAO;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.Mensagem;
import mvc.model.MensagemDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.Post;
import mvc.model.Preferencias;
import mvc.model.Refeicao;
import mvc.model.RefeicaoDAO;
import mvc.model.Seguir;
import mvc.model.SeguirDAO;
import mvc.model.TipoDieta;

/**
 *
 * @author diogo
 */
public class GUI {
    Scanner scanner = new Scanner(System.in);
    private long id;
  
    //LOGIN
    private String email;
    private String senha;
    
    //CADASTRO
    private String nome;
    private String sexo;
    private LocalDate dataNascimento;
    
    //AVALIACAO
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    
    //ALIMENTOS
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private double calorias;
    private int porcao;
    
    //DIETA
    private String objetivo;
    private int nrRefeicoes;
    
    //POST
    String conteudoMensagem;
    
    //MENSAGEM
    String mensagem;
    
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
                           
                           1. Avaliacao Fisica
                           2. Alimentos
                           3. Preferencias
                           4. Dietas
                           5. Refeicoes
                           6. SAIR
                           """);
        
        System.out.print("Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuAvaliacao(){
        System.out.println("\n\n");
        System.out.println("""
                           ======== AVALIACAO ========
                           
                           1. Fazer Avaliacao Fisica
                           2. Buscar avaliacao
                           3. Alterar avaliacao
                           4. Deletar avaliacao
                           5. Ver avaliacoes
                           6. SAIR
                           """);
        System.out.print("Escolha uma opção: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Avaliacao fazerAvaliacao(Pessoa pessoa){
        /*PESSOA, PESO, ALTURA, IDADE, PESCOCO,
        CINTURA, QUADRIL, IMC, TMB, BF, MASSA GORDA KG, MASSA MAGRA KG,
        DATACRIACAO, DATAMODIFICACAO.*/
        
        System.out.println("\n ==== FAZER AVALIACAO ====");
        
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
    
    public int praticaExercicios(){
        System.out.println("""
                           
                           O quanto você pratica exercícios?
                           1. Nenhuma
                           2. 1 a 3 vezes na semana
                           3. 6 a 7 vezes na semana
                           4. 2 vezes ao dia (ou intensamente todos os dias)
                           5. Treinamento intenso (muito difícil)
                           """);
        
        System.out.print("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public long buscarAvaliacao(){
        System.out.println("\n ====== BUSCAR AVALIACAO ======");
        
        System.out.print("\n Informe o id para busca: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id;
    }
    
    public long alterarAvaliacao(){
        System.out.println("\n ===== ALTERAR AVALIACAO =====");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public long removerAvaliacao(){
        System.out.println("\n ===== REMOVER AVALIACAO =====");
        
        System.out.print("Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public int menuAlimentos(){
        System.out.println("""
                           
                           ====== ALIMENTOS ======
 
                           1. Ver Alimentos
                           2. Cadastar Alimento
                           3. Buscar
                           4. Alterar 
                           5. Excluir
                           6. SAIR
                           """);
        System.out.print("Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Alimento cadastrarAlimentos(Pessoa pessoa){
        /*nome, carboidratos, proteínas, gorduras, 
        calorias, porcao, pessoa, dataCriacao, dataModificacao*/
        System.out.println("\n");
        
        System.out.println("==== CADASTRE UM ALIMENTO ====");
        
        System.out.print("\n Nome: ");
        nome = scanner.nextLine();
        
        System.out.print("\n Proteínas: ");
        proteinas = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Gordura: ");
        gorduras = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Carboidratos: ");
        carboidratos = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Calorias: ");
        calorias = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Porcao: ");
        porcao = Integer.parseInt(scanner.nextLine());
        
        return new Alimento(nome, carboidratos, proteinas, gorduras, porcao, pessoa);
    }
    
    public Alimento buscarAlimento(AlimentoDAO alimentoDAO){
        System.out.print("\n Digite o nome do alimento: ");
        
        return alimentoDAO.buscarNome(scanner.nextLine());
    }
    
    public Alimento escolherAlimento(AlimentoDAO alimentoDAO, Pessoa pessoaLogada){
        System.out.println(alimentoDAO);
        
        System.out.print("\n Escolha algum alimento pelo ID: ");
        
        return alimentoDAO.buscar(Long.parseLong(scanner.nextLine()));
    } 
    
    public int cadastrarTipoDieta(){
        System.out.println("""
                           ========= TIPO DIETA =========
                           1. Equilibrada 
                           2. Low Carb
                           3. Cetogenica                         
                           """);
        System.out.print("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuDieta(){
        System.out.println("""
                           ======== DIETA ========
                           1. Ver Dietas
                           2. Montar Dieta
                           3. Buscar Dieta
                           4. Alterar Dieta
                           5. Remover Dieta
                           6. SAIR
                           """);
        System.out.print("Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Dieta cadastrarDieta(Pessoa pessoa, AvaliacaoDAO avaliacaoDAO, TipoDieta tipoDieta){
        /*id, pessoa, avaliacao fisica, tipo dieta, objetivo, 
        calorias, nro refeicoes, dataCriacao, dataModificacao*/
        System.out.println(avaliacaoDAO);
        id = Long.parseLong(scanner.nextLine());
        
        Avaliacao avaliacaoDieta = avaliacaoDAO.buscar(id);
        
        System.out.println("\n ====== Monte uma Dieta ======");
        System.out.println("Qual o seu objetivo? \n");
        System.out.println("1. Diminuir o peso");
        System.out.println("2. Manter o peso");
        System.out.println("3. Aumentar o peso");
        
        //O VALOR DO OBJETIVO É TRATADO NO CONTROLLER, NA CLASSE PROGRAMA
        objetivo = scanner.nextLine();
        
        System.out.println("Numero de Refeicoes: ");
        nrRefeicoes = Integer.parseInt(scanner.nextLine());
        
        //CALORIAS DA DIETA SÃO DEFINIDAS NO CONTROLLER, NA CLASSE PROGRAMA
        return new Dieta(pessoa, avaliacaoDieta, tipoDieta, objetivo, avaliacaoDieta.getTmb(), nrRefeicoes);
    }
    
    public long buscarDieta(){
        System.out.print("Informe o id para busca: ");
        return Long.parseLong(scanner.nextLine());
    }
    
    public long escolherDieta(){
        System.out.print("Informe o id que deseja: ");
        return Long.parseLong(scanner.nextLine());
    } 
    
    public int menuRefeicao(){
        System.out.println("\n");
        System.out.println("""
                           ======= REFEICAO =======

                           1. Ver Refeicoes
                           2. Cadastar Refeicao
                           3. Gerar Refeicao Automaticamente
                           4. Ver Alimentos da Refeicao
                           5. Buscar 
                           6. Alterar
                           7. Remover
                           8. SAIR
                           """);
        System.out.print("Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Dieta escolheDieta(DietaDAO dietaDAO){
        System.out.println(dietaDAO);
        
        System.out.print("\n Escolha uma opcao: ");
        id = Integer.parseInt(scanner.nextLine());
        
        return dietaDAO.buscar(id);
    }
    
    public Refeicao cadastrarRefeicao(Dieta dieta){
        /*id, dieta, carboidrato, proteína, gordura, 
        calorias, nome da refeição, dataCriacao, dataModificacao.*/
        System.out.println("\n ======= Monte uma Refeição =======");
        
        System.out.print("\n Nome: ");
        nome = scanner.nextLine();
        
        System.out.print("\n Proteínas: ");
        proteinas = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Gordura: ");
        gorduras = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Carboidratos: ");
        carboidratos = Double.parseDouble(scanner.nextLine());
        
        System.out.print("\n Calorias: ");
        calorias = Double.parseDouble(scanner.nextLine());
        
        return new Refeicao(dieta, carboidratos, proteinas, gorduras, calorias, nome);
    }
    
    public Refeicao buscarRefeicao(RefeicaoDAO refeicaoDAO){
        System.out.print("\n Digite o nome da Refeicao: ");
        
        return refeicaoDAO.buscarNome(scanner.nextLine());
    }
    
    public Refeicao escolherRefeicao(RefeicaoDAO refeicaoDAO, Pessoa pessoaLogada){
        System.out.println(refeicaoDAO);
        
        System.out.print("\n Escolha alguma Refeicao pelo ID: ");
        
        return refeicaoDAO.buscar(Long.parseLong(scanner.nextLine()));
    } 
    
    public Alimento escolherAlimentosRefeicoes(AlimentoDAO alimentoDAO){
        System.out.println(alimentoDAO);
        System.out.print("\n Escolha um alimento pelo ID: ");
        id = Integer.parseInt(scanner.nextLine());

        return alimentoDAO.buscar(id);
    }
    
    public AlimentoRefeicoes cadastrarAlimentosRefeicoes(Alimento alimento, Refeicao refeicao){
        System.out.print("\n Quantidade de porcoes desse alimento voce ira consumir: ");
        porcao = Integer.parseInt(scanner.nextLine());
        
        //GUARDANDO A PORCENTAGEM QUE O ALIMENTO REPRESENTA EM RELAÇÃO AO TOTAL DA REFEIÇÃO
        carboidratos = (alimento.getCarboidratos() * 100 * porcao) / refeicao.getCarboidrato();
        proteinas = (alimento.getProteinas() * 100 * porcao) / refeicao.getProteina();
        gorduras = (alimento.getGorduras() * 100 * porcao) / refeicao.getGordura();
        calorias = (alimento.getCalorias() * 100 * porcao) / refeicao.getCalorias();
        
        return new AlimentoRefeicoes(refeicao, alimento, porcao, carboidratos, proteinas, gorduras, calorias);
    }
    
    public int menuPreferencias(){
        System.out.println("\n======= PREFERENCIAS =======");
        System.out.println("1. Ver preferencias");
        System.out.println("2. Cadastrar");
        System.out.println("3. Buscar");
        System.out.println("4. Alterar");
        System.out.println("5. Remover");
        System.out.println("6. SAIR");
        
        System.out.print("\n Escolha uma opcao: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Preferencias cadastrarPreferencias(Pessoa pessoaLogada, AlimentoDAO alimentoDAO){   
        System.out.println("\n ======= Cadastrar Preferencias =======");
        System.out.println(alimentoDAO);
        System.out.print("\n Escolha algum alimento pelo ID: ");
        id = Integer.parseInt(scanner.nextLine());
        
        return new Preferencias(pessoaLogada, alimentoDAO.buscar(id));
    }
    
    public long buscarPreferencia(){
        System.out.println("\n ==== BUSCAR PREFERENCIA ==== \n");
        
        System.out.print("\n Informe o id para busca: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id;
    }
    
    public long alterarPreferencia(){
        System.out.println("\n ==== ALTERAR PREFERENCIA ==== \n");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public long removerPreferencia(){
        System.out.println("\n ===== REMOVER PREFERENCIA ===== \n");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public int menuPostFit(){
        
        System.out.println("""
                            
                            ====== PostFit ======

                            1. Timeline
                            2. Mensagens
                            3. Post
                            4. Seguir
                            5. Configuracoes
                            6. SAIR
                            """);
        
        System.out.print("Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public int menuPost(){
         System.out.println("""
                            ====== Posts ======

                            1. Ver posts
                            2. Criar post
                            3. Buscar post
                            4. Alterar post
                            5. Remover post
                            6. SAIR
                            """);
        
        System.out.print("\n Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Post criarPost(Pessoa pessoaLogada){
        System.out.println("\n ===== CRIAR POST ===== \n");
        
        System.out.println("\n Conteudo do Post: ");
        conteudoMensagem = scanner.nextLine();
        
        return new Post(pessoaLogada, conteudoMensagem);
    }
    
    public long buscarPost(){
        System.out.println("\n ===== BUSCAR POST ===== \n");
        
        System.out.print("Informe o id para busca: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id;
    }
    
    public long alterarPost(){
        System.out.println("\n ===== ALTERAR POST ===== \n");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public long removerPost(){
        System.out.println("\n ===== REMOVER POST =====");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public int menuMensagem(){
        System.out.print("\n");
        System.out.println("""
                            ====== MENSAGENS ======

                            1. Ver mensagens
                            2. Mandar mensagem
                            3. Buscar mensagem
                            4. Alterar mensagem
                            5. Remover mensagem                 
                            6. SAIR
                            """);
        
        System.out.print("Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Mensagem mandarMensagem(Pessoa pessoaLogada, SeguirDAO seguirDAO, PessoaDAO pessoaDAO){ 
        System.out.print("\n Digite a mensagem: ");
        conteudoMensagem = scanner.nextLine();
        
        //RECEBER PESSOA DESTINO
        System.out.println(seguirDAO);
        
        System.out.print("\n Escolha alguem pelo ID: ");
        id = Long.parseLong(scanner.nextLine());
        
        return new Mensagem(pessoaLogada, pessoaDAO.buscar(seguirDAO.buscar(id).getPessoaSeguindo().getId()), conteudoMensagem);
    }
    
    public long buscarMensagem(MensagemDAO mensagemDAO){
        System.out.println("\n ==== BUSCAR MENSAGEM ==== \n");
        
        System.out.println(mensagemDAO);
        
        System.out.print("\n Informe o id para busca: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id;
    }
    
    public long alterarMensagem(MensagemDAO mensagemDAO){
        System.out.println("\n ==== ALTERAR MENSAGEM ====");
        
        System.out.println(mensagemDAO);
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public long removerMensagem(){
        System.out.println("\n ==== REMOVER MENSAGEM ==== \n");
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    
    public int menuSeguir(){
        System.out.println("""
                            ====== SEGUIR ======

                            1. Ver seguidores
                            2. Seguir
                            3. Buscar seguidor
                            4. Alterar seguidor
                            5. Remover seguidor                
                            6. SAIR
                            """);
        
        System.out.print("\n Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public Seguir seguir(Pessoa pessoaLogada, PessoaDAO pessoaDAO){
        System.out.println(pessoaDAO);
        
        System.out.print("\n Escolha alguem pelo ID: ");
        id = Long.parseLong(scanner.nextLine());
        
        return new Seguir(pessoaLogada, pessoaDAO.buscar(id));
    }
    
    public long buscarSeguidor(){
        System.out.println("\n ==== BUSCAR SEGUIDOR ====");
        
        System.out.print("\n Informe o id para busca: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id;
    }
    
    public long alterarSeguidor(SeguirDAO seguirDAO){
        System.out.println("\n ==== ALTERAR SEGUIDOR ==== \n");
        
        System.out.println(seguirDAO);
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }
    
    public long removerSeguidor(SeguirDAO seguirDAO){
        System.out.println("\n ==== REMOVER SEGUIDOR ==== \n");
        
        System.out.println(seguirDAO);
        
        System.out.print("\n Informe o id que deseja: ");
        id = Long.parseLong(scanner.nextLine());
        
        return id; 
    }  
    public int menuConfiguracoes(){
        System.out.println("""
                           ====== CONFIGURACOES ======
                           
                           1. Ver meus dados
                           2. Alterar nome
                           3. Alterar email
                           4. Alterar senha
                           5. Deslogar
                           6. Excluir conta
                           7. SAIR (voltar)
                           """);
        
        System.out.print("\n Escolha uma opcao: ");
        
        return Integer.parseInt(scanner.nextLine());
    }
    
    public String alterarNome(){
        System.out.println("Digite o novo nome: ");
        
        return scanner.nextLine();
    }
    
    public String alterarEmail(){
        System.out.println("Digite o novo email: ");
        
        return scanner.nextLine();
    }
    
    public String alterarSenha(){
        System.out.println("Digite a nova senha: ");
        
        return scanner.nextLine();
    }

}