/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.entidades;

import java.math.BigDecimal;
/**
 *
 * @author João
 */
public class Conta extends Banco{
    //Atributos
    protected int conta = 0;
    protected int agencia = 0;
    protected double saldo = 0;
    protected String titular;
    protected double limite = 0;
            
    //Métodos
    
    public Conta(){
        
    }
    
    public Conta(int id, String descricao, int conta, int agencia, double saldo, String titular, double limite){
        super(id, descricao);
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
        this.limite = limite;
    }
    
    
    
    

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    
    public String toString(){
        return 
                descricao + ";" +
                conta + ";" +
                agencia + ";" +
                titular + ";" +
                limite + ";" +
                saldo + ";";             
    }
}
