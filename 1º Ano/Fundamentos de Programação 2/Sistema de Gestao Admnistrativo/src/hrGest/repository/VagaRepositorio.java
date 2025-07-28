package hrGest.repository;
import hrGest.model.VagaModel;
import hrGest.util.FicheiroUtil;

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

    public static void editar(VagaModel vagaEditada) {
        List<VagaModel> vagas = carregar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_FICHEIRO))) {
            for (VagaModel vaga : vagas) {
                if (vaga.getCodigo().equals(vagaEditada.getCodigo())) {
                    writer.write(vagaEditada.toLinhaTexto()); // escreve os dados atualizados
                } else {
                    writer.write(vaga.toLinhaTexto()); // mantém os dados antigos
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // VagaRepositorio.java
    public static void eliminarVaga(String codigo) {
        List<VagaModel> vagas = carregar();
        List<String> linhasAtualizadas = new ArrayList<>();

        for (VagaModel v : vagas) {
            if (!v.getCodigo().equals(codigo)) {
                String linha = String.join(";",
                        v.getCodigo(), v.getNome(), v.getDescricao(),
                        v.getMotivo(), v.getCargo(), v.getDepartamento(),
                        String.valueOf(v.getQuantidade())
                );
                linhasAtualizadas.add(linha);
            }
        }

        FicheiroUtil.substituirTudo(CAMINHO_FICHEIRO, linhasAtualizadas);
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
