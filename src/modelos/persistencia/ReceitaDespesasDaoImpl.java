package modelos.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.entidades.ReceitaDespesa;
import modelos.interfaces.ReceitaDespesasDao;

public class ReceitaDespesasDaoImpl implements ReceitaDespesasDao {

    private String nomeDoArquivoNoDisco = "./ArquivoDeDados/ReceitaDespesa.txt";

    public ReceitaDespesasDaoImpl() {
      try{
            File arquivo = new File(nomeDoArquivoNoDisco);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
        } catch (Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo");
        }
    }
    
    @Override
    public void incluir(ReceitaDespesa receitaDespesa) throws Exception {
        try {
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(receitaDespesa.toString() + "\n");
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(ReceitaDespesa receitaDespesa) throws Exception {
        ArrayList<ReceitaDespesa> receitaDespesas = listagem();
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            for (int pos = 0; pos < receitaDespesas.size(); pos++) {
                if (receitaDespesa.getId() != receitaDespesas.get(pos).getId()) {
                    bw.write(receitaDespesas.get(pos).toString() + "\n");
                }
            }
            bw.write(receitaDespesa.toString() + "\n");
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        try {
            ArrayList<ReceitaDespesa> receitaDespesas = listagem();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < receitaDespesas.size(); pos++) {
                if (id != receitaDespesas.get(pos).getId()) {
                    bw.write(receitaDespesas.get(pos).toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public ReceitaDespesa consultarPorId(int id) throws Exception {
        ReceitaDespesa aux = new ReceitaDespesa();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        try {
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                String parcelas[] = vetorString[5].split("/");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setTipoReceita(vetorString[1]);
                aux.setNome(vetorString[2]);
                aux.setDataDaCompra(vetorString[3]);
                aux.setCategoria(vetorString[4]);
                aux.setParcelaAtual(Integer.parseInt(parcelas[0]));
                aux.setParcela(Integer.parseInt(parcelas[1]));
                aux.setValor(new BigDecimal(vetorString[6]));
                aux.setTipoEntrada(vetorString[7]);
                aux.setRepetitivo(Boolean.parseBoolean(vetorString[8]));
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
    public ArrayList<ReceitaDespesa> listagem() throws Exception {
        try {
            ArrayList<ReceitaDespesa> receitaDespesas = new ArrayList<ReceitaDespesa>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ReceitaDespesa aux = new ReceitaDespesa();
                String vetorString[] = linha.split(";");
                String parcelas[] = vetorString[5].split("/");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setTipoReceita(vetorString[1]);
                aux.setNome(vetorString[2]);
                aux.setDataDaCompra(vetorString[3]);
                aux.setCategoria(vetorString[4]);
                aux.setParcelaAtual(Integer.parseInt(parcelas[0]));
                aux.setParcela(Integer.parseInt(parcelas[1]));
                aux.setValor(new BigDecimal(vetorString[6]));
                aux.setTipoEntrada(vetorString[7]);
                aux.setRepetitivo(Boolean.parseBoolean(vetorString[8]));
                receitaDespesas.add(aux);
            }
            br.close();
            return receitaDespesas;
        } catch (Exception erro) {
            throw erro;
        }
    }

}
