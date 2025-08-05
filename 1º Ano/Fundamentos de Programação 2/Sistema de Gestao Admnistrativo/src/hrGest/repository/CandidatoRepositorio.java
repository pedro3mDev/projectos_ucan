package hrGest.repository;
import hrGest.model.CandidatoModel;
import hrGest.util.FicheiroUtil;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CandidatoRepositorio {

    private static final String CAMINHO_FICHEIRO = "bd/candidato.txt";

    public static void salvar(CandidatoModel candidato) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_FICHEIRO, true))) {
            writer.write(candidato.toLinhaTexto());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editar(CandidatoModel candidatoEditado) {
        List<CandidatoModel> candidatos = carregar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_FICHEIRO))) {
            for (CandidatoModel candidato : candidatos) {
                if (candidato.getCodigo().equals( candidatoEditado.getCodigo())) {
                    writer.write(candidatoEditado.toLinhaTexto()); // escreve os dados atualizados
                } else {
                    writer.write(candidato.toLinhaTexto()); // mantém os dados antigos
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarCandidato(String codigo) {
        List<CandidatoModel> candidatos = carregar();
        List<String> linhasAtualizadas = new ArrayList<>();

        for (CandidatoModel c : candidatos) {
            if (!c.getCodigo().equals(codigo)) {
                String linha = String.join(";",
                        c.getCodigo(), c.getNome(), c.getSobreNome(),
                        c.getGenero(), c.getGenero(), c.getDepartamento(),
                        String.valueOf(c.getQuantidade())
                );
                linhasAtualizadas.add(linha);
            }
        }

        FicheiroUtil.substituirTudo(CAMINHO_FICHEIRO, linhasAtualizadas);
    }


    public static List<CandidatoModel> carregar() {
        List<CandidatoModel> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_FICHEIRO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(CandidatoModel.fromLinhaTexto(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
