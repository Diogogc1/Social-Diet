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
public class Refeicao {
    private final long id;
    private static long serial;
    private Dieta Dieta;
    private String nomeRefeicao;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double calorias;
    private final LocalDate dataCriacao;
    private final LocalDate dataModificacao;

    //CRUD
    //CRIAR
    public Refeicao(Dieta Dieta, double carboidrato, double proteina, double gordura, double calorias, String nomeDaRefeicao) {
        id = ++serial;
        this.Dieta = Dieta;
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
        return "Atualmente há " + serial + "refeições no sistema";
    }
    
    public Dieta getDieta() {
        return Dieta;
    }

    public void setDieta(Dieta dieta) {
        this.Dieta = dieta;
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

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    //TO STRING - PRECISO DA DIETA (MATHEUS)
    @Override
    public String toString() {
        return "Refeicao{" + "id=" + id + ", Dieta=" + Dieta + ", carboidrato=" + carboidrato + ", proteina=" + proteina + ", gordura=" + gordura + ", calorias=" + calorias + ", nomeRefeicao=" + nomeRefeicao + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }
    
    //EQUALS E HASH CODE - PRECISO DA DIETA (MATHEUS)
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.Dieta);
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
        if (!Objects.equals(this.Dieta, other.Dieta)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }
    
}
