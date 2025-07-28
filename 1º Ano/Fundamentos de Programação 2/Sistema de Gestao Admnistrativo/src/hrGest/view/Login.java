/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Pedro Moniz
Numero: 17285
Ficheiro: Login.java
--------------------------------------*/
package hrGest.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame {

	private JLabel lblTexto;
	private JTextField emailField;
	private JPasswordField senhaField;
	private JButton entrarButton;

	public Login() {
		super("Autenticação");
		adicionarComponentes();
		setSize(800, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void adicionarComponentes() {
		setLayout(null);
		ImageIcon imagemFundo = new ImageIcon(getClass().getResource("/hrGest/imagem/fundo2.jpg"));


		JLabel background = new JLabel(imagemFundo);
		background.setBounds(0, 0, 800, 700);
		setContentPane(background);
		background.setLayout(null);

		// Label
		lblTexto = new JLabel("HR - GEST");
		lblTexto.setBounds(300, 150, 300, 40);
		lblTexto.setFont(new Font("Arial", Font.BOLD, 30));
		lblTexto.setForeground(Color.white);
		background.add(lblTexto);

		// Campo de Email
		emailField = new JTextField();
		emailField.setBounds(250, 250, 300, 40);
		emailField.setFont(new Font("Arial", Font.PLAIN, 16));
		emailField.setForeground(Color.BLACK);
		background.add(emailField);

		// Campo de Senha
		senhaField = new JPasswordField();
		senhaField.setBounds(250, 310, 300, 40);
		senhaField.setFont(new Font("Arial", Font.PLAIN, 16));
		senhaField.setForeground(Color.BLACK);
		background.add(senhaField);

		// Botão Entrar
		entrarButton = new JButton("Entrar");
		entrarButton.setBounds(250, 370, 300, 40);
		entrarButton.setBackground(Color.DARK_GRAY);
		entrarButton.setFont(new Font("Arial", Font.PLAIN, 16));
		entrarButton.setForeground(Color.YELLOW);
		background.add(entrarButton);

		// Evento do botão
		entrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String senha = new String(senhaField.getPassword());
				if (autenticarUsuario(email, senha)) {
					dispose();
					new Dashboard();
				} else {
					JOptionPane.showMessageDialog(null, "Email ou senha inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private boolean autenticarUsuario(String email, String senha) {
		File arquivo = new File("bd/usuarios.txt");

		if (!arquivo.exists()) {
			JOptionPane.showMessageDialog(null, "Ficheiro de usuários não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = leitor.readLine()) != null) {
				String[] partes = linha.split(";");
				if (partes.length == 2) {
					String emailArmazenado = partes[0].trim();
					String senhaArmazenada = partes[1].trim();

					if (email.equals(emailArmazenado) && senha.equals(senhaArmazenada)) {
						return true;
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void main(String args[]) {
		new Login();
	}
}
