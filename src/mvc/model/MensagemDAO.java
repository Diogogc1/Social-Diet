/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

/**
 *
 * @author User
 */
public class MensagemDAO {
    Mensagem mensagens[] = new Mensagem[10];
    
    //ADICIONAR - PERCORRE O VETOR E PROCURA UMA POSIÇÃO VAZIA PARA ADICIONAR
    public boolean adicionar(Mensagem mensagem){
        for (int i = 0; i < mensagens.length; i++) {
            if(mensagens[i] == null){
                mensagens[i] = mensagem;
                return true;
            } 
        }
        return false;
    }
    
    //REMOVER - PERCORRE O VETOR E PROCURA A PESSOA PARA SER REMOVIDA
    public boolean remover(long idMensagem){
        for (int i = 0; i < mensagens.length; i++) {
            if(mensagens[i].getId() == idMensagem){
                mensagens[i] = null;
                return true;
            }
        }
        return false;
    }
    
    //ALTERAR
    public boolean alterar(long idMensagem, Mensagem mensagemNovo){
        for (int i = 0; i < mensagens.length; i++) {
            if(mensagens[i].getId() == idMensagem){
                mensagens[i] = mensagemNovo;
                return true;
            }
        }
        return false;
    }
    
    //BUSCAR
    public Mensagem buscar (Long idMensagem){
        for(int i = 0; i < mensagens.length; i++){
           if(mensagens[i].getId() == idMensagem){
               return mensagens[i];
           }
        }
        return null;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== MENSAGENS ======");
        for (Mensagem mensagem : mensagens) {
            if(mensagem != null){
                sb.append("\n ID: ").append(mensagem.getId()).
                append("\n Nome: ").append(mensagem.getPessoaOrigem()).
                append("\n Altura: ").append(mensagem.getPessoaDestino()).
                append("\n Idade: ").append(mensagem.getMensagem()). 
                append("\n Data de Criacao: ").append(mensagem.getDataCriacao()).
                append("\n Data de Modificacao: ").append(mensagem.getDataModificacao()).
                append("\n ========================================");
            }
        }
        return sb.toString();
    }
}
