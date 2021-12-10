/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.persistencia;
import modelos.interfaces.ICartaoDao;
import modelos.entidades.Cartoes;
import java.util.ArrayList;
//Bibliotecas para manipulação de arquivo texto no disco
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import uteis.Util;

/**
 *
 * @author luisg
 */
public class CartaoDao implements ICartaoDao{
    
    private String nomeDoArquivoDeDadosNoDisco = "";
    public CartaoDao(String nomeDoArquivoDeDadosNoDisco){
        this.nomeDoArquivoDeDadosNoDisco = nomeDoArquivoDeDadosNoDisco;
    }

    @Override
    public void incluir(Cartoes objeto) throws Exception {
        try {
            FileWriter fw = new FileWriter(nomeDoArquivoDeDadosNoDisco, true);
            //Criar o Buffer
            BufferedWriter bw = new BufferedWriter(fw);
            //Escrevendo no arquivo
            bw.write(objeto.toString() + "\n");
            //fechando o arquivo
            bw.close();
            
        } catch (Exception erro){
            throw erro;
        }
    }

    @Override
    public void alterar(Cartoes objeto) throws Exception {
       ArrayList<Cartoes> arrayDoscartoes = listagem();
       FileWriter fw = new FileWriter(nomeDoArquivoDeDadosNoDisco);
       BufferedWriter bw = new BufferedWriter(fw);
       
        try {
            //Excluir
            for (int pos = 0; pos < arrayDoscartoes.size(); pos++ ){
                if(objeto.getId() != arrayDoscartoes.get(pos).getId()){
                    bw.write(arrayDoscartoes.get(pos).toString() + "\n");
                }
            }
            bw.write(objeto.toString() + "\n");
            
            //fecha o arquivo
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            ArrayList<Cartoes> arrayDosCartoes = listagem();
            
            //Criar o arquivo
            FileWriter fw = new FileWriter(nomeDoArquivoDeDadosNoDisco);
            
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int pos = 0; pos < arrayDosCartoes.size(); pos ++){
                if (id != arrayDosCartoes.get(pos).getId()){
                    bw.write(arrayDosCartoes.get(pos).toString() + "\n");
                }
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Cartoes consultarPorId(int id) throws Exception {
        Cartoes aux = new Cartoes();
        FileReader fr = new FileReader(nomeDoArquivoDeDadosNoDisco);
        BufferedReader br = new BufferedReader(fr);
        
     
        try {
            String linha = "";
            while ((linha = br.readLine()) != null) {
            String vetorString[] = linha.split(";");
            
            aux.setId(Integer.parseInt(vetorString[0]));
            aux.setBandeiraDoCartao(vetorString[1]);
            aux.setNumeroDoCartao(vetorString[2]);
            aux.setNomeDoTitular(vetorString[3]);
            aux.setCCV(vetorString[4]);
            aux.setLimiteDoCartao(Double.parseDouble(vetorString[5]));
            aux.setDataDeVencimento(vetorString[6]);
            aux.setDataDeFechamento(vetorString[7]);
            aux.setDataDePagamento(vetorString[8]);
   
            if(aux.getId() == id){
                return aux ;
            }
        }
          aux = null;
          return aux;
            
        } catch (Exception erro) {
            throw erro;
        } finally{
            br.close();
        }
        
     
    }

    @Override
    public ArrayList<Cartoes> listagem() throws Exception {
        try {
            ArrayList<Cartoes> arrayDosCartoes = new ArrayList<Cartoes>();
            
            FileReader fr = new FileReader(nomeDoArquivoDeDadosNoDisco);
            BufferedReader br = new BufferedReader(fr);
            
            
            String linha = "";
            
            while((linha = br.readLine()) != null) {
              Cartoes aux = new Cartoes();
              String vetorString[] = linha.split(";");
              aux.setId(Integer.parseInt(vetorString[0]));
              aux.setBandeiraDoCartao(vetorString[1]);
              aux.setNumeroDoCartao(vetorString[2]);
              aux.setNomeDoTitular(vetorString[3]);
              aux.setCCV(vetorString[4]);
              aux.setLimiteDoCartao(Double.parseDouble(vetorString[5]));
              aux.setDataDeVencimento(vetorString[6]);
              aux.setDataDeFechamento(vetorString[7]);
              aux.setDataDePagamento(vetorString[8]);
              
             
              arrayDosCartoes.add(aux);
                
            }
            
            br.close();
            Collections.sort(arrayDosCartoes, new Comparator() {
                public int compare(Object o1, Object o2) {
                    Cartoes c1 = (Cartoes) o1;
                    Cartoes c2 = (Cartoes) o2;
                    if(c1.getId() > c2.getId()){
                        return 1;
                    }else{
                        return -1;
                    }

                }
            });
            
           
            return arrayDosCartoes;
        } catch (Exception erro) {
            throw erro;
        }
    }


    
}
