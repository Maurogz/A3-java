/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelPrincipal extends JFrame {
    private Usuario usuario;
    private AgendaConsultas agendaConsultas;

    public PainelPrincipal(Usuario usuario, AgendaConsultas agendaConsultas) {
        this.usuario = usuario;
        this.agendaConsultas = agendaConsultas;

        setTitle("Painel Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criando barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Criando menus
        JMenu menuConsulta = new JMenu("Consultas");
        JMenu menuUsuario = new JMenu("Usuário");

        // Criando itens de menu
        JMenuItem itemMarcarConsulta = new JMenuItem("Marcar Consulta");
        JMenuItem itemVerConsultas = new JMenuItem("Ver Consultas");
        JMenuItem itemExcluirConsulta = new JMenuItem("Excluir Consulta"); // Novo item de menu

        // Adicionando itens aos menus
        menuConsulta.add(itemMarcarConsulta);
        menuConsulta.add(itemVerConsultas);
        menuConsulta.add(itemExcluirConsulta); // Adicionando o novo item ao menu de consultas
        menuUsuario.add(new JMenuItem("Logout"));

        // Adicionando menus à barra de menu
        menuBar.add(menuConsulta);
        menuBar.add(menuUsuario);

        // Configurando barra de menu na janela
        setJMenuBar(menuBar);

        // Adicionando listeners para os itens de menu
        itemMarcarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                marcarConsulta();
            }
        });

        itemVerConsultas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verConsultas();
            }
        });

        itemExcluirConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirConsulta();
            }
        });

        // Layout básico para o conteúdo principal
        JLabel bemVindoLabel = new JLabel("Bem-vindo, " + usuario.getNomeUsuario() + "!", SwingConstants.CENTER);
        bemVindoLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(bemVindoLabel, BorderLayout.CENTER);
    }

    private void marcarConsulta() {
        TelaMarcarConsulta telaMarcarConsulta = new TelaMarcarConsulta(usuario, agendaConsultas);
        telaMarcarConsulta.setVisible(true);
    }

    private void verConsultas() {
        TelaVerConsultas telaVerConsultas = new TelaVerConsultas(usuario, agendaConsultas);
        telaVerConsultas.setVisible(true);
    }

    private void excluirConsulta() {
        TelaExcluirConsulta telaExcluirConsulta = new TelaExcluirConsulta(usuario, agendaConsultas);
        telaExcluirConsulta.setVisible(true);
    }
}