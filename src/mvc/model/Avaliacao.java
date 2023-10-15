/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author User
 */
/*AVALIAÇÃO FÍSICA. NA AVALIAÇÃO FÍSICA A PESSOA REGISTRA O SEUS DADOS.
INFORMAÇÕES IMPORTANTES: ID, PESSOA, PESO, ALTURA, IDADE, PESCOCO,
CINTURA, QUADRIL, IMC, TMB, BF, MASSA GORDA KG, MASSA MAGRA KG,
DATACRIACAO, DATAMODIFICACAO.*/
public class Avaliacao {
    private static long serial;

    private final long id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double imc;
    private double tmb;
    private double bf;
    private double massaGorda;
    private double massaMagra;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
    public String getSerial() {
        return "Atualmente há " + serial + "avaliacoes no sistema";
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTmb() {
        return tmb;
    }

    public void setTmb(double tmb) {
        this.tmb = tmb;
    }

    public double getBf() {
        return bf;
    }

    public void setBf(double bf) {
        this.bf = bf;
    }

    public double getMassaGorda() {
        return massaGorda;
    }

    public void setMassaGorda(double massaGorda) {
        this.massaGorda = massaGorda;
    }

    public double getMassaMagra() {
        return massaMagra;
    }

    public void setMassaMagra(double massaMagra) {
        this.massaMagra = massaMagra;
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
    
    //CONSTRUTOR
    public Avaliacao(Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril) {
        this.id = ++serial;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        this.imc = calcularImc();
        this.tmb = calcularTmb();
        this.bf = calcularBf();
        gerarRelatorio();
    }
    
    
    //CRIAÇÃO SCANNER
    Scanner sc = new Scanner(System.in);
    
    /*O CÁLCULO É FEITO DA SEGUINTE FORMA: DIVIDE-SE O PESO (EM KG)
    PELO QUADRADO DA ALTURA (EM METROS). IMC = PESO ÷ (ALTURA × ALTURA)*/
    public double calcularImc (){
        
        this.imc = this.peso / (this.altura * this.altura);
        
        return imc;
    }
    
    /*FATOR DA TAXA DE ATIVIDADE:
    1.2: SEDENTÁRIO (POUCO OU NENHUM EXERCÍCIO)
    1,375: LEVEMENTE ATIVO (EXERCÍCIO LEVE 1 A 3 DIAS POR SEMANA)
    1,55: MODERADAMENTE ATIVO (EXERCÍCIO MODERADO 6 A 7 DIAS POR SEMANA)
    1,725: MUITO ATIVO (EXERCÍCIO INTENSO TODOS OS DIAS OU EXERCÍCIO DUAS VEZES AO DIA)
    1,9: EXTRA ATIVO (EXERCÍCIO MUITO DIFÍCIL, TREINAMENTO OU TRABALHO FÍSICO)*/
    
    public double obterTaxaAtvd() {
        double taxaAtvd = 0;
        int opcAtvd;
        //MODIFICAR SAIDAS E ENTRADAS PARA A MAIN
        System.out.println("""
                           O quanto você pratica exercícios?
                           1. Nenhuma
                           2. 1 a 3 vezes na semana
                           3. 6 a 7 vezes na semana
                           4. 2 vezes ao dia (ou intensamente todos os dias)
                           5. Treinamento intenso (muito difícil)
                           Escolha uma opção:
                           """);
        opcAtvd = Integer.parseInt(sc.nextLine());
        
        switch(opcAtvd){
            case 1 -> taxaAtvd = 1.2;
            case 2 -> taxaAtvd = 1.375;
            case 3 -> taxaAtvd = 1.55;
            case 4 -> taxaAtvd = 1.725;
            case 5 -> taxaAtvd = 1.9;
        }
        
        return taxaAtvd;
    }
    
    /*FÓRMULA PARA HOMENS: TMB = FATOR DA TAXA DE ATIVIDADE X
    {66 + [(13,7 X PESO(KG)) + ( 5 X ALTURA(CM)) – (6,8 X IDADE(ANOS))]}
    FÓRMULA PARA MULHERES: TMB = FATOR DA TAXA DE ATIVIDADE X {655 +
    [(9,6 X PESO(KG)) + (1,8 X ALTURA(CM)) – (4,7 X IDADE(ANOS))]}*/
    public double calcularTmb(){
       
        double taxaAtvd;
        
        taxaAtvd = this.obterTaxaAtvd();
        
        if("1".equals(this.pessoa.getSexo())){
            
            this.tmb = taxaAtvd * (66.0 + (13.7 * this.peso) + (5.0 * this.altura) - (6.8 * this.idade));
            
        }else if("2".equals(this.pessoa.getSexo())) {
            
            this.tmb = taxaAtvd * (655 + (9.6 * this.peso) + (1.8 * this.altura) - (4.7 * this.idade));
            
        }
        
        return this.tmb;
    }
    
    /*DEVERÁ SER ESTIMADO O VALOR DO PERCENTUAL DE GORDURA.
    DA QUANTIDADE DE MASSA MAGRA E DA QUANTIDADE DE MASSA GORDA.
    FÓRMULA PARA MULHERES: % BODY FAT = 163.205 X LOG10
    (CINTURA + QUADRIL – PESCOÇO) – 97.684 X LOG10 (ALTURA) – 78.387
    FÓRMULA PARA HOMENS: % BODY FAT = 86.010 X LOG10 (ABDOME – PESCOÇO) –
    70.041 X LOG10 (ALTURA) + 36.76*/
    public double calcularBf(){
        
        if("1".equals(this.pessoa.getSexo())){
            
            this.bf = 86.010 * Math.log10(this.cintura - this.pescoco)
            - 70.41 * Math.log10(this.altura) + 36.76;
            
        }else if("2".equals(this.pessoa.getSexo())) {
            
            this.bf = 163.205 * Math.log10(this.cintura +
            this.quadril - this.pescoco) - 97.684 *
            Math.log10(this.altura) - 78.387;
            
        }
        
        return this.bf;
    }
   
    /*COM O % BODY FAT CALCULADO, BASTA FAZER OUTRAS MULTIPLICAÇÕES
    PARA DESCOBRIR O PESO DE MASSA GORDA E O RESTANTE É DE MASSA MAGRA.*/
    public double calcularGorda(){
        
        this.massaGorda = this.bf / 100 * this.peso;
        
        return this.massaGorda;
    }
    
    public double calcularMagra(){
        
        this.massaMagra = this.peso - (this.bf / 100 * this.peso);
        
        return this.massaMagra;
    }
    
    //INTERPRETAÇÃO DE DADOS DE BF
    
    
    //ESTUDAR FOR PARA IMPLEMENTAR
    public String interpretarBf(){
        String estadoBf = "";
        
        if ("1".equals(pessoa.getSexo())){
            if (this.idade >= 20 && this.idade <=29){
                if(this.bf < 11){
                    estadoBf = "Atleta";
                }else if(this.bf >= 11 && this.bf <= 13){
                    estadoBf = "Bom";
                }else if (this.bf >= 14 && this.bf <= 20){
                    estadoBf = "Normal";
                }else if (this.bf >= 21 && this.bf <= 23){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 30 && this.idade <=39){
                if(this.bf < 12){
                    estadoBf = "Atleta";
                }else if(this.bf >= 12 && this.bf <= 14){
                    estadoBf = "Bom";
                }else if (this.bf >= 15 && this.bf <= 21){
                    estadoBf = "Normal";
                }else if (this.bf >= 22 && this.bf <= 24){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 40 && this.idade <=49){
                if(this.bf < 14){
                    estadoBf = "Atleta";
                }else if(this.bf >= 14 && this.bf <= 16){
                    estadoBf = "Bom";
                }else if (this.bf >= 17 && this.bf <= 23){
                    estadoBf = "Normal";
                }else if (this.bf >= 24 && this.bf <= 26){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 50 && this.idade <=59){
                if(this.bf < 15){
                    estadoBf = "Atleta";
                }else if(this.bf >= 15 && this.bf <= 17){
                    estadoBf = "Bom";
                }else if (this.bf >= 18 && this.bf <= 24){
                    estadoBf = "Normal";
                }else if (this.bf >= 25 && this.bf <= 27){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }
            
        }else if ("2".equals(pessoa.getSexo())){
            if (this.idade >= 20 && this.idade <=29){
                if(this.bf < 16){
                    estadoBf = "Atleta";
                }else if(this.bf >= 16 && this.bf <= 19){
                    estadoBf = "Bom";
                }else if (this.bf >= 20 && this.bf <= 28){
                    estadoBf = "Normal";
                }else if (this.bf >= 29 && this.bf <= 31){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 30 && this.idade <=39){
                if(this.bf < 17){
                    estadoBf = "Atleta";
                }else if(this.bf >= 17 && this.bf <= 20){
                    estadoBf = "Bom";
                }else if (this.bf >= 21 && this.bf <= 29){
                    estadoBf = "Normal";
                }else if (this.bf >= 30 && this.bf <= 32){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 40 && this.idade <=49){
                if(this.bf < 18){
                    estadoBf = "Atleta";
                }else if(this.bf >= 18 && this.bf <= 21){
                    estadoBf = "Bom";
                }else if (this.bf >= 22 && this.bf <= 30){
                    estadoBf = "Normal";
                }else if (this.bf >= 31 && this.bf <= 33){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }else if (this.idade >= 50 && this.idade <=59){
                if(this.bf < 19){
                    estadoBf = "Atleta";
                }else if(this.bf >= 19 && this.bf <= 22){
                    estadoBf = "Bom";
                }else if (this.bf >= 23 && this.bf <= 31){
                    estadoBf = "Normal";
                }else if (this.bf >= 32 && this.bf <= 34){
                    estadoBf = "Elevado";
                }else{
                    estadoBf = "Muito elevado";
                }
            }
        }
        
        return estadoBf;
    }
    
    
    /*PÓS O REGISTRO DA AVALIAÇÃO FÍSICA DEVERÁ SER GERADO UM RELATÓRIO
    COM INFORMAÇÕES PARA A PESSOA. ALÉM DISSO, OS DADOS DEVEM SER
    INTERPRETADOS. SE DISPONÍVEL, COMPARE COM A ÚLTIMA AVALIAÇÃO FÍSICA.*/
    public void gerarRelatorio() {
        
        String estadoBf = interpretarBf();
        
        //RELATÓRIO FINAL
        StringBuilder sb = new StringBuilder();
                sb.append("====== RELATORIO ======").
                append("\n ID: ").append(this.id).
                append("\n Peso: ").append(this.peso).
                append("\n Altura: ").append(this.altura).
                append("\n Idade: ").append(this.idade).
                append("\n Pescoco: ").append(this.pescoco).
                append("\n Cintura: ").append(this.cintura).
                append("\n Quadril: ").append(this.quadril).
                append("\n IMC: ").append(this.imc).
                append("\n TMB: ").append(this.tmb).
                append("\n BF: ").append(this.bf).
                append("\n TMB: ").append(estadoBf).
                append("\n ========================================");
        System.out.println(sb);
    }
    /*
    this.id = ++serial;
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
    */
}
