/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author User
 */

/*CRUD TIPO DE DIETA.  INFORMAÇÕES IMPORTANTES: ID, NOME, CARBOIDRATO,
PROTEÍNA, GORDURA, DATACRIACAO, DATAMODIFICACAO.*/
public class TipoDieta {
    
    private static long serial = 1; 
    private long id;
    private String nome;
    private int carboidrato;
    private int proteina;
    private int gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //GETTERS E SETTERS

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public int getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public int getGordura() {
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
    public TipoDieta(String nome, int carboidrato, int proteina, int gordura, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = ++serial;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

      
}
