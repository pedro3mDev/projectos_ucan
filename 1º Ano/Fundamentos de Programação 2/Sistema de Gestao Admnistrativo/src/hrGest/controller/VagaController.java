package hrGest.controller;
import hrGest.repository.VagaRepositorio;
import hrGest.model.VagaModel;
import java.util.List;

public class VagaController {

    public void adicionarVaga(VagaModel vaga) {
        VagaRepositorio.salvar(vaga);
    }

    private String gerarCodigoAutomatico() {
        List<VagaModel> vagas = VagaRepositorio.carregar();
        return "VAGA" + (vagas.size() + 1);
    }

    public List<VagaModel> listarVagas() {
        return VagaRepositorio.carregar();
    }
}
