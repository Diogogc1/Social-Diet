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
public class Alimento {
    //id, nome, carboidratos, proteínas, gorduras, calorias, porcao, tipoUsuario, dataCriacao, dataModificacao. 
    
    private final int id;
    private static int serial;
    private String nome;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private double calorias;
    private int porcao;
    private boolean tipoUsuario;
    private final LocalDate dataDeCriacao;
    private LocalDate dataDeModificacao;
    
    //CONSTRUTOR
    public Alimento(String nome, double carboidratos, double proteinas, double gorduras, int porcao, boolean tipoUsuario, LocalDate dataDeCriacao, LocalDate dataDeModificacao) {
        id = ++serial;
        this.nome = nome;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.calorias = (4 * carboidratos) + (4 * proteinas) + (4 * gorduras);
        this.porcao = porcao;
        this.tipoUsuario = tipoUsuario;
        this.dataDeCriacao = dataDeCriacao;
        this.dataDeModificacao = dataDeModificacao;
    }
    
    //GETTERS E SETTERS
    public int getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "pessoa no sistema";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public boolean getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public LocalDate getDataDeModificacao() {
        return dataDeModificacao;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Alimento{" + "id=" + id + ", Atualmente, há " + serial + "pessoas no sistema" + 
               ", nome=" + nome + ", carboidratos=" + carboidratos + ", proteinas=" + proteinas + 
               ", gorduras=" + gorduras + ", calorias=" + calorias + ", porcao=" + porcao + 
               ", tipoUsuario=" + tipoUsuario + ", dataDeCriacao=" + dataDeCriacao + 
               ", dataDeModificacao=" + dataDeModificacao + '}';
    }
    
    //EQUALS E HASH CODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.carboidratos) ^ (Double.doubleToLongBits(this.carboidratos) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.proteinas) ^ (Double.doubleToLongBits(this.proteinas) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gorduras) ^ (Double.doubleToLongBits(this.gorduras) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.calorias) ^ (Double.doubleToLongBits(this.calorias) >>> 32));
        hash = 59 * hash + this.porcao;
        hash = 59 * hash + (this.tipoUsuario ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.dataDeCriacao);
        hash = 59 * hash + Objects.hashCode(this.dataDeModificacao);
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
        final Alimento other = (Alimento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.carboidratos) != Double.doubleToLongBits(other.carboidratos)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteinas) != Double.doubleToLongBits(other.proteinas)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gorduras) != Double.doubleToLongBits(other.gorduras)) {
            return false;
        }
        if (Double.doubleToLongBits(this.calorias) != Double.doubleToLongBits(other.calorias)) {
            return false;
        }
        if (this.porcao != other.porcao) {
            return false;
        }
        if (this.tipoUsuario != other.tipoUsuario) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataDeCriacao, other.dataDeCriacao)) {
            return false;
        }
        return Objects.equals(this.dataDeModificacao, other.dataDeModificacao);
    }
    
}
