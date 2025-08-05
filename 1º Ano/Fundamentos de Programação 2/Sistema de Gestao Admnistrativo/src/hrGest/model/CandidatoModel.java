package hrGest.model;

public class CandidatoModel {
    private String codigo;
    private String nome;
    private String sobreNome;
    private String genero;
    private String salarioDesejado;
    private String aniversario;
    private String vaga;
    private String habilidade;

    public CandidatoModel(String codigo, String nome, String sobreNome, String genero, String salarioDesejado, String aniversario, String vaga, String habilidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.genero = genero;
        this.salarioDesejado = salarioDesejado;
        this.aniversario = aniversario;
        this.vaga = vaga;
        this.habilidade = habilidade;
    }

    public String toLinhaTexto() {
        return String.join(";",
                codigo, nome, sobreNome, genero, salarioDesejado, aniversario, vaga, habilidade
        );
    }

    public static CandidatoModel fromLinhaTexto(String linha) {
        String[] partes = linha.split(";");
        return new CandidatoModel(
                partes[0], partes[1], partes[2],
                partes[3], partes[4], partes[5],
                partes[6], partes[7]
        );
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setSalarioDesejado(String salarioDesejado) {
        this.salarioDesejado = salarioDesejado;
    }
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
    public void setVaga(String vaga) {
        this.vaga = vaga;
    }
    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }



    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getSobreNome() {
        return sobreNome;
    }
    public String getGenero() {
        return genero;
    }
    public String getSalarioDesejado() {
        return salarioDesejado;
    }
    public String getAniversario() {
        return aniversario;
    }
    public String getVaga() {
        return vaga;
    }
    public String getHabilidade() {
        return habilidade;
    }



}
