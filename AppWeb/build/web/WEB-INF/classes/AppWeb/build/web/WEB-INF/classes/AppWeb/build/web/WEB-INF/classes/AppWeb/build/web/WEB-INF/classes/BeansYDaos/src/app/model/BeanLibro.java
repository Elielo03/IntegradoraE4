/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.util.List;

/**
 *
 * @author Eliel David
 */
public class BeanLibro {

    private int id_libro;
    private String titulo;
    private long ISBN;
    private int paginas;
    private BeanArea area;
    private BeanEditorial editorial;
    private List<BeanAutor>autores;
    
        
        
        
    
   

    public BeanLibro(int id_libro, String titulo, long ISBN, int paginas, BeanArea area, BeanEditorial editorial, List<BeanAutor> autores) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.paginas = paginas;
        this.area = area;
        this.editorial = editorial;
        this.autores = autores;
    }
    

    public BeanLibro() {
    }

   

    public List<BeanAutor> getAutores() {
        return autores;
    }

    public void setAutores(List<BeanAutor> autores) {
        this.autores = autores;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

   
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    
    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public BeanArea getArea() {
        return area;
    }

    public void setArea(BeanArea area) {
        this.area = area;
    }

    public BeanEditorial getEditorial() {
        return editorial;
    }

    public void setEditorial(BeanEditorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return titulo+" "+ISBN+" "+ paginas +" "+editorial
                +" "+area +" "+autores;
    }

  

}
