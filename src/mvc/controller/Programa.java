/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controller;

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
    private Dieta dietaSelecionada;
    private Refeicao refeicaoNova;
    private Refeicao refeicaoSelecionada;
    private Alimento alimentoSelecionado;
    private int contRefeicao;
    private AlimentoRefeicoes alimentoRefeicoesNovo;
    private Preferencias preferenciaNova;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private double calorias;
    private int porcao;
    
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
    private final MensagemDAO mensagemDAO = new MensagemDAO(login.getPessoaLogada(), pessoaDAO.buscar(1));
    private final SeguirDAO seguirDAO = new SeguirDAO(login.getPessoaLogada(), pessoaDAO.buscar(1));
    
    public Programa() {
        menuInicial();
    }
    
    public void menuInicial(){
        do{
            switch(gui.menuInicial()){
                //LOGIN
                case 1 -> {  
                    String email = gui.email();
                    String senha = gui.senha();
                    
                    if(pessoaDAO.validarLogin(email, senha)){
                        //PESSOA LOGADA É CRIADA
                        login.setPessoaLogada(pessoaDAO.buscarLogin(email, senha));
                        
                        //MENU PRINCIPAL
                        menuPrincipal();
                        menu = 0;
                    }
                    else{
                        System.out.println("\n Email ou senha incorreto");
                    }
                }
                //CADASTRO
                case 2 -> {
                    pessoaNova = gui.cadastro();
                    if(pessoaDAO.adicionar(pessoaNova)){
                        System.out.println("Pessoa adicionada com sucesso!");
                    }else{
                        System.out.println("Erro - Pessoa não adicionada!");
                    }
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
                        System.out.println("\n Nao ha alimentos cadastrados! Cadastre alimentos");
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
                //BUSCAR ALIMENTO
                case 3 -> {
                    System.out.println(gui.buscarAlimento(alimentoDAO));
                }
                //ALTERAR ALIMENTO
                case 4 -> {
                    alimentoDAO.alterar(gui.escolherAlimento(alimentoDAO, login.getPessoaLogada()), gui.cadastrarAlimentos(login.getPessoaLogada())); 
                }
                
                //EXCLUIR ALIMENTO
                case 5 -> {
                    alimentoSelecionado = gui.escolherAlimento(alimentoDAO, login.getPessoaLogada());
                    alimentoDAO.remover(alimentoSelecionado);
                    alimentoRefeicoesDAO.removerAlimento(alimentoSelecionado);
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
    
    public Dieta tratarObjetivo(TipoDieta tipoDieta){
        
        Dieta d = gui.cadastrarDieta(login.getPessoaLogada(), avaliacaoDAO, tipoDieta);
        switch(d.getObjetivo()){
            case "1" -> {
                d.setObjetivo("Diminuir o peso");
            }
            
            case "2" -> {
                d.setObjetivo("Manter o peso");
            }
            
            case "3" -> {
                d.setObjetivo("Melhorar composicao corporal");
            }
            
            case "4" -> {
                d.setObjetivo("Aumentar o peso");
            }
        }
        return d;
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
                        if(dietaDAO.adicionar(tratarObjetivo(tipoDieta))){
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
                    dietaSelecionada = gui.escolheDieta(dietaDAO);
                    contRefeicao = refeicaoDAO.numeroDeRefeicaoDaDieta(dietaSelecionada);
                    
                    refeicaoNova = gui.cadastrarRefeicao(dietaSelecionada);

                    for (int i = 0; !refeicaoDAO.bateuMetaDieta(refeicaoNova); i++) {
                        if(contRefeicao < dietaSelecionada.getNumeroRefeicoes()){
                            //VERIFICA SE JÁ TEM REFEIÇÕES CADASTRADAS NESSA DIETA E CADASTRA SÓ O QUE FALTA
                            if(i == 0){
                                i = i + contRefeicao;
                            }
                            
                            refeicaoNova = gui.cadastrarRefeicao(dietaSelecionada);
                            
                            for(int j = 0; !alimentoRefeicoesDAO.bateuMetaRefeicao(refeicaoNova); j++){
                               alimentoSelecionado = gui.escolherAlimentosRefeicoes(alimentoDAO, login.getPessoaLogada());
                               alimentoRefeicoesNovo = gui.cadastrarAlimentosRefeicoes(alimentoSelecionado, refeicaoNova);
                               alimentoRefeicoesDAO.adicionar(alimentoRefeicoesNovo);
                            }
                        }else{
                            System.out.println("\n O numero maximo de refeicoes da dieta foi atingido!");
                        }
                    }
                }
                //GERAR REFEIÇÕES AUTOMÁTICAS
                case 3 -> {
                    dietaSelecionada = gui.escolheDieta(dietaDAO);
                    refeicaoNova = gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada());
                    
                    
                    for (int i = 0; !refeicaoDAO.bateuMetaDieta(refeicaoNova); i++) {
                        if(contRefeicao < dietaSelecionada.getNumeroRefeicoes()){
                            //VERIFICA SE JÁ TEM REFEIÇÕES CADASTRADAS NESSA DIETA E CADASTRA SÓ O QUE FALTA
                            if(i == 0){
                                i = i + contRefeicao;
                            }
                            
                            refeicaoNova = gui.cadastrarRefeicao(dietaSelecionada);

                            for(int j = 0; !alimentoRefeicoesDAO.bateuMetaRefeicao(refeicaoNova); j++){
                                alimentoRefeicoesNovo = cadastrarAutomaticoAlimentoRefeicoes(refeicaoNova, j);
                                alimentoRefeicoesDAO.adicionar(alimentoRefeicoesNovo);
                            }
                        }
                    }
                }
                //BUSCAR
                case 4 -> {
                    System.out.println(gui.buscarRefeicao(refeicaoDAO));
                }
                
                //ALTERAR
                case 5 -> {
                    refeicaoDAO.alterar(gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada()), gui.cadastrarRefeicao(gui.escolheDieta(dietaDAO)));
                }
                
                //REMOVER
                case 6 -> {
                    refeicaoSelecionada = gui.escolherRefeicao(refeicaoDAO, login.getPessoaLogada());
                    refeicaoDAO.remover(refeicaoSelecionada);
                    alimentoRefeicoesDAO.removerRefeicao(refeicaoSelecionada);
                }
                
                case 7 -> {
                    menu = -1;
                }
                
                default -> {
                    System.out.println("\n Opcao Invalida!");
                }
            }
        }while(menu != -1);
    }
    
    public AlimentoRefeicoes cadastrarAutomaticoAlimentoRefeicoes(Refeicao refeicao, int j){
        preferenciaNova = preferenciasDAO.buscar(j);
        
        //GUARDANDO A PORCENTAGEM QUE O ALIMENTO REPRESENTA EM RELAÇÃO AO TOTAL DA REFEIÇÃO
        carboidratos = (preferenciaNova.getAlimento().getCarboidratos() * 100 * porcao) / refeicao.getCarboidrato();
        proteinas = (preferenciaNova.getAlimento().getProteinas() * 100 * porcao) / refeicao.getProteina();
        gorduras = (preferenciaNova.getAlimento().getGorduras() * 100 * porcao) / refeicao.getGordura();
        calorias = (preferenciaNova.getAlimento().getCalorias() * 100 * porcao) / refeicao.getCalorias();
        
        return new AlimentoRefeicoes(refeicao, preferenciaNova.getAlimento(), preferenciaNova.getAlimento().getPorcao(), carboidratos, proteinas, gorduras, calorias);
    }
    
    public void menuAvaliacao(){
        do{
            switch(gui.menuAvaliacao()){
                case 1 ->{
                   avaliacaoNova = gui.fazerAvaliacao(login.getPessoaLogada());
                   avaliacaoNova.setImc(avaliacaoNova.calcularImc());
                   avaliacaoNova.setTmb(avaliacaoNova.calcularTmb());
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
                    avaliacaoNova.setTmb(avaliacaoNova.calcularTmb());
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
                               System.out.print(preferenciasDAO.buscarPorId(gui.buscarPreferencia())); 
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
                    mensagemDAO.adicionar(gui.mandarMensagem(login.getPessoaLogada(), seguirDAO, pessoaDAO));
                }
                case 3 ->{
                    System.out.print(mensagemDAO.buscar(gui.buscarMensagem()));
                }
                case 4 ->{
                    mensagemDAO.alterar(gui.alterarMensagem(), gui.mandarMensagem(login.getPessoaLogada(), seguirDAO, pessoaDAO));
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
                    seguirDAO.alterar(gui.alterarSeguidor(), gui.seguir(login.getPessoaLogada(), pessoaDAO));
                }
                case 5 ->{
                    seguirDAO.remover(gui.removerSeguidor());
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
               //ALTERAR NOME
               case 1 -> {
                   if(pessoaDAO.alterarNome(login.getPessoaLogada(), gui.alterarNome())){
                       System.out.println("\n Nome alterado com sucesso!");
                   }else{
                       System.out.println("\n Erro - Nome não alterado!");
                   }
               }
               //ALTERAR EMAIL
               case 2 -> {
                   if(pessoaDAO.alterarEmail(login.getPessoaLogada(), gui.alterarEmail())){
                       System.out.println("\n Email alterado com sucesso!");
                   }else{
                       System.out.println("\n Erro - Email não alterado!");
                   }
               }
               //ALTERAR SENHA
               case 3 -> {
                   if(pessoaDAO.alterarSenha(login.getPessoaLogada(), gui.alterarSenha())){
                       System.out.println("\n Senha alterada com sucesso!");
                   }else{
                       System.out.println("\n Erro - Senha não alterada!");
                   }
               }
               //DESLOGAR
               case 4 -> {
                   menuInicial();
               }
               //EXCLUIR CONTA
               case 5 -> {
                   pessoaDAO.remover(login.getPessoaLogada());
                   menuInicial();
               }
           }
       }while(menu != -1);
   }
}
