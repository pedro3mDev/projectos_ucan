package hrGest.view.vaga;

import hrGest.controller.VagaController;
import hrGest.model.VagaModel;
import hrGest.repository.VagaRepositorio;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class EliminarVaga extends JFrame {
	private JTable tabela;
	private JButton eliminarBtn, cancelarBtn;
	private List<VagaModel> vagas;

	public EliminarVaga() {
		super("Eliminar Vaga");
		vagas = VagaRepositorio.carregar();

		String[] colunas = { "Código", "Nome", "Cargo", "Departamento" };
		String[][] dados = new String[vagas.size()][colunas.length];
		for (int i = 0; i < vagas.size(); i++) {
			VagaModel v = vagas.get(i);
			dados[i][0] = v.getCodigo();
			dados[i][1] = v.getNome();
			dados[i][2] = v.getCargo();
			dados[i][3] = v.getDepartamento();
		}

		tabela = new JTable(dados, colunas);
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(20, 20, 540, 250);
		add(scrollPane);

		eliminarBtn = new JButton("Eliminar");
		eliminarBtn.setBounds(150, 300, 100, 30);
		eliminarBtn.addActionListener(e -> eliminarSelecionado());
		add(eliminarBtn);

		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.setBounds(300, 300, 100, 30);
		cancelarBtn.addActionListener(e -> dispose());
		add(cancelarBtn);

		setLayout(null);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void eliminarSelecionado() {
		int linha = tabela.getSelectedRow();
		if (linha >= 0) {
			String codigo = (String) tabela.getValueAt(linha, 0);
			int confirm = JOptionPane.showConfirmDialog(this,
					"Tem certeza que deseja eliminar a vaga selecionada?",
					"Confirmar eliminação", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				VagaController.eliminarVaga(codigo);
				JOptionPane.showMessageDialog(this, "Vaga eliminada com sucesso!");
				dispose();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Selecione uma vaga para eliminar.");
		}
	}

	public static void main(String[] args) {
		new EliminarVaga();
	}
}
