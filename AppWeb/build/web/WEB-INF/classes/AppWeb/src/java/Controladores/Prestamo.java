/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Util.ConexionSQLServer;
import app.Daos.DaoArea;
import app.Daos.DaoAutor;
import app.Daos.DaoEditorial;
import app.Daos.DaoEjemplar;
import app.Daos.DaoEstante;
import app.Daos.DaoLibro;
import app.Daos.DaoPrestamo;
import app.Daos.DaoUsuario;
import app.model.BeanAutor;
import app.model.BeanEjemplar;
import app.model.BeanEstante;
import app.model.BeanLibro;
import app.model.BeanPrestamo;
import app.model.BeanUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * @author Eric
 */
public class Prestamo extends HttpServlet {

 
   
    private Connection con;
    private DaoPrestamo dao;
    private List<BeanUsuario>listaUser;
    private List <BeanEjemplar>listEjemplar;

    public Prestamo() {

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
            }else if (operacion.equals("combos")) {
                irA = this.combos(request, response);
            } 
            else if (operacion.equals("modificar")) {
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
        
        BeanPrestamo beanP= new BeanPrestamo();
        String irA = "/mensaje.jsp";
        
        int idUser;
        int idEjemplar;
        String user= request.getParameter("cmbUsuario");
        String ejemplar= request.getParameter("cmbEjemplar");
        String fecha_salida = request.getParameter("txtFechaSalida");
        String fecha_entrega = request.getParameter("txtFechaEntrega");
        
        idUser=Integer.parseInt(user);
        idEjemplar=Integer.parseInt(ejemplar);
        
        DaoEjemplar daoEjemplar= new DaoEjemplar(con);
        BeanEjemplar beanEjemplar= new BeanEjemplar();
        beanEjemplar=daoEjemplar.get(idUser);
        
        
        DaoUsuario daoUser= new DaoUsuario(con);
        BeanUsuario beanUsuario= new BeanUsuario();
        beanUsuario=daoUser.get(idUser);
        
        
        DaoPrestamo daoPrestamo = new DaoPrestamo(con);
        BeanPrestamo bean= new BeanPrestamo();
        bean.setId_usuario(beanUsuario.getId_usuario());
        bean.setId_ejemplar(beanEjemplar.getId_ejemplar());
//        bean.setFecha_salida(fecha_salida);
        
        if (daoPrestamo.add(bean)) {
            irA = "/Prestamo?action=consultar";
           
        } else {
            
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

        return irA;
    }
    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {
        
        String irA="/IndexUsuario.jsp";
        dao = new DaoPrestamo(con);
        List<BeanPrestamo> prestamo = dao.getAll();
        
       
        //atributo con el nombre: attAutores y valor: autores
        request.setAttribute("attPrestamo", prestamo);
        
        irA="/ReadPrestamo.jsp";
        return irA;
    }
               

    

   
     protected String processActualizarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         BeanEstante bean = new BeanEstante();
        String irA = "/mensaje.jsp";
        String id = request.getParameter("id");
        String nombre = request.getParameter("txtNombre");
        bean.setId_estante(Integer.parseInt(id));
        bean.setUbicacion(nombre);
        

//         dao = new DaoEstante(con);
//
//        if (dao.update(bean)) {
//            irA = "/Estante?action=consultar";
//
//        } else {
//            request.setAttribute("mensaje", "error al crear el registro");
//            irA = "/mensaje.jsp";
//        }

        return irA;

    }

    private String processEliminar(HttpServletRequest request, HttpServletResponse response) {

        String irA ="/IndexUsuario.jsp";
        String pId = request.getParameter("id");
//         dao = new DaoEstante(con);
        int id = 0;
        boolean elimino = false;
        try {
            id = Integer.parseInt(pId);

//            elimino = dao.del(id);
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
        }
        if (elimino == false) {
            request.setAttribute("mensaje", "error al eliminar registro con id=" + id);
            irA = "/mensaje.jsp";
        } else {
            request.setAttribute("mensaje", "éxito al eliminar registro ID=" + id);
        }
        irA = "/Estante?action=consultar";
        return irA;
    }

    protected String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/IndexUsuario.jsp";
//         dao = new DaoEstante(con);
//        String pId = request.getParameter("id");
//        int id = 0;
//        try {
//            id = Integer.parseInt(pId);
//            BeanEstante estante = dao.get(id);
//            request.setAttribute("attEstante", estante);
//            irA = "/UpdateEstante.jsp";
//        } catch (NumberFormatException e) {
//            request.setAttribute("mensaje", "error al obtener el ID");
//            irA = "/mensaje.jsp";
//        }
        return irA;
    }
    
    protected String combos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/CreatePrestamo.jsp";
       DaoUsuario daoUsuario = new DaoUsuario(con);
        DaoEjemplar daoEjemplar = new DaoEjemplar(con);
        

        listaUser = daoUsuario.getActive();
        listEjemplar = daoEjemplar.getAll();
        
        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attUsuario", listaUser);
        request.setAttribute("attLibro", listEjemplar);
        

        return irA;
    }

    protected String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/CreateEstante.jsp";
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
