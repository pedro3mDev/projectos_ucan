package hrGest.view.tabelas;
import hrGest.repository.NacionalidadeRepositorio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Nacionalidade extends JFrame {

    public Nacionalidade() {
        setTitle("Listagem de Nacionalidades");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Colunas
        String[] colunas = {"ID", "Nome"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        // Carregar dados do ficheiro
        NacionalidadeRepositorio repo = new NacionalidadeRepositorio();
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
