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
public class BeanEditorial {
    private int id_editorial;
    private String nombre;
    private String direccion;
    private boolean alta;

    public BeanEditorial(int id_editorial, String nombre, String direccion, boolean alta) {
        this.id_editorial=id_editorial;
        this.nombre=nombre;
        this.direccion=direccion;
        this.alta=alta;
        
    }
    
    public BeanEditorial() {
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean getAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "\n"+nombre+ "\n"+direccion;
    }
    
    
}
