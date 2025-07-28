package hrGest.controller;
import hrGest.repository.VagaRepositorio;
import hrGest.model.VagaModel;
import java.util.List;

public class VagaController {

    public void adicionarVaga(VagaModel vaga) {
        VagaRepositorio.salvar(vaga);
    }

    public void editarVaga(VagaModel vagaAtualizada) {
        VagaRepositorio.editar(vagaAtualizada);
    }

    // VagaController.java
    public static void eliminarVaga(String codigo) {
        VagaRepositorio.eliminarVaga(codigo);
    }


    public List<VagaModel> listarVagas() {
        return VagaRepositorio.carregar();
    }

    private String gerarCodigoAutomatico() {
        List<VagaModel> vagas = VagaRepositorio.carregar();
        return "VAGA" + (vagas.size() + 1);
    }

}
