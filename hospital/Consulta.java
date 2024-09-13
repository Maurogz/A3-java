/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;

public class Consulta {
    private String nomeUsuario;
    private String data;
    private String horario;
    private String medico;

    public Consulta(String nomeUsuario, String data, String horario, String medico) {
        this.nomeUsuario = nomeUsuario;
        this.data = data;
        this.horario = horario;
        this.medico = medico;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getMedico() {
        return medico;
    }
}