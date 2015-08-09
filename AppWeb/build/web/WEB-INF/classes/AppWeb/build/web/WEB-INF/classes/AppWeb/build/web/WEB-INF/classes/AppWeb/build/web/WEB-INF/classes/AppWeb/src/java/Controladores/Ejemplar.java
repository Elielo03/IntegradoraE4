/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Util.ConexionSQLServer;
import app.Daos.DaoEditorial;
import app.Daos.DaoEjemplar;
import app.Daos.DaoEstante;
import app.Daos.DaoLibro;
import app.model.BeanEditorial;
import app.model.BeanEjemplar;
import app.model.BeanEstante;
import app.model.BeanLibro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Ejemplar extends HttpServlet {

    private DaoEjemplar dao;
    private Connection con;
    private DaoEstante daoEstante;
    private DaoLibro daoLibro;
    private List<BeanLibro> listaLibro;
    private List<BeanEstante> listaEstante;
    private DaoEditorial daoEdi;
    private List<BeanEditorial> listaEdi;

    public Ejemplar() {

        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Ejemplar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection conexion() {
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
            } else if (operacion.equals("combos")) {

                irA = this.processllenarCombos(request, response);
            } else if (operacion.equals("combos2")) {

                irA = this.processllenarCombos2(request, response); 
            
            
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
        List<BeanEjemplar> ejemplarList = new ArrayList();
        dao = new DaoEjemplar(con);
        String irA = "/mensaje.jsp";
        String libro = request.getParameter("cmbLibro");
        String estante = request.getParameter("cmbEstante");
        String num = request.getParameter("txtNum");

        int numEjemplares = Integer.parseInt(num);

        BeanEstante beanEstante = new BeanEstante();
        DaoEstante daoE = new DaoEstante(con);
        beanEstante = daoE.findByNombre(estante);

        BeanLibro beanLibro = new BeanLibro();
        DaoLibro daoLib = new DaoLibro(con);
        beanLibro = daoLib.findByNombre(libro);

        BeanEjemplar bean = new BeanEjemplar();
        bean.setEstante(beanEstante);
        bean.setLibro(beanLibro);

        for (int i = 0; i < numEjemplares; i++) {
            BeanEjemplar beanEj = new BeanEjemplar();
            beanEj.setEstante(beanEstante);
            beanEj.setLibro(beanLibro);
            ejemplarList.add(beanEj);
        }
        int cuenta = 0;

        for (BeanEjemplar ejemplar : ejemplarList) {
            if (!dao.addEjemplar(bean)) {
                request.setAttribute("mensaje", "error al crear el registro");
                irA = "/mensaje.jsp";
            } else {
                cuenta++;
            }
            if (cuenta > 0) {
                irA = "/Ejemplar?action=consultar";
            }

           
        }
 return irA;
    }

    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/IndexUsuario.jsp";
        dao = new DaoEjemplar(con);
        List<BeanEjemplar> ejemplar = dao.getAll();

        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attEjemplar", ejemplar);

        irA = "/ReadEjemplar.jsp";
        return irA;
    }

    protected String processActualizarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BeanEjemplar bean = new BeanEjemplar();
        String irA = "/mensaje.jsp";
        String id = request.getParameter("id");
        String nombre = request.getParameter("txtNombre");
//        bean.setEstante(Integer.parseInt(id));

        dao = new DaoEjemplar(con);

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
         dao = new DaoEjemplar(con);
        int id = 0;
        boolean elimino = false;
        try {
            id = Integer.parseInt(pId);

            elimino = dao.baja(id);
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
        }
        if (elimino == false) {
            request.setAttribute("mensaje", "error al eliminar registro con id=" + id);
            irA = "/mensaje.jsp";
        } else {
            request.setAttribute("mensaje", "éxito al eliminar registro ID=" + id);
        }
        irA = "/Ejemplar?action=consultar";
        return irA;
    }

    protected String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/IndexUsuario.jsp";
        dao = new DaoEjemplar(con);
        String pId = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(pId);
            BeanEjemplar ejemplar = dao.get(id);
            request.setAttribute("attEjemplar", ejemplar);
            irA = "/UpdateEjemplar.jsp";
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
            irA = "/mensaje.jsp";
        }
        return irA;
    }

    private String processllenarCombos(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/CreateEjemplar.jsp";
        daoLibro = new DaoLibro(con);
        daoEstante = new DaoEstante(con);

        listaLibro = daoLibro.getAll();
        listaEstante = daoEstante.getAll();

        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("libro", listaLibro);
        request.setAttribute("estante", listaEstante);

        return irA;
    }
    
     private String processllenarCombos2(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/Estadistica.jsp";
        daoLibro = new DaoLibro(con);
        daoEdi = new DaoEditorial(con);

        listaLibro = daoLibro.maxEjemplar();
        
        listaEdi = daoEdi.minEditorial();

        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("libro", listaLibro);
        request.setAttribute("editorial", listaEdi);

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
