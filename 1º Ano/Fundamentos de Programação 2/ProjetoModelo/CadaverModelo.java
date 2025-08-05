/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: CadaverModelo.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class CadaverModelo implements RegistGeneric
{
	int id;
	StringBufferModelo nome, estadoCivil, nacionalidade, tipo_documento, 
		numero_documento;
	StringBufferModelo genero, provincia, municipio, comuna;
	DataModelo dataNascimento;
	
	public CadaverModelo()
	{
		id = 0;
		nome = new StringBufferModelo("", 50); 
		estadoCivil = new StringBufferModelo("", 15);
		nacionalidade = new StringBufferModelo("", 20);
		tipo_documento = new StringBufferModelo("", 20);
		numero_documento = new StringBufferModelo("", 15);
		dataNascimento = new DataModelo();
		genero = new StringBufferModelo("", 10);
		provincia = new StringBufferModelo("", 20);
		municipio = new StringBufferModelo("", 20);
		comuna = new StringBufferModelo("", 20);
	}
	public CadaverModelo(int id, String nome, String estadoCivil, String nacionalidade,
		String tipo_documento, String numero_documento, String dataNascimento, 
		String genero, String provincia, String municipio, String comuna)
	{
		this.id = id;
		this.nome = new StringBufferModelo(nome, 50); 
		this.estadoCivil = new StringBufferModelo(estadoCivil, 15);
		this.nacionalidade = new StringBufferModelo(nacionalidade, 20);
		this.tipo_documento = new StringBufferModelo(tipo_documento, 20);
		this.numero_documento = new StringBufferModelo(numero_documento, 15);
		this.dataNascimento = new DataModelo(dataNascimento);
		this.genero = new StringBufferModelo(genero, 10);
		this.provincia = new StringBufferModelo(provincia, 20);
		this.municipio = new StringBufferModelo(municipio, 20);
		this.comuna = new StringBufferModelo(comuna, 20);
	}
	
	//--- metodos get
	public int getId()
	{
		return id;
	}
	public String getNome()
	{
		return nome.toStringEliminatingSpaces();
	}
	public String getEstadoCivil()
	{
		return estadoCivil.toStringEliminatingSpaces();
	}
	public String getNacionalidade()
	{
		return nacionalidade.toStringEliminatingSpaces();
	}
	public String getTipoDocumento()
	{
		return tipo_documento.toStringEliminatingSpaces();
	}
	public String getNumeroDocumento()
	{
		return numero_documento.toStringEliminatingSpaces();
	}
	public String getDataNascimento()
	{
		return dataNascimento.toString();
	}
	public String getGenero()
	{
		return genero.toStringEliminatingSpaces();
	}
	public String getProvincia()
	{
		return provincia.toStringEliminatingSpaces();
	}
	public String getMunicipio()
	{
		return municipio.toStringEliminatingSpaces();
	}
	public String getComuna()
	{
		return comuna.toStringEliminatingSpaces();
	}
	
	//--- metodos set
	public void setId(int novoId)
	{
		id = novoId;
	}
	public void setNome(String novoNome)
	{
		nome = new StringBufferModelo(novoNome, 50);
	}
	public void setEstadoCivil(String novoEstadoCivil)
	{
		estadoCivil = new StringBufferModelo(novoEstadoCivil, 15);
	}
	public void setNacionalidade(String novaNacionalidade)
	{
		nacionalidade = new StringBufferModelo(novaNacionalidade, 20);
	}
	public void setTipoDocumento(String novoTipoDocumento)
	{
		tipo_documento = new StringBufferModelo(novoTipoDocumento, 20);
	}
	public void setNumeroDocumento(String novoNumeroDocumento)
	{
		numero_documento = new StringBufferModelo(novoNumeroDocumento, 15);
	}
	public void setDataNascimento(String novaData)
	{
		dataNascimento = new DataModelo( novaData );
	}
	public void setGenero(String novoGenero)
	{
		genero = new StringBufferModelo(novoGenero, 10);
	}
	public void setProvincia(String novaProvincia)
	{
		provincia = new StringBufferModelo(novaProvincia, 20);
	}
	public void setMunicipio(String novoMunicipio)
	{
		municipio = new StringBufferModelo(novoMunicipio, 20);
	}
	public void setComuna(String novaComuna)
	{
		comuna = new StringBufferModelo(novaComuna, 20);
	}
	
	//--- toString
	public String toString ()
	{
		String str = "Dados do Cadaver Modelo\n\n";

		str += "Id: " + getId() + "\n";
		str += "Nome: " + getNome() + "\n";
		str += "Estado Civil: " + getEstadoCivil() + "\n";
		str += "Nacionalidade: " + getNacionalidade() + "\n";
		str += "Tipo de Documento: " + getTipoDocumento() + "\n";
		str += "Numero do Documento: " + getNumeroDocumento() + "\n";
		str += "Data de Nascimento: " + getDataNascimento() + "\n";
		str += "Genero: " + getGenero() + "\n";
		str += "Provincia: " + getProvincia() + "\n";
		str += "Municipio: " + getMunicipio() + "\n";
		str += "Comuna: " + getComuna() + "\n";
		
		return str;
	}
	
	// calcula o tamanho geral de cada registo/modelo
	public long sizeof()
	{		
		try
		{
			return 190 * 2 + 4 + 12; // 396	
		}
		catch(Exception ex)
		{
			return 0;
		}
				
	}
	
	public void write(RandomAccessFile stream)
	{
		try
		{
			stream.writeInt(id);
			nome.write(stream); 
			estadoCivil.write(stream);
			nacionalidade.write(stream);
			tipo_documento.write(stream);
			numero_documento.write(stream);
			dataNascimento.write(stream);
			genero.write(stream);
			provincia.write(stream);
			municipio.write(stream);
			comuna.write(stream);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao tentar Escrever no Ficheiro");
		}
	}
	public void read(RandomAccessFile stream)
	{
		try
		{
			id = stream.readInt();
			nome.read(stream); 
			estadoCivil.read(stream);
			nacionalidade.read(stream);
			tipo_documento.read(stream);
			numero_documento.read(stream);
			dataNascimento.read(stream);
			genero.read(stream);
			provincia.read(stream);
			municipio.read(stream);
			comuna.read(stream);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao tentar Ler no Ficheiro");
		}
	}
	
	public void salvar()
	{
		CadaverFile file = new CadaverFile();
		file.salvarDados(this);
	}
	
}