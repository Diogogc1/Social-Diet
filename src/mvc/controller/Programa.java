/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

import java.util.Scanner;
import mvc.model.Alimento;
import mvc.model.AvaliacaoDAO;
import mvc.model.AlimentoDAO;
import mvc.model.AlimentoRefeicoes;
import mvc.model.AlimentoRefeicoesDAO;
import mvc.model.Avaliacao;
import mvc.model.Dieta;
import mvc.model.DietaDAO;
import mvc.model.Login;
import mvc.model.Mensagem;
import mvc.model.MensagemDAO;
import mvc.model.Pessoa;
import mvc.model.PessoaDAO;
import mvc.model.PostDAO;
import mvc.model.Preferencias;
import mvc.model.PreferenciasDAO;
import mvc.model.Refeicao;
import mvc.model.RefeicaoDAO;
import mvc.model.SeguirDAO;
import mvc.model.TipoDieta;
import mvc.model.TipoDietaDAO;
import mvc.view.GUI;

/**
 *
 * @author diogo e matheus
 */
public class Programa {
    private GUI gui = new GUI(); 
    
    //VARIÁVEL DO LOOP
    private int menu;
    
    //CADASTRO
    private Pessoa pessoaNova;
    
    //AVALIAÇÃO
    Avaliacao avaliacaoNova;
    
    //REFEIÇÃO
    private Dieta dietaEscolhida;
    private Refeicao refeicaoNova;
    private Alimento alimentoSelecionado;
    private Refeicao refeicaoEscolhida;
    private AlimentoRefeicoes alimentoRefeicoesBuscado;
    private Alimento alimentoEscolhido;
    private int contRefeicao;
    private AlimentoRefeicoes alimentoRefeicoesNovo;
    private Alimento alimentoCadastrado;
    
    //PESSOA DAO
    private final PessoaDAO pessoaDAO = new PessoaDAO();
    
    //LOGIN
    private final Login login = new Login(pessoaDAO);
    
    //DAOs
    private final AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(login.getPessoaLogada());
    private final AlimentoDAO alimentoDAO = new AlimentoDAO(login.getPessoaLogada());
    private final TipoDietaDAO tipoDietaDAO = new TipoDietaDAO();
    private final DietaDAO dietaDAO = new DietaDAO(login.getPessoaLogada(), avaliacaoDAO, tipoDietaDAO);
    private final RefeicaoDAO refeicaoDAO = new RefeicaoDAO(dietaDAO, login.getPessoaLogada());
    private final AlimentoRefeicoesDAO alimentoRefeicoesDAO = new AlimentoRefeicoesDAO();
    private final PreferenciasDAO preferenciasDAO = new PreferenciasDAO(login.getPessoaLogada(), alimentoDAO);
    private final PostDAO postDAO = new PostDAO(login.getPessoaLogada());
    private final MensagemDAO mensagemDAO = new MensagemDAO();
    private final SeguirDAO seguirDAO = new SeguirDAO();
    
    public Programa() {
        menuInicial();
    }
    
