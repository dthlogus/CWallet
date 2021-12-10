/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.persistencia;

import modelos.interfaces.IbancoDao;
import modelos.entidades.Banco;
import java.util.ArrayList;

//Bibliotecas para manipulação de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;


/**
 *
 * @author João
 */
public class BancoDao implements IbancoDao {

    //Atributo
    private String nomeDoArquivoDadosNoDisco = "./ArquivoDeDados/Banco.txt";

    //Métodos
    //Construtor
    public BancoDao() {
        try{
            File arquivo = new File(nomeDoArquivoDadosNoDisco);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo");
        }
    }

    @Override
    public void incluir(Banco objeto) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco, true);

            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(objeto.toString() + "\n");

            //Fechar o arquivo
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }

    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        ArrayList<Banco> arrayDosBancos = listagem();
        FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
        BufferedWriter bw = new BufferedWriter(fw);

        try {
            //Excluir
            for (int pos = 0; pos < arrayDosBancos.size(); pos++) {
                if (objeto.getId() != arrayDosBancos.get(pos).getId()) {
                    bw.write(arrayDosBancos.get(pos).toString() + "\n");
                }
            }

            bw.write(objeto.toString() + "\n");

            //Fechar o arquivo
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = listagem();

            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);

            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < arrayDosBancos.size(); pos++) {
                if (id != arrayDosBancos.get(pos).getId()) {
                    bw.write(arrayDosBancos.get(pos).toString() + "\n");
                }
            }

            //Fechar o arquivo
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Banco consultarPorId(int id) throws Exception {

        Banco aux = new Banco();
        //Abrir o arquivo
        FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);

        //criar um buffer do arquivo
        BufferedReader br = new BufferedReader(fr);

        try {

            //Ler Linhas
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String nomeDoBanco = vetorString[1];
                aux.setId(identificador);
                aux.setDescricao(nomeDoBanco);
                if (aux.getId() == id) {
                    return aux;
                }
            }

            aux = null;

            return aux;
        } catch (Exception erro) {
            throw erro;
        } finally {
            br.close();
        }
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
        try {
            ArrayList<Banco> arrayDosBancos = new ArrayList<Banco>();

            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);

            //criar um buffer do arquivo
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while ((linha = br.readLine()) != null) {
                Banco aux = new Banco();
                String vetorString[] = linha.split(";");
                int identificador = Integer.parseInt(vetorString[0]);
                String nomeDoBanco = vetorString[1];
                aux.setId(identificador);
                aux.setDescricao(nomeDoBanco);
                arrayDosBancos.add(aux);
            }

            br.close();

            //Ordenar por ID
            Collections.sort(arrayDosBancos, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Banco b1 = (Banco) o1;
                    Banco b2 = (Banco) o2;
                    if(b1.getId() > b2.getId()){
                        return 1;
                    }else{
                        return -1;
                    }
                    
                }
            });

            return arrayDosBancos;
        } catch (Exception erro) {
            throw erro;
        }
    }

}
