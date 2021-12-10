/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import modelos.entidades.Usuarios;
import java.util.ArrayList;
/**
 *
 * @author luisg
 */
public interface iUsuarioDao {
    void incluir (Usuarios objeto) throws Exception;
    void alterar (Usuarios objeto) throws Exception;
    ArrayList<Usuarios>listagem () throws Exception;
    Usuarios consultarPorCPF (String CPF ) throws Exception;
    
}
