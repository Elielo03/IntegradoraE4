/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author Eliel David
 */
public class BeanArea {
    private int id_area;
    private String nombre;
    private boolean alta;
    

    public BeanArea() {
    }

    public BeanArea(int id_area, String nombre, boolean alta) {
        this.id_area = id_area;
        this.nombre = nombre;
        this.alta = alta;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return nombre+alta;
    }
    
    
    
    
}
