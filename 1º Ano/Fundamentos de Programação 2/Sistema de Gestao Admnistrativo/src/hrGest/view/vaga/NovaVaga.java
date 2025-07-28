package hrGest.view.vaga;
import hrGest.model.VagaModel;
import hrGest.repository.VagaRepositorio;
import hrGest.controller.VagaController;
import hrGest.util.FicheiroUtil;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class NovaVaga extends JFrame implements ActionListener {

	private JLabel tituloLbl;
	private JTextField codigoVagaField, nomeVagaField, quantidadeField;
	private JTextArea descricaoArea;
	private JComboBox<String> motivoCombo, cargoCombo, departamentoCombo;
	private JButton salvarBtn, limparBtn, cancelarBtn;

	public NovaVaga() {
		super("Nova Vaga");
		adicionarComponentes();
		setSize(600, 520);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public void adicionarComponentes() {
		setLayout(null);

		tituloLbl = new JLabel("Cadastro de Nova Vaga");
		tituloLbl.setBounds(200, 10, 300, 30);
		add(tituloLbl);

		// Código da Vaga
		JLabel codigoLbl = new JLabel("Código da Vaga:");
		codigoLbl.setBounds(30, 60, 120, 25);
		add(codigoLbl);

		codigoVagaField = new JTextField("Gerado automaticamente");
		codigoVagaField.setBounds(160, 60, 380, 25);
		codigoVagaField.setEnabled(false);
		add(codigoVagaField);

		// Nome da Vaga
		JLabel nomeLbl = new JLabel("Nome da Vaga:");
		nomeLbl.setBounds(30, 100, 120, 25);
		add(nomeLbl);

		nomeVagaField = new JTextField();
		nomeVagaField.setBounds(160, 100, 380, 25);
		add(nomeVagaField);

		// Descrição
		JLabel descricaoLbl = new JLabel("Descrição:");
		descricaoLbl.setBounds(30, 140, 120, 25);
		add(descricaoLbl);

		descricaoArea = new JTextArea();
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
		add(motivoCombo);

		// Cargo
		JLabel cargoLbl = new JLabel("Cargo:");
		cargoLbl.setBounds(30, 275, 120, 25);
		add(cargoLbl);

		List<String> linhas = FicheiroUtil.carregarLinhas("bd/cargo.txt");
		List<String> nomes = new ArrayList<>();
		for (String linha : linhas) {
			String[] partes = linha.split(";");
			if (partes.length > 1) {
				nomes.add(partes[1]);
			}
		}
		if (nomes.isEmpty()) {
			nomes.add("Nenhum cargo encontrado");
		}
		cargoCombo = new JComboBox<>(nomes.toArray(new String[0]));
		cargoCombo.setBounds(160, 275, 380, 25);
		add(cargoCombo);


		// Departamento
		JLabel departamentoLbl = new JLabel("Departamento:");
		departamentoLbl.setBounds(30, 315, 120, 25);
		add(departamentoLbl);

		departamentoCombo = new JComboBox<>(new String[] {
				"RH", "Financeiro", "TI", "Operações"
		});
		departamentoCombo.setBounds(160, 315, 380, 25);
		add(departamentoCombo);

		// Quantidade
		JLabel quantidadeLbl = new JLabel("Qtd. Recrutada:");
		quantidadeLbl.setBounds(30, 355, 120, 25);
		add(quantidadeLbl);

		quantidadeField = new JTextField();
		quantidadeField.setBounds(160, 355, 380, 25);
		add(quantidadeField);

		// Botões
		salvarBtn = new JButton("Salvar");
		salvarBtn.setBounds(160, 400, 100, 30);
		salvarBtn.addActionListener(this);
		add(salvarBtn);

		limparBtn = new JButton("Limpar");
		limparBtn.setBounds(270, 400, 100, 30);
		limparBtn.addActionListener(this);
		add(limparBtn);

		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.setBounds(380, 400, 100, 30);
		cancelarBtn.addActionListener(this);
		add(cancelarBtn);
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

				// Gerar código automaticamente — exemplo simples:
				String codigo = "V" + System.currentTimeMillis(); // Ex: V1699876532

				VagaModel novaVaga = new VagaModel(
						codigo, nome, descricao, motivo, cargo, departamento, quantidade
				);

				VagaController controller = new VagaController();
				controller.adicionarVaga(novaVaga);

				JOptionPane.showMessageDialog(this, "Vaga salva com sucesso!");
				dispose(); // fecha a janela após salvar (opcional)

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Por favor, insira um número válido para quantidade.");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Erro ao salvar vaga: " + ex.getMessage());
			}
		}
		else if (source == limparBtn) {
			nomeVagaField.setText("");
			descricaoArea.setText("");
			motivoCombo.setSelectedIndex(0);
			cargoCombo.setSelectedIndex(0);
			departamentoCombo.setSelectedIndex(0);
			quantidadeField.setText("");
		} else if (source == cancelarBtn) {
			dispose(); // Fecha a janela
		}
	}

	public static void main(String[] args) {
		new NovaVaga();
	}
}
