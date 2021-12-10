/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import java.util.Date;

/**
 *
 * @author luisg
 */
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import uteis.Util;
public class Cartoes {
    private int id = 0;
    private String bandeiraDoCartao = "";
    private String numeroDoCartao = "";
    private String nomeDoTitular = "";
    private String CCV = "";
    private double limiteDoCartao = 0.00;
    private String dataDeVencimento;
    private String dataDeFechamento;
    private String dataDePagamento;
    
    
    

    public Cartoes() {
    }

    public Cartoes(int id,String bandeiraDoCartao, String numeroDoCartao, String nomeDoTitular, String CCV, double limite, String dataDeVencimento, String dataDeFechamento,
            String dataDePagamento) {
        this.id = id;
        this.bandeiraDoCartao = bandeiraDoCartao;
        this.numeroDoCartao = numeroDoCartao;
        this.nomeDoTitular = nomeDoTitular;
        this.CCV = CCV;
        this.limiteDoCartao = limite;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDeFechamento = dataDeFechamento;
        this.dataDePagamento = dataDePagamento;

    }

    public String getBandeiraDoCartao() {
        return bandeiraDoCartao;
    }

    public void setBandeiraDoCartao(String bandeiraDoCartao) {
        this.bandeiraDoCartao = bandeiraDoCartao;
    }
   

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getNomeDoTitular() {
        return nomeDoTitular;
    }

    public void setNomeDoTitular(String nomeNoCartao) {
        this.nomeDoTitular = nomeNoCartao;
    }

    public String getCCV() {
        return CCV;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }

    public double getLimiteDoCartao() {
        return limiteDoCartao;
    }

    public void setLimiteDoCartao(double limiteDoCartao){
       
        this.limiteDoCartao = limiteDoCartao;
    }

    public String getDataDeFechamento() {
        return dataDeFechamento;
    }

    public void setDataDeFechamento( String dataDeFechamento)throws Exception {
      this.dataDeFechamento = dataDeFechamento;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento( String dataDeVencimento)throws Exception {
      this.dataDeVencimento = dataDeVencimento;
        
    }

    public String getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento( String dataDePagamento)throws Exception {
       
      this.dataDePagamento = dataDePagamento;
        
    }
    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return  id + ";" + bandeiraDoCartao + ";" + numeroDoCartao + ";" + nomeDoTitular +
                ";" + CCV + ";" + limiteDoCartao + ";" + dataDeVencimento +";" + dataDeFechamento +
                ";" + dataDePagamento;
    }

    
}
