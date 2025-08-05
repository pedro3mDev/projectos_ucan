/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Pedro Moniz Ramos
Numero: 17285
Ficheiro: Login.java
--------------------------------------*/
package hrGest.view;
import hrGest.view.tabelas.*;
import hrGest.view.vaga.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu ficheiroMenu, ficheiroRecrutamento, ficheiroIntegracao, listagensMenu, tabelasMenu, ajudaMenu, pesquisaMenu;
	private JMenuItem novoVagaItem, editarVagaItem, eliminarVagaItem, pesquisaVagaDataItem;
	private JMenuItem novoCandidatoItem, editarCandidatoItem, eliminarCandidatoItem;
	private JMenuItem novoEntrevistaItem, editarEntrevistaItem, eliminarEntrevistaItem;
	private JMenuItem novoFuncionarioItem, editarFuncionarioItem, eliminarFuncionarioItem;
	private JMenuItem novoCargoItem, editarCargoItem, eliminarCargoItem;
	private JMenuItem novoTreinamentoItem, editarTreinamentoItem, eliminarTreinamentoItem;
	private JMenuItem novoContratoItem, editarContratoItem, eliminarContratoItem;
	private JMenuItem nacionalidadeTbItem, provinciaTbItem, municipioTbItem, comunaTbItem, estadoCivilTbItem, sexoTbItem, cargoTbItem, motivoContratacaoTbItem, departamentoTbItem;
	private JMenuItem sobreItem;
	private JMenuItem listarVagasItem;

	public Dashboard()
	{
		super("Dashboard");

		adicionarComponentesMenus();
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void adicionarComponentesMenus()
	{

		setLayout(null);
		//Barra Menus
		menuBar = new JMenuBar();
		setJMenuBar( menuBar );
		//Menus
		menuBar.add(ficheiroMenu = new JMenu("Ficheiro"));
		ficheiroMenu.setMnemonic('F');
		menuBar.add( listagensMenu = new JMenu("Listagens") );
		listagensMenu.setMnemonic('L');
		menuBar.add( tabelasMenu = new JMenu("Tabelas") );
		tabelasMenu.setMnemonic('T');
		menuBar.add( ajudaMenu = new JMenu("Ajuda") );
		ajudaMenu.setMnemonic('A');
		menuBar.add( pesquisaMenu = new JMenu("Pesquisa") );
		pesquisaMenu.setMnemonic('P');


		// Criar submenu Recrutamento
		ficheiroMenu.add(ficheiroRecrutamento = new JMenu("Recrutamento"));
		ficheiroMenu.add(ficheiroIntegracao = new JMenu("Gestao de Integraçao"));

		// Recrutamento
		ficheiroRecrutamento.add(novoVagaItem = new JMenuItem("Nova Vaga"));
		ficheiroRecrutamento.add(editarVagaItem = new JMenuItem("Editar Vaga"));
		ficheiroRecrutamento.add(eliminarVagaItem = new JMenuItem("Eliminar Vaga"));
		ficheiroRecrutamento.add(novoCandidatoItem = new JMenuItem("Novo Candidato"));
		ficheiroRecrutamento.add(editarCandidatoItem = new JMenuItem("Editar Candidato"));
		ficheiroRecrutamento.add(eliminarCandidatoItem = new JMenuItem("Eliminar Candidato"));
		ficheiroRecrutamento.add(novoEntrevistaItem = new JMenuItem("Novo Entrevista"));
		ficheiroRecrutamento.add(editarEntrevistaItem = new JMenuItem("Editar Entrevista"));
		ficheiroRecrutamento.add(eliminarEntrevistaItem = new JMenuItem("Eliminar Entrevista"));

		// Integraçao
		ficheiroIntegracao.add(novoFuncionarioItem = new JMenuItem("Novo Funcionario"));
		ficheiroIntegracao.add(editarFuncionarioItem = new JMenuItem("Editar Funcionario"));
		ficheiroIntegracao.add(eliminarFuncionarioItem = new JMenuItem("Eliminar Funcionario"));
		ficheiroIntegracao.add(novoCargoItem = new JMenuItem("Novo Cargo"));
		ficheiroIntegracao.add(editarCargoItem = new JMenuItem("Editar Cargo"));
		ficheiroIntegracao.add(eliminarCargoItem = new JMenuItem("Eliminar Cargo"));
		ficheiroIntegracao.add(novoTreinamentoItem = new JMenuItem("Novo Treinamento"));
		ficheiroIntegracao.add(editarTreinamentoItem = new JMenuItem("Editar Treinamento"));
		ficheiroIntegracao.add(eliminarTreinamentoItem = new JMenuItem("Eliminar Treinamento"));
		ficheiroIntegracao.add(novoContratoItem = new JMenuItem("Novo Contrato"));
		ficheiroIntegracao.add(editarContratoItem = new JMenuItem("Editar Contrato"));
		ficheiroIntegracao.add(eliminarContratoItem = new JMenuItem("Eliminar Contrato"));

		//Listagem
		listagensMenu.add(listarVagasItem = new JMenuItem("Listar Vagas"));

		//Submenus (Tabelas)
		tabelasMenu.add( nacionalidadeTbItem = new JMenuItem("Nacionalidade"));
		tabelasMenu.add( estadoCivilTbItem = new JMenuItem("Estado Civil"));
		tabelasMenu.add( sexoTbItem = new JMenuItem("Sexo"));
		tabelasMenu.add( provinciaTbItem = new JMenuItem("Provincia"));
		tabelasMenu.add( municipioTbItem = new JMenuItem("Municipio"));
		tabelasMenu.add( comunaTbItem = new JMenuItem("Comuna"));
		tabelasMenu.add( cargoTbItem = new JMenuItem("Cargos"));
		tabelasMenu.add( departamentoTbItem = new JMenuItem("Departamento"));
		tabelasMenu.add( motivoContratacaoTbItem = new JMenuItem("Tipos de Contratações"));

		//Submenus (Ajuda)
		ajudaMenu.add( sobreItem = new JMenuItem("Sobre"));

		//Pesquisas
		pesquisaMenu.add( pesquisaVagaDataItem = new JMenuItem("Vaga por Data"));

		// Eventos dos submenus
		novoVagaItem.addActionListener(this);
		editarVagaItem.addActionListener(this);
		eliminarVagaItem.addActionListener(this);
		listarVagasItem.addActionListener(e -> new ListagemVagas());

		nacionalidadeTbItem.addActionListener(e -> new Nacionalidade());
		estadoCivilTbItem.addActionListener(e -> new EstadoCivil());
		sexoTbItem.addActionListener(e -> new Sexo());


		/*

		provinciaTbItem.addActionListener(e -> new ProvinciaListagem());
		municipioTbItem.addActionListener(e -> new MunicipioListagem());
		comunaTbItem.addActionListener(e -> new ComunaListagem());
		*/
		cargoTbItem.addActionListener(e -> new Cargo());
		departamentoTbItem.addActionListener(e -> new Departamento());
		motivoContratacaoTbItem.addActionListener(e -> new MotivoContratacao());


		sobreItem.addActionListener(this);

	}

	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		if (source == novoVagaItem) {
			new NovaVaga();
		} else if (source == editarVagaItem) {
			new ListagemVagasParaEditar();
		} else if (source == eliminarVagaItem) {
			new EliminarVaga();
		}
		else if (source == sobreItem) {
			JOptionPane.showMessageDialog(this, "Sistema de Gestão de Recursos Humanos\nDesenvolvido por Pedro Moniz");
		}
	}

	public static void main(String args[])
	{
		new Dashboard();
	}
}
