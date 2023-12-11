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
import java.util.List;
import java.awt.Desktop;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author diogo
 */
public class AlimentoDAO {
    List<Alimento> alimentos;
    private final Login login = new Login();
    private String sql;
    private Alimento a;
    private final PessoaDAO pessoaDAO;
    public static final String CAMINHOPASTA = System.getProperty("user.home") +  File.separator + "Downloads" + File.separator + "Relatorio.pdf";

    public AlimentoDAO(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
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
    
    //ADICIONAR
    public void adicionar(Alimento alimento){
                sql = "insert into alimento"
                + " (nome, carboidrato, proteina, gordura, caloria, porcao, idPessoa, dataCriacao, dataModificacao)"
                + " values (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setString(1, alimento.getNome());
            ps.setDouble(2, alimento.getCarboidrato());
            ps.setDouble(3, alimento.getProteina());
            ps.setDouble(4, alimento.getGordura());
            ps.setDouble(5, alimento.getCaloria());
            ps.setInt(6, alimento.getPorcao());
            ps.setLong(7, login.getPessoaLogada().getId());
            ps.setDate(8, java.sql.Date.valueOf(alimento.getDataCriacao()));
            ps.setDate(9, java.sql.Date.valueOf(alimento.getDataModificacao()));
            
            ps.execute();
            
            System.out.println("\n Alimento inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel adicionar esse alimento no banco!", e);
        }
    }
    
    //REMOVER
    public void remover(Alimento alimento){
        sql = "delete from alimento where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, alimento.getId());
            
            ps.execute();
            
            System.out.println("\n Alimento removido com sucesso!");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover o alimento!", e);
        }
    }
    
    //ALTERAR
    public void alterar(Alimento alimento, Alimento novoAlimento){
        sql = "update alimento set nome = ?, carboidrato = ?, proteina = ?, gordura = ?, caloria = ?, porcao = ?, idPessoa = ?, dataModificacao = ? where id = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setString(1, alimento.getNome());
            ps.setDouble(2, alimento.getCarboidrato());
            ps.setDouble(3, alimento.getProteina());
            ps.setDouble(4, alimento.getGordura());
            ps.setDouble(5, alimento.getCaloria());
            ps.setInt(6, alimento.getPorcao());
            ps.setLong(7, login.getPessoaLogada().getId());
            ps.setDate(8, java.sql.Date.valueOf(alimento.getDataModificacao()));
            ps.setLong(9, alimento.getId());
            
            ps.execute();
            
            System.out.println("\n Alimento alterado com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel alterar o alimento!", e);
        }
    }
    
    //BUSCAR
    public Alimento buscar(long id){
        sql = "select * from alimento where ID = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                a = new Alimento();
                
                if(rs.next()){
                    a.setId(rs.getLong("id"));
                    a.setNome(rs.getString("nome"));
                    a.setCarboidrato(rs.getDouble("carboidrato"));
                    a.setProteina(rs.getDouble("proteina"));
                    a.setGordura(rs.getDouble("gordura"));
                    a.setCaloria(rs.getDouble("caloria"));
                    a.setPorcao(rs.getInt("porcao"));
                    a.setPessoa(pessoaDAO.buscar(rs.getInt("idPessoa")));
                    a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    a.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return a;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o usuario!", e);
        }
    }
    
    //BUSCAR NOME
    public Alimento buscarNome(String nome){
                sql = "select * from alimento where nome = ?";
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);){
            
            ps.setString(1, nome);
            try(ResultSet rs = ps.executeQuery()){
                a = new Alimento();
                
                if(rs.next()){
                    a.setId(rs.getLong("id"));
                    a.setNome(rs.getString("nome"));
                    a.setCarboidrato(rs.getDouble("carboidrato"));
                    a.setProteina(rs.getDouble("proteina"));
                    a.setGordura(rs.getDouble("gordura"));
                    a.setCaloria(rs.getDouble("caloria"));
                    a.setPorcao(rs.getInt("porcao"));
                    a.setPessoa(pessoaDAO.buscar(rs.getInt("idPessoa")));
                    a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    a.setDataModificacao((rs.getDate("dataModificacao").toLocalDate()));
                }else{
                    throw new SQLException();
                }

                return a;
            }  
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel buscar o usuario!", e);
        }
    }
    
    public List<Alimento> listar(){
        sql = "select * from alimento";

        alimentos = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                a = new Alimento();
                a.setId(rs.getLong("id"));
                a.setNome(rs.getString("nome"));
                a.setCarboidrato(rs.getDouble("carboidrato"));
                a.setProteina(rs.getDouble("proteina"));
                a.setGordura(rs.getDouble("gordura"));
                a.setCaloria(rs.getDouble("caloria"));
                a.setPorcao(rs.getInt("porcao"));
                a.setPessoa(pessoaDAO.buscar(rs.getInt("idPessoa")));
                a.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                a.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                alimentos.add(a);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return alimentos;
    }
    
    public void gerarRelatorio(){
        Document document = new Document();
        
        try{
            PdfWriter.getInstance(document, new FileOutputStream(CAMINHOPASTA));
            document.open();
            document.add(new Paragraph(toString()));
            document.close();
            
            System.out.println("\n Relatorio gerado com sucesso! \n");
            
            abrirPDF();
        }catch(FileNotFoundException | DocumentException e){
            System.out.println("\n Erro ao gerar Relatório!" + e + "\n");
        } 
    }
    
    
    private void abrirPDF() {
        try {
            // Obtém o sistema Desktop
            Desktop desktop = Desktop.getDesktop();
            // Obtém o arquivo PDF
            File arquivoPDF = new File(CAMINHOPASTA);
            // Abre o arquivo com o aplicativo padrão associado a arquivos PDF
            desktop.open(arquivoPDF);
        } catch (IOException e) {
            System.out.println("\nErro ao abrir o PDF!" + e + "\n");
        }
    }

    @Override
    public String toString() {
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n========== ALIMENTOS ==========");
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
