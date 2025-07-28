package hrGest.view.vaga;

import hrGest.model.VagaModel;
import hrGest.controller.VagaController;
import hrGest.util.FicheiroUtil;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EditarVaga extends JFrame implements ActionListener {

	private JTextField codigoVagaField, nomeVagaField, quantidadeField;
	private JTextArea descricaoArea;
	private JComboBox<String> motivoCombo, cargoCombo, departamentoCombo;
	private JButton salvarBtn, cancelarBtn;

	private VagaModel vagaOriginal;

	public EditarVaga(VagaModel vaga) {
		super("Editar Vaga");
		this.vagaOriginal = vaga;

		adicionarComponentes();
		preencherCampos();

		setSize(600, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public EditarVaga() {

	}

	private void adicionarComponentes() {
		setLayout(null);

		JLabel tituloLbl = new JLabel("Editar Vaga");
		tituloLbl.setBounds(230, 10, 200, 30);
		add(tituloLbl);

		JLabel codigoLbl = new JLabel("Código da Vaga:");
		codigoLbl.setBounds(30, 60, 120, 25);
		add(codigoLbl);
		codigoVagaField = new JTextField();
		codigoVagaField.setBounds(160, 60, 380, 25);
		codigoVagaField.setEnabled(false);
		add(codigoVagaField);

		JLabel nomeLbl = new JLabel("Nome da Vaga:");
		nomeLbl.setBounds(30, 100, 120, 25);
		add(nomeLbl);
		nomeVagaField = new JTextField();
		nomeVagaField.setBounds(160, 100, 380, 25);
		add(nomeVagaField);

		JLabel descricaoLbl = new JLabel("Descrição:");
		descricaoLbl.setBounds(30, 140, 120, 25);
		add(descricaoLbl);
		descricaoArea = new JTextArea();
		JScrollPane scrollDescricao = new JScrollPane(descricaoArea);
		scrollDescricao.setBounds(160, 140, 380, 80);
		add(scrollDescricao);

		JLabel motivoLbl = new JLabel("Motivo da Contratação:");
		motivoLbl.setBounds(30, 235, 150, 25);
		add(motivoLbl);
		motivoCombo = new JComboBox<>(carregarOpcoes("bd/motivoContratacao.txt"));
		motivoCombo.setBounds(190, 235, 350, 25);
		add(motivoCombo);

		JLabel cargoLbl = new JLabel("Cargo:");
		cargoLbl.setBounds(30, 275, 120, 25);
		add(cargoLbl);
		cargoCombo = new JComboBox<>(carregarOpcoes("bd/cargo.txt"));
		cargoCombo.setBounds(160, 275, 380, 25);
		add(cargoCombo);

		JLabel departamentoLbl = new JLabel("Departamento:");
		departamentoLbl.setBounds(30, 315, 120, 25);
		add(departamentoLbl);
		departamentoCombo = new JComboBox<>(carregarOpcoes("bd/departamento.txt"));
		departamentoCombo.setBounds(160, 315, 380, 25);
		add(departamentoCombo);

		JLabel quantidadeLbl = new JLabel("Qtd. Recrutada:");
		quantidadeLbl.setBounds(30, 355, 120, 25);
		add(quantidadeLbl);
		quantidadeField = new JTextField();
		quantidadeField.setBounds(160, 355, 380, 25);
		add(quantidadeField);

		salvarBtn = new JButton("Salvar Alterações");
		salvarBtn.setBounds(160, 400, 150, 30);
		salvarBtn.addActionListener(this);
		add(salvarBtn);

		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.setBounds(320, 400, 150, 30);
		cancelarBtn.addActionListener(this);
		add(cancelarBtn);
	}

	private void preencherCampos() {
		codigoVagaField.setText(vagaOriginal.getCodigo());
		nomeVagaField.setText(vagaOriginal.getNome());
		descricaoArea.setText(vagaOriginal.getDescricao());
		quantidadeField.setText(String.valueOf(vagaOriginal.getQuantidade()));

		motivoCombo.setSelectedItem(vagaOriginal.getMotivo());
		cargoCombo.setSelectedItem(vagaOriginal.getCargo());
		departamentoCombo.setSelectedItem(vagaOriginal.getDepartamento());
	}

	private String[] carregarOpcoes(String caminho) {
		List<String> linhas = FicheiroUtil.carregarLinhas(caminho);
		List<String> nomes = new ArrayList<>();
		for (String linha : linhas) {
			String[] partes = linha.split(";");
			if (partes.length > 1) {
				nomes.add(partes[1]);
			}
		}
		if (nomes.isEmpty()) {
			nomes.add("Nenhum dado encontrado");
		}
		return nomes.toArray(new String[0]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == salvarBtn) {
			try {
				String nome = nomeVagaField.getText();
				String descricao = descricaoArea.getText();
				String motivo = (String) motivoCombo.getSelectedItem();
				String cargo = (String) cargoCombo.getSelectedItem();
				String departamento = (String) departamentoCombo.getSelectedItem();
				int quantidade = Integer.parseInt(quantidadeField.getText());

				VagaModel vagaAtualizada = new VagaModel(
						vagaOriginal.getCodigo(), nome, descricao, motivo, cargo, departamento, quantidade
				);

				VagaController controller = new VagaController();
				controller.editarVaga(vagaAtualizada);

				JOptionPane.showMessageDialog(this, "Vaga atualizada com sucesso!");
				dispose();

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para quantidade.");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao atualizar vaga: " + ex.getMessage());
			}
		} else if (source == cancelarBtn) {
			dispose();
		}
	}
}
