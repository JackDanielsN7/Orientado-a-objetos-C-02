/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.clinicareserve.dao;

/**
 *
 * @author SOFTWARE
 */
import com.upeu.clinicareserve.modelo.Medico;
import com.upeu.clinicareserve.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private Connection conn;

    public MedicoDAO() {
        conn = Conexion.getConexion();
    }

    public List<Medico> listar() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM Registro_Medico";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Medico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("celular"),
                        rs.getString("especialidad")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar médicos: " + e.getMessage());
        }
        return lista;
    }

    public boolean insertar(Medico m) {
        String sql = "INSERT INTO Registro_Medico(nombre, documento, celular, especialidad) VALUES(?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDocumento());
            ps.setString(3, m.getCelular());
            ps.setString(4, m.getEspecialidad());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar médico: " + e.getMessage());
            return false;
        }
    }
}