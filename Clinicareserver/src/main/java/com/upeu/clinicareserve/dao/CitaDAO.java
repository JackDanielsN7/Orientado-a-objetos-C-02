/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.clinicareserve.dao;

/**
 *
 * @author SOFTWARE
 */
import com.upeu.clinicareserve.modelo.Cita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    private Connection conn;

    public CitaDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:clinica.db");
        } catch (SQLException e) {
        }
    }

    // Insertar cita
    public void insertarCita(Cita c) {
        String sql = "INSERT INTO citas(paciente, medico, fecha, hora) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getPaciente());
            ps.setString(2, c.getMedico());
            ps.setString(3, c.getFecha());
            ps.setString(4, c.getHora());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Listar citas
    public List<Cita> listarCitas() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cita c = new Cita();
                c.setId(rs.getInt("id"));
                c.setPaciente(rs.getString("paciente"));
                c.setMedico(rs.getString("medico"));
                c.setFecha(rs.getString("fecha"));
                c.setHora(rs.getString("hora"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar cita
    public void actualizarCita(Cita c) {
        String sql = "UPDATE citas SET paciente=?, medico=?, fecha=?, hora=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getPaciente());
            ps.setString(2, c.getMedico());
            ps.setString(3, c.getFecha());
            ps.setString(4, c.getHora());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar cita
    public void eliminarCita(int id) {
        String sql = "DELETE FROM citas WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
