/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.util.Objects;
/**
 *
 * @author User
 */

/*CRUD DE PREFERÊNCIAS. INFORMAÇÕES IMPORTANTES: ID, PESSOA,
ALIMENTO, DATACRIACAO, DATAMODIFICACAO.*/
public class Preferencias {
    private static long serial;
    private long id;
    private Pessoa pessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao; 
    private Alimento alimento;
    
    //GETTERS AND SETTERS
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
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

    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSerial() {
        return "Atualmente ha " + serial + "preferencias no sistema";
    }
    
    public Preferencias(){
        
    }
    
    //CONSTRUTOR
    public Preferencias(Pessoa pessoa, Alimento alimento) {
        
        this.id = ++serial;
        this.pessoa = pessoa;
        this.alimento = alimento;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.pessoa);
        hash = 23 * hash + Objects.hashCode(this.dataCriacao);
        hash = 23 * hash + Objects.hashCode(this.dataModificacao);
        hash = 23 * hash + Objects.hashCode(this.alimento);
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
        final Preferencias other = (Preferencias) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        if (!Objects.equals(this.dataModificacao, other.dataModificacao)) {
            return false;
        }
        return Objects.equals(this.alimento, other.alimento);
    }

    @Override
    public String toString() {
        return "Preferencias{" + "id=" + id + ", pessoa=" + pessoa + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + ", alimento=" + alimento + '}';
    }
    
    
}
