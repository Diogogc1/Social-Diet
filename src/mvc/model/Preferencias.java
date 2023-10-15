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
    private Alimento alimento;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    private Alimento proteinas[] = new Alimento[3];
    private Alimento carboidratos[] = new Alimento[3];
    private Alimento gorduras[] = new Alimento[3];
    
    //GETTERS AND SETTERS
    
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public Alimento getAlimento() {
        return alimento;
    }
    
    public Alimento[] getProteinas() {
        return proteinas;
    }

    public void setProteinas(Alimento[] proteinas) {
        this.proteinas = proteinas;
    }

    public Alimento[] getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(Alimento[] carboidratos) {
        this.carboidratos = carboidratos;
    }

    public Alimento[] getGorduras() {
        return gorduras;
    }

    public void setGorduras(Alimento[] gorduras) {
        this.gorduras = gorduras;
    }
    
    
    public LocalDate getDataCriação() {
        return dataCriacao;
    }

    public void setDataCriação(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificação() {
        return dataModificacao;
    }

    public void setDataModificação(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente ha " + serial + "preferencias no sistema";
    }
    
    //CONSTRUTOR
    public Preferencias(Pessoa pessoa, Alimento alimento, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = ++serial;
        this.pessoa = pessoa;
        this.alimento = alimento;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }    
}
