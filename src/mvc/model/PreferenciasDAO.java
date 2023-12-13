/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PreferenciasDAO {
    List<Preferencias> preferencias;
    private final Login login = new Login();
    private int aux;
    private String sql;
    private Preferencias p;
    private final PessoaDAO pessaoDAO;
    private final AlimentoDAO alimentoDAO;

    public PreferenciasDAO(AlimentoDAO alimentoDAO, PessoaDAO pessaoDAO) {
        this.alimentoDAO = alimentoDAO;
        this.pessaoDAO = pessaoDAO;
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(1)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(2)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(3)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(4)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(5)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(6)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(7)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(8)));
//        adicionar(new Preferencias(pessoaLogada, alimentoDAO.buscar(9)));
    }
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public void adicionar(Preferencias preferencias) {
        sql = "INSERT INTO preferencias"
                + " (idPessoa, dataCriacao, dataModificacao, idAlimento)"
                + " VALUES (?,?,?,?)";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            // seta os valores
            ps.setLong(1, login.getPessoaLogada().getId()); 
            ps.setDate(2, java.sql.Date.valueOf(preferencias.getDataCriacao()));
            ps.setDate(3, java.sql.Date.valueOf(preferencias.getDataModificacao()));
            ps.setLong(4, preferencias.getAlimento().getId()); 

            ps.execute();

            System.out.println("\n Preferência inseridas com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível adicionar essa preferência no banco!", e);
        }
    }

    
    //REMOVER
    public void remover(long id){
        sql = "delete from preferencias where id = ?" ;
        
        try(Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            
            ps.setLong(1, id);
            
            ps.execute();
            
            System.out.println("\n Preferencia removida com sucesso! \n");
            
        }catch(SQLException e){
            throw new RuntimeException("Não foi possivel remover a Preferencia!", e);
        }
    }
    
    //ALTERAR
    public void alterar(long id, Preferencias preferenciaNova) {
        sql = "UPDATE preferencias SET idPessoa = ?, dataCriacao = ?, dataModificacao = ?, idAlimento = ?"
                    + " WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, login.getPessoaLogada().getId()); // Certifique-se de ter um método getId() em Pessoa
            ps.setDate(2, java.sql.Date.valueOf(preferenciaNova.getDataCriacao()));
            ps.setDate(3, java.sql.Date.valueOf(preferenciaNova.getDataModificacao()));
            ps.setLong(4, preferenciaNova.getAlimento().getId()); // Certifique-se de ter um método getId() em Alimento
            ps.setLong(5, id);

            ps.execute();

            System.out.println("\n Preferência alterada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível alterar a preferência!", e);
        }
    }
    
    //BUSCAR
    public Preferencias buscar(Long id) {
        sql = "SELECT * FROM preferencias WHERE id = ?";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                p = new Preferencias();

                if (rs.next()) {
                    p.setId(rs.getLong("id"));
                    p.setPessoa(pessaoDAO.buscar(rs.getLong("idPessoa")));
                    p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                    p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                    p.setAlimento(alimentoDAO.buscar(rs.getLong("idAlimento")));
                } else {
                    throw new SQLException();
                }

                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possível buscar a preferencia!", e);
        }
    }

    
        public Preferencias buscarNaoNulo(int indice) {
        sql = "SELECT * FROM preferencias";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                int contador = 0;

                while (rs.next()) {
                    contador++;

                    if (contador == indice) {
                        p = new Preferencias();
                        p.setId(rs.getLong("id"));
                        p.setPessoa(pessaoDAO.buscar(rs.getInt("idPessoa")));
                        p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                        p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                        p.setAlimento(alimentoDAO.buscar(rs.getLong("idAlimento")));
                        return p;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro na busca de Preferências!", e);
        }

        return null; // Retorna null se não encontrar a preferência
    }

    public boolean isVazio() {
        sql = "SELECT COUNT(*) FROM preferencias";

        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int totalRegistros = rs.getInt(1);
                return totalRegistros == 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar se a tabela de preferências está vazia!", e);
        }

        return true;
    }
   
     public List<Preferencias> listar(){
        sql = "select * from preferencias";

        preferencias = new ArrayList();

        try (Connection connection = new ConnectionFactory().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql)) {

            while(rs.next()) {
                p = new Preferencias();
                
                p.setId(rs.getLong("id"));
                p.setPessoa(pessaoDAO.buscar(rs.getInt("idPessoa")));
                p.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
                p.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
                p.setAlimento(alimentoDAO.buscar(rs.getLong("idAlimento")));
                
                preferencias.add(p);
            }
        } catch (SQLException e) {
             throw new RuntimeException("Erro na Listagem!",e);
        }

        return preferencias;
    }
    
    @Override
    public String toString(){
        listar();
        StringBuilder sb = new StringBuilder();
        sb.append("\n ====== PREFERENCIAS ======");
        for(Preferencias preferencia : preferencias) {
            if(preferencia != null && preferencia.getPessoa().equals(login.getPessoaLogada())){
                sb.append("\n ID: ").append(preferencia.getId()).
                append("\n Alimento: ").append(preferencia.getAlimento().getNome()).
                append("\n\n Data de Criacao: ").append(preferencia.getDataCriacao()).
                append("\n Data de Modificacao: ").append(preferencia.getDataModificacao()).
                append("\n ================================== \n\n");
            }
        }
        return sb.toString();
    }
}


