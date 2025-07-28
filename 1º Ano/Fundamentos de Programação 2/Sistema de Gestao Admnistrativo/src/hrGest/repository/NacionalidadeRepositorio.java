package hrGest.repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NacionalidadeRepositorio {

    private static final String CAMINHO = "bd/nacionalidades.txt";

    public List<String[]> listar() {
        List<String[]> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    lista.add(partes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
