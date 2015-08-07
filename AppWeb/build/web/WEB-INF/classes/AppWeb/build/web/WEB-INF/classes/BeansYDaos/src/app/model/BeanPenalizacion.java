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
public class BeanPenalizacion {
    private int id_penalizacion;
    private double monto;
    private int id_detallePrestamo;
    
    

    public BeanPenalizacion() {
    }

    public int getId_penalizacion() {
        return id_penalizacion;
    }

    public void setId_penalizacion(int id_penalizacion) {
        this.id_penalizacion = id_penalizacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId_detallePrestamo() {
        return id_detallePrestamo;
    }

    public void setId_detallePrestamo(int id_detallePrestamo) {
        this.id_detallePrestamo = id_detallePrestamo;
    }
    
    
}
