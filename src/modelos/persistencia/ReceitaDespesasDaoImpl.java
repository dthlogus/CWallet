package modelos.persistencia;

import Util.UtilReceitaDespesa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import modelos.entidades.ReceitaDespesa;
import modelos.enumerator.TipoEntrada;
import modelos.enumerator.TipoReceita;
import modelos.interfaces.ReceitaDespesasDao;

public class ReceitaDespesasDaoImpl implements ReceitaDespesasDao {

    private String nomeDoArquivoNoDisco = "./ArquivoDeDados/ReceitaDespesa.txt";

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
                String parcelas[] = vetorString[6].split("/");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setTipoReceita(TipoReceita.valueOf(vetorString[1]));
                aux.setNome(vetorString[2]);
                aux.setDataDaCompra(UtilReceitaDespesa.stringToDateDataDaCompra(vetorString[3]));
                aux.setFormaDePagamento(vetorString[4]);
                aux.setCategoria(Integer.parseInt(vetorString[5]));
                aux.setParcelaAtual(Integer.parseInt(parcelas[0]));
                aux.setParcela(Integer.parseInt(parcelas[1]));
                aux.setValor(new BigDecimal(vetorString[7]));
                aux.setTipoEntrada(TipoEntrada.valueOf(vetorString[8]));
                aux.setRepetitivo(Boolean.parseBoolean(vetorString[9]));
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
                String parcelas[] = vetorString[6].split("/");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setTipoReceita(TipoReceita.valueOf(vetorString[1]));
                aux.setNome(vetorString[2]);
                aux.setDataDaCompra(UtilReceitaDespesa.stringToDateDataDaCompra(vetorString[3]));
                aux.setFormaDePagamento(vetorString[4]);
                aux.setCategoria(Integer.parseInt(vetorString[5]));
                aux.setParcelaAtual(Integer.parseInt(parcelas[0]));
                aux.setParcela(Integer.parseInt(parcelas[1]));
                aux.setValor(new BigDecimal(vetorString[7]));
                aux.setTipoEntrada(TipoEntrada.valueOf(vetorString[8]));
                aux.setRepetitivo(Boolean.parseBoolean(vetorString[9]));
                receitaDespesas.add(aux);
            }
            br.close();
            return receitaDespesas;
        } catch (Exception erro) {
            throw erro;
        }
    }

}
