/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hospital;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class TelaLogin extends JFrame {
    private JTextField campoNomeUsuario;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoRegistrar;
    private RegistroLogin registroLogin;
    private AgendaConsultas agendaConsultas;

    public TelaLogin(RegistroLogin registroLogin, AgendaConsultas agendaConsultas) {
        this.registroLogin = registroLogin;
        this.agendaConsultas = agendaConsultas;

        setTitle("Login de Usuário");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10)); // Atualizado para 5 linhas

        JLabel labelNomeUsuario = new JLabel("Nome de Usuário:");
        campoNomeUsuario = new JTextField(20);
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);
        botaoLogin = new JButton("Login");
        botaoRegistrar = new JButton("Registrar");
  

        add(labelNomeUsuario);
        add(campoNomeUsuario);
        add(labelSenha);
        add(campoSenha);
        add(new JLabel()); // Espaço em branco
        add(botaoLogin);
        add(new JLabel()); // Espaço em branco
        add(botaoRegistrar);
        add(new JLabel()); // Espaço em branco


        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    verificarLogin();
                } catch (SQLException ex) {
                    
                }
            }
        });

        botaoRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirTelaRegistro();
            }
        });

  

    }

    private void verificarLogin() throws SQLException {
        String nomeUsuario = campoNomeUsuario.getText();
        String senha = new String(campoSenha.getPassword());
        
        String sql = "SELECT * FROM paciente WHERE ";
        sql = sql + "nome ='" + nomeUsuario + "' AND ";
        sql = sql + "senha ='" + senha + "'";
        
        ConnectionFactory factory = new ConnectionFactory();
        Connection c = factory.obtemconexao();
        PreparedStatement ps;
        try{    
            ps = c.prepareStatement(sql);
        
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
                String email = rs.getString("email");
                Usuario user = new Usuario(nomeUsuario, senha, email);
                AgendaConsultas agenda = new AgendaConsultas();
                PainelPrincipal painel = new PainelPrincipal(user,agenda);
                painel.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciais inválidas!");
            }                
        } catch (SQLException ex) {
            System.out.println("erro cadastro");
            ex.printStackTrace();
        }
    }
    
    private void abrirTelaRegistro() {
        TelaRegistro telaRegistro = new TelaRegistro(registroLogin);
        telaRegistro.setVisible(true);
    }

 
    
}