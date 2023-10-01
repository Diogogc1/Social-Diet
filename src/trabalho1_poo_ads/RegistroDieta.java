/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;

import java.time.LocalDate;

/**
 *
 * @author diogo
 */
public class RegistroDieta {
    /*id, pessoa, avaliacao fisica,  tipo dieta, objetivo, 
    calorias, nro refeicoes, dataCriacao, dataModificacao.*/
    
    private final int id;
    private static int serial;
    private Pessoa pessoa;
    
    //PRECISO DA PARTE MATHEUS
    //avaliacao fisica
    //tipo dieta
    
    private double caloria;
    private int numeroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    

    public RegistroDieta(Pessoa pessoa, double caloria, int numeroDeRefeicoes, LocalDate dataDeCriacao, LocalDate dataDeModificacao) {
        id = ++serial;
        this.pessoa = pessoa;
        this.caloria = caloria;
        this.numeroRefeicoes = numeroDeRefeicoes;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "pessoa no sistema";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public int getNumeroRefeicoes() {
        return numeroRefeicoes;
    }

    public void setNumeroRefeicoes(int numeroRefeicoes) {
        this.numeroRefeicoes = numeroRefeicoes;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }   
    
    //TO STRING - PRECISO DA DIETA (MATHEUS)
    
    //EQUALS E HASH CODE - PRECISO DA DIETA (MATHEUS)
}
