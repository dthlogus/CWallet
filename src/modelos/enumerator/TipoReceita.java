package modelos.enumerator;

public enum TipoReceita {
    DINHEIRO("dinheiro"), CARTAO("cartao"), CONTA("conta");
    
    private final String descricao;

    private TipoReceita(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
