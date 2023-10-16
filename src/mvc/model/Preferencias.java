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
    
    private Alimento proteinas[] = new Alimento[3];
    private Alimento carboidratos[] = new Alimento[3];
    private Alimento gorduras[] = new Alimento[3];
    
    //GETTERS AND SETTERS
    
    public Pessoa getPessoa() {
        return pessoa;
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
    public Preferencias(Pessoa pessoa, Alimento[] proteinas, Alimento[] carboidratos, Alimento[] gorduras) {
        
        this.id = ++serial;
        this.pessoa = pessoa;
        this.proteinas = proteinas;
        this.carboidratos = carboidratos;
        this.gorduras = gorduras;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }  
    
    public String toStringProteinas(){
        StringBuilder sb = new StringBuilder();
        for (Alimento proteina : proteinas) {
            if(proteina != null){
                sb.append("\n ID: ").append(proteina.getId()).
                append("\n Nome: ").append(proteina.getNome()).
                append("\n Carboidratos: ").append(proteina.getCarboidratos()).
                append("\n Proteinas: ").append(proteina.getProteinas()).
                append("\n Gorduras: ").append(proteina.getGorduras()).
                append("\n Calorias: ").append(proteina.getCalorias()).
                append("\n Data de Criacao: ").append(proteina.getDataCriacao()).
                append("\n Data de Modificacao: ").append(proteina.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
    
    public String toStringCarboidratos(){
        StringBuilder sb = new StringBuilder();
        for (Alimento carboidrato : carboidratos) {
            if(carboidrato  != null){
                sb.append("\n ID: ").append(carboidrato.getId()).
                append("\n Nome: ").append(carboidrato.getNome()).
                append("\n Carboidratos: ").append(carboidrato.getCarboidratos()).
                append("\n Proteinas: ").append(carboidrato.getProteinas()).
                append("\n Gorduras: ").append(carboidrato.getGorduras()).
                append("\n Calorias: ").append(carboidrato.getCalorias()).
                append("\n Data de Criacao: ").append(carboidrato.getDataCriacao()).
                append("\n Data de Modificacao: ").append(carboidrato.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
    
    public String toStringGorduras(){
        StringBuilder sb = new StringBuilder();
        for (Alimento gordura : gorduras) {
            if(gordura  != null){
                sb.append("\n ID: ").append(gordura.getId()).
                append("\n Nome: ").append(gordura.getNome()).
                append("\n Carboidratos: ").append(gordura.getCarboidratos()).
                append("\n Proteinas: ").append(gordura.getProteinas()).
                append("\n Gorduras: ").append(gordura.getGorduras()).
                append("\n Calorias: ").append(gordura.getCalorias()).
                append("\n Data de Criacao: ").append(gordura.getDataCriacao()).
                append("\n Data de Modificacao: ").append(gordura.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
