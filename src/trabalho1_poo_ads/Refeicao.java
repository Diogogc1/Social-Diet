/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author diogo
 */
public class Refeicao {
    
    private final int id;
    private static int serial;
    
    //DIETA - ESPERANDO MATHEUS
    
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String nomeRefeicao;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //CRUD
    //CRIAR
    public Refeicao(double carboidrato, double proteina, double gordura, double calorias, String nomeDaRefeicao, LocalDate dataDeCriacao, LocalDate dataDeModificacao) {
        id = ++serial;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.nomeRefeicao = nomeDaRefeicao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "pessoa no sistema";
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

    public String getNomeDaRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeDaRefeicao(String nomeDaRefeicao) {
        this.nomeRefeicao = nomeDaRefeicao;
    }

    public LocalDate getDataDeCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataDeModificacao() {
        return dataModificacao;
    }

    //TO STRING - PRECISO DA DIETA (MATHEUS)
    
    //EQUALS E HASH CODE - PRECISO DA DIETA (MATHEUS)
}
