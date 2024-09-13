package com.mycompany.hospital;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class TelaExcluirConsulta extends JFrame {
    private Usuario usuario;
    private AgendaConsultas agendaConsultas;

    public TelaExcluirConsulta(Usuario usuario, AgendaConsultas agendaConsultas) {
        this.usuario = usuario;
        this.agendaConsultas = agendaConsultas;

        setTitle("Excluir Consulta");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Obtém a lista de consultas marcadas pelo usuário
        List<Consulta> consultasUsuario = obterConsultasUsuario();

        // Cria uma lista de consultas em formato de texto para exibir no combo box
        List<String> consultasTexto = new ArrayList<>();
        for (Consulta consulta : consultasUsuario) {
            String consultaTexto = consulta.getData() + " - " + consulta.getHorario() + " - " + consulta.getMedico();
            consultasTexto.add(consultaTexto);
        }

        // Cria o combo box com as consultas marcadas pelo usuário
        JComboBox<String> comboConsultas = new JComboBox<>(consultasTexto.toArray(new String[0]));

        // Botão para excluir a consulta selecionada
        JButton botaoExcluir = new JButton("Excluir");

        // Painel para organizar os componentes
        JPanel painelCentral = new JPanel(new GridLayout(3, 2, 10, 10));
        painelCentral.add(new JLabel("Consultas Marcadas:"));
        painelCentral.add(comboConsultas);
        painelCentral.add(new JLabel()); // Espaço em branco
        painelCentral.add(new JLabel()); // Espaço em branco
        painelCentral.add(new JLabel()); // Espaço em branco
        painelCentral.add(botaoExcluir);

        // Adiciona o painel central à janela
        add(painelCentral, BorderLayout.CENTER);

        // Listener para o botão de excluir
        botaoExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String consultaSelecionada = (String) comboConsultas.getSelectedItem();

                if (consultaSelecionada != null) {
                    String[] partes = consultaSelecionada.split(" - ");
                    String data = partes[0];
                    String horario = partes[1];
                    String medico = partes[2];

                    boolean excluiu = agendaConsultas.excluirConsulta(usuario.getNomeUsuario(), data, horario, medico);
                    if (excluiu) {
                        JOptionPane.showMessageDialog(TelaExcluirConsulta.this, "Consulta excluída com sucesso!");
                        dispose(); // Fecha a tela de exclusão de consulta
                    } else {
                        JOptionPane.showMessageDialog(TelaExcluirConsulta.this, "Erro ao excluir consulta.");
                    }
                } else {
                    JOptionPane.showMessageDialog(TelaExcluirConsulta.this, "Nenhuma consulta selecionada.");
                }
            }
        });
    }
    public boolean excluirConsulta(String nomeUsuario, String data, String horario, String medico) {
        List<Consulta> consultas = null;
		Iterator<Consulta> iterator = consultas.iterator();
        while (iterator.hasNext()) {
            Consulta consultas1 = iterator.next();
            if (consultas1.getNomeUsuario().equals(nomeUsuario) && consultas1.getData().equals(data) &&
                consultas1.getHorario().equals(horario) && consultas1.getMedico().equals(medico)) {
                iterator.remove();
                System.out.println("Consulta excluída: " + consultas1);
                return true;
            }
        }
        System.out.println("Consulta não encontrada para exclusão.");
        return false;
    }
    // Método para obter a lista de consultas marcadas pelo usuário
    private List<Consulta> obterConsultasUsuario() {
        List<Consulta> consultasUsuario = new ArrayList<>();
        for (Consulta consulta : agendaConsultas.listarConsultas()) {
            if (consulta.getNomeUsuario().equals(usuario.getNomeUsuario())) {
                consultasUsuario.add(consulta);
            }
        }
        return consultasUsuario;
    }
}
