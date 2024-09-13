/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

import java.util.ArrayList;
import java.util.List;

public class RegistroLogin {
    private final List<Usuario> usuariosRegistrados;

    public RegistroLogin() {
        this.usuariosRegistrados = new ArrayList<>();
    }

    public void registrarUsuario(String nomeUsuario, String senha, String email) {
        Usuario novoUsuario = new Usuario(nomeUsuario, senha, email);
        usuariosRegistrados.add(novoUsuario);
    }

    public boolean verificarCredenciais(String nomeUsuario, String senha) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNomeUsuario().equals(nomeUsuario) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Usuario obterUsuario(String nomeUsuario) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}