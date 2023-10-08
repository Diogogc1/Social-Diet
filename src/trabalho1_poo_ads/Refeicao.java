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
    
    private final long id;
    private static long serial;
    private TipoDieta tipoDieta;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private String nomeRefeicao;
    private final LocalDate dataCriacao;
    private LocalDate dataModificacao;

    //CRUD
    //CRIAR
    public Refeicao(TipoDieta tipoDieta, double carboidrato, double proteina, double gordura, double calorias, String nomeDaRefeicao, LocalDate dataDeCriacao, LocalDate dataDeModificacao) {
        id = ++serial;
        this.tipoDieta = tipoDieta;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.calorias = calorias;
        this.nomeRefeicao = nomeDaRefeicao;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }

    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "pessoa no sistema";
    }
    
    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
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
    @Override
    public String toString() {
        return "Refeicao{" + "id=" + id + ", tipoDieta=" + tipoDieta + ", carboidrato=" + carboidrato + ", proteina=" + proteina + ", gordura=" + gordura + ", calorias=" + calorias + ", nomeRefeicao=" + nomeRefeicao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    //EQUALS E HASH CODE - PRECISO DA DIETA (MATHEUS)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.tipoDieta);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.carboidrato) ^ (Double.doubleToLongBits(this.carboidrato) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.proteina) ^ (Double.doubleToLongBits(this.proteina) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.gordura) ^ (Double.doubleToLongBits(this.gordura) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nomeRefeicao);
        hash = 97 * hash + Objects.hashCode(this.dataCriacao);
        hash = 97 * hash + Objects.hashCode(this.dataModificacao);
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
        final Refeicao other = (Refeicao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidrato) != Double.doubleToLongBits(other.carboidrato)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteina) != Double.doubleToLongBits(other.proteina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordura) != Double.doubleToLongBits(other.gordura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (!Objects.equals(this.nomeRefeicao, other.nomeRefeicao)) {
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
