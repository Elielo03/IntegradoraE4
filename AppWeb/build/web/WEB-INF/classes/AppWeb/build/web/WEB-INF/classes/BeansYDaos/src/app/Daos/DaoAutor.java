/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.Daos;

import app.model.BeanAutor;
import app.model.BeanLibro;
import java.beans.Statement;
import java.sql.Array;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliel David
 */
public class DaoAutor extends AbstractDao<BeanAutor> {

    public DaoAutor(Connection con) {
        super(con);
        //
    }

    @Override
    public BeanAutor get(int id) {
        BeanAutor autor = new BeanAutor();
        String query = "SELECT * FROM " + "Autor" + " WHERE " + "id_autor" + " = ?";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {

                autor.setId_autor(result.getInt("id_autor"));
                autor.setNombre(result.getString("nombre"));
                autor.setPrimer_apellido(result.getString("primer_apellido"));
                autor.setSegundo_apellido(result.getString("segundo_apellido"));
                autor.setPais(result.getString("pais"));
            }

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autor;
    }

        public List<BeanAutor> getAllAu(int id) {
        List<BeanAutor> Autores = new ArrayList();
        BeanAutor Autor = new BeanAutor();
            
        String query = "SELECT nombre FROM Autor JOIN (Autor_has JOIN Libro "
                + "ON Autor_has.id_libro = Libro.id_libro) ON Autor.id_autor ="
                + "Autor_has.id_autor WHERE Libro.id_libro = ?;";

        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {                
                Autor.setNombre(result.getString("nombre"));
            }
            Autores = passResultSetest(result, Autores);            
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Autores;
    }
        
    public boolean addAutor(BeanAutor beanAutor) {
        String query = "insert into Autor(nombre, primer_apellido, segundo_apellido, pais)"
                + "values(?,?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, beanAutor.getNombre());
            ps.setString(2, beanAutor.getPrimer_apellido());
            ps.setString(3, beanAutor.getSegundo_apellido());
            ps.setString(4, beanAutor.getPais());

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    List<BeanAutor> passResultSet(ResultSet res, List<BeanAutor> list) throws SQLException {

        while (res.next()) {

            BeanAutor bean = new BeanAutor();
            bean.setId_autor(res.getInt("id_autor"));
            bean.setNombre(res.getString("nombre"));
            bean.setPrimer_apellido(res.getString("primer_apellido"));
            bean.setSegundo_apellido(res.getString("segundo_apellido"));
            bean.setPais(res.getString("pais"));
            list.add(bean);
        }

        return list;

    }
    
    List<BeanAutor> passResultSetest(ResultSet res, List<BeanAutor> list) throws SQLException {

        while (res.next()) {

            BeanAutor bean = new BeanAutor();
            bean.setNombre(res.getString("nombre"));
            list.add(bean);
        }

        return list;

    }

    @Override
    public List<BeanAutor> getAll() {

        List<BeanAutor> autores = new ArrayList();

        String query = "SELECT * from Autor order by id_autor" + " ASC;";

        try {
            ResultSet result = executeQuery(query);
            autores = passResultSet(result, autores);

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autores;

    }

    public List<BeanAutor> getActive() {

        List<BeanAutor> list = new ArrayList<>();

        String query = "SELECT * from Autor where alta = 'true' ORDER BY id_autor ASC;";

        try {
            PreparedStatement sql = con.prepareStatement(query);
            list = (List<BeanAutor>) passResultSet(sql.executeQuery(), list);
            sql.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @Override
    public boolean update(BeanAutor bean) {

        bean.toString();
        String query = "UPDATE " + "Autor" + " SET"
                + " nombre = ?,"
                + " primer_apellido = ?,"
                + " segundo_apellido = ?,"
                + " pais = ?"
                + " WHERE " + " id_autor" + " = ?;";
        bean.toString();

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getNombre());
            ps.setString(2, bean.getPrimer_apellido());
            ps.setString(3, bean.getSegundo_apellido());
            ps.setString(4, bean.getPais());
            ps.setInt(5, bean.getId_autor());

            if (ps.executeUpdate() == 1) {

                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean delete(BeanAutor id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean baja(int id) {
        String query = "UPDATE Autor SET alta='false' WHERE id_autor= ?;";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;

            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean add(BeanAutor beanAutor) {

        String query = "insert into Autor (nombre, primer_apellido, segundo_apellido, pais) values (? ,?,"
                + "?,?);";
        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, beanAutor.getNombre());
            ps.setString(2, beanAutor.getPrimer_apellido());
            ps.setString(3, beanAutor.getSegundo_apellido());
            ps.setString(4, beanAutor.getPais());

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean deleteAutor(int id) {
        String query = "DELETE FROM Autor WHERE id_autor= ?;";

        try (PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            if (ps.executeUpdate() == 1) {
                ps.close();
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public BeanAutor findByNombre(String nombre) {

        String query = "SELECT * from Autor where nombre= ?;";
        BeanAutor autor = new BeanAutor();

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);

            ResultSet result = ps.executeQuery();
            if (result.next()) {

                autor.setId_autor(result.getInt("id_autor"));
                autor.setNombre(result.getString("nombre"));
                autor.setPrimer_apellido(result.getString("primer_apellido"));
                autor.setSegundo_apellido(result.getString("segundo_apellido"));
                autor.setPais(result.getString("pais"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return autor;
    }
    public List<BeanAutor> findByLibro(BeanLibro libro){
        List<BeanAutor> list= new ArrayList<>();
        String query=" SELECT * from Autor where id_autor IN "
                + "(SELECT id_autor from Autor_has where id_libro=? );";
        
       
        try {
           PreparedStatement   ps = con.prepareStatement(query);
           ps.setInt(1, libro.getId_libro());
           
        ResultSet result= ps.executeQuery();
        
      list=passResultSet(result, list);
      ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
        
    }
    
    
    
    
}
