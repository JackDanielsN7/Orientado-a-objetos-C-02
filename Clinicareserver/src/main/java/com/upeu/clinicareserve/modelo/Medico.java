/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upeu.clinicareserve.modelo;

/**
 *
 * @author SOFTWARE
 */
public class Medico {
    private int id;
    private String nombre;
    private String documento;
    private String celular;
    private String especialidad;

    public Medico() {}
    public Medico(int id, String nombre, String documento, String celular, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.celular = celular;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
