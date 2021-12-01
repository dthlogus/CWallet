
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.ReceitaDespesa;

public interface ReceitaDespesasDao {
    void incluir(ReceitaDespesa receitaDespesa) throws Exception;
    void alterar(ReceitaDespesa receitaDespesa) throws Exception;
    void apagarPorId(int id) throws Exception;
    ReceitaDespesa consultarPorId(int id) throws Exception;
    ArrayList<ReceitaDespesa> listagem() throws Exception;
}
