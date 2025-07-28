package hrGest.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FicheiroUtil {

    public static List<String> carregarLinhas(String caminho) {
        List<String> linhas = new ArrayList<>();
        File file = new File(caminho);
        if (!file.exists()) return linhas;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    linhas.add(linha.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }
}
