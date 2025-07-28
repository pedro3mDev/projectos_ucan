package hrGest.view.vaga;

import javax.swing.*;
import java.awt.event.*;

public class EditarVaga extends JFrame implements ActionListener {

	private JTextField codigoVagaField, nomeVagaField, quantidadeField;
	private JTextArea descricaoArea;
	private JComboBox<String> motivoCombo, cargoCombo, departamentoCombo;
	private JButton salvarBtn, cancelarBtn;

	public EditarVaga() {
		super("Editar Vaga");
		adicionarComponentes();
		setSize(600, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void adicionarComponentes() {
		setLayout(null);

		JLabel tituloLbl = new JLabel("Edição de Vaga");
		tituloLbl.setBounds(200, 10, 300, 30);
		add(tituloLbl);

		// Código da Vaga
		JLabel codigoLbl = new JLabel("Código da Vaga:");
		codigoLbl.setBounds(30, 60, 120, 25);
		add(codigoLbl);

		codigoVagaField = new JTextField("VAG123"); // preenchido
		codigoVagaField.setBounds(160, 60, 380, 25);
		codigoVagaField.setEnabled(false);
		add(codigoVagaField);

		// Nome da Vaga
		JLabel nomeLbl = new JLabel("Nome da Vaga:");
		nomeLbl.setBounds(30, 100, 120, 25);
		add(nomeLbl);

		nomeVagaField = new JTextField("Desenvolvedor Java");
		nomeVagaField.setBounds(160, 100, 380, 25);
		add(nomeVagaField);

		// Descrição
		JLabel descricaoLbl = new JLabel("Descrição:");
		descricaoLbl.setBounds(30, 140, 120, 25);
		add(descricaoLbl);

		descricaoArea = new JTextArea("Desenvolvimento e manutenção de aplicações web.");
		JScrollPane scrollDescricao = new JScrollPane(descricaoArea);
		scrollDescricao.setBounds(160, 140, 380, 80);
		add(scrollDescricao);

		// Motivo
		JLabel motivoLbl = new JLabel("Motivo da Contratação:");
		motivoLbl.setBounds(30, 235, 150, 25);
		add(motivoLbl);

		motivoCombo = new JComboBox<>(new String[] {
				"Substituição", "Nova Demanda", "Ampliação", "Outros"
		});
		motivoCombo.setBounds(190, 235, 350, 25);
		motivoCombo.setSelectedItem("Nova Demanda");
		add(motivoCombo);

		// Cargo
		JLabel cargoLbl = new JLabel("Cargo:");
		cargoLbl.setBounds(30, 275, 120, 25);
		add(cargoLbl);

		cargoCombo = new JComboBox<>(new String[] {
				"Analista", "Técnico", "Supervisor", "Gerente"
		});
		cargoCombo.setBounds(160, 275, 380, 25);
		cargoCombo.setSelectedItem("Analista");
		add(cargoCombo);

		// Departamento
		JLabel departamentoLbl = new JLabel("Departamento:");
		departamentoLbl.setBounds(30, 315, 120, 25);
		add(departamentoLbl);

		departamentoCombo = new JComboBox<>(new String[] {
				"RH", "Financeiro", "TI", "Operações"
		});
		departamentoCombo.setBounds(160, 315, 380, 25);
		departamentoCombo.setSelectedItem("TI");
		add(departamentoCombo);

		// Quantidade
		JLabel quantidadeLbl = new JLabel("Qtd. Recrutada:");
		quantidadeLbl.setBounds(30, 355, 120, 25);
		add(quantidadeLbl);

		quantidadeField = new JTextField("2");
		quantidadeField.setBounds(160, 355, 380, 25);
		add(quantidadeField);

		// Botões
		salvarBtn = new JButton("Salvar");
		salvarBtn.setBounds(280, 400, 120, 30);
		salvarBtn.addActionListener(this);
		add(salvarBtn);

		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.setBounds(420, 400, 120, 30);
		cancelarBtn.addActionListener(this);
		add(cancelarBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salvarBtn) {
			JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
		} else if (e.getSource() == cancelarBtn) {
			dispose(); // Fecha a janela
		}
	}

	public static void main(String[] args) {
		new EditarVaga();
	}
}
