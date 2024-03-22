/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
/**
 *
 * @author User
 */
/*CRUD ALIMENTO REFEIÇÕES. INFORMAÇÕES IMPORTANTES: ID,
REFEIÇÃO,ALIMENTO, PORCAO, PROTEÍNA, GORDURA, CALORIAS,
DATACRIACAO, DATAMODIFICACAO.*/
public class AlimentoRefeicoes {
    private long id;
    private Refeicao refeicao;
    private Alimento alimento;
    private int porcao;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double caloria;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public AlimentoRefeicoes(){
        
    }
    
    //CONSTRUTOR
    public AlimentoRefeicoes(Refeicao refeicao, Alimento alimento, int porcao, double carboidrato, double proteina, double gordura, double calorias) {
        this.refeicao = refeicao;
        this.alimento = alimento;
        this.porcao = porcao;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.caloria = calorias;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }   
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlimentoRefeicoes other = (AlimentoRefeicoes) obj;
        return this.id == other.id;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("======= ALIMENTO DA REFEICAO =======");
        sb.append("\n ID: ").append(id).
        append("\n Alimento: ").append(alimento.getNome()).
        append("\n Refeicao: ").append(refeicao.getNomeDaRefeicao()).
        append("\n Porcao: ").append(porcao).
        append("\n Carboidratos: ").append(carboidrato).
        append("\n Proteinas: ").append(proteina).
        append("\n Gorduras: ").append(gordura).
        append("\n Calorias: ").append(caloria).
        append("\n Data de Criacao: ").append(dataCriacao).
        append("\n Data de Modificacao: ").append(dataModificacao).
        append("\n ==================================== \n");

        return sb.toString();
    }
}