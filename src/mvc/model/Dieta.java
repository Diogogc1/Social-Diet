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
    calorias, nro refeicoes, dataCriacao, dataModificacao.*/
    
    private final long id;
    private static long serial;
    private final Pessoa pessoa;
    private Avaliacao avaliacao;
    private TipoDieta tipoDieta;
    private String objetivo;
    private double calorias;
    private int numeroRefeicoes;
    private final LocalDate dataCriacao;
    private final LocalDate dataModificacao;

    public Dieta(Pessoa pessoa, Avaliacao avaliacao, TipoDieta tipoDieta, String objetivo, double calorias, int numeroRefeicoes) {
        id = ++serial;
        this.pessoa = pessoa;
        this.avaliacao = avaliacao;
        this.tipoDieta = tipoDieta;
        this.objetivo = objetivo;
        if(objetivo.equals("Diminuir o peso")){
            this.calorias = avaliacao.getTmb() - 500;
        }else{
            if(objetivo.equals("Manter o peso")){
                this.calorias = avaliacao.getTmb();
            }else{
                if(objetivo.equals("Melhorar composicao corporal")){
                    this.calorias = avaliacao.getTmb() + 200;
                }else{
                    if(objetivo.equals("Aumentar o peso")){
                        this.calorias = avaliacao.getTmb() + 500;
                    }
                }
            }
        }
        this.numeroRefeicoes = numeroRefeicoes;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    
    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "dietas no sistema";
    }

    public Pessoa getPessoa() {
        return pessoa;
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
    
    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
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
    
    //TO STRING

    @Override
    public String toString() {
        return "Dieta{" + "id=" + id + ", pessoa=" + pessoa + ", avaliacao=" + avaliacao + ", tipoDieta=" + tipoDieta + ", objetivo=" + objetivo + ", calorias=" + calorias + ", numeroRefeicoes=" + numeroRefeicoes + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
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
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
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
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
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