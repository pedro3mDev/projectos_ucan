package hrGest.view.tabelas;

import hrGest.repository.MotivoContratacaoRepositorio ;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MotivoContratacao extends JFrame {

    public MotivoContratacao() {
        setTitle("Listagem de Tipos de Contratação");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Colunas
        String[] colunas = {"ID", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // Carregar dados do ficheiro
        MotivoContratacaoRepositorio repo = new MotivoContratacaoRepositorio();
        List<String[]> lista = repo.listar();

        for (String[] item : lista) {
            modelo.addRow(item);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);

        JButton fecharBtn = new JButton("Fechar");
        fecharBtn.addActionListener(e -> dispose());

        JPanel botoes = new JPanel();
        botoes.add(fecharBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setVisible(true);
    }
}
