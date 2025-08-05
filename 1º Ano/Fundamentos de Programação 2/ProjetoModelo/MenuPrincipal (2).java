/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: MenuPrincipal.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;


public class MenuPrincipal extends JFrame implements ActionListener
{
	
	private JMenuBar menuBar;
	private JMenu ficheiroMenu, operacoesMenu, tabelasMenu, ajudaMenu;
	private JMenuItem novoCadaverItem, editarCadaverItem, eliminarCadaverItem, sair;
	private JMenuItem novaEntradaItem, novaSaidaItem;
	private JMenuItem nacionalidadeItem, funcionariosItem, tipoDocumentosItem, causasMorteItem, 
					provinciaMoradaItem, municipioMoradaItem, comunaMoradaItem;
	private JMenuItem ajudaAplicacaoItem, ajudaAutorItem;
	
	public MenuPrincipal()
	{
		instanciarObjectos();
		
		setJMenuBar( menuBar );
		
		setTitle("Menu Principal");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void instanciarObjectos()
	{
		menuBar = new JMenuBar();
		
		ficheiroMenu = new JMenu("Ficheiro");
		ficheiroMenu.setMnemonic('F');
		operacoesMenu = new JMenu("Operacoes");
		operacoesMenu.setMnemonic('O');
		tabelasMenu = new JMenu("Tabelas");
		tabelasMenu.setMnemonic('T');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		//adicionar os menus na barra de Menu
		menuBar.add(ficheiroMenu);
		menuBar.add(operacoesMenu);
		menuBar.add(tabelasMenu);
		menuBar.add(ajudaMenu);
		
		//itens do Menu Ficheiro		
		ficheiroMenu.add( novoCadaverItem = new JMenuItem("Novo Cadaver") );
		novoCadaverItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		ficheiroMenu.add( editarCadaverItem = new JMenuItem("Editar Cadaver") );
		ficheiroMenu.add( eliminarCadaverItem = new JMenuItem("Eliminar Cadaver") );
		ficheiroMenu.addSeparator();
		ficheiroMenu.add( sair = new JMenuItem("Sair") );
		sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		//itens do Menu operacoes
		operacoesMenu.add( novaEntradaItem = new JMenuItem("Nova Entrada"));
		operacoesMenu.addSeparator();
		operacoesMenu.add( novaSaidaItem = new JMenuItem("Nova Saida"));
		
		
		//itens do Menu Tabelas
		tabelasMenu.add( nacionalidadeItem = new JMenuItem("Nacionalidades") );
		tabelasMenu.add( funcionariosItem = new JMenuItem("Funcionarios") );
		tabelasMenu.add( tipoDocumentosItem = new JMenuItem("Tipos de Documentos") );
		tabelasMenu.add( causasMorteItem = new JMenuItem("Causas De Morte") );
		
		tabelasMenu.add( provinciaMoradaItem = new JMenuItem("Provincias") );
		tabelasMenu.add( municipioMoradaItem = new JMenuItem("Municipios") );
		tabelasMenu.add( comunaMoradaItem = new JMenuItem("Comunas") );
		
		//itens do Menu Ajuda		
		ajudaMenu.add( ajudaAplicacaoItem = new JMenuItem("Sobre o Software") );
		ajudaMenu.addSeparator();
		ajudaMenu.add( ajudaAutorItem = new JMenuItem("Sobre o Autor") );
		
		//registar o manipulador de eventos aos items
		novoCadaverItem.addActionListener(this);
		sair.addActionListener(this); 
		ajudaAutorItem.addActionListener(this);	

		nacionalidadeItem.addActionListener(this);
		funcionariosItem.addActionListener(this);
		tipoDocumentosItem.addActionListener(this);
		causasMorteItem.addActionListener(this);
		provinciaMoradaItem.addActionListener(this);
		municipioMoradaItem.addActionListener(this);
		comunaMoradaItem.addActionListener(this);
	}
	
	// manipulacao dos eventos
	public void actionPerformed(ActionEvent evt)
	{
		
		if (evt.getSource() == novoCadaverItem)
			new CadaverVisao();
		if (evt.getSource() == nacionalidadeItem)
			Tabela2.editarNovosItems("Nacionalidades.tab", "Nova Nacionalidade");
		if (evt.getSource() == funcionariosItem)
			Tabela2.editarNovosItems("Funcionarios.tab", "Novo Funcionario");
		if (evt.getSource() == tipoDocumentosItem)
			Tabela2.editarNovosItems("TipoDocumentos.tab", "Novo Tipo de Documento");
		if (evt.getSource() == causasMorteItem)
			Tabela2.editarNovosItems("CausaDaMorte.tab", "Nova Causa de Morte");
		
		if (evt.getSource() == provinciaMoradaItem)
			Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
		if (evt.getSource() == municipioMoradaItem)
			Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", 
				"Provincias", "Municipios", "Novo Municipio");
		if (evt.getSource() == comunaMoradaItem)
			Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab", "Comunas.tab", 
				"Provincias", "Municipios", "Comunas", "Nova Comuna");
				
		else if (evt.getSource() == sair)
				dispose();
		else if (evt.getSource() == ajudaAutorItem)
			JOptionPane.showMessageDialog(null, "Autor: Osvaldo Ramos");
		
	}
	
	public static void main(String[] args)
	{
		Vector_Tabelas.inic();	//cria a conexao do projecto com a API SWINGCOMPONENTS
		new MenuPrincipal();
	}
}