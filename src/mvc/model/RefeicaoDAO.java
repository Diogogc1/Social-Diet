/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class RefeicaoDAO {
    Refeicao refeicoes[] = new Refeicao[10];
    private final Login login = new Login();
    int cont;
    
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    
    public RefeicaoDAO(DietaDAO dietaDAO, Pessoa pessoaLogada) {
        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Café da Manhã"));
        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Almoco"));
        adicionar(new Refeicao(dietaDAO.buscarPessoa(pessoaLogada), 100, 100, 100, 100, "Janta"));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] == null){
                refeicoes[i] = refeicao;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public boolean remover(Refeicao refeicao){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Refeicao refeicao, Refeicao refeicaoNova){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i].equals(refeicao)){
                refeicoes[i] = refeicaoNova;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Refeicao buscar(long id){
        for (Refeicao refeicao : refeicoes) {
            if (refeicao.getId() == id) {
                return refeicao;
            } 
        }
        return null;
    }
    
    //BUSCAR NOME
    public Refeicao buscarNome(String nome){
        for (Refeicao refeicao : refeicoes) {
            if (refeicao != null && refeicao.getNomeDaRefeicao().equals(nome)) {
                return refeicao;
            } 
        }
        return null;
    }
    
    public int numeroDeRefeicaoDaDieta(Dieta dieta){
        cont = 0;
        for (Refeicao r : refeicoes) {
            if (r != null && r.getDieta().equals(dieta)) {
                cont++;
                if(cont >= dieta.getNumeroRefeicoes()){
                    return cont;
                }
            } 
        }
        return cont;
    }
     
    public boolean isVazio(){
        for(Refeicao refeicao : refeicoes){
            if(refeicao != null){
                return false;
            }
        }
        return true;
    }
    
    public boolean bateuMetaDieta(Dieta dietaSelecionada){
        carboidrato = 0;
        proteina = 0;
        gordura = 0;
        calorias = 0;
        for (Refeicao refeicao : refeicoes) {
            if(refeicao != null && dietaSelecionada.equals(refeicao.getDieta())){
                carboidrato += refeicao.getCarboidrato() / (dietaSelecionada.getTipoDieta().getCarboidrato() * dietaSelecionada.getCalorias());
                proteina    += refeicao.getProteina()    / (dietaSelecionada.getTipoDieta().getProteina() * dietaSelecionada.getCalorias());
                gordura     += refeicao.getGordura()     / (dietaSelecionada.getTipoDieta().getGordura() * dietaSelecionada.getCalorias());
                calorias    += refeicao.getCalorias()    / (dietaSelecionada.getCalorias());
            }
            
            if(carboidrato >= 1 && proteina >= 1 && gordura >= 1 && calorias >= 1){
                return true;
            }
        }     
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== REFEICOES ==========");
        for(Refeicao refeicao : refeicoes) {
            if(refeicao != null && refeicao.getDieta().getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(refeicao.getId()).
                append("\n Nome: ").append(refeicao.getNomeDaRefeicao()).
                append("\n Carboidratos: ").append(refeicao.getCarboidrato()).
                append("\n Proteinas: ").append(refeicao.getProteina()).
                append("\n Gorduras: ").append(refeicao.getGordura()).
                append("\n Calorias: ").append(refeicao.getCalorias()).
                append("\n Data de Criacao: ").append(refeicao.getDataCriacao()).
                append("\n Data de Modificacao: ").append(refeicao.getDataModificacao()).
                append("\n ================================");
            }
        }
        return sb.toString();
    }
}
