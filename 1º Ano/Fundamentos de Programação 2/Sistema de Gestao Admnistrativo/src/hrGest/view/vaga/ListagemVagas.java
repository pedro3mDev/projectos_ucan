/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Pedro Moniz Ramos
Número: 17285
Ficheiro: ListagemVagas.java
--------------------------------------*/
package hrGest.view.vaga;

import hrGest.model.VagaModel;
import hrGest.controller.VagaController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListagemVagas extends JFrame {

    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    public ListagemVagas() {
        super("Listagem Geral de Vagas");
        configurarJanela();
        adicionarComponentes();
        setVisible(true);
    }

    private void configurarJanela() {
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    private void adicionarComponentes() {
        // Inicializa o modelo de tabela com as colunas
        String[] colunas = {
                "Código", "Nome", "Descrição", "Motivo", "Cargo", "Departamento", "Qtd. Recrutada"
        };
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modeloTabela);
        tabela.setFillsViewportHeight(true);

        // Busca os dados reais
        VagaController controller = new VagaController();
        List<VagaModel> vagas = controller.listarVagas();

        for (VagaModel v : vagas) {
            modeloTabela.addRow(new Object[]{
                    v.getCodigo(), v.getNome(), v.getDescricao(), v.getMotivo(),
                    v.getCargo(), v.getDepartamento(), v.getQuantidade()
            });
        }

        // Scroll com a tabela
        scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(30, 30, 920, 500);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListagemVagas::new);
    }
}
