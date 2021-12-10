package modelos.entidades;

import java.math.BigDecimal;

public class ReceitaDespesa implements  Comparable<ReceitaDespesa>{
    private int id;
    private String tipoReceita;
    private String nome;
    private String dataDaCompra;
    private String categoria;
    private int parcela;
    private int parcelaAtual;
    private BigDecimal valor;
    private String tipoEntrada;
    private boolean repetitivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws Exception {
        this.categoria = categoria;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public int getParcelaAtual() {
        return parcelaAtual;
    }

    public void setParcelaAtual(int parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public boolean isRepetitivo() {
        return repetitivo;
    }

    public void setRepetitivo(boolean repetitivo) {
        this.repetitivo = repetitivo;
    }    

    @Override
    public String toString() {
        return getId() + ";" + getTipoReceita() + ";" + getNome() + ";" + getDataDaCompra() + ";" 
               + getCategoria() +";"+
               getParcelaAtual() + "/" + getParcela() + ";" +
               this.valor.toString() + ";" + getTipoEntrada() + ";" + isRepetitivo();
    }

    @Override
    public int compareTo(ReceitaDespesa receitaDespesa) {
        int idComparador = ((ReceitaDespesa) receitaDespesa).getId();
        return this.id - idComparador;
    }
}
