/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;
import java.time.LocalDate;
/**
 *
 * @author User
 */
/*CRUD ALIMENTO REFEIÇÕES. INFORMAÇÕES IMPORTANTES: ID,
REFEIÇÃO,ALIMENTO, PORCAO, PROTEÍNA, GORDURA, CALORIAS,
DATACRIACAO, DATAMODIFICACAO.*/
public class AlimentoRefeicoes {
    private int id;
    private static int serial;
    private Refeicao refeicao;
    private Alimento alimento;
    private double porcao;
    private double proteina;
    private double gordura;
    private double calorias;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //GETTERS E SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getSerial() {
        return serial;
    }

    public static void setSerial(int serial) {
        AlimentoRefeicoes.serial = serial;
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
    
    //CONSTRUTOR

    public AlimentoRefeicoes(int id, Refeicao refeicao, Alimento alimento, double porcao, double proteina, double gordura, double calorias, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = serial++;
        this.refeicao = refeicao;
        this.alimento = alimento;
        this.porcao = porcao;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    
}
