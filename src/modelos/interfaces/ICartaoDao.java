/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import modelos.entidades.Cartoes;
import java.util.ArrayList;
/**
 *
 * @author luisg
 */
public interface ICartaoDao {
        void incluir (Cartoes objeto) throws Exception;
        void alterar (Cartoes objeto) throws Exception;
        void apagarPorId (int id) throws Exception;
        Cartoes consultarPorId (int id ) throws Exception;
        ArrayList<Cartoes>listagem () throws Exception;
        
    
}
