package modelos.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelos.entidades.Categoria;
import modelos.interfaces.CategoriaDao;

public class CategoriaDaoImpl implements CategoriaDao{
    
    private String nomeDoArquivoNoDisco = "./ArquivoDeDados/Categoria.txt";

    @Override
    public void incluir(Categoria categoria) throws Exception {
        try {
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(categoria.toString() + "\n");
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Categoria categoria) throws Exception {
        ArrayList<Categoria> categorias = listagem();
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            for (int pos = 0; pos < categorias.size(); pos++) {
                if(categoria.getId() != categorias.get(pos).getId()){
                    bw.write(categorias.get(pos).toString()+"\n");
                }
            }
            bw.write(categoria.toString() + "\n"); 
           bw.close(); 
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void apagarPorId(int id) throws Exception {
       try {
            ArrayList<Categoria> categorias = listagem();
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int pos = 0; pos < categorias.size(); pos++) {
                if (id != categorias.get(pos).getId()) {
                    bw.write(categorias.get(pos).toString() + "\n");
                }
            }
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public Categoria consultarPorId(int id) throws Exception {
        Categoria aux = new Categoria();
        FileReader fr = new FileReader(nomeDoArquivoNoDisco);
        BufferedReader br = new BufferedReader(fr);
        try {
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setNome(vetorString[1]);
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
    public ArrayList<Categoria> listagem() throws Exception {
        try {
            ArrayList<Categoria> categorias = new ArrayList<Categoria>();
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Categoria aux = new Categoria();
                String vetorString[] = linha.split(";");
                aux.setId(Integer.parseInt(vetorString[0]));
                aux.setNome(vetorString[1]);
                categorias.add(aux);
            }
            br.close();
            return categorias;
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