    public final void menuInicial(){
        do{
            switch(gui.menuInicial()){
                //LOGIN
                case 1 -> {  
                    String email = gui.email();
                    String senha = gui.senha();

                    //PESSOA LOGADA É CRIADA
                    login.setPessoaLogada(pessoaDAO.buscarLogin(email, senha));

                    //MENU PRINCIPAL
                    menuPrincipal();
                    menu = 0;
                }
                //CADASTRO
                case 2 -> {
                    pessoaNova = gui.cadastro();
                    pessoaDAO.adicionar(pessoaNova); 
                }
                //SAIR
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
                //FIT PERSON
                case 1 -> {
                    menuFitPerson();
                    menu = 0;
                }
                //POSTFIT
                case 2 -> {
                    menuPostFit(); 
                    menu = 0;
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
    
    public void menuFitPerson(){
        do{
            switch(gui.menuFitPerson()){
                //MENU AVALIACAO FISICA
                case 1 -> {
                    menuAvaliacao();
                    menu = 0;
                }
                //MENU ALIMENTOS
                case 2 -> {
                    menuAlimentos();
                    menu = 0;
                }
                //MENU PREFÊRENCIAS
                case 3 -> {
                    menuPreferencias();
                    menu = 0;
                }

                //MENU DIETA
                case 4 -> {
                    menuDieta();
                    menu = 0;
                }
                //MENU REFEIÇÕES
                case 5 -> {
                    menuRefeicao();
                    menu = 0;
                }
                //SAIR
                case 6 -> {
                    menu = -1;
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
                        System.out.println("\n Nao ha alimentos cadastrados! Cadastre alimentos \n");
                    }else{
                        System.out.println("\n");
                        System.out.println(alimentoDAO);
                    }
                }
                //CADASTAR ALIMENTOS
                case 2 -> {
                    if(alimentoDAO.adicionar(gui.cadastrarAlimentos(login.getPessoaLogada()))){
                        System.out.println("\n Alimento cadastrado com sucesso!");
                    }else{
                        System.out.println("ERRO - Alimento nao cadastrado!");
                    }
                }
                
                //GERAR RELATÓRIO
                case 3 -> {
                    alimentoDAO.gerarRelatorio();
                }
                
                //BUSCAR ALIMENTO
                case 4 -> {
                    System.out.println(gui.buscarAlimento(alimentoDAO));
                }
                //ALTERAR ALIMENTO
                case 5 -> {
                    alimentoDAO.alterar(gui.escolherAlimento(alimentoDAO, login.getPessoaLogada()), gui.cadastrarAlimentos(login.getPessoaLogada())); 
                }
                
                //EXCLUIR ALIMENTO
                case 6 -> {
                    alimentoEscolhido = gui.escolherAlimento(alimentoDAO, login.getPessoaLogada());
                    alimentoDAO.remover(alimentoEscolhido);
                    alimentoRefeicoesDAO.removerAlimento(alimentoEscolhido);
                }
                
                //SAIR
                case 7 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public TipoDieta montarTipoDieta(){
        switch(gui.cadastrarTipoDieta()){
            case 1 -> {
                return tipoDietaDAO.buscar(1);
            }
            case 2 -> {
                return tipoDietaDAO.buscar(2);
            }
            case 3 -> {
                return tipoDietaDAO.buscar(3);
            }
            default -> {
                 return null;
            }
        } 
    }
    
    public void menuDieta(){
        do{
            switch(gui.menuDieta()){
                //VER DIETAS
                case 1 -> {
                    System.out.println(dietaDAO);
                }
                
                //CADASTRAR DIETA
                case 2 -> {
                    TipoDieta tipoDieta = montarTipoDieta();
                    if(tipoDieta == null){
                        System.out.println("Opcao Invalida!");
                    }else{
                        if(dietaDAO.adicionar(gui.cadastrarDieta(login.getPessoaLogada(), avaliacaoDAO, tipoDieta))){
                            System.out.println("\n Dieta adicionada com sucesso!");
                        }else{
                            System.out.println("\n ERRO - Dieta nao adicionada!");
                        }
                    }
                }
                
                //BUSCAR DIETA
                case 3 -> {
                    System.out.println(dietaDAO.buscar(gui.buscarDieta()));
                }
                
                //ALTERAR DIETA
                case 4 -> {
                    dietaDAO.alterar(dietaDAO.buscar(gui.escolherDieta()), gui.cadastrarDieta(login.getPessoaLogada(), avaliacaoDAO, montarTipoDieta())) ;
                }
                //REMOVER DIETA
                case 5 -> {
                    dietaDAO.remover(gui.escolheDieta(dietaDAO));
                }
                //SAIR
                case 6 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuRefeicao(){
        do{
            switch(gui.menuRefeicao()){
                //VER REFEICOES
                case 1 -> {
                    if(refeicaoDAO.isVazio()){
                        System.out.println("\n Nao ha refeicoes cadastradas! Cadastre refeicoes");
                    }else{
                        System.out.println("\n");
                        System.out.println(refeicaoDAO);
                    }
                }
                //CADASTAR REFEICOES
                case 2 -> {
                    dietaEscolhida = gui.escolheDieta(dietaDAO);
                    contRefeicao = refeicaoDAO.numeroDeRefeicaoDaDieta(dietaEscolhida);

                     //VERIFICA SE JÁ TEM REFEIÇÕES CADASTRADAS NESSA DIETA E CADASTRA SÓ O QUE FALTA
                    while (!refeicaoDAO.bateuMetaDieta(dietaEscolhida) && contRefeicao < dietaEscolhida.getNumeroRefeicoes()) {
                        
                        refeicaoNova = gui.cadastrarRefeicao(dietaEscolhida);
                        refeicaoDAO.adicionar(refeicaoNova);

                        while(!alimentoRefeicoesDAO.bateuMetaRefeicao(refeicaoNova)){
                            alimentoEscolhido = gui.escolherAlimentosRefeicoes(alimentoDAO);
                            alimentoRefeicoesNovo = gui.cadastrarAlimentosRefeicoes(alimentoEscolhido, refeicaoNova);
                            alimentoRefeicoesDAO.adicionar(alimentoRefeicoesNovo);
                        }
                        System.out.println("\n\n O numero maximo de alimentos da refeicao foi atingido!");
                        contRefeicao++;
                    }
                    
                    if(contRefeicao >= dietaEscolhida.getNumeroRefeicoes()){
                        System.out.println("\n\n O numero maximo de refeicoes da dieta foi atingido!");
                    }
                }
                //GERAR REFEIÇÕES AUTOMÁTICAS
                case 3 -> {
                    dietaEscolhida = gui.escolheDieta(dietaDAO);
                    contRefeicao = refeicaoDAO.numeroDeRefeicaoDaDieta(dietaEscolhida);
                    
                     if(!preferenciasDAO.isVazio()){
                        while(!refeicaoDAO.bateuMetaDieta(dietaEscolhida) && contRefeicao < dietaEscolhida.getNumeroRefeicoes()) {
                            refeicaoNova = gui.cadastrarRefeicao(dietaEscolhida);
                            refeicaoDAO.adicionar(refeicaoNova);

                            for(int j = 1; !alimentoRefeicoesDAO.bateuMetaRefeicao(refeicaoNova); j++){
                                alimentoRefeicoesNovo = alimentoRefeicoesDAO.cadastrarAutomaticoAlimentoRefeicoes(refeicaoNova, j, preferenciasDAO);
                                alimentoCadastrado = preferenciasDAO.buscarNaoNulo(j).getAlimento();
                                if(alimentoCadastrado == null){
                                    j = 1;
                                    alimentoCadastrado = preferenciasDAO.buscarNaoNulo(j).getAlimento();
                                }
                                
                                alimentoRefeicoesDAO.adicionar(alimentoRefeicoesNovo);
                            }
                            contRefeicao++;
                        }
                    }else{
                         System.out.println("\n\n Voce nao possui preferencias!");
                     }
                }
                
                //VER ALIMENTOS QUE ESTÃO NA REFEIÇÃO
                case 4 -> {
                    refeicaoEscolhida = gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada());
                    alimentoRefeicoesBuscado = alimentoRefeicoesDAO.buscarAlimentosDeUmaRefeicao(refeicaoEscolhida, 0);
                    for (int i = 1; alimentoRefeicoesBuscado != null; i++) {
                        System.out.println(alimentoRefeicoesBuscado);
                        alimentoRefeicoesBuscado = alimentoRefeicoesDAO.buscarAlimentosDeUmaRefeicao(refeicaoEscolhida, i);
                    }
                }
                
                //BUSCAR
                case 5 -> {
                    System.out.println(gui.buscarRefeicao(refeicaoDAO));
                }
                
                //ALTERAR
                case 6 -> {
                    refeicaoDAO.alterar(gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada()), gui.cadastrarRefeicao(gui.escolheDieta(dietaDAO)));
                }
                
                //REMOVER
                case 7 -> {
                    refeicaoEscolhida = gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada());
                    refeicaoDAO.remover(refeicaoEscolhida);
                    alimentoRefeicoesDAO.removerRefeicao(refeicaoEscolhida);
                }
                
                case 8 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public void menuAvaliacao(){
        do{
            switch(gui.menuAvaliacao()){
                case 1 ->{
                   avaliacaoNova = gui.fazerAvaliacao(login.getPessoaLogada());
                   avaliacaoNova.setImc(avaliacaoNova.calcularImc());
                   avaliacaoNova.setTmb(avaliacaoNova.calcularTmb(avaliacaoNova.obterTaxaAtvd(gui.praticaExercicios())));
                   avaliacaoNova.setBf(avaliacaoNova.calcularBf());

                   //MOSTRAR RELATÓRIO
                   System.out.println(avaliacaoNova);
                   avaliacaoDAO.adicionar(avaliacaoNova);                  
                }
                case 2 ->{
                    System.out.print(avaliacaoDAO.buscar(gui.buscarAvaliacao()));
                }
                case 3 -> {
                    
                    avaliacaoNova = gui.fazerAvaliacao(login.getPessoaLogada());
                    avaliacaoNova.setImc(avaliacaoNova.calcularImc());
                    avaliacaoNova.setTmb(avaliacaoNova.calcularTmb(avaliacaoNova.obterTaxaAtvd(gui.praticaExercicios())));
                    avaliacaoNova.setBf(avaliacaoNova.calcularBf());
                    
                    System.out.println(avaliacaoNova);
                    
                    avaliacaoDAO.alterar(gui.alterarAvaliacao(), avaliacaoNova);
                }
                case 4 -> {
                    avaliacaoDAO.remover(gui.removerAvaliacao());
                }
                case 5 ->{
                    System.out.print(avaliacaoDAO);
                }
                case 6 ->{
                    menu = -1;
                }
            }
        }while(menu != -1);
    }
    
    public void menuPreferencias(){
        do{
            switch(gui.menuPreferencias()){
                case 1 ->{
                    System.out.println(preferenciasDAO);                           
                }
                //CADASTRAR
                case 2 ->{
                    System.out.println(alimentoDAO);
                    if(preferenciasDAO.adicionar(gui.cadastrarPreferencias(login.getPessoaLogada(), alimentoDAO))){
                        System.out.println("\n Preferencia cadastrada");
                    }else{
                        System.out.println("\n Preferencia nao cadastrada");
                    }

                }
                case 3 ->{
                   System.out.print(preferenciasDAO.buscar(gui.buscarPreferencia())); 
                }
                case 4 ->{
                    preferenciasDAO.alterar(gui.alterarPreferencia(), gui.cadastrarPreferencias(login.getPessoaLogada(), alimentoDAO));
                }
                case 5 ->{
                    preferenciasDAO.remover(gui.removerPreferencia());
                }
                case 6 ->{
                  menu = -1;  
                }
            }
        }while(menu != -1);
    }
    
    public void menuPostFit(){
        do{
            switch(gui.menuPostFit()){
                //TIMELINE
                case 1 ->{
                    System.out.println(seguirDAO.timeline(login.getPessoaLogada(), postDAO));
                }
                //MENSAGEM
                case 2 ->{
                    menuMensagem();
                    menu = 0;
                }
                //POST
                case 3 ->{
                    menuPost();
                    menu = 0;
                }
                //SEGUIR
                case 4 ->{
                    menuSeguir();
                    menu = 0;
                }
                //SAIR
                case 5 ->{
                    menuConfiguracoes();
                    menu = 0;
                }
                
                case 6 -> {
                    menu = -1;
                }
            }
        }while(menu != -1);
    }
    
    public void menuPost(){
        do{
            switch(gui.menuPost()){
                case 1 ->{
                    System.out.println(postDAO);
                }
                case 2 ->{
                    postDAO.adicionar(gui.criarPost(login.getPessoaLogada()));
                }
                case 3 ->{
                    System.out.print(postDAO.buscar(gui.buscarPost()));
                }
                case 4 ->{
                    postDAO.alterar(gui.alterarPost(), gui.criarPost(login.getPessoaLogada()));
                }
                case 5 ->{
                    postDAO.remover(gui.removerPost());
                }   
                case 6 ->{
                    menu = -1;
                }
            }
        }while(menu != -1);
    }
    
    public void menuMensagem(){
        do{
            switch(gui.menuMensagem()){
                case 1 ->{
                    System.out.println(mensagemDAO);
                }
                case 2 ->{
                    if(mensagemDAO.adicionar(gui.mandarMensagem(login.getPessoaLogada(), seguirDAO, pessoaDAO))){
                        System.out.println("\n Mensagem enviada com sucesso!");
                    }else{
                        System.out.println("\n ERRO! Mensagem não enviada!");
                    }
                }
                case 3 ->{
                    System.out.print(mensagemDAO.buscar(gui.buscarMensagem(mensagemDAO)));
                }
                case 4 ->{
                    mensagemDAO.alterar(gui.alterarMensagem(mensagemDAO), gui.mandarMensagem(login.getPessoaLogada(), seguirDAO, pessoaDAO));
                }
                case 5 ->{
                    mensagemDAO.remover(gui.removerMensagem());
                }   
                case 6 ->{
                    menu = -1;
                }
            }
        }while(menu != -1);
    }
    
    public void menuSeguir(){
        do{
            switch(gui.menuSeguir()){
                //VER SEGUIDORES
                case 1 -> {
                    System.out.println(seguirDAO.toString());
                }
                //SEGUIR ALGUÉM
                case 2 -> {
                    seguirDAO.adicionar(gui.seguir(login.getPessoaLogada(), pessoaDAO));
                }
                case 3 ->{
                    System.out.print(seguirDAO.buscar(gui.buscarSeguidor()));
                }
                case 4 ->{
                    seguirDAO.alterar(gui.alterarSeguidor(seguirDAO), gui.seguir(login.getPessoaLogada(), pessoaDAO));
                }
                case 5 ->{
                    seguirDAO.remover(gui.removerSeguidor(seguirDAO));
                }   
                case 6 ->{
                    menu = -1;
                }
            }
        }while(menu != -1);
    }
    
   public void menuConfiguracoes(){
       do{
           switch(gui.menuConfiguracoes()){
               //VER MEU DADOS
               case 1 -> {
                   System.out.println(login.getPessoaLogada());
               }
               //ALTERAR NOME
               case 2 -> {
                    login.getPessoaLogada().setNome(gui.alterarNome());
                    pessoaDAO.alterarNome(login.getPessoaLogada(), login.getPessoaLogada().getNome());
               }
               //ALTERAR EMAIL
               case 3 -> {
                    login.getPessoaLogada().setNome(gui.alterarEmail());
                    pessoaDAO.alterarEmail(login.getPessoaLogada(), login.getPessoaLogada().getEmail()); 
               }
               //ALTERAR SENHA
               case 4 -> {
                    login.getPessoaLogada().setSenha(gui.alterarSenha());
                    pessoaDAO.alterarSenha(login.getPessoaLogada(), login.getPessoaLogada().getEmail());
               }
               //DESLOGAR
               case 5 -> {
                    menuInicial();
               }
               //EXCLUIR CONTA
               case 6 -> {
                    pessoaDAO.remover(login.getPessoaLogada());
                    menuInicial();
               }
               //SAIR
               case 7 -> {
                   menu = -1;
               }
           }
       }while(menu != -1);
   }
}