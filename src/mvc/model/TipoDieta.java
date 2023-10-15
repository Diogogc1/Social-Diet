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

/*CRUD TIPO DE DIETA.  INFORMAÇÕES IMPORTANTES: ID, NOME, CARBOIDRATO,
PROTEÍNA, GORDURA, DATACRIACAO, DATAMODIFICACAO.*/
public class TipoDieta {
    
    private static long serial; 
    private final long id;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "tipos de dieta no sistema";
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
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
    public TipoDieta(String nome, double carboidrato, double proteina, double gordura) {
        this.id = ++serial;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }     
}