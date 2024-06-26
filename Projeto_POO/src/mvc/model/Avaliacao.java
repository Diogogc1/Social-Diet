/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.model;
import java.time.LocalDate;
import java.util.Scanner;
import java.lang.Math;
import java.util.Locale;
import java.util.Objects;
/**
 *
 * @author User
 */
/*AVALIAÇÃO FÍSICA. NA AVALIAÇÃO FÍSICA A PESSOA REGISTRA O SEUS DADOS.
INFORMAÇÕES IMPORTANTES: ID, PESSOA, PESO, ALTURA, IDADE, PESCOCO,
CINTURA, QUADRIL, IMC, TMB, BF, MASSA GORDA KG, MASSA MAGRA KG,
DATACRIACAO, DATAMODIFICACAO.*/
public class Avaliacao {

    private long id;
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
    private String estadoBf;
    private double massaGorda;
    private double massaMagra;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    //GETTERS E SETTERS
    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    public String getEstadoBf() {
        return estadoBf;
    }

    public void setEstadoBf(String estadoBf) {
        this.estadoBf = estadoBf;
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
    
    public Avaliacao(){
        
    }    
    //CONSTRUTOR
    public Avaliacao(Pessoa pessoa, double peso, double altura, int idade, double pescoco, double cintura, double quadril) {
        this.pessoa = pessoa;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
        this.pescoco = pescoco;
        this.cintura = cintura;
        this.quadril = quadril;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        
        /*this.imc = calcularImc();
        this.tmb = calcularTmb();
        this.bf = calcularBf();
        gerarRelatorio();*/
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
    
    public double obterTaxaAtvd(int opcAtvd) {
        double taxaAtvd = 0;

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
    public double calcularTmb(double taxaAtvd){
        if("Masculino".equals(this.pessoa.getSexo())){
            this.tmb = taxaAtvd * (66.0 + (13.7 * this.peso) + (5.0 * this.altura) - (6.8 * this.idade));
            
        }else if("Feminino".equals(this.pessoa.getSexo())) {
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
    public final double calcularBf(){
        
        if("Masculino".equals(this.pessoa.getSexo())){
            
            this.bf = 86.010 * Math.log10(this.cintura - this.pescoco)
            - 70.041 * Math.log10(this.altura) + 36.76;
            
        }else if("Feminino".equals(this.pessoa.getSexo())) {
            
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
        
        //this.massaMagra = this.peso - (this.bf / 100 * this.peso);
        this.massaMagra = this.peso * (1 - this.bf / 100);
        
        return this.massaMagra;
    }
    
    //INTERPRETAÇÃO DE DADOS DE BF
    
    
    //ESTUDAR FOR PARA IMPLEMENTAR
    public String interpretarBf(){
        estadoBf = "";
        
        if ("Masculino".equals(pessoa.getSexo())){
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
            
        }else if ("Feminino".equals(pessoa.getSexo())){
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
    @Override
    public String toString() {
        
        estadoBf = interpretarBf();
        
        //RELATÓRIO FINAL
        StringBuilder sb = new StringBuilder();
                sb.append("\n ====== RELATORIO DA AVALIACAO ======").
                append("\n Peso: ").append(this.peso).
                append("\n Altura: ").append(this.altura).
                append("\n Idade: ").append(this.idade).
                append("\n Pescoco: ").append(this.pescoco).
                append("\n Cintura: ").append(this.cintura).
                append("\n Quadril: ").append(this.quadril).
                append("\n IMC: ").append(String.format(Locale.US, "%.2f", this.imc)).
                append("\n TMB: ").append(String.format(Locale.US, "%.2f", this.tmb)).
                append("\n BF: ").append(String.format(Locale.US, "%.2f", this.bf)).
                append("\n Estado BF: ").append(estadoBf).
                append("\n Massa Magra: ").append(String.format(Locale.US, "%.2f", this.massaMagra)).
                append("\n Massa Gorda: ").append(String.format(Locale.US, "%.2f", this.massaGorda)).
                append("\n ========================================");
        return sb.toString();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.pessoa);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 53 * hash + this.idade;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.pescoco) ^ (Double.doubleToLongBits(this.pescoco) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.cintura) ^ (Double.doubleToLongBits(this.cintura) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.quadril) ^ (Double.doubleToLongBits(this.quadril) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.imc) ^ (Double.doubleToLongBits(this.imc) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.tmb) ^ (Double.doubleToLongBits(this.tmb) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.bf) ^ (Double.doubleToLongBits(this.bf) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.massaGorda) ^ (Double.doubleToLongBits(this.massaGorda) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.massaMagra) ^ (Double.doubleToLongBits(this.massaMagra) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dataCriacao);
        hash = 53 * hash + Objects.hashCode(this.dataModificacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (Double.doubleToLongBits(this.pescoco) != Double.doubleToLongBits(other.pescoco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cintura) != Double.doubleToLongBits(other.cintura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quadril) != Double.doubleToLongBits(other.quadril)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imc) != Double.doubleToLongBits(other.imc)) {
            return false;
        }
        if (Double.doubleToLongBits(this.tmb) != Double.doubleToLongBits(other.tmb)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bf) != Double.doubleToLongBits(other.bf)) {
            return false;
        }
        if (Double.doubleToLongBits(this.massaGorda) != Double.doubleToLongBits(other.massaGorda)) {
            return false;
        }
        if (Double.doubleToLongBits(this.massaMagra) != Double.doubleToLongBits(other.massaMagra)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return Objects.equals(this.dataModificacao, other.dataModificacao);
    }
}