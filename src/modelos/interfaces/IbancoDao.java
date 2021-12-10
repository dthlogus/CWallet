/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;
import modelos.entidades.Banco;
import java.util.ArrayList;
/**
 *
 * @author João
 */
public interface IbancoDao {
    void incluir(Banco objeto) throws Exception;
    void alterar(Banco objeto) throws Exception;
    void apagarPorId(int id) throws Exception;
    Banco consultarPorId(int id) throws Exception;
    ArrayList<Banco> listagem() throws Exception;
}
