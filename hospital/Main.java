/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RegistroLogin registroLogin = new RegistroLogin();
                AgendaConsultas agendaConsultas = new AgendaConsultas();
                TelaLogin telaLogin = new TelaLogin(registroLogin, agendaConsultas);
                telaLogin.setVisible(true);
            }
        });
    }
}