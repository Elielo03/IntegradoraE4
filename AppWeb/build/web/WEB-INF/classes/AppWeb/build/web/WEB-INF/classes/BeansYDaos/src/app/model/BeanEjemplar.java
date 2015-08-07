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
public class BeanEjemplar {
    private int id_ejemplar;
    private BeanLibro libro;
    private BeanEstante estante;

    public BeanEjemplar() {
    }

    public BeanEjemplar(int id_ejemplar, BeanLibro libro, BeanEstante estante) {
        this.id_ejemplar = id_ejemplar;
        this.libro = libro;
        this.estante = estante;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public BeanLibro getLibro() {
        return libro;
    }

    public void setLibro(BeanLibro libro) {
        this.libro = libro;
    }

    public BeanEstante getEstante() {
        return estante;
    }

    public void setEstante(BeanEstante estante) {
        this.estante = estante;
    }

   
    }

   
    
