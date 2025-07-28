package hrGest.view.vaga;

import hrGest.model.VagaModel;
import hrGest.repository.VagaRepositorio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class ListagemVagasParaEditar extends JFrame {

    private JTable tabela;
    private JButton editarBtn;
    private List<VagaModel> listaVagas;

    public ListagemVagasParaEditar() {
        setTitle("Selecionar Vaga para Editar");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listaVagas = VagaRepositorio.carregar();
        String[] colunas = {"Código", "Nome", "Descrição", "Motivo", "Cargo", "Departamento", "Qtd"};

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        for (VagaModel vaga : listaVagas) {
            modelo.addRow(new Object[]{
                    vaga.getCodigo(),
                    vaga.getNome(),
                    vaga.getDescricao(),
                    vaga.getMotivo(),
                    vaga.getCargo(),
                    vaga.getDepartamento(),
                    vaga.getQuantidade()
            });
        }

        tabela = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela);

        editarBtn = new JButton("Editar Vaga Selecionada");
        editarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada != -1) {
                    VagaModel vagaSelecionada = listaVagas.get(linhaSelecionada);
                    new EditarVaga(vagaSelecionada);
                    dispose(); // fecha esta tela
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma vaga para editar.");
                }
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(editarBtn, BorderLayout.SOUTH);

        setVisible(true);
    }
}
