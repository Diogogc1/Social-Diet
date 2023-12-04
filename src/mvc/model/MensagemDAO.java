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

    public MensagemDAO(Pessoa pessoaOrigem, Pessoa pessoaDestino) {
        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Opa, bao?"));
        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Bao e vc?"));
        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Comecou a usar o postfit ne?"));
        this.adicionar(new Mensagem (pessoaOrigem, pessoaDestino, "Sim, muito bao"));
    }
    
    
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
        sb.append("\n =========== MENSAGENS ===========");
        for (Mensagem mensagem : mensagens) {
            if(mensagem != null){
                sb.append("\n ID: ").append(mensagem.getId()).
                append("\n Remetente: ").append(mensagem.getPessoaOrigem().getNome()).
                append("\n Destinatário: ").append(mensagem.getPessoaDestino().getNome()).
                append("\n Mensagem: ").append(mensagem.getMensagem()). 
                append("\n Data de Criacao: ").append(mensagem.getDataCriacao()).
                append("\n Data de Modificacao: ").append(mensagem.getDataModificacao()).
                append("\n =================================");
            }
        }
        return sb.toString();
    }
}
