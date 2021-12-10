/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.ArrayList;
import modelos.entidades.Banco;
import modelos.interfaces.IbancoDao;
import modelos.persistencia.BancoDao;

/**
 *
 * @author João
 */
public class BancoControle implements IbancoDao {

    BancoDao objetoBancoDao = new BancoDao();

    @Override
    public void incluir(Banco objeto) throws Exception {
        try {

            Banco aux = objetoBancoDao.consultarPorId(objeto.getId());
            if (aux == null) {
                objetoBancoDao.incluir(objeto);
            } else {
                throw new Exception("Este ID de Banco já existe no sistema!");
            }

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {

        try {
            Banco aux = objetoBancoDao.consultarPorId(objeto.getId());
            if(aux == null){
                objetoBancoDao.incluir(objeto);
            }

        } catch (Exception erro) {
            throw erro;
        }

        objetoBancoDao.alterar(objeto);
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        objetoBancoDao.apagarPorId(id);
    }

    @Override
    public Banco consultarPorId(int id) throws Exception {
        return objetoBancoDao.consultarPorId(id);
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
        return objetoBancoDao.listagem();
    }

}
