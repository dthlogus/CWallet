/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.persistencia;

import modelos.interfaces.IcontaDao;
import java.util.ArrayList;
import modelos.entidades.Banco;

//Bibliotecas para manipulação de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import modelos.entidades.Conta;

/**
 *
 * @author João
 */
public class ContaDao implements IcontaDao {

    //Atributo
    private String nomeDoArquivoDadosNoDisco = "./ArquivoDeDados/Contas.txt";


    public ContaDao() {
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
    public void incluir(Conta conta) throws Exception {
        try {
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco, true);

            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(conta.toString() + "\n");

            //Fechar o arquivo
            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Conta objeto) throws Exception {
        ArrayList<Conta> arrayDasContas = listagem();
        
        //Ler o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);
        
        //Buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        
        try {
            //
            for(int pos = 0; pos < arrayDasContas.size(); pos++){
                if(objeto.getConta() != arrayDasContas.get(pos).getConta()){
                    bw.write(arrayDasContas.get(pos).toString() + "\n");
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
    public void apagarPorConta(int conta) throws Exception {
        try {
            ArrayList<Conta> arrayDasContas = listagem();

            //Ler arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDadosNoDisco);

            //Buffer
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < arrayDasContas.size(); pos++) {
                if (conta != arrayDasContas.get(pos).getConta()) {
                    bw.write(arrayDasContas.get(pos).toString() + "\n");
                }
            }

            bw.close();

        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Conta consultarPorConta(int conta) throws Exception {
        Conta aux = new Conta();

        //Abrir arquivo e ler sem modificar
        FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);

        //Criar buffer do arquivo
        BufferedReader br = new BufferedReader(fr);

        try {

            //Ler linhas no arquivo
            String linha = "";

            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");

                String bancoDescricao = vetorString[0];
                int numeroDaConta = Integer.parseInt(vetorString[1]);
                int agencia = Integer.parseInt(vetorString[2]);
                String nomeDoTitular = vetorString[3];
                double limiteDaConta = Double.parseDouble(vetorString[4]);
                double saldoDaConta = Double.parseDouble(vetorString[5]);

                aux.setDescricao(bancoDescricao);
                aux.setConta(numeroDaConta);
                aux.setAgencia(agencia);
                aux.setTitular(nomeDoTitular);
                aux.setLimite(limiteDaConta);
                aux.setSaldo(saldoDaConta);

                if (aux.getConta() == conta) {
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
    public ArrayList<Conta> listagem() throws Exception {
        try {
            ArrayList<Conta> arrayDasContas = new ArrayList<Conta>();

            //Abrir o arquivo
            FileReader fr = new FileReader(nomeDoArquivoDadosNoDisco);

            //criar um buffer
            BufferedReader br = new BufferedReader(fr);

            String linha = "";

            while ((linha = br.readLine()) != null) {
                Conta aux = new Conta();
                String vetorString[] = linha.split(";");

                String bancoDescricao = vetorString[0];
                int numeroDaConta = Integer.parseInt(vetorString[1]);
                int agencia = Integer.parseInt(vetorString[2]);
                String nomeDoTitular = vetorString[3];
                double limiteDaConta = Double.parseDouble(vetorString[4]);
                double saldoDaConta = Double.parseDouble(vetorString[5]);

                aux.setDescricao(bancoDescricao);
                aux.setConta(numeroDaConta);
                aux.setAgencia(agencia);
                aux.setTitular(nomeDoTitular);
                aux.setLimite(limiteDaConta);
                aux.setSaldo(saldoDaConta);
                arrayDasContas.add(aux);

            }

            br.close();

            //Ordenar por ID
            Collections.sort(arrayDasContas, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Conta c1 = (Conta) o1;
                    Conta c2 = (Conta) o2;

                    //Comparar por ID do banco
                    if (c1.getId() > c1.getId()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });

            return arrayDasContas;
        } catch (Exception erro) {
            throw erro;
        }

    }

}
