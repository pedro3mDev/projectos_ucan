/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: MenuPrincipal.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;


public class MenuPrincipal extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	
	private JMenu ficheiroMenu, operacoesMenu, listagensMenu, tabelasMenu, ajudaMenu;
	private JMenuItem novoCadaverItem, editarCadaverItem, eliminarCadaverItem, sairItem;
	private JMenuItem novaEntrada, novaSaida;
	private JMenuItem listarCadaversItem, pesquisarCadaverItem;
	private JMenuItem nacionalidadesItem, estadoCivilItem, causaMorteItem, 
			provinciaMoradaItem, municipioMoradaItem, comunaMoradaItem, tipoDocumentosItem; 
	
	public MenuPrincipal(String user)
	{
		super("Menu Principal | Operador: " + user);
		
		instanciarObjectos();
		
		setJMenuBar( menuBar );
		
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
		listagensMenu = new JMenu("Listagens/Pesquisas");
		listagensMenu.setMnemonic('L');
		tabelasMenu = new JMenu("Tabelas");
		tabelasMenu.setMnemonic('T');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		novoCadaverItem = new JMenuItem("Novo Cadaver");
		novoCadaverItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		editarCadaverItem = new JMenuItem("Editar Cadaver");
		eliminarCadaverItem = new JMenuItem("Eliminar Cadaver");
		sairItem = new JMenuItem("Sair");
		sairItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		//items do menu ficheiro 
		ficheiroMenu.add(novoCadaverItem);
		ficheiroMenu.add(editarCadaverItem);
		ficheiroMenu.add(eliminarCadaverItem);
		ficheiroMenu.addSeparator();
		ficheiroMenu.add(sairItem);
		
		//items do menu operacoes 
		novaEntrada = new JMenuItem("Registar Entrada");
		novaSaida = new JMenuItem("Registar Saida");
		
		operacoesMenu.add(novaEntrada);
		operacoesMenu.add(novaSaida);
		
		//items do menu listagem
		listagensMenu.add( listarCadaversItem = new JMenuItem("Listar Cadavers"));
		listagensMenu.addSeparator();
		listagensMenu.add( pesquisarCadaverItem  = new JMenuItem("Pesquisar Cadavers"));
		
		//items do menu Tabelas 
		nacionalidadesItem = new JMenuItem("Nacionalidades");
		provinciaMoradaItem = new JMenuItem("Provincias");
		municipioMoradaItem = new JMenuItem("Municipios");
		comunaMoradaItem  = new JMenuItem("Comunas");
		estadoCivilItem = new JMenuItem("Estado Civil");
		causaMorteItem  = new JMenuItem("Causas de Morte");
		tipoDocumentosItem = new JMenuItem("Tipos de Documentos");
		
		tabelasMenu.add(nacionalidadesItem);
		tabelasMenu.add(provinciaMoradaItem);
		tabelasMenu.add(municipioMoradaItem);
		tabelasMenu.add(comunaMoradaItem);
		tabelasMenu.add(estadoCivilItem);
		tabelasMenu.add(causaMorteItem);
		tabelasMenu.add(tipoDocumentosItem);
	
		
		menuBar.add(ficheiroMenu);
		menuBar.add(operacoesMenu);
		menuBar.add(listagensMenu);		
		menuBar.add(tabelasMenu);
		menuBar.add(ajudaMenu);
		
		novoCadaverItem.addActionListener(this);
		editarCadaverItem.addActionListener(this);
		sairItem.addActionListener(this);
		listarCadaversItem.addActionListener(this);
		nacionalidadesItem.addActionListener(this);
		provinciaMoradaItem.addActionListener(this);
		municipioMoradaItem.addActionListener(this);
		comunaMoradaItem.addActionListener(this);
		estadoCivilItem.addActionListener(this);
		causaMorteItem.addActionListener(this);
		tipoDocumentosItem.addActionListener(this);
		pesquisarCadaverItem.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		
		if (evt.getSource() == novoCadaverItem)
			new CadaverVisao(false, new CadaverModelo() );
		
		else if (evt.getSource() == editarCadaverItem)
			new EditarCadaver();
		if (evt.getSource() == nacionalidadesItem)
			Tabela2.editarNovosItems("Nacionalidades.tab", "Nova Nacionalidade");
		if (evt.getSource() == causaMorteItem)
			Tabela2.editarNovosItems("CausaDaMorte.tab", "Nova Causa de Morte");
		if (evt.getSource() == estadoCivilItem)
			Tabela2.editarNovosItems("EstadoCivil.tab", "Novo Estado Civil");
		if (evt.getSource() == tipoDocumentosItem)
			Tabela2.editarNovosItems("TipoDocumentos.tab", "Tipos de Documentos");
		if (evt.getSource() == listarCadaversItem)
			CadaverFile.listarCadavers();		
		if (evt.getSource() == pesquisarCadaverItem)
			new PesquisarCadaver();	
		if (evt.getSource() == provinciaMoradaItem)
			Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
		if (evt.getSource() == municipioMoradaItem)
			Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", "Provincias", "Municipios", "Novo Municipio");
		if (evt.getSource() == comunaMoradaItem)
			Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab", "Comunas.tab", "Provincias", "Municipios", "Comunas", "Nova Comuna");
		
		else if (evt.getSource() == sairItem)
			dispose();
		
	}
	
	/*public static void main(String args[])
	{
		
		new MenuPrincipal();
	}*/
}