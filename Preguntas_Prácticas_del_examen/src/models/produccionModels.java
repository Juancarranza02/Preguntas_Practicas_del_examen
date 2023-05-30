/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author CCNAR
 */
public class produccionModels {
    private String actividad;
    private String codigo;
    private int id;
    private String nombre;
    private String responsable;
    private String uso;

    public produccionModels() {
    }

    public produccionModels(String actividad, String codigo, int id, String nombre, String responsable, String uso) {
        this.actividad = actividad;
        this.codigo = codigo;
        this.id = id;
        this.nombre = nombre;
        this.responsable = responsable;
        this.uso = uso;
    }
    
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
    
    
}
