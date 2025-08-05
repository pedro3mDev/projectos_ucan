/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: CadaverVisao.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class CadaverVisao extends JFrame
{
	PainelCentro centro;
	PainelSul sul;
	
	public CadaverVisao(boolean alterar, CadaverModelo modelo)
	{
		super("Cadastro de Novo Cadaver");
		
		definirTema();
		
		JPanel painelNorte = new JPanel();
		JLabel lbImagem = new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma A\\OsvaldoRamos2817\\image\\topo.jpg"));
		painelNorte.add(lbImagem);
		
		getContentPane().add(painelNorte, BorderLayout.NORTH);
		
		if (!alterar)
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		else
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	class PainelCentro extends JPanel
	{
		private JTextField idJTF, nomeJTF, numeroDocumentoJTF, dataNascimentoJTF;
		private JComboBox tipoDocumentoJCB, nacionalidadeJCB, estadoCivilJCB,
					generoJCB;
		private JComboBoxPersonal provinciasJCB, municipiosJCB, comunasJCB;
		private JComboBoxTabela3_Tabela3 provMunCom;
		private String [] generosArray = {"Masculino", "Feminino"};
		private JTextFieldData txtData;
		private CadaverFile cadaverFile;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(6, 4, 10, 5) );
			
			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
			cadaverFile = new CadaverFile();
			
			//linha1
			add( new JLabel("Id") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000" + cadaverFile.getProximoCodigo() );
			idJTF.setFocusable(false);
			
			add( new JLabel("Nome") );
			add( nomeJTF = new JTextField() );
			
			//linha2
			add( new JLabel("Tipo de Documento") );
			add( tipoDocumentoJCB = UInterfaceBox.createJComboBoxsTabela2("TipoDocumentos.tab") );
			add( new JLabel("Numero do Documento") );
			add( numeroDocumentoJTF = new JTextField() );
			
			//linha3
			add( new JLabel("Nacionalidade") );
			add( nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab") );
			add( new JLabel("Genero") );
			add( generoJCB = new JComboBox( generosArray ) );
			
			//linha4
			add( new JLabel("Provincia") );
			add( provinciasJCB = provMunCom.getComboBoxFather() );
			add( new JLabel("Municipio") );
			add( municipiosJCB = provMunCom.getComboBoxSun() );
			
			//linha5
			add( new JLabel("Comuna") );
			add( comunasJCB = provMunCom.getComboBoxNeto() );
			add( new JLabel("Data de Nascimento") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);			
			
			//linha6
			add( new JLabel("Estado Civil") );
			add( estadoCivilJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoCivil.tab") );
			
		}
		public PainelCentro(CadaverModelo modelo)
		{
			setLayout( new GridLayout(6, 4, 10, 5) );
			
			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
			cadaverFile = new CadaverFile();
			
			//linha1
			add( new JLabel("Id") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000"+ modelo.getId() );
			idJTF.setFocusable(false);
			
			add( new JLabel("Nome") );
			add( nomeJTF = new JTextField() );
			nomeJTF.setText( modelo.getNome() );
			
			//linha2
			add( new JLabel("Tipo de Documento") );
			add( tipoDocumentoJCB = UInterfaceBox.createJComboBoxsTabela2("TipoDocumentos.tab") );
			tipoDocumentoJCB.setSelectedItem(modelo.getTipoDocumento() );
			add( new JLabel("Numero do Documento") );
			add( numeroDocumentoJTF = new JTextField() );
			numeroDocumentoJTF.setText( modelo.getNumeroDocumento() );
			
			//linha3
			add( new JLabel("Nacionalidade") );
			add( nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab") );
			nacionalidadeJCB.setSelectedItem( modelo.getNacionalidade() );
			add( new JLabel("Genero") );
			add( generoJCB = new JComboBox( generosArray ) );
			generoJCB.setSelectedItem( modelo.getGenero() );
			
			//linha4
			add( new JLabel("Provincia") );
			add( provinciasJCB = provMunCom.getComboBoxFather() );
			provinciasJCB.setSelectedItem( modelo.getProvincia() );
			
			add( new JLabel("Municipio") );
			add( municipiosJCB = provMunCom.getComboBoxSun() );
			municipiosJCB.setSelectedItem( modelo.getMunicipio() );
			
			//linha5
			add( new JLabel("Comuna") );
			add( comunasJCB = provMunCom.getComboBoxNeto() );
			comunasJCB.setSelectedItem( modelo.getComuna() );
			
			add( new JLabel("Data de Nascimento") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);	
			txtData.getDTestField().setText( modelo.getDataNascimento() );			
			
			//linha6
			add( new JLabel("Estado Civil") );
			add( estadoCivilJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoCivil.tab") );
			estadoCivilJCB.setSelectedItem( modelo.getEstadoCivil() );			
		}
		
		//--- metodos get
		public int getId()
		{
			return Integer.parseInt( idJTF.getText().trim());
		}
		public String getNome()
		{
			return nomeJTF.getText().trim();
		}
		
		public String getEstadoCivil()
		{
			return String.valueOf( estadoCivilJCB.getSelectedItem() );
		}
		public String getNacionalidade()
		{
			return String.valueOf( nacionalidadeJCB.getSelectedItem() );
		}
		public String getTipoDocumento()
		{
			return String.valueOf( tipoDocumentoJCB.getSelectedItem() );
		}
		public String getNumeroDocumento()
		{
			return numeroDocumentoJTF.getText().trim();
		}
		public String getGenero()
		{
			return String.valueOf( generoJCB.getSelectedItem() );
		}
		public String getDataNascimento()
		{
			return txtData.getDTestField().getText();
		}
		public String getProvincia()
		{
			return String.valueOf( provinciasJCB.getSelectedItem() );
		}
		public String getMunicipio()
		{
			return String.valueOf(municipiosJCB.getSelectedItem() );
		}
		public String getComuna()
		{
			return String.valueOf( comunasJCB.getSelectedItem() );
		}
		
		//--- metodos get
		public void setId(int id)
		{
			idJTF.setText("" + id);
		}
		public void setNome(String nome)
		{
			nomeJTF.setText(nome);
		}
		
		public void setEstadoCivil(String estadoCivil)
		{
			estadoCivilJCB.setSelectedItem( estadoCivil );
		}
		public void setNacionalidade(String nacionalidade)
		{
			nacionalidadeJCB.setSelectedItem( nacionalidade );
		}
		public void setTipoDocumento(String tipoDocumento)
		{
			tipoDocumentoJCB.setSelectedItem(tipoDocumento);
		}
		public void setNumeroDocumento(String numDocumento)
		{
			numeroDocumentoJTF.setText( numDocumento );
		}
		public void setGenero(String genero)
		{
			generoJCB.setSelectedItem(genero);
		}
		public void setDataNascimento(String data)
		{
			txtData.getDTestField().setText(data);
		}
		public void setProvincia(String provincia)
		{
			provinciasJCB.setSelectedItem(provincia);
		}
		public void setMunicipio(String municipio)
		{
			municipiosJCB.setSelectedItem(municipio);
		}
		public void setComuna(String comuna)
		{
			comunasJCB.setSelectedItem(comuna);
		}
	
		
		//--- salvar
		public void salvar()
		{			
			CadaverModelo modelo = new CadaverModelo(getId(), getNome(), 
					getEstadoCivil(), getNacionalidade(),
					getTipoDocumento(), getNumeroDocumento(), getDataNascimento(), 
					getGenero(), getProvincia(), getMunicipio(), getComuna());
					
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
			modelo.salvar();			
			dispose();
		}
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton salvarJB, cancelarJB;
		
		public PainelSul()
		{
			add(salvarJB = new JButton("Salvar", new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma A\\OsvaldoRamos2817\\image\\save24.png") ) );
			add(cancelarJB = new JButton("Cancelar") );
			
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
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }
}