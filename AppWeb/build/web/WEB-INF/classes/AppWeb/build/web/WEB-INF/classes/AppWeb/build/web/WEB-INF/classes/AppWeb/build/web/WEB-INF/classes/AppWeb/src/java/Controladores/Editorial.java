/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Util.ConexionSQLServer;
import app.Daos.DaoAutor;
import app.Daos.DaoEditorial;
import app.model.BeanAutor;
import app.model.BeanEditorial;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Editorial extends HttpServlet {
    private Connection con;
    private DaoEditorial dao;
    
    

    public Editorial() {
        try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Editorial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection conexionn(){
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
       
        BeanEditorial beanEditorial= new BeanEditorial();
        String irA = "/mensaje.jsp";
        String nombre = request.getParameter("txtNombre");
        String direccion = request.getParameter("txtDireccion");
        String alta = request.getParameter("rdAlta");

        if (alta.equals("no")) {

            beanEditorial.setAlta(false);
        } else {
           
            beanEditorial.setAlta(true);
        }
       
        beanEditorial.setNombre(nombre);
        beanEditorial.setDireccion(direccion);
       
        
        
        DaoEditorial daoEditorial = new DaoEditorial(con);
        if (daoEditorial.add(beanEditorial)) {
            irA = "/Editorial1?action=consultar";
            
        } else {
            
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

       return irA;
    }
    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {
       
        String irA="/IndexUsuario.jsp";
        dao = new DaoEditorial(con);
        List<BeanEditorial> editorial = dao.getAll();
        
       
        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attEditorial", editorial);
        
        irA="/ReadEditorial.jsp";
        return irA;
    }
               

    

    protected String processActualizarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String irA="/";
        String id=request.getParameter("id");
        String nombre = request.getParameter("txtNombre");
        String direccion = request.getParameter("txtDireccion");
         String alta = request.getParameter("rdAlta");
        BeanEditorial bean = new BeanEditorial();
        if (alta.equals("no")) {

            bean.setAlta(false);
        } else {
           
            bean.setAlta(true);
        }
        
       
        bean.setId_editorial(Integer.parseInt(id));
        bean.setNombre(nombre);
       
       
        bean.setDireccion(direccion);
        
        DaoEditorial daoEditorial = new DaoEditorial(con);
        
        if (daoEditorial.update(bean)) {
            irA = "/Editorial1?action=consultar";

        } else {
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

        return irA;
        
        
        
    }

    private String processEliminar(HttpServletRequest request, HttpServletResponse response) {
       
        String irA="/IndexUsuario.jsp";
        String pId=request.getParameter("id"); 
       DaoEditorial daoEditorial = new DaoEditorial(con);
        int id=0;
        boolean elimino=false;        
        try{
        id=Integer.parseInt(pId);
            
        elimino = daoEditorial.deleteEditorial(id);                                
        }catch(NumberFormatException e){             
            request.setAttribute("mensaje", "error al obtener el ID");            
        }
        if(elimino==false){
            request.setAttribute("mensaje", "error al eliminar registro con id="+id);
            irA="/mensaje.jsp";
        }else
            request.setAttribute("mensaje", "éxito al eliminar registro ID="+id);
        irA="/Editorial1?action=consultar";
        return irA;
    }

     protected String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String irA="/IndexUsuario.jsp";
        DaoEditorial dao=new DaoEditorial(con);
        String pId=request.getParameter("id");
        int id=0;
        try{
        id=Integer.parseInt(pId);
        BeanEditorial editorial = dao.get(id);        
        request.setAttribute("attEditorial", editorial);
        irA="/UpdateEditorial.jsp";        
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
