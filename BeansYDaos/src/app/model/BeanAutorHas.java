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
public class BeanAutorHas {
    private int id_autor_has;
     private int  id_libro;
     private int id_autor;

    public BeanAutorHas() {
    }

    public BeanAutorHas(int id_autor_has, int id_libro, int id_autor) {
        this.id_autor_has = id_autor_has;
        this.id_libro = id_libro;
        this.id_autor = id_autor;
    }

    public int getId_autor_has() {
        return id_autor_has;
    }

    public void setId_autor_has(int id_autor_has) {
        this.id_autor_has = id_autor_has;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    
}
