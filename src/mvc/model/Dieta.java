/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author diogo
 */
public class Dieta {
    /*id, pessoa, avaliacao fisica,  tipo dieta, objetivo, 
    caloria, nro refeicoes, dataCriacao, dataModificacao.*/
    
    private long id;
    private Pessoa pessoa;
    private Avaliacao avaliacao;
    private TipoDieta tipoDieta;
    private String objetivo;
    private double caloria;
    private int numeroRefeicoes;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Dieta(){
        
    }

    public Dieta(Pessoa pessoa, Avaliacao avaliacao, TipoDieta tipoDieta, String objetivo, double calorias, int numeroRefeicoes) {
        this.pessoa = pessoa;
        this.avaliacao = avaliacao;
        this.tipoDieta = tipoDieta;
        this.objetivo = objetivo;
        this.caloria = calorias;
        
        switch(this.objetivo){
            case "1" -> {
                this.objetivo = "Diminuir o peso";
                this.caloria = avaliacao.getTmb() - 350;
            }
            
            case "2" -> {
               this.objetivo = "Manter o peso";
               this.caloria = avaliacao.getTmb();
            }
            
            case "3" -> {
                this.objetivo = "Aumentar o peso";
                this.caloria = avaliacao.getTmb() + 350;
            }

        }
        
        this.numeroRefeicoes = numeroRefeicoes;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
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
    
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }   
    
    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return "Dieta{" + "id=" + id + ", pessoa=" + pessoa + ", avaliacao=" + avaliacao + ", tipoDieta=" + tipoDieta + ", objetivo=" + objetivo + ", calorias=" + caloria + ", numeroRefeicoes=" + numeroRefeicoes + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    //EQUALS E HASH CODE
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.pessoa);
        hash = 37 * hash + Objects.hashCode(this.avaliacao);
        hash = 37 * hash + Objects.hashCode(this.tipoDieta);
        hash = 37 * hash + Objects.hashCode(this.objetivo);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.caloria) ^ (Double.doubleToLongBits(this.caloria) >>> 32));
        hash = 37 * hash + this.numeroRefeicoes;
        hash = 37 * hash + Objects.hashCode(this.dataCriacao);
        hash = 37 * hash + Objects.hashCode(this.dataModificacao);
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
        final Dieta other = (Dieta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloria) != Double.doubleToLongBits(other.caloria)) {
            return false;
        }
        if (this.numeroRefeicoes != other.numeroRefeicoes) {
            return false;
        }
        if (!Objects.equals(this.objetivo, other.objetivo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.avaliacao, other.avaliacao)) {
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