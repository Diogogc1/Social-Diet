/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalho1_poo_ads;
import java.time.LocalDate;
/**
 *
 * @author User
 */

/*CRUD DE PREFERÊNCIAS. INFORMAÇÕES IMPORTANTES: ID, PESSOA,
ALIMENTO, DATACRIACAO, DATAMODIFICACAO.*/
public class Preferencias {
    private static int serial = 1;
    
    private int id;
    private Pessoa pessoa;
    private Alimento alimento;
    private LocalDate dataCriação;
    private LocalDate dataModificação;
    
    private Alimento proteinas[] = new Alimento[3];
    private Alimento carboidratos[] = new Alimento[3];
    private Alimento gorduras[] = new Alimento[3];
    
    //GETTERS AND SETTERS
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
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
        return dataCriação;
    }

    public void setDataCriação(LocalDate dataCriação) {
        this.dataCriação = dataCriação;
    }

    public LocalDate getDataModificação() {
        return dataModificação;
    }

    public void setDataModificação(LocalDate dataModificação) {
        this.dataModificação = dataModificação;
    }
    
    //CONSTRUTOR
    public Preferencias(int id, Pessoa pessoa, Alimento alimento, LocalDate dataCriação, LocalDate dataModificação) {
        this.id = ++serial;
        this.pessoa = pessoa;
        this.alimento = alimento;
        this.dataCriação = dataCriação;
        this.dataModificação = dataModificação;
    }    
}
