package hrGest.view.vaga;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EliminarVaga extends JFrame {

	private JTable tabelaVagas;
	private DefaultTableModel modeloTabela;
	private JButton eliminarButton, fecharButton;

	public EliminarVaga() {
		super("Lista de Vagas");

		setLayout(new BorderLayout());
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Criar modelo da tabela
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Código");
		modeloTabela.addColumn("Nome da Vaga");
		modeloTabela.addColumn("Departamento");

		// Simulação de dados (substitua por dados reais do banco)
		modeloTabela.addRow(new Object[]{"001", "Analista de RH", "RH"});
		modeloTabela.addRow(new Object[]{"002", "Programador Java", "TI"});
		modeloTabela.addRow(new Object[]{"003", "Gestor Financeiro", "Financeiro"});

		// Criar tabela
		tabelaVagas = new JTable(modeloTabela);
		JScrollPane scrollPane = new JScrollPane(tabelaVagas);
		add(scrollPane, BorderLayout.CENTER);

		// Botões
		JPanel painelBotoes = new JPanel();
		eliminarButton = new JButton("Eliminar");
		fecharButton = new JButton("Fechar");

		painelBotoes.add(eliminarButton);
		painelBotoes.add(fecharButton);
		add(painelBotoes, BorderLayout.SOUTH);

		// Ação de Eliminar
		eliminarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabelaVagas.getSelectedRow();
				if (linhaSelecionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma vaga para eliminar.");
					return;
				}

				String codigo = modeloTabela.getValueAt(linhaSelecionada, 0).toString();
				String nome = modeloTabela.getValueAt(linhaSelecionada, 1).toString();

				int opcao = JOptionPane.showConfirmDialog(
						null,
						"Tem certeza que deseja eliminar a vaga:\n" + nome + " (Código: " + codigo + ")?",
						"Confirmação",
						JOptionPane.YES_NO_OPTION
				);

				if (opcao == JOptionPane.YES_OPTION) {
					// Aqui você pode chamar um método para eliminar do banco
					modeloTabela.removeRow(linhaSelecionada);
					JOptionPane.showMessageDialog(null, "Vaga eliminada com sucesso.");
				}
			}
		});

		// Ação de Fechar
		fecharButton.addActionListener(e -> dispose());

		setVisible(true);
	}

	public static void main(String[] args) {
		new EliminarVaga();
	}
}
