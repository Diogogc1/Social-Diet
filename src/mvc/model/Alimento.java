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
public class Alimento {
    private final long id;
    private static long serial;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private double caloria;
    private int porcao;
    private final Pessoa pessoa;
    private final LocalDate dataDeCriacao;
    private LocalDate dataDeModificacao;
    
    //CONSTRUTOR
    public Alimento(String nome, double carboidratos, double proteinas, double gorduras, int porcao, Pessoa pessoa) {
        id = ++serial;
        this.nome = nome;
        this.carboidrato = carboidratos;
        this.proteina = proteinas;
        this.gordura = gorduras;
        this.caloria = (4 * carboidratos) + (4 * proteinas) + (4 * gorduras);
        this.porcao = porcao;
        this.pessoa = pessoa;
        this.dataDeCriacao = LocalDate.now();
        this.dataDeModificacao = LocalDate.now();
    }
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "alimentos no sistema";
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

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public LocalDate getDataCriacao() {
        return dataDeCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataDeModificacao;
    }

    public void setDataDeModificacao(LocalDate dataDeModificacao) {
        this.dataDeModificacao = dataDeModificacao;
    }

    //TO STRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n =========== ALIMENTO ===========");

        sb.append("\n ID: ").append(id).
        append("\n Nome: ").append(nome).
        append("Porcao: ").append(porcao).
        append("\n Carboidratos: ").append(carboidrato).
        append("\n Proteinas: ").append(proteina).
        append("\n Gorduras: ").append(gordura).
        append("\n Calorias: ").append(caloria).
        append("\n Data de Criacao: ").append(dataDeCriacao).
        append("\n Data de Modificacao: ").append(dataDeModificacao).
        append("\n =================================");
   
        return sb.toString();
    }
    
    //EQUALS E HASH CODE

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.carboidrato) ^ (Double.doubleToLongBits(this.carboidrato) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.proteina) ^ (Double.doubleToLongBits(this.proteina) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.gordura) ^ (Double.doubleToLongBits(this.gordura) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.caloria) ^ (Double.doubleToLongBits(this.caloria) >>> 32));
        hash = 53 * hash + this.porcao;
        hash = 53 * hash + Objects.hashCode(this.pessoa);
        hash = 53 * hash + Objects.hashCode(this.dataDeCriacao);
        hash = 53 * hash + Objects.hashCode(this.dataDeModificacao);
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
        if (Double.doubleToLongBits(this.carboidrato) != Double.doubleToLongBits(other.carboidrato)) {
            return false;
        }
        if (Double.doubleToLongBits(this.proteina) != Double.doubleToLongBits(other.proteina)) {
            return false;
        }
        if (Double.doubleToLongBits(this.gordura) != Double.doubleToLongBits(other.gordura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.caloria) != Double.doubleToLongBits(other.caloria)) {
            return false;
        }
        if (this.porcao != other.porcao) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.dataDeCriacao, other.dataDeCriacao)) {
            return false;
        }
        return Objects.equals(this.dataDeModificacao, other.dataDeModificacao);
    }
    
}
