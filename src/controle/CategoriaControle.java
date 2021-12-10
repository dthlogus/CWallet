package controle;

import java.util.ArrayList;
import modelos.entidades.Categoria;
import modelos.interfaces.CategoriaDao;
import modelos.persistencia.CategoriaDaoImpl;

public class CategoriaControle implements CategoriaDao {

    CategoriaDaoImpl categoriaDao = new CategoriaDaoImpl();

    @Override
    public void incluir(Categoria categoria) throws Exception {
        try {
            Categoria aux = categoriaDao.consultarPorId(categoria.getId());
            if (aux != null) {
                throw new Exception("Este ID de categoria já existe no sistema!");
            } else if (categoria.getNome().isEmpty()) {
                throw new Exception("A descrição tem que ser preenchida");
            } else {
                categoriaDao.incluir(categoria);
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Categoria categoria) throws Exception {
        try {
            Categoria aux = categoriaDao.consultarPorId(categoria.getId());
            if (aux == null) {
                throw new Exception("Não existe categoria com esse id");
            } else if (categoria.getNome().isEmpty()) {
                throw new Exception("A descrição tem que ser preenchida");
            } else {
                categoriaDao.alterar(categoria);
            }
        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void apagarPorId(int id) throws Exception {
        categoriaDao.apagarPorId(id);
    }

    @Override
    public Categoria consultarPorId(int id) throws Exception {
        return categoriaDao.consultarPorId(id);
    }

    @Override
    public ArrayList<Categoria> listagem() throws Exception {
        return categoriaDao.listagem();
    }
}
