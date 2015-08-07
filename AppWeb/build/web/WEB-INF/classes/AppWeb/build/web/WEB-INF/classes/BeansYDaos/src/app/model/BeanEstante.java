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
public class BeanEstante {
    private int id_estante;
    private String ubicacion;

    public BeanEstante() {
    }

    public BeanEstante(int id_estante, String ubicacion) {
        this.id_estante = id_estante;
        this.ubicacion = ubicacion;
    }

    public int getId_estante() {
        return id_estante;
    }

    public void setId_estante(int id_estante) {
        this.id_estante = id_estante;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return ubicacion;
    
}
}