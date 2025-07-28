/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: MenuPrincipal.java
Data: 19.06.2025
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame implements ActionListener
{	
	private JMenu ficheiroMenu, operacoesMenu, listagensMenu, tabelasMenu, ajudaMenu;
	private JMenuItem novoCadaverItem, alterarCadaverItem, eliminarCadaverItem, sairItem;
	private JMenuItem novaEntradaItem, alterarEntradaItem, eliminarEntradaItem;
	private JMenuItem saidaCadaverItem, alterarSaidaItem, eliminarSaidaItem;
	private JMenuItem listarCadaversItem, listarEntradasItem, listarSaidasItem;
	private JMenuItem nacionalidadesItem, estadoCivilItem, causaDaMorteItem,
			tipoDocumentosItem, provinciaItem, municipioItem, comunaItem;
	private JMenuItem ajudaSobreAutorItem, ajudaSobreAplicacaoItem;
	private JMenuBar menuBar;
	
	public MenuPrincipal()
	{		
		super("Menu Principal");
		
		menuBar = new JMenuBar();
		
		adicionarComponentes();
			
		
		setJMenuBar( menuBar );
		
		setSize(800, 700);
		setLocationRelativeTo(null);	//alinhar ao centro
		setVisible(true);
	}
	
	public void adicionarComponentes()
	{
		menuBar.add( ficheiroMenu = new JMenu("Ficheiro") );
		ficheiroMenu.setMnemonic('F');
		menuBar.add( operacoesMenu = new JMenu("Operacoes") );
		operacoesMenu.setMnemonic('O');
		menuBar.add( listagensMenu = new JMenu("Listagens") );
		listagensMenu.setMnemonic('L');
		menuBar.add( tabelasMenu = new JMenu("Tabelas") );
		tabelasMenu.setMnemonic('T');
		menuBar.add( ajudaMenu = new JMenu("Ajuda") );
		ajudaMenu.setMnemonic('A');
		
		ficheiroMenu.add( novoCadaverItem = new JMenuItem("Novo Cadaver"));
		ficheiroMenu.add( alterarCadaverItem = new JMenuItem("Alterar Cadaver"));
		ficheiroMenu.add( eliminarCadaverItem = new JMenuItem("Eliminar Cadaver"));
		ficheiroMenu.addSeparator();
		ficheiroMenu.add( sairItem = new JMenuItem("Sair"));
		
		operacoesMenu.add( novaEntradaItem = new JMenuItem("Nova Entrada") );
		operacoesMenu.add( alterarEntradaItem = new JMenuItem("Alterar Entrada") );
		operacoesMenu.add( eliminarEntradaItem = new JMenuItem("Eliminar Entrada") );
		
		operacoesMenu.addSeparator();
		
		operacoesMenu.add( saidaCadaverItem = new JMenuItem("Nova Saida") );
		operacoesMenu.add( alterarSaidaItem  = new JMenuItem("Alterar Saida") );
		operacoesMenu.add( eliminarSaidaItem  = new JMenuItem("Eliminar Saida") );
		
		listagensMenu.add( listarCadaversItem = new JMenuItem("Listar Cadavers"));
		listagensMenu.add( listarEntradasItem = new JMenuItem("Listar Entradas"));
		listagensMenu.add( listarSaidasItem = new JMenuItem("Listar Saidas"));
		
		tabelasMenu.add( nacionalidadesItem = new JMenuItem("Nacionalidade") );
		tabelasMenu.add( estadoCivilItem = new JMenuItem("Estado Civil") );
		tabelasMenu.add( causaDaMorteItem = new JMenuItem("Causas de Morte"));
		tabelasMenu.add( tipoDocumentosItem = new JMenuItem("Tipo de Documentos") );
		tabelasMenu.add( provinciaItem = new JMenuItem("Provincias") );
		tabelasMenu.add( municipioItem = new JMenuItem("Municipios") );
		tabelasMenu.add( comunaItem = new JMenuItem("Comunas") );
		
		ajudaMenu.add( ajudaSobreAutorItem = new JMenuItem("Sobre o Autor") );
		ajudaMenu.add( ajudaSobreAplicacaoItem  = new JMenuItem("Sobre a Aplicacao") );
	
		//adicionar evento aos menus
		novoCadaverItem.addActionListener( this );
		sairItem.addActionListener( this );
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == novoCadaverItem)
			JOptionPane.showMessageDialog(null, "Novo Cadaver");
		else
			dispose();
	}
	
	public static void main(String args[])
	{
		new MenuPrincipal();
	}
}