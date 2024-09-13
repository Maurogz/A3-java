/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaVerConsultas extends JFrame {
    private Usuario usuario;
    private AgendaConsultas agendaConsultas;

    public TelaVerConsultas(Usuario usuario, AgendaConsultas agendaConsultas) {
        this.usuario = usuario;
        this.agendaConsultas = agendaConsultas;

        setTitle("Consultas Agendadas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        List<Consulta> consultas = agendaConsultas.listarConsultas();

        String[] colunas = {"Data", "Horário", "Médico"};
        String[][] dados = new String[consultas.size()][3];

        int i = 0;
        for (Consulta consulta : consultas) {
            if (consulta.getNomeUsuario().equals(usuario.getNomeUsuario())) {
                dados[i][0] = consulta.getData();
                dados[i][1] = consulta.getHorario();
                dados[i][2] = consulta.getMedico();
                i++;
            }
        }

        JTable tabelaConsultas = new JTable(dados, colunas);
        add(new JScrollPane(tabelaConsultas), BorderLayout.CENTER);
    }
}