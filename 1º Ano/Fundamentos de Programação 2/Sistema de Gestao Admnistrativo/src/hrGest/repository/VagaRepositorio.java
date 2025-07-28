package hrGest.repository;
import hrGest.model.VagaModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VagaRepositorio {

    private static final String CAMINHO_FICHEIRO = "bd/vaga.txt";

    public static void salvar(VagaModel vaga) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_FICHEIRO, true))) {
            writer.write(vaga.toLinhaTexto());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<VagaModel> carregar() {
        List<VagaModel> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_FICHEIRO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(VagaModel.fromLinhaTexto(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
