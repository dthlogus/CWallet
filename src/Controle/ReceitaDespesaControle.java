package Controle;

import java.util.ArrayList;
import modelos.entidades.ReceitaDespesa;
import modelos.interfaces.ReceitaDespesasDao;
import modelos.persistencia.ReceitaDespesasDaoImpl;

public class ReceitaDespesaControle implements ReceitaDespesasDao{
    
    ReceitaDespesasDaoImpl receitaDao = new ReceitaDespesasDaoImpl();

    @Override
    public void incluir(ReceitaDespesa receitaDespesas) throws Exception {
        try {
            ReceitaDespesa aux = receitaDao.consultarPorId(receitaDespesas.getId());
            if (aux == null) {
                receitaDao.incluir(receitaDespesas);
            } else {
                throw new Exception("Este ID de Banco já existe no sistema!");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(ReceitaDespesa receitaDespesas) throws Exception {
        try {
            ReceitaDespesa aux = receitaDao.consultarPorId(receitaDespesas.getId());
            if(aux == null){
                receitaDao.incluir(receitaDespesas);
            }
        } catch (Exception erro) {
            throw erro;
        }
        receitaDao.alterar(receitaDespesas);
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        receitaDao.apagarPorId(id);
    }

    @Override
    public ReceitaDespesa consultarPorId(int id) throws Exception {
        return receitaDao.consultarPorId(id);
    }

    @Override
    public ArrayList<ReceitaDespesa> listagem() throws Exception {
        return receitaDao.listagem();
    }
    
}
