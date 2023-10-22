/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author diogo
 */
public class SeguirDAO {
    Seguir seguidores[] = new Seguir[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Seguir seguidor){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] == null){
                seguidores[i] = seguidor;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A REFEICAO PARA SER REMOVIDA
    public boolean remover(long idSeguidor){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getId() == (idSeguidor)){
                seguidores[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idSeguidor, Seguir seguidorNova){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getId() == idSeguidor){
                seguidores[i] = seguidorNova;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Seguir buscar(long idSeguidor){
        for (Seguir seguidor : seguidores) {
            if (seguidor.getId() == idSeguidor) {
                return seguidor;
            } 
        }
        return null;
    }
     
    public String timeline(Pessoa pessoaLogada, PostDAO postDAO){
        StringBuilder sb = new StringBuilder();
        sb.append("====== POSTS ======");
        for (Seguir seguir : seguidores) {
            if(seguir != null && seguir.getPessoaOrigem().equals(pessoaLogada)){
                postDAO.toString(seguir.getPessoaSeguindo());
            }
        }

        return sb.toString();
    }

     
    public String toString(Pessoa pessoaLogada) {
        StringBuilder sb = new StringBuilder();
        sb.append("====== Seguidores ======");
        for (Seguir seguidor : seguidores) {
            if(seguidor != null && seguidor.getPessoaOrigem().equals(pessoaLogada)){
                sb.append("\n ID: ").append(seguidor.getPessoaSeguindo().getId()).
                append("\n Nome: ").append(seguidor.getPessoaSeguindo().getNome()).
                append("Sexo: ").append(seguidor.getPessoaSeguindo().getSexo()).
                append("Data de nascimento: ").append(seguidor.getPessoaSeguindo().getDataDeNascimento()).
                append("E-mail: ").append(seguidor.getPessoaSeguindo().getEmail()).
                append("Senha: ").append(seguidor.getPessoaSeguindo().getSenha()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
