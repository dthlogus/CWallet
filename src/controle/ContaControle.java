/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.ArrayList;
import modelos.entidades.Conta;
import modelos.interfaces.IcontaDao;
import modelos.persistencia.ContaDao;

/**
 *
 * @author João
 */
public class ContaControle implements IcontaDao {

    ContaDao objetoContaDao = new ContaDao();

    @Override
    public void incluir(Conta conta) throws Exception {
        try {
            
            Conta aux = objetoContaDao.consultarPorConta(conta.getConta());

            if(aux != null){
                throw new Exception("Esta Conta já existe no sistema");   
            }
            if(conta.getLimite() < conta.getSaldo()){
                throw new Exception("O saldo não pode ultrapassar o limite");
            }            
            objetoContaDao.incluir(conta);
    
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Conta conta) throws Exception {
        
        try {
            Conta aux = objetoContaDao.consultarPorConta(conta.getConta());
            if(aux == null){
                throw new Exception("Não foi encontrado a conta informada");
            }
            if(aux.getLimite() < conta.getSaldo()){
                throw new Exception("O saldo não pode ultrapassar o limite");
            }
            
            objetoContaDao.alterar(conta);
            
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorConta(int conta) throws Exception {
        objetoContaDao.apagarPorConta(conta);
    }

    @Override
    public Conta consultarPorConta(int conta) throws Exception {
        return objetoContaDao.consultarPorConta(conta);
    }

    @Override
    public ArrayList<Conta> listagem() throws Exception {
        return objetoContaDao.listagem();
    }

}
