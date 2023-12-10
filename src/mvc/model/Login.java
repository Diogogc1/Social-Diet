/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;

import java.time.LocalDate;

/**
 *
 * @author diogo
 */
public class Login {
    private static Pessoa pessoaLogada;
    
    public Login(){}
            
    public Login(PessoaDAO pessoaDAO) {
        pessoaLogada = new Pessoa("AAAA", "M", LocalDate.now(), "diogo", "diogo");
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public void setPessoaLogada(Pessoa pessoaLogada) {
        Login.pessoaLogada = pessoaLogada;
    }
}
