/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AgendaConsultas {
    private List<Consulta> consultas;

    public AgendaConsultas() {
        this.consultas = new ArrayList<>();
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> listarConsultas() {
        return new ArrayList<>(consultas);
    }

    // Método para excluir uma consulta
    public boolean excluirConsulta(String nomeUsuario, String data, String horario, String medico) {
        Iterator<Consulta> iterator = consultas.iterator();
        while (iterator.hasNext()) {
            Consulta consulta = iterator.next();
            if (consulta.getNomeUsuario().equals(nomeUsuario) &&
                consulta.getData().equals(data) &&
                consulta.getHorario().equals(horario) &&
                consulta.getMedico().equals(medico)) {
                iterator.remove();
                return true;
            }
        }
        return false; // Retorna false se a consulta não for encontrada
    }
}