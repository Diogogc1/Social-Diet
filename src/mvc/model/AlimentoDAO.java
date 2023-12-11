/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author diogo
 */
public class AlimentoDAO {
    Alimento alimentos[] = new Alimento[20];
    private final Login login = new Login();
    public static final String caminhoPasta = System.getProperty("user.home") +  File.separator + "Downloads" + File.separator + "Relatorio.pdf";

    public AlimentoDAO(Pessoa pessoa) {
//        //GORDURA
//        adicionar(new Alimento("Ovo", 1.2, 15.6, 18.6, 1, pessoa));
//        adicionar(new Alimento("Castanha-de-caju torrada", 29.1, 18.5, 46.3, 1, pessoa));
//        adicionar(new Alimento("Manteiga", 0.1, 0.4, 82.4, 1, pessoa));
//        
//        //CARBOIDRATO
//        adicionar(new Alimento("Arroz", 28.1, 2.5, 0.2, 1, pessoa));
//        adicionar(new Alimento("Pao frances", 49.9, 9.4, 3.7, 1, pessoa));
//        adicionar(new Alimento("Feijao", 13.8, 4.8, 0.5, 1, pessoa));
//        
//        //PROTEINAS
//        adicionar(new Alimento("Carne (coxão mole)", 0, 32.4, 8.9, 1, pessoa));
//        adicionar(new Alimento("Frango Caipira (sem Pele)", 0, 29.6, 7.7, 1, pessoa));
//        adicionar(new Alimento("Picanha assada (sem gordura)", 0, 21.3, 4.7, 1, pessoa));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(Alimento alimento){
        
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA O ALIMENTO PARA SER REMOVIDO
    public boolean remover(Alimento alimento){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i].equals(alimento)){
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(Alimento alimento, Alimento novoAlimento){
        for (Alimento alimento1 : alimentos) {
            if (alimento.equals(alimento1)) {
                alimento1.setNome(novoAlimento.getNome());
                alimento1.setPorcao(novoAlimento.getPorcao());
                alimento1.setCarboidrato(novoAlimento.getCarboidrato());
                alimento1.setProteina(novoAlimento.getProteina());
                alimento1.setGordura(novoAlimento.getGordura());
                alimento1.setCaloria(novoAlimento.getCaloria());
                alimento1.setDataDeModificacao(LocalDate.now());
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Alimento buscar(long idAlimento){
        for (Alimento a : alimentos) {
            if (a != null && a.getId() == idAlimento) {
                return a;
            } 
        }
        return null;
    }
    
    //BUSCAR NOME
    public Alimento buscarNome(String nome){
        for (Alimento alimento : alimentos) {
            if (alimento != null && alimento.getNome().equals(nome)) {
                return alimento;
            } 
        }
        return null;
    }
     
    public boolean isVazio(){
        for (Alimento alimento : alimentos) {
            if(alimento != null){
                return false;
            }
        }
        return true;
    }
    
    public void gerarRelatorio(){
        Document document = new Document();
        
        try{
            PdfWriter.getInstance(document, new FileOutputStream(caminhoPasta));
            document.open();
            document.add(new Paragraph(toString()));
            document.close();
            
            System.out.println("\n Relatorio gerado com sucesso! \n");
        }catch(FileNotFoundException | DocumentException e){
            System.out.println("\n Erro ao gerar Relatório!" + e + "\n");
        }
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== ALIMENTOS ==========");
        for (Alimento alimento : alimentos) {
            if(alimento != null && alimento.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(alimento.getId()).
                append("\n Nome: ").append(alimento.getNome()).
                append("\n Porcao: ").append(alimento.getPorcao()).
                append("\n Carboidratos: ").append(alimento.getCarboidrato()).
                append("\n Proteinas: ").append(alimento.getProteina()).
                append("\n Gorduras: ").append(alimento.getGordura()).
                append("\n Calorias: ").append(alimento.getCaloria()).
                append("\n Data de Criacao: ").append(alimento.getDataCriacao()).
                append("\n Data de Modificacao: ").append(alimento.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
