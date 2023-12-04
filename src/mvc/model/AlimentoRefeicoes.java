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
    private final long id;
    private static long serial;
    private Refeicao refeicao;
    private Alimento alimento;
    private double porcao;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //CONSTRUTOR
    public AlimentoRefeicoes(Refeicao refeicao, Alimento alimento, double porcao, double carboidrato, double proteina, double gordura, double calorias) {
        this.id = serial++;
        this.refeicao = refeicao;
        this.alimento = alimento;
        this.porcao = porcao;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }   
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }

    public static long getSerial() {
        return serial;
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

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
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

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
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
        sb.append("====== ALIMENTO DA REFEICAO ======");
        sb.append("\n ID: ").append(id).
        append("\n Alimento: ").append(alimento.getNome()).
        append("\n Refeicao: ").append(refeicao.getNomeDaRefeicao()).
        append("\n Porcao: ").append(porcao).
        append("\n Carboidratos: ").append(carboidrato).
        append("\n Proteinas: ").append(proteina).
        append("\n Gorduras: ").append(gordura).
        append("\n Calorias: ").append(calorias).
        append("\n Data de Criacao: ").append(dataCriacao).
        append("\n Data de Modificacao: ").append(dataModificacao).
        append("\n ======================================== \n");

        return sb.toString();
    }
}