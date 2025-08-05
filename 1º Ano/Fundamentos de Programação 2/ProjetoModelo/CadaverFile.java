/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: CadaverFile.java
Data: 31.05.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class CadaverFile extends ObjectsFile
{
	
	public CadaverFile()
	{
		super("CadaverFile.dat", new CadaverModelo() );
	}
	
	public void salvarDados(CadaverModelo modelo)
	{
		try
		{
			//colocar o File Pointer no final do ficheiro
			stream.seek( stream.length() );
			
			//escrever os dados no ficheiro
			modelo.write(stream);
			
			incrementarProximoCodigo();
			
			JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao Salvar um Novo Cadaver");
		}
	}
	
	public static void listarCadavers()
	{
		CadaverFile ficheiro = new CadaverFile();
		CadaverModelo modelo = new CadaverModelo();
		String output = "Listagem de Dados do Ficheiro\n\n";
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				output += "---------------------------------\n";
				output += modelo.toString() + "\n";
			}
						
			JTextArea area = new JTextArea(40, 60);
			area.setText( output );
			area.setFocusable(false);
			JOptionPane.showMessageDialog(null, new JScrollPane( area ), 
					"Gestao de Morgue", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	public static StringVector getAllNames()
	{
		CadaverFile ficheiro = new CadaverFile();
		CadaverModelo modelo = new CadaverModelo();
		StringVector vector = new StringVector();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				vector.add( modelo.getNome() );
			}
						
			vector.sort();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	
		return vector;
	}
	
	public static CadaverModelo getCadaverPorNome(String nomeProcurado)
	{
		CadaverFile ficheiro = new CadaverFile();
		CadaverModelo modelo = new CadaverModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNome().equalsIgnoreCase( nomeProcurado ) )
					return modelo;
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return modelo;	
	}
	public static void pesquisarCadaverPorNome(String nomeProcurado)
	{
		CadaverFile ficheiro = new CadaverFile();
		CadaverModelo modelo = new CadaverModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNome().equalsIgnoreCase( nomeProcurado ) )
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"Gestao de Morgue", JOptionPane.INFORMATION_MESSAGE);
					break;					
				}
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	public static void pesquisarCadaverPorDocumento(String documentoProcurado)
	{
		CadaverFile ficheiro = new CadaverFile();
		CadaverModelo modelo = new CadaverModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNumeroDocumento().equalsIgnoreCase( documentoProcurado ) )
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"Gestao de Morgue", JOptionPane.INFORMATION_MESSAGE);
					break;					
				}
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
}