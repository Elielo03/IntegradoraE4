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
import app.Daos.DaoLibro;
import app.Daos.DaoUsuario;
import app.model.BeanArea;
import app.model.BeanAutor;
import app.model.BeanEditorial;
import app.model.BeanLibro;
import app.model.BeanUsuario;
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
 * @author Eric
 */
public class Libro1 extends HttpServlet {

    private Connection con;

    private DaoLibro dlib;
    private DaoArea daoArea;
    private DaoAutor daoAutor;
    private List<BeanArea> listaArea;
    private List<BeanEditorial> listaEditorial;
    private List<BeanAutor> listaAutor;
    private List<BeanAutor> listAutor;
    private DaoEditorial daoEditorial;

    public Libro1() {
        try {
            con = ConexionSQLServer.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
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
            } else if (operacion.equals("combos")) {
                irA = this.combos(request, response);
            } else if (operacion.equals("llenarLista")) {
                irA = this.combos(request, response);
            } else if (operacion.equals("Libros")) {
                irA = this.processConsultar2(request, response);
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

        BeanLibro beanLibro = new BeanLibro();

        String irA = "/mensaje.jsp";

        String nombre = request.getParameter("txtTitulo");
        String ISBN = request.getParameter("txtISBN");
        String paginas = request.getParameter("txtPaginas");
         String editorial=request.getParameter("cmbEditorial");
           String area= request.getParameter("cmbArea");
       


       

        DaoArea daoarea = new DaoArea(con);
        BeanArea beanarea = new BeanArea();
        beanarea = daoarea.findByNombre(area);
        
        

        DaoEditorial daoeditorial = new DaoEditorial(con);
        BeanEditorial beanEditorial = new BeanEditorial();
        beanEditorial = daoeditorial.findByNombre(editorial);
        
        
        
        String aut="";
         listAutor = new ArrayList<>();
        DaoAutor daoautor= new DaoAutor(con);
        String [] autores =request.getParameterValues("to");
        
        for (int i = 0; i < autores.length; i++) {
           aut=autores[i];
           
            listAutor.add(daoAutor.findByNombre(aut));
            
        }
        beanLibro.setTitulo(nombre);
        beanLibro.setISBN(Long.parseLong(ISBN));
        beanLibro.setPaginas(Integer.parseInt(paginas));
        beanLibro.setArea(beanarea);
        beanLibro.setEditorial(beanEditorial);
        beanLibro.setAutores(listAutor);



        DaoLibro daoLibro = new DaoLibro(con);
       
       
        if (daoLibro.add(beanLibro)) {
            irA = "/Libro1?action=consultar";
           

        } else {

            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

        return irA;
    }

    private String processConsultar(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/IndexUsuario.jsp";
        dlib = new DaoLibro(con);
        List<BeanLibro> libros = dlib.getAll();
        
//        List<BeanAutor> autor= new ArrayList<>();
//        DaoAutor daoAutor = new DaoAutor(con);
//        autor=daoAutor.findByLibro(null)

        //atributo con el nombre: attAutores y valor: autores
        request.setAttribute("attLibro", libros);

        irA = "/ReadLibro.jsp";
        return irA;
    }

    private String processConsultar2(HttpServletRequest request, HttpServletResponse response) {

        String irA = "/IndexUsuario.jsp";
        dlib = new DaoLibro(con);
        List<BeanLibro> libros = dlib.getAll();

        //atributo con el nombre: attAutores y valor: autores
        request.setAttribute("attLibro", libros);

        irA = "/ReadLibro2.jsp";
        return irA;
    }

    protected String processActualizarRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
BeanLibro beanLibro = new BeanLibro();
        String irA = "/mensaje.jsp";
        int pId;
        String id=request.getParameter("id");
        pId=Integer.parseInt(id);
        String nombre = request.getParameter("txtTitulo");
         JOptionPane.showMessageDialog(null, nombre);
        String ISBN = request.getParameter("txtISBN");
         JOptionPane.showMessageDialog(null, ISBN);
        String paginas = request.getParameter("txtPaginas");
         JOptionPane.showMessageDialog(null, paginas);
         String editorial=request.getParameter("cmbEditorial");
           String area= request.getParameter("cmbArea");
           
            
        
       DaoArea daoarea = new DaoArea(con);
        BeanArea beanarea = new BeanArea();
        beanarea = daoarea.findByNombre(area);
         
       
        DaoEditorial daoeditorial = new DaoEditorial(con);
        BeanEditorial beanEditorial = new BeanEditorial();
        beanEditorial = daoeditorial.findByNombre(editorial);
         

       String aut="";
         listAutor = new ArrayList<>();
        DaoAutor daoautor= new DaoAutor(con);
        String [] autores =request.getParameterValues("to");
        
        for (int i = 0; i < autores.length; i++) {
           aut=autores[i];
             
            listAutor.add(daoAutor.findByNombre(aut));
            
        }
        beanLibro.setId_libro(pId);
         beanLibro.setTitulo(nombre);
        beanLibro.setISBN(Long.parseLong(ISBN));
        beanLibro.setPaginas(Integer.parseInt(paginas));
        beanLibro.setArea(beanarea);
        beanLibro.setEditorial(beanEditorial);
        beanLibro.setAutores(listAutor);

        DaoLibro daolib = new DaoLibro(con);

        if (daolib.update(beanLibro)) {
            irA = "/Libro1?action=consultar";

        } else {
            request.setAttribute("mensaje", "error al crear el registro");
            irA = "/mensaje.jsp";
        }

        return irA;

    }

    private String processEliminar(HttpServletRequest request, HttpServletResponse response) {


        String irA = "/IndexUsuario.jsp";

        String pId = request.getParameter("id");
        DaoLibro daol = new DaoLibro(con);
        int id = 0;
        boolean elimino = false;
        try {
            id = Integer.parseInt(pId);

            elimino = daol.baja(id);
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
        }
        if (elimino == false) {
            request.setAttribute("mensaje", "error al eliminar registro con id=" + id);
            irA = "/mensaje.jsp";
        } else {
            request.setAttribute("mensaje", "éxito al eliminar registro ID=" + id);
        }
        irA = "/Libro1?action=consultar";
        return irA;
    }

    protected String processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/IndexUsuario.jsp";
        
         daoArea = new DaoArea(con);
        daoAutor = new DaoAutor(con);
        daoEditorial = new DaoEditorial(con);

        listaArea = daoArea.getActive();
        listaEditorial = daoEditorial.getActive();
        listaAutor = daoAutor.getAll();
        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attArea", listaArea);
        request.setAttribute("attEditorial", listaEditorial);
        request.setAttribute("attAutor", listaAutor);
        
        
        DaoLibro dao = new DaoLibro(con);
        String pId = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(pId);
            BeanLibro lib = dao.get(id);
            request.setAttribute("attLibro", lib);
            irA = "/UpdateLibro.jsp";
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "error al obtener el ID");
            irA = "/mensaje.jsp";
        }
        return irA;
    }

    protected String combos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/CreateLibro.jsp";
        daoArea = new DaoArea(con);
        daoAutor = new DaoAutor(con);
        daoEditorial = new DaoEditorial(con);

        listaArea = daoArea.getActive();
        listaEditorial = daoEditorial.getActive();
        listaAutor = daoAutor.getAll();
        //atributo con el nombre: editorial y valor: autores
        request.setAttribute("attArea", listaArea);
        request.setAttribute("attEditorial", listaEditorial);
        request.setAttribute("attAutor", listaAutor);

        return irA;
    }

    protected String processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String irA = "/CreateLibro.jsp";
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
