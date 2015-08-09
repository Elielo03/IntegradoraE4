/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Util.ConexionSQLServer;
import app.Daos.DaoAutor;
import app.model.BeanAutor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliel David
 */
public class Autor extends HttpServlet {

    private Connection con;
    private DaoAutor dao;

    public Autor() {

        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public Connection conexion(){
    return con;
}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/IndexUsuario.jsp";
        String operacion = request.getParameter("action");

        if (operacion != null) {
            if (operacion.equals("formAdd")) {
                irA = this.processAdd(request, response);
            } else if (operacion.equals("crear")) {
               
                irA = this.processNuevoRegistro(request, response);
            } else if (operacion.equals("consultar")) {
                irA = this.processConsultar(request, response);
            } else if (operacion.equals("formEdit")) {
                irA = this.processEdit(request, response);
            } else if (operacion.equals("modificar")) {
                irA = this.processActualizarRegistro(request, response);
            } else if (operacion.equals("eliminar")) {
                irA = this.processEliminar(request, response);
            } else {
                request.setAttribute("mensaje", "operación no soportada: " + operacion);
                irA = "/mensaje.jsp";
            }

        } else {
            request.setAttribute("Mnesaje", "No se especifico el action");
            irA = "/mensaje.jsp";
        }
        this.getServletConfig().getServletContext().getRequestDispatcher(irA).forward(request, response);

    }

    public String processNuevoRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BeanAutor beanAutor= new BeanAutor();
        String irA = "/mensaje.jsp";
        String nombre = request.getParameter("txtNombre");
        String primerApellido = request.getParameter("txtApellido1");
        String segundoApellido = request.getParameter("txtApellido2");
        String pais = request.getParameter("txtpais");
        beanAutor.setNombre(nombre);
        beanAutor.setPrimer_apellido(primerApellido);
         beanAutor.setSegundo_apellido(segundoApellido);
         beanAutor.setPais(pais);
        
        
        DaoAutor daoAutor = new DaoAutor(con);
        if (daoAutor.addAutor(beanAutor)) {
            irA = "/Autor?action=consultar";
            
        } else {
            
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/IndexUsuario.jsp";
        }

        return irA;
    }
    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {
        
        String irA="/IndexUsuario.jsp";
        dao = new DaoAutor(con);
        List<BeanAutor> autores = dao.getAll();
        
       
        //atributo con el nombre: attAutores y valor: autores
        request.setAttribute("attAutores", autores);
        
        irA="/ReadAutor.jsp";
        return irA;
    }
               

    

    protected String processActualizarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String irA="/";
        String id=request.getParameter("id");
        String nombre = request.getParameter("txtNombre");
        String primerApellido = request.getParameter("txtApellido1");
        String segundoApellido = request.getParameter("txtApellido2");
        String pais = request.getParameter("txtpais");
        BeanAutor bean = new BeanAutor();
        bean.setId_autor(Integer.parseInt(id));
        bean.setNombre(nombre);
        bean.setPrimer_apellido(primerApellido);
        bean.setSegundo_apellido(segundoApellido);
        bean.setPais(pais);
        DaoAutor daoAutor = new DaoAutor(con);
        
        if (daoAutor.update(bean)) {
            irA = "/Autor?action=consultar";

        } else {
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/IndexUsuario.jsp";
        }

        return irA;
        
        
        
    }

    private String processEliminar(HttpServletRequest request, HttpServletResponse response) {
       
        String irA="/IndexUsuario.jsp";
        String pId=request.getParameter("id"); 
        DaoAutor dao=new DaoAutor(con);
        int id=0;
        boolean elimino=false;        
        try{
        id=Integer.parseInt(pId);
        elimino = dao.deleteAutor(id);                                
        }catch(NumberFormatException e){             
            request.setAttribute("mensaje", "error al obtener el ID");            
        }
        if(elimino==false){
            request.setAttribute("mensaje", "error al eliminar registro con id="+id);
            irA="/IndexUsuario.jsp";
        }else
            request.setAttribute("mensaje", "éxito al eliminar registro ID="+id);
        irA="/Autor?action=consultar";
        return irA;
    }

     protected String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String irA="/IndexUsuario.jsp";
        DaoAutor dao=new DaoAutor(con);
        String pId=request.getParameter("id");
        int id=0;
        try{
        id=Integer.parseInt(pId);
        BeanAutor autor = dao.get(id);        
        request.setAttribute("attAutor", autor);
        irA="/UpdateAutor.jsp";        
        }catch(NumberFormatException e){ 
            request.setAttribute("mensaje", "error al obtener el ID");
            irA="/mensaje.jsp";
        }        
        return irA;
    }
     
     
     protected String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA="/Createautor.jsp";
        return irA;
    }
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
