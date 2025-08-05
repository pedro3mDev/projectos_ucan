/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: EditarCadaver.java
Data: 10.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EditarCadaver extends JFrame
{	
	
	PainelCentro centro;
	PainelSul sul;
	
	public EditarCadaver()
	{
		super("Pesquisar para Editar Dados");
		
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
	
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JComboBox nomesJCB;
		JTextField numDocumentoJTF;
		JRadioButton pesquisarPorNomeJRB, pesquisarPorDocumentoJRB;
		ButtonGroup group;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(3, 2));
			
			group = new ButtonGroup();
			
			add( pesquisarPorNomeJRB = new JRadioButton("Pesquisar Por Nome", true) );
			add( pesquisarPorDocumentoJRB = new JRadioButton("Pesquisar Por Documento", false) );
			group.add(pesquisarPorNomeJRB);
			group.add(pesquisarPorDocumentoJRB);
			
			add( new JLabel("Escolha o Nome Procurado") );
			add( nomesJCB = new JComboBox( CadaverFile.getAllNames() ) );
			
			add( new JLabel("Digite o Numero do Docuemento Procurado") );
			add( numDocumentoJTF = new JTextField() );
			numDocumentoJTF.setEnabled(false);
			
			pesquisarPorNomeJRB.addActionListener(this);
			pesquisarPorDocumentoJRB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarPorNomeJRB)
			{
				nomesJCB.setEnabled(true);
				numDocumentoJTF.setEnabled(false);
			}
			else
			{
				nomesJCB.setEnabled(false);
				numDocumentoJTF.setEnabled(true);
			}
		}
		
		public int getTipoPesquisa()
		{
			if (pesquisarPorNomeJRB.isSelected())
				return 1;
			else
				return 2;
		}
		public String getNomeProcurado()
		{
			return String.valueOf(nomesJCB.getSelectedItem());
		}
		public String getDocumentoProcurado()
		{
			return numDocumentoJTF.getText().trim();
		}
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton pesquisarJB, cancelarJB;
		
		public PainelSul()
		{
			add(pesquisarJB = new JButton("Pesquisar", new ImageIcon("C:\\Users\\HP\\Documents\\Aulas UCAN\\2024\\FPGII\\Dev\\Turma A\\OsvaldoRamos2817\\image\\search32.png") ) );
			add(cancelarJB = new JButton("Cancelar") );
			
			pesquisarJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarJB)
			{
				CadaverModelo modelo;
				
				if (centro.getTipoPesquisa() == 1)
				{
					modelo = CadaverFile.getCadaverPorNome( centro.getNomeProcurado() );
					new CadaverVisao(true, modelo);
				}
				else
					CadaverFile.pesquisarCadaverPorDocumento( centro.getDocumentoProcurado() );
			}
			else
				dispose();
		}
	}
}