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
public class BeanUsuario {
   private int id_usuario ;
private String nombre ;
private String primer_apellido ;
private String segundo_apellido ;
private String correo  ;
private boolean es_admi ;
private String pass ;
private String direccion;
private String telefono;
private boolean alta ;

    public BeanUsuario() {
    }

    public BeanUsuario(int id_usuario, String nombre, String primer_apellido, String segundo_apellido, String correo, boolean es_admi, String pass, String direccion, String telefono, boolean alta) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo = correo;
        this.es_admi = es_admi;
        this.pass = pass;
        this.direccion = direccion;
        this.telefono = telefono;
        this.alta = alta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEs_admi() {
        return es_admi;
    }

    public void setEs_admi(boolean es_admi) {
        this.es_admi = es_admi;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

   

    @Override
    public String toString() {
        return id_usuario+" "+nombre+" "+primer_apellido +" alta: "+alta+" admin: "+es_admi ;
    }
    
}
