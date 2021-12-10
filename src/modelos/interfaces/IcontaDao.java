/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.Banco;
import modelos.entidades.Conta;

/**
 *
 * @author João
 */
public interface IcontaDao {
    void incluir (Conta objeto) throws Exception;
    void alterar (Conta objeto) throws Exception;
    void apagarPorConta(int conta) throws Exception;
    Conta consultarPorConta(int conta) throws Exception;
    ArrayList<Conta> listagem() throws Exception;
}
