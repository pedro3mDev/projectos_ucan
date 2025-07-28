/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: CadaverModelo.java
Data: 19.06.2025
--------------------------------------*/

public class CadaverModelo
{	
	private int id;
	private String nome, tipo_documento, numero_documento, 
		dataNascimento, nacionalidade, estadoCivil, genero;
	
	public CadaverModelo()
	{
		id = 0;
		nome = " ";
		tipo_documento = " ";
		numero_documento = " ";
		dataNascimento = " ";
		nacionalidade = " ";
		estadoCivil = " ";
		genero = " ";
	}
	
	public CadaverModelo(int id, String nome, String tipo_documento,
		String numero_documento, String dataNascimento, String nacionalidade,
		String estadoCivil, String genero)
	{
		this.id = id;
		this.nome = nome;
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.estadoCivil = estadoCivil;
		this.genero = genero;
	}

	//---- metodos get
	public int getId()
	{
		return id;
	}
	public String getNome()
	{
		return nome;
	}
	public String getTipoDocumento()
	{
		return tipo_documento;
	}
	public String getNumeroDocumento()
	{
		return numero_documento;
	}
	public String getDataNascimento()
	{
		return dataNascimento;
	}
	public String getNacionalidade()
	{
		return nacionalidade;
	}
	public String getEstadoCivil()
	{
		return estadoCivil;
	}
	public String getGenero()
	{
		return genero;
	}
	//---- metodos set
	public void setId(int id)
	{
		this.id = id;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	public void setTipoDocumento(String tipo_documento)
	{
		this.tipo_documento = tipo_documento;
	}
	public void setNumeroDocumento(String numero_documento)
	{
		this.numero_documento = numero_documento;
	}
	public void setDataNascimento(String dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
	public void setNacionalidade(String nacionalidade)
	{
		this.nacionalidade = nacionalidade;
	}
	public void setEstadoCivil(String estadoCivil)
	{
		this.estadoCivil = estadoCivil;
	}
	public void setGenero(String genero)
	{
		this.genero = genero;
	}
	
	//---- metodo toString
	public String toString()
	{
		String str = "Dados do Cadaver Modelo \n";
		
		str += "Id: " + getId() + "\n";
		str += "Nome: " + getNome() + "\n";
		str += "Tipo de Documento: " + getTipoDocumento() + "\n";
		str += "Numero do Documento " + getNumeroDocumento() + "\n";
		str += "Data de Nascimento; " + getDataNascimento() + "\n";
		str += "Nacionalidade: " + getNacionalidade() + "\n";
		str += "Estado Civil: " + getEstadoCivil() + "\n";
		str += "Genero: " + getGenero() + "\n";
		
		return str;
	}
}