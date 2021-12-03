package modelos.entidades;

public class Categoria implements Comparable<Categoria>{
    
    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getId() + ";" + getNome(); 
    }

    @Override
    public int compareTo(Categoria categoria) {
        int idComparador = ((Categoria) categoria).getId();
        return this.id - idComparador;
    }
}
