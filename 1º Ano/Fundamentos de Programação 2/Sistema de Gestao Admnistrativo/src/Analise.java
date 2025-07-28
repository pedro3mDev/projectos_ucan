/*------------------------------------
Tema: Gestão de Recursos Humanos (Recrutamento e Selecçao)
Nome: Pedro Moniz
Numero: 17285
Ficheiro: Analise.java
Data: 28.07.2025
--------------------------------------*

/*
1. Objectivo
Este projecto tem o objectivo fazer o Gerenciamento de Recursos Humanos de Qualquer Empresa.





2. Visao [Interfaces Graficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipal
- CadaverVisao
- EntradaVisao
- SaidaVisao





3. Entidades Fortes e Seus Atributos (Modelo)
- FuncionarioModelo
	int id
	String nomeFuncionario
	String sobrenomeFuncionario
	String generoFuncionario
	String emailFuncionario
    String telefoneFuncionario
    String dataNascimentoFuncionario
	String nacionalidade
    String cargo
    String departamento
	String estadoCivil
	boolean status
- CampanhaModelo
	int id
	String nomeCampanha
    String descriçãoCampanha
	String cargo
	String dataInicioCampanha
	String dataFimCampanha
    String motivo
	boolean status
- CandidaturaModelo
	int id
	String nomeCampanha
    String nomeCandidato
	String sobrenomeCandidato
	String generoCandidato
	String emailCandidato
    String telefoneCandidato
    String dataNascimentoCandidato
	String nacionalidade
    String cargo
    String departamento
	String estadoCivil
	String esperienciaTrabalho
	String nivelAcademico
	boolean status
- EntrevistaModelo
	int id
	String nomeEntrevista
    String dataEntrevista
	String nomeCandidato
	String emailCandidato
    String telefoneCandidato
	boolean status

- EntradaModelo
- SaidaModelo





4. Ficheiro





5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Nacionalidades.tab
- EstadoCivil.tab
- Provincia.tab
- MotivoCampanha.tab
- Municipio.tab
- Comuna.tab
- EsperienciaTrabalho.tab
- NivelAcademico.tab





6. Listagens e Pesquisas
-Listagem geral de Funcionarios
-Pesquisar Cadaver por Nome

7. Diversos
7.1 - Implementação: Java Swing
7.2 - IDE: Bloco de Notas
*/
