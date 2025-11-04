/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.clinicareserve.servicio;

/**
 *
 * @author SOFTWARE
 */
import com.upeu.clinicareserve.dao.CitaDAO;
import com.upeu.clinicareserve.modelo.Cita;
import java.util.List;

public class CitaService {
    private CitaDAO citaDAO;

    public CitaService() {
        citaDAO = new CitaDAO();
    }

    // 1. Agregar nueva cita con validaciones
    public void agregarCita(Cita c) {
        if (c.getPaciente() == null || c.getPaciente().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente no puede estar vacío");
        }
        if (c.getMedico() == null || c.getMedico().isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar un médico");
        }
        if (c.getFecha() == null || c.getFecha().isEmpty()) {
            throw new IllegalArgumentException("Debe indicar la fecha de la cita");
        }
        if (c.getHora() == null || c.getHora().isEmpty()) {
            throw new IllegalArgumentException("Debe indicar la hora de la cita");
        }

        // Aquí podrías añadir reglas más específicas, como:
        // - Verificar que el médico no tenga otra cita a la misma hora
        // - Limitar citas por paciente al día
        citaDAO.insertarCita(c);
    }

    // 2. Listar todas las citas
    public List<Cita> obtenerCitas() {
        return citaDAO.listarCitas();
    }

    // 3. Actualizar cita
    public void actualizarCita(Cita c) {
        // Podrías validar si la cita ya pasó, etc.
        citaDAO.actualizarCita(c);
    }

    // 4. Eliminar cita
    public void eliminarCita(int id) {
        citaDAO.eliminarCita(id);
    }
}