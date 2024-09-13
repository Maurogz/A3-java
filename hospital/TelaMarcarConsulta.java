/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMarcarConsulta extends JFrame {
    private JComboBox<String> comboData;
    private JComboBox<String> comboHorario;
    private JComboBox<String> comboMedicos;
    private JButton botaoMarcar;
    private AgendaConsultas agendaConsultas;
    private Usuario usuario;

    public TelaMarcarConsulta(Usuario usuario, AgendaConsultas agendaConsultas) {
        this.usuario = usuario;
        this.agendaConsultas = agendaConsultas;

        setTitle("Marcar Consulta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel labelData = new JLabel("Data:");
        
        // Adicionando uma lista de datas ao combo box
        String[] datas = {
            "01/06/2024", "02/06/2024", "03/06/2024",
            "04/06/2024", "05/06/2024", "06/06/2024",
            "07/06/2024", "08/06/2024", "09/06/2024", "10/06/2024"
        };
        comboData = new JComboBox<>(datas);
        
        JLabel labelHorario = new JLabel("Horário:");
        
        // Adicionando uma lista de horários ao combo box
        String[] horarios = {
            "08:00", "09:00", "10:00", "11:00",
            "13:00", "14:00", "15:00", "16:00"
        };
        comboHorario = new JComboBox<>(horarios);
        
        JLabel labelMedico = new JLabel("Médico:");
        
        // Adicionando uma lista de médicos ao combo box
        String[] medicos = {
            "Dr. João - Cardiologista",
            "Dra. Maria - Dermatologista",
            "Dr. Pedro - Ortopedista",
            "Dra. Ana - Pediatra",
            "Dr. José - Neurologista",
            "Dra. Clara - Ginecologista",
            "Dr. Marcos - Urologista",
            "Dra. Luiza - Oftalmologista",
            "Dr. Ricardo - Otorrinolaringologista",
            "Dra. Fernanda - Endocrinologista"
        };
        comboMedicos = new JComboBox<>(medicos);

        botaoMarcar = new JButton("Marcar");

        add(labelData);
        add(comboData);
        add(labelHorario);
        add(comboHorario);
        add(labelMedico);
        add(comboMedicos);
        add(new JLabel()); // Espaço em branco
        add(botaoMarcar);

        botaoMarcar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                marcarConsulta();
            }
        });
    }

    private void marcarConsulta() {
        String data = (String) comboData.getSelectedItem();
        String horario = (String) comboHorario.getSelectedItem();
        String medico = (String) comboMedicos.getSelectedItem();

        if (data == null || horario == null || medico == null) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

        Consulta consulta = new Consulta(usuario.getNomeUsuario(), data, horario, medico);
        agendaConsultas.adicionarConsulta(consulta);
        JOptionPane.showMessageDialog(this, "Consulta marcada com sucesso!");
        dispose();
    }
}