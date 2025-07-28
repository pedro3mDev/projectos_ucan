package hrGest.model;

public class VagaModel {
    private String codigo;
    private String nome;
    private String descricao;
    private String motivo;
    private String cargo;
    private String departamento;
    private int quantidade;

    public VagaModel(String codigo, String nome, String descricao, String motivo, String cargo, String departamento, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.motivo = motivo;
        this.cargo = cargo;
        this.departamento = departamento;
        this.quantidade = quantidade;
    }

    public String toLinhaTexto() {
        return String.join(";",
                codigo, nome, descricao, motivo, cargo, departamento, String.valueOf(quantidade)
        );
    }

    public static VagaModel fromLinhaTexto(String linha) {
        String[] partes = linha.split(";");
        return new VagaModel(
                partes[0], partes[1], partes[2],
                partes[3], partes[4], partes[5],
                Integer.parseInt(partes[6])
        );
    }
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
