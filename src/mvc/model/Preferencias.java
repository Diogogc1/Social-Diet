/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
/**
 *
 * @author User
 */

/*CRUD DE PREFERÊNCIAS. INFORMAÇÕES IMPORTANTES: ID, PESSOA,
ALIMENTO, DATACRIACAO, DATAMODIFICACAO.*/
public class Preferencias {
    private static long serial;
    private final long id;
    private Pessoa pessoa;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao; 
    private Alimento alimento;
    
    //GETTERS AND SETTERS
    
    public Pessoa getPessoa() {
        return pessoa;
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
    
    public String getSerial() {
        return "Atualmente ha " + serial + "preferencias no sistema";
    }
    
    
    //CONSTRUTOR
    public Preferencias(Pessoa pessoa, Alimento alimento) {
        
        this.id = ++serial;
        this.pessoa = pessoa;
        this.alimento = alimento;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }  
}
