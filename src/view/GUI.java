/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author diogo
 */
public class GUI {
    public void menuInicial(){
        System.out.println("""
                           ========== POSTFIT  ==========
                           
                           1. Login
                           2. Cadstro
                           
                           Escolha uma opção:  
                           """);
    }
    
    public void email(){
        System.out.println("E-mail");
    }
    
    public void senha(){
        System.out.println("""
                             senha:  
                             """);
    }
    
    public void cadastro(){
        System.out.println("""
                           /// CADASTRO ///
                           
                           Nome:
                           E-mail:
                           Senha:
                           Sexo:
                           """);
    }
    
    public void menuPrincipal(){
        System.out.println("""
                           /// MENU ///
                           
                           1. FitPerson
                           2. PostFit
                           
                           Escolha uma opção:
                           """);
    }
    
    public void menuFitPerson(){
        System.out.println("""
                           //// FitPeson ////
                           
                           1. Realizar Avaliação Física
                           2. Casdastrar Alimentos
                           3. Escolher Preferências
                           4. Montar Refeição
                           5. Registrar Dieta
                           
                           Escolha uma opção:
                           """);
    }
    
    public void avaliacaoFisica(){
        
    }
}
