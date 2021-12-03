package modelos.entidades;

import java.math.BigDecimal;
import java.util.Date;
import modelos.enumerator.TipoEntrada;
import modelos.enumerator.TipoReceita;
import modelos.persistencia.CategoriaDaoImpl;

public class ReceitaDespesa {
    private int id;
    private TipoReceita tipoReceita;
    private String nome;
    private Date dataDaCompra;
    private Categoria categoria;
    private int parcela;
    private int parcelaAtual;
    private BigDecimal valor;
    private TipoEntrada tipoEntrada;
    private boolean repetitivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(int id) throws Exception {
        CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();
        this.categoria = categoriaDao.consultarPorId(id);
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

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
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
        return getId() + ";" + getTipoReceita().getDescricao() + ";" + getNome() + ";" + getDataDaCompra() + ";" 
               + getCategoria().getId() +";"+
               getParcelaAtual() + "/" + getParcela() + ";" +
               this.valor.toString() + ";" + getTipoEntrada().getDescricao() + ";" + isRepetitivo();
    }
}
