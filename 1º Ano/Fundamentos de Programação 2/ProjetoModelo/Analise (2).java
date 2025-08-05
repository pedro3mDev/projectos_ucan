/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: Analise.java
Data: 20.05.2024
--------------------------------------*/

/*
1. Objectivo
Este projecto tem o objectivo de registar a entrada e saida de cadaveres 
e sua respectiva localização dentro de uma morgue (casa mortuaria).

2. Visao [Interfaces Graficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipal
- CadaverVisao
- EntradaVisao
- SaidaVisao

3. Entidades Fortes e Seus Atributos (Modelo)
- CadaverModelo
	int id
	String nome
	String tipo_documento  [Fk]
	String numero_documento
	String dataNascimento
	String nacionalidade [Fk]
	String genero
- EntradaModelo
	int id
	CadaverModelo cadaver  [Fk]
	String dataMorte
	String causaMorte [Fk]
	String dataEntrada
	String horaEntrada
	String nomeFamiliar
	String telefone
	String nomeFuncionario [Fk]
	int numero_gaveta 
	
- SaidaModelo
	int id
	EntradaModelo entrada
	String dataSaida
	String horaSaida
	String nomeFamiliar
	String telefone
	String nomeFuncionario [Fk]
	
4. Ficheiro | persistencia de dados
- CadaverFile.dat
- EntradaFile.dat
- SaidaFile.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Nacionalidades.tab
- Funcionarios.tab
- TipoDocumentos.tab
- CausaDaMorte.tab

6. Diversos
6.1 - Implementação: Java Swing
6.2 - IDE: Notepad++
*/