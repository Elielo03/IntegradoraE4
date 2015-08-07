/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.sql.Date;

/**
 *
 * @author Eliel David
 */
public class BeanPrestamo {
    private int id_prestamo;
      private int id_usuario;
        private int id_ejemplar;
    private Date fecha_salida;
    private Date fecha_entrega;
  

    public BeanPrestamo(int id_prestamo, int id_usuario, int id_ejemplar, Date fecha_salida, Date fecha_entrega) {
        this.id_prestamo = id_prestamo;
        this.id_usuario = id_usuario;
        this.id_ejemplar = id_ejemplar;
        this.fecha_salida = fecha_salida;
        this.fecha_entrega = fecha_entrega;
    }

    public BeanPrestamo() {
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    
    
}
