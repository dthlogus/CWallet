package modelos.enumerator;

public enum TipoEntrada {
    CUSTO("custo"), RECEITA("receita");
    
    private final String descricao;

    private TipoEntrada(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
