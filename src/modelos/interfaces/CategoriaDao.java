
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.Categoria;

public interface CategoriaDao {
    void incluir(Categoria categoria) throws Exception;
    void alterar(Categoria categoria) throws Exception;
    void apagarPorId(int id) throws Exception;
    Categoria consultarPorId(int id) throws Exception;
    ArrayList<Categoria> listagem() throws Exception;
}
