/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Util.ConexionSQLServer;
import app.Daos.DaoArea;
import app.Daos.DaoEstante;

import app.model.BeanEstante;
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

/**
 *
 * @author Eliel David
 */
public class Estante extends HttpServlet {
    private DaoEstante dao ;
    private Connection con;
    

    public Estante() {
        try {
            con=ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Estante.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String irA ="/IndexUsuario.jsp";
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

        BeanEstante beanEstante = new BeanEstante();
        String irA = "/mensaje.jsp";
        String ubicacion = request.getParameter("txtNombre");
        

        

        beanEstante.setUbicacion(ubicacion);

        DaoEstante daoEstante = new DaoEstante(con);
        if (daoEstante.add(beanEstante)) {
            irA = "/Estante?action=consultar";

        } else {
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";

        }

        return irA;
    }

    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/IndexUsuario.jsp";
        dao = new DaoEstante(con);
        List<BeanEstante> estante = dao.getAll();

        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attEstante", estante);

        irA = "/ReadEstante.jsp";
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
        

         dao = new DaoEstante(con);

        if (dao.update(bean)) {
            irA = "/Estante?action=consultar";

        } else {
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

        return irA;

    }

    private String processEliminar(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/IndexUsuario.jsp";
        String pId = request.getParameter("id");
         dao = new DaoEstante(con);
        int id = 0;
        boolean elimino = false;
        try {
            id = Integer.parseInt(pId);

            elimino = dao.del(id);
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
         dao = new DaoEstante(con);
        String pId = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(pId);
            BeanEstante estante = dao.get(id);
            request.setAttribute("attEstante", estante);
            irA = "/UpdateEstante.jsp";
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
            irA = "/mensaje.jsp";
        }
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
