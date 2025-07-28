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

    public static void substituirTudo(String caminho, List<String> novasLinhas) {
        File file = new File(caminho);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String linha : novasLinhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
