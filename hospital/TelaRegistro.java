/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaRegistro extends JFrame {
    private JTextField campoNomeUsuario;
    private JPasswordField campoSenha;
    private JTextField campoEmail;
    private JButton botaoRegistrar;
    private RegistroLogin registroLogin;

    public TelaRegistro(RegistroLogin registroLogin) {
        this.registroLogin = registroLogin;

        setTitle("Registro de Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel labelNomeUsuario = new JLabel("Nome de Usuário:");
        campoNomeUsuario = new JTextField(20);
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);
        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);
        botaoRegistrar = new JButton("Registrar");

        add(labelNomeUsuario);
        add(campoNomeUsuario);
        add(labelSenha);
        add(campoSenha);
        add(labelEmail);
        add(campoEmail);
        add(new JLabel()); // Espaço em branco
        add(botaoRegistrar);

        botaoRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String nomeUsuario = campoNomeUsuario.getText();
        String senha = new String(campoSenha.getPassword());
        String email = campoEmail.getText();

        if (nomeUsuario.isEmpty() || senha.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
            return;
        }

         String sql = "INSERT INTO paciente (nome,senha, email) VALUES (?,?,?)";
        
        ConnectionFactory factory = new ConnectionFactory();
        Connection c = factory.obtemconexao();
        PreparedStatement ps;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,nomeUsuario);
            ps.setString(2,senha);
            ps.setString(3,email);
            ps.execute();             
        } catch (SQLException ex) {
            System.out.println("erro cadastro");
            ex.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(this, "Usuário registrado com sucesso!");
        dispose();
    }
    }
