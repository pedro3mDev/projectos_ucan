/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: CadaverVisao.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class CadaverVisao extends JFrame
{
	PainelCentro centro;
	PainelSul sul;
	public CadaverVisao()
	{
		super("Cadastro de Novo Cadaver");
		
		definirTema();
		
		JPanel painelNorte = new JPanel();
		JLabel lbBanner = new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma B\\OsvaldoRamos2817\\image\\topo.JPG"));
		painelNorte.add(lbBanner); 
		
		getContentPane().add(painelNorte, BorderLayout.NORTH);
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		
		//setSize(400, 300);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);		
	}
	
	class PainelCentro extends JPanel
	{
		JTextField idJTF, nomeJTF, numeroDocumentoJTF, dataNascimentoJTF;
		JComboBox tipoDocumentoJCB, nacionalidadeJCB, generoJCB;
		JComboBoxPersonal provinciasJCB, municipiosJCB, comunasJCB;
		String generos[] = {"Masculino", "Feminino"};
		JComboBoxTabela3_Tabela3 provMunCom;
		JTextFieldData txtData;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(5, 4) );
			
			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
			
			
			//linha1
			add( new JLabel("Id") );
			add( idJTF = new JTextField() );
			add( new JLabel("Nome"));
			add( nomeJTF = new JTextField() );
			
			//linha2
			add( new JLabel("Tipo de Documento") );
			add( tipoDocumentoJCB = UInterfaceBox.createJComboBoxPersonalTab2("TipoDocumentos.tab") );
			add( new JLabel("Numero do Documento"));
			add( numeroDocumentoJTF = new JTextField() );
			
			//linha3
			add( new JLabel("Genero") );
			add( generoJCB = new JComboBox( generos ) );
			add( new JLabel("Nacionalidade"));
			add( nacionalidadeJCB = UInterfaceBox.createJComboBoxPersonalTab2("Nacionalidades.tab") );
			
			//linha4
			add( new JLabel("Data de Nascimento") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data de Nascimento");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);
			
			add( new JLabel("Provincia"));
			add( provinciasJCB = provMunCom.getComboBoxFather() );
			
			//linha5
			add( new JLabel("Municipio") );
			add( municipiosJCB = provMunCom.getComboBoxSun() );
			add( new JLabel("Comuna"));
			add( comunasJCB = provMunCom.getComboBoxNeto() );
		}
		
		//--- metodos get
		public int getId()
		{
			return Integer.parseInt(idJTF.getText().trim());
		}
		public String getNome()
		{
			return nomeJTF.getText().trim();
		}
		public String getTipoDocumento()
		{
			return String.valueOf(tipoDocumentoJCB.getSelectedItem());
		}
		
		public String getNumeroDocumento()
		{
			return numeroDocumentoJTF.getText().trim();
		}
		public String getNacionalidade()
		{
			return String.valueOf(nacionalidadeJCB.getSelectedItem());
		}
		public String getGenero()
		{
			return String.valueOf(generoJCB.getSelectedItem());
		}
		public String getProvincia()
		{
			return String.valueOf(provinciasJCB.getSelectedItem());
		}
		public String getMunicipio()
		{
			return String.valueOf(municipiosJCB.getSelectedItem());
		}
		public String getComuna()
		{
			return String.valueOf(comunasJCB.getSelectedItem());
		}
		public String getDataNascimento()
		{
			return txtData.getDTestField().getText();
		}

		
		//--- salvar 
		public void salvar()
		{			
			//--- envido dos dados da visao para o modelo
			CadaverModelo modelo = new CadaverModelo(getId(), getNome(), getTipoDocumento(), 
				getNumeroDocumento(), getNacionalidade(), getGenero(), getProvincia(), 
				getMunicipio(), getComuna(), getDataNascimento());
			
			JOptionPane.showMessageDialog(null, modelo.toString() );
		}
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton salvarJB, cancelarJB;
		
		public PainelSul()
		{
			add( salvarJB = new JButton("Salvar", new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma B\\OsvaldoRamos2817\\image\\novo24.PNG") ) );
			add( cancelarJB = new JButton("Cancelar", new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma B\\OsvaldoRamos2817\\image\\delete24.PNG") ) );
			
			salvarJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == salvarJB)
				centro.salvar();
			else
				dispose();
		}
	}
	
	public void definirTema() 
	 {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }
}