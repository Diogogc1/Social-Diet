/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Objects;

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
    Avaliacao avaliacaoFisica;
    TipoDieta tipoDieta;
    private double caloria;
    private int numeroRefeicoes;
    private final LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public RegistroDieta(Pessoa pessoa, Avaliacao avaliacaoFisica, TipoDieta tipoDieta, double caloria, int numeroRefeicoes, LocalDate dataCriacao, LocalDate dataModificacao) {
        id = ++serial;
        this.pessoa = pessoa;
        this.avaliacaoFisica = avaliacaoFisica;
        this.tipoDieta = tipoDieta;
        this.caloria = caloria;
        this.numeroRefeicoes = numeroRefeicoes;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
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

    public Avaliacao getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(Avaliacao avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
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
     @Override
    public String toString() {
        return "RegistroDieta{" + "id=" + id + ", pessoa=" + pessoa + ", avaliacaoFisica=" + avaliacaoFisica + ", tipoDieta=" + tipoDieta + ", caloria=" + caloria + ", numeroRefeicoes=" + numeroRefeicoes + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    //EQUALS E HASH CODE - PRECISO DA DIETA (MATHEUS)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.pessoa);
        hash = 67 * hash + Objects.hashCode(this.avaliacaoFisica);
        hash = 67 * hash + Objects.hashCode(this.tipoDieta);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.caloria) ^ (Double.doubleToLongBits(this.caloria) >>> 32));
        hash = 67 * hash + this.numeroRefeicoes;
        hash = 67 * hash + Objects.hashCode(this.dataCriacao);
        hash = 67 * hash + Objects.hashCode(this.dataModificacao);
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
        final RegistroDieta other = (RegistroDieta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloria) != Double.doubleToLongBits(other.caloria)) {
            return false;
        }
        if (this.numeroRefeicoes != other.numeroRefeicoes) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.avaliacaoFisica, other.avaliacaoFisica)) {
            return false;
        }
        if (!Objects.equals(this.tipoDieta, other.tipoDieta)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    } 
}
